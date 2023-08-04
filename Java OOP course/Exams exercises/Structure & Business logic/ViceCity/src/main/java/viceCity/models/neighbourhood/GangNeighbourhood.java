package viceCity.models.neighbourhood;

import viceCity.models.guns.Gun;
import viceCity.models.players.Player;

import java.util.Collection;

public class GangNeighbourhood implements Neighbourhood {

    private int civilDied;

    public int getCivilPlayersLeft() {
        return civilPlayersLeft;
    }

    public void setCivilPlayersLeft(int civilPlayersLeft) {
        this.civilPlayersLeft = civilPlayersLeft;
    }

    private int civilPlayersLeft;

    public int getCivilDied() {
        return civilDied;
    }

    public void setCivilDied(int civilDied) {
        this.civilDied = civilDied;
    }


    @Override
    public void action(Player mainPlayer, Collection<Player> civilPlayers) {
        while (!mainPlayer.getGunRepository().getModels().isEmpty()) {
            Gun gun = null;
            for (Gun g : mainPlayer.getGunRepository().getModels()) {
                if (g != null) {
                    gun = g;
                    break;
                }
            }

            if (gun != null) {
                while (gun.canFire()) {
                    Player civil = null;
                    for (Player c : civilPlayers) {
                        civil = c;
                        break;
                    }
                    if (civil == null) {
                        return;
                    }

                    civil.takeLifePoints(gun.fire());

                    if (!civil.isAlive()) {
                        setCivilDied(getCivilDied() + 1);
                        civilPlayers.remove(civil);
                        break;
                    }
                    if (!gun.canFire()) {
                        mainPlayer.getGunRepository().remove(gun);
                        break;
                    }
                }
            }
        }

        for (Player civil : civilPlayers) {
            for (Gun gunCivil : civil.getGunRepository().getModels()) {

                while (gunCivil.canFire()) {
                    mainPlayer.takeLifePoints(gunCivil.fire());
                    if (!mainPlayer.isAlive()) {
                        setCivilPlayersLeft(civilPlayers.size());
                        return;
                    }
                }

            }

        }
        setCivilPlayersLeft(civilPlayers.size());

    }
}
