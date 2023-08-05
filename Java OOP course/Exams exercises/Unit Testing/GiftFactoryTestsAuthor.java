package gifts;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class GiftFactoryTests {
    private GiftFactory giftFactory;
    private Gift gift;

    @Before
    public void setUp() {
        this.giftFactory = new GiftFactory();
        this.gift = new Gift("Car", 1.1);
    }

    @Test
    public void getCount() {
        this.giftFactory.createGift(this.gift);
        Assert.assertEquals(1, this.giftFactory.getCount());
    }

    @Test(expected = NullPointerException.class)
    public void createPresentWithNULL() {
        this.giftFactory.createGift(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void createExceptionEqualName() {
        Gift presentNew = new Gift("Car", 1.1);
        this.giftFactory.createGift(this.gift);
        this.giftFactory.createGift(presentNew);
    }

    @Test
    public void createPresent() {
        this.giftFactory.createGift(this.gift);
        Assert.assertEquals("Car", this.gift.getType());
    }

    @Test(expected = NullPointerException.class)
    public void removeNullName() {
        this.giftFactory.removeGift(null);
    }

    @Test(expected = NullPointerException.class)
    public void removeNullNameEmpty() {
        this.giftFactory.removeGift("         ");
    }

    @Test
    public void remove() {
        this.giftFactory.createGift(this.gift);
        Assert.assertTrue(this.giftFactory.removeGift("Car"));
    }

    @Test
    public void getPresentWithLeastMagic() {
        Gift presentNew = new Gift("Car0", 0.1);
        this.giftFactory.createGift(this.gift);
        this.giftFactory.createGift(presentNew);

        Assert.assertEquals(presentNew, this.giftFactory.getPresentWithLeastMagic());
    }

    @Test
    public void getPresent(){
        Gift presentNew = new Gift("Car0", 0.1);
        this.giftFactory.createGift(this.gift);
        this.giftFactory.createGift(presentNew);

        Assert.assertEquals(this.gift, this.giftFactory.getPresent("Car"));
    }

    @Test(expected = UnsupportedOperationException.class)
    public void IfTrueToModifiedCollectionThrowException(){
        this.giftFactory.createGift(this.gift);
        this.giftFactory.getPresents().remove(this.gift);

    }
}
