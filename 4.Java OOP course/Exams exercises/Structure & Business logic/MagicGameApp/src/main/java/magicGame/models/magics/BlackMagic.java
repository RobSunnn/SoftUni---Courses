package magicGame.models.magics;

public class BlackMagic extends MagicImpl {

    public BlackMagic(String name, int bulletsCount) {
        super(name, bulletsCount);
    }

    @Override
    public int fire() {
        int bullets = super.getBulletsCount();
        if (bullets >= 10) {
            int newBullets = bullets - 10;
            super.setBulletsCount(newBullets);
            return 10;
        }
        super.setBulletsCount(0);
        return 0;
        //TODO
    }
}
