package bank;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class BankTests {

    private Bank bank;

    private Client client0;

    private Client client1;

    private Client client2;

    @Before
    public void prepare() {
        this.bank = new Bank("Name", 3);
        this.client0 = new Client("0");
        this.client1 = new Client("1");
        this.client2 = new Client("2");
    }

    private void addClient(Bank bank) {
        bank.addClient(this.client0);
        bank.addClient(this.client1);
        bank.addClient(this.client2);
    }

    @Test
    public void testGetBankName() {
        Assert.assertEquals("Name", this.bank.getName());
    }

    @Test
    public void testGetBankCapacity() {
        Assert.assertEquals(3, this.bank.getCapacity());
    }

    @Test(expected = NullPointerException.class)
    public void testBankNameNull() {
        new Bank(null, 1);
    }

    @Test(expected = NullPointerException.class)
    public void testBankNameEmpty() {
        new Bank("    ", 1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testBankNegativeCapacity() {
        new Bank("name", -1);
    }

    @Test
    public void testGetClientsSize() {
        addClient(this.bank);

        Assert.assertEquals(3, this.bank.getCount());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testBankAddingClientWhenNoCapacity() {
        addClient(this.bank);
        this.bank.addClient(new Client("No"));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testRemoveClientWhenClientNotExist() {
        addClient(this.bank);
        this.bank.removeClient("No");
    }

    @Test
    public void testRemoveClient() {
        addClient(this.bank);

        this.bank.removeClient("0");
        Assert.assertEquals(2, this.bank.getCount());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testLoanWithdrawalWhenClientNotExist() {
        this.bank.loanWithdrawal("No");
    }

    @Test
    public void testLoanWithdrawal() {
        addClient(this.bank);

        this.bank.loanWithdrawal("0");
        Assert.assertFalse(this.client0.isApprovedForLoan());
        Assert.assertEquals(this.client0, this.bank.loanWithdrawal("0"));
    }


}
