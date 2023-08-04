package viceCity.models.guns;

public class Pistol extends BaseGun {

    private static final int BULLETS_PER_BARREL = 10;
    private static final int TOTAL_BULLETS = 100;

    public Pistol(String name) {
        super(name, BULLETS_PER_BARREL, TOTAL_BULLETS);
    }

    @Override
    public boolean canFire() {
        return super.getBulletsPerBarrel() >= 1;
    }

    @Override
    public int fire() {
        if (super.getBulletsPerBarrel() >= 1) {
            super.setBulletsPerBarrel(getBulletsPerBarrel() - 1);
            if (getBulletsPerBarrel() == 0) {
                if (getTotalBullets() >= 10) {
                    super.setTotalBullets(getTotalBullets() - 10);
                    super.setBulletsPerBarrel(10);
                }
            }
            return 1;
        }
        super.setBulletsPerBarrel(0);
        super.setTotalBullets(0);

        return 0;
    }
}
