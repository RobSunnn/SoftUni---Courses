package shopAndGoods;


import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import javax.naming.OperationNotSupportedException;

public class ShopTest {

    private Shop shop;
    private Goods goods;

    @Before
    public void prepare() {
        this.shop = new Shop();
        this.goods = new Goods("goods", "123");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddGoodsWhenNoExistingShelf() throws OperationNotSupportedException {
        this.shop.addGoods("A", this.goods);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddGoodsWhenShelfBusy() throws OperationNotSupportedException {
        this.shop.addGoods("Shelves1", this.goods);
        this.shop.addGoods("Shelves1", new Goods("Goodsss", " 12312312"));
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testAddGoodsWhenGoodsExist() throws OperationNotSupportedException {

        Assert.assertEquals("Goods: 123 is placed successfully!", this.shop.addGoods("Shelves1", this.goods));
        this.shop.addGoods("Shelves2", this.goods);
        boolean b = this.shop.getShelves().containsValue(this.goods);
        Assert.assertTrue(b);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testRemoveGoodsWhenInvalidShelf() {
        this.shop.removeGoods("A", this.goods);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testRemoveGoodsFromShelfWhenGoodsNotExist() {
        this.shop.removeGoods("Shelves1", this.goods);
    }

    @Test
    public void testRemoveGoods() throws OperationNotSupportedException {
        this.shop.addGoods("Shelves1", this.goods);
        Assert.assertEquals("Goods: 123 is removed successfully!", this.shop.removeGoods("Shelves1", this.goods));
        boolean b = this.shop.getShelves().containsValue(this.goods);
        Assert.assertFalse(b);
    }
}