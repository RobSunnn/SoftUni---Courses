package bank.entities.client;

public class Adult extends BaseClient{

    private static final int ADULT_INITIAL_INTEREST = 4;

    public Adult(String name, String ID, double income) {
        super(name, ID, ADULT_INITIAL_INTEREST, income);
    }

    @Override
    public void increase() {
        this.setInterest(ADULT_INITIAL_INTEREST + 2);
    }
}
