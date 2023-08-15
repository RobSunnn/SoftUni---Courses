package bank.entities.loan;

public class StudentLoan extends BaseLoan {

    private static final int STUDENT_INTEREST_RATE = 1;

    private static final double STUDENT_AMOUNT = 10_000;


    public StudentLoan() {
        super(STUDENT_INTEREST_RATE, STUDENT_AMOUNT);
    }

}
