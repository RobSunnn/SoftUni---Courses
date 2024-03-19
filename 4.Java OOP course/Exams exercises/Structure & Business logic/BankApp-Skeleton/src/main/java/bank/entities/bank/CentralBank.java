package bank.entities.bank;

public class CentralBank extends BaseBank{

    private static final int BANK_CAPACITY = 50;


    public CentralBank(String name) {
        super(name, BANK_CAPACITY);
    }
}
