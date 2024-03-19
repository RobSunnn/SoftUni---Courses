package magicGame.models.magics;

public class RedMagic extends MagicImpl {


    public RedMagic(String name, int bulletsCount) {
        super(name, bulletsCount);
    }

    @Override
    public int fire() {
        int bullets = super.getBulletsCount();
        if (bullets >= 1) {
            int newBullets = bullets - 1;
            super.setBulletsCount(newBullets);
            return 1;
        }
        super.setBulletsCount(0);
        return 0;
    }
}
