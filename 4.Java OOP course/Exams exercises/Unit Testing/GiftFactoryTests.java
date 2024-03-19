package gifts;

import org.junit.Assert;
import org.junit.Test;

public class GiftFactoryTests {

    @Test(expected = IllegalArgumentException.class)
    public void isGiftCreated() {
        GiftFactory giftFactory = new GiftFactory();
        Gift gift = new Gift("Dog", 1000000);
        giftFactory.createGift(gift);
        giftFactory.createGift(gift);
    }

    @Test
    public void isGiftCreatedAndAdded() {
        GiftFactory giftFactory = new GiftFactory();
        Gift gift = new Gift("Dog", 1000000);
        giftFactory.createGift(gift);
        Assert.assertEquals(1, giftFactory.getCount());
    }

    @Test(expected = NullPointerException.class)
    public void isGiftRemovedWhenNull() {
        GiftFactory giftFactory = new GiftFactory();
        giftFactory.removeGift(null);
    }

    @Test(expected = NullPointerException.class)
    public void isGiftRemovedWhenEmpty() {
        GiftFactory giftFactory = new GiftFactory();
        giftFactory.removeGift("           ");
    }

    @Test
    public void isGiftRemoved() {
        GiftFactory giftFactory = new GiftFactory();
        Gift gift = new Gift("Dog", 1000000);
        giftFactory.createGift(gift);
        giftFactory.removeGift(gift.getType());

        Assert.assertEquals(0, giftFactory.getCount());
    }

    @Test
    public void isGetPresentWithLeastMagicWork() {
        GiftFactory giftFactory = new GiftFactory();
        Gift gift = new Gift("Truck", 1000000);
        Gift gift1 = new Gift("Car", 1000);
        Gift gift2 = new Gift("Doll", 10);
        giftFactory.createGift(gift);
        giftFactory.createGift(gift1);
        giftFactory.createGift(gift2);

        Assert.assertEquals(gift2, giftFactory.getPresentWithLeastMagic());

    }

    @Test
    public void isGetPresentWorking() {
        GiftFactory giftFactory = new GiftFactory();
        Gift gift = new Gift("Truck", 1000000);
        giftFactory.createGift(gift);

        Assert.assertEquals(gift, giftFactory.getPresent("Truck"));
    }


}
