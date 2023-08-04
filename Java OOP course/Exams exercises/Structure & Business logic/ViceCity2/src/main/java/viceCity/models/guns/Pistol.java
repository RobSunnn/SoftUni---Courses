package viceCity.models.guns;

public class Pistol extends BaseGun{

    public Pistol(String name) {
        super(name, 10, 100);
    }

    @Override
    public int fire() {
        if (this.getBulletsPerBarrel() > 0) {
            int newBulletsPerBarrel = this.getBulletsPerBarrel() - 1;
            if (newBulletsPerBarrel <= 0) {
                if (this.getTotalBullets() >= 10) {
                    newBulletsPerBarrel = 10;
                    this.setTotalBullets(getTotalBullets() - 10);
                    this.setBulletsPerBarrel(newBulletsPerBarrel);
                } else {
                    this.setBulletsPerBarrel(0);
                    this.setTotalBullets(0);
                }
            } else {
                this.setBulletsPerBarrel(newBulletsPerBarrel);
            }
            return 1;
        }

        this.setBulletsPerBarrel(0);
        this.setTotalBullets(0);
        return 0;
    }
}
