package viceCity.models.guns;

public class Rifle extends BaseGun {

    public Rifle(String name) {
        super(name, 50, 500);
    }

    @Override
    public int fire() {
        if (this.getBulletsPerBarrel() >= 5) {
            int newBulletsPerBarrel = this.getBulletsPerBarrel() - 5;
            if (newBulletsPerBarrel <= 0) {
                if (this.getTotalBullets() >= 50) {
                    newBulletsPerBarrel = 50;
                    this.setTotalBullets(getTotalBullets() - 50);
                    this.setBulletsPerBarrel(newBulletsPerBarrel);
                } else {
                    this.setBulletsPerBarrel(0);
                    this.setTotalBullets(0);
                }
            } else {
                this.setBulletsPerBarrel(newBulletsPerBarrel);
            }
            return 5;
        }

        this.setBulletsPerBarrel(0);
        this.setTotalBullets(0);
        return 0;
    }
}
