package bank.entities.loan;

public class MortgageLoan extends BaseLoan{

    private static final int MORTGAGE_INTEREST_RATE = 3;

    private static final double MORTGAGE_AMOUNT = 50_000;

    public MortgageLoan() {
        super(MORTGAGE_INTEREST_RATE, MORTGAGE_AMOUNT);
    }

}
