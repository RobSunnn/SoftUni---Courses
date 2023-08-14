package bank.core;

import bank.common.ConstantMessages;
import bank.common.ExceptionMessages;
import bank.entities.bank.Bank;
import bank.entities.bank.BranchBank;
import bank.entities.bank.CentralBank;
import bank.entities.client.Adult;
import bank.entities.client.Client;
import bank.entities.client.Student;
import bank.entities.loan.Loan;
import bank.entities.loan.MortgageLoan;
import bank.entities.loan.StudentLoan;
import bank.repositories.LoanRepository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.stream.Collectors;

public class ControllerImpl implements Controller {

    private LoanRepository loans;

    private Collection<Bank> banks;

    public ControllerImpl() {
        this.loans = new LoanRepository();
        this.banks = new ArrayList<>();
    }

    @Override
    public String addBank(String type, String name) {
        Bank bank = null;

        switch (type) {
            case "CentralBank":
                bank = new CentralBank(name);
                break;
            case "BranchBank":
                bank = new BranchBank(name);
                break;
            default:
                throw new IllegalArgumentException(ExceptionMessages.INVALID_BANK_TYPE);
        }


        this.banks.add(bank);


        return String.format(ConstantMessages.SUCCESSFULLY_ADDED_BANK_OR_LOAN_TYPE, type);
    }

    @Override
    public String addLoan(String type) {
        Loan loan = null;

        switch (type) {
            case "StudentLoan":
                loan = new StudentLoan();
                break;
            case "MortgageLoan":
                loan = new MortgageLoan();
                break;
            default:
                throw new IllegalArgumentException(ExceptionMessages.INVALID_LOAN_TYPE);
        }

        this.loans.addLoan(loan);


        return String.format(ConstantMessages.SUCCESSFULLY_ADDED_BANK_OR_LOAN_TYPE, type);
    }

    @Override
    public String returnedLoan(String bankName, String loanType) {
        Loan loan = this.loans.findFirst(loanType);

        if (loan == null) {
            throw new IllegalArgumentException(String.format(ExceptionMessages.NO_LOAN_FOUND, loanType));
        }

        Bank bank = null;

        for (Bank b : banks) {
            if (b.getName().equals(bankName)) {
                bank = b;
                break;
            }
        }

        assert bank != null;
        bank.addLoan(loan);
        this.loans.removeLoan(loan);

        return String.format(ConstantMessages.SUCCESSFULLY_ADDED_CLIENT_OR_LOAN_TO_BANK, loanType, bankName);
    }

    private Bank findBank(String bankName) {
        return this.banks.stream().filter(b -> b.getName().equals(bankName)).findFirst().orElse(null);
    }

    @Override
    public String addClient(String bankName, String clientType, String clientName, String clientID, double income) {
        Client client = null;

        switch (clientType) {
            case "Student":
                client = new Student(clientName, clientID, income);
                break;
            case "Adult":
                client = new Adult(clientName, clientID, income);
                break;
            default:
                throw new IllegalArgumentException(ExceptionMessages.INVALID_CLIENT_TYPE);
        }

        Bank bank = findBank(bankName);

        if (bank != null) {
            if (!isClientSuitable(bank, client)) {
                return ConstantMessages.UNSUITABLE_BANK;
            }
        } else {
            throw new IllegalStateException("Bank cannot be null!");
        }

        bank.addClient(client);

        return String.format(ConstantMessages.SUCCESSFULLY_ADDED_CLIENT_OR_LOAN_TO_BANK, clientType, bankName);
    }

    private boolean isClientSuitable(Bank bank, Client client) {
        boolean isSuitable = bank.getClass().getSimpleName().equals("CentralBank") &&
                client.getClass().getSimpleName().equals("Adult");

        if (!isSuitable) {
            isSuitable = bank.getClass().getSimpleName().equals("BranchBank") &&
                    client.getClass().getSimpleName().equals("Student");
        }

        return isSuitable;
    }

    @Override
    public String finalCalculation(String bankName) {
        Bank bank = findBank(bankName);
        double fundsOfBank = 0.0;

        if (bank != null) {
            fundsOfBank = bank.getClients().stream().mapToDouble(Client::getIncome).sum() +
                    bank.getLoans().stream().mapToDouble(Loan::getAmount).sum();
        } else {
            throw new IllegalStateException("Bank cannot be null!");
        }


        return String.format(ConstantMessages.FUNDS_BANK, bankName, fundsOfBank);
    }

    @Override
    public String getStatistics() {
        StringBuilder sb = new StringBuilder();

        sb.append(this.banks.stream().map(Bank::getStatistics).collect(Collectors.joining("\n")));

        return sb.toString().trim();
    }
}
