package viceCity.models.guns;

public class Rifle extends BaseGun {

    private static final int BULLETS_PER_BARREL = 50;
    private static final int TOTAL_BULLETS = 500;

    public Rifle(String name) {
        super(name, BULLETS_PER_BARREL, TOTAL_BULLETS);
    }

    @Override
    public boolean canFire() {
        return super.getBulletsPerBarrel() >= 5;
    }

    @Override
    public int fire() {


        if (super.getBulletsPerBarrel() >= 5) {
            super.setBulletsPerBarrel(getBulletsPerBarrel() - 5);
            if (getBulletsPerBarrel() == 0) {
                if (getTotalBullets() >= 50) {
                    super.setTotalBullets(getTotalBullets() - 50);
                    super.setBulletsPerBarrel(50);
                }
            }
            return 5;
        }
        super.setBulletsPerBarrel(0);
        super.setTotalBullets(0);

        return 0;

    }
}
