package bank.entities.bank;

public class BranchBank extends BaseBank {

    private static final int BANK_CAPACITY = 25;

    public BranchBank(String name) {
        super(name, BANK_CAPACITY);
    }
}
