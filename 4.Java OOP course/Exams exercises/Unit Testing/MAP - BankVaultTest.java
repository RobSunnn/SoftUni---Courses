package bankSafe;


import org.junit.Assert;
import org.junit.Test;

import javax.naming.OperationNotSupportedException;

public class BankVaultTest {

   @Test(expected = IllegalArgumentException.class)
    public void isItemAddedWhenNoCell() throws OperationNotSupportedException {
       BankVault bankVault = new BankVault();
       Item item = new Item("R", "123");
       bankVault.addItem("O", item);
   }

   @Test(expected = IllegalArgumentException.class)
   public void isItemAddedWhenCellIsTaken() throws OperationNotSupportedException {
      BankVault bankVault = new BankVault();
      Item item = new Item("R", "123");
      Item item1 = new Item("S", "12323");
      bankVault.addItem("A1", item);
      bankVault.addItem("A1", item1);
   }

   @Test(expected = OperationNotSupportedException.class)
   public void isItemAddedWhenItemExist() throws OperationNotSupportedException {
      BankVault bankVault = new BankVault();
      Item item = new Item("R", "123");

      bankVault.addItem("A1", item);
      bankVault.addItem("A2", item);
   }

   @Test
   public void isItemAdded() throws OperationNotSupportedException {
      BankVault bankVault = new BankVault();
      Item item = new Item("R", "123");
      Item item1 = new Item("S", "12323");
      bankVault.addItem("A1", item);
      bankVault.addItem("A2", item1);
      boolean b =  bankVault.getVaultCells().containsValue(item);
      boolean b1 =  bankVault.getVaultCells().containsValue(item1);

      Assert.assertTrue(b);
      Assert.assertTrue(b1);
   }

   @Test(expected = IllegalArgumentException.class)
   public void isItemRemovedWhenCellNotExist() throws OperationNotSupportedException {
      BankVault bankVault = new BankVault();
      Item item = new Item("R", "123");
      bankVault.addItem("A1" ,item);
      bankVault.removeItem("Z2", item);
   }

   @Test(expected = IllegalArgumentException.class)
   public void isItemRemovedWhenNoItem() throws OperationNotSupportedException {
      BankVault bankVault = new BankVault();
      Item item = new Item("R", "123");
      Item item1 = new Item("R", "123");
      bankVault.addItem("A1" ,item);
      bankVault.removeItem("A1",item1);
   }

   @Test
   public void isItemRemoved() throws OperationNotSupportedException {
      BankVault bankVault = new BankVault();
      Item item = new Item("R", "123");
      Item item1 = new Item("R", "123");
      bankVault.addItem("A1" ,item);
      bankVault.addItem("A2" ,item1);


      Assert.assertEquals("Remove item:123 successfully!", bankVault.removeItem("A1", item));
      Assert.assertNull(bankVault.getVaultCells().get("A1"));
   }

}