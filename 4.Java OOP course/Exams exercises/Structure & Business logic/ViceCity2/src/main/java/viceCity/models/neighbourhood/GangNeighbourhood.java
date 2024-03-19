package viceCity.models.neighbourhood;

import viceCity.models.guns.Gun;
import viceCity.models.players.Player;

import java.util.Collection;

public class GangNeighbourhood implements Neighbourhood {
    @Override
    public void action(Player mainPlayer, Collection<Player> civilPlayers) {
        if (!mainPlayer.getGunRepository().getModels().isEmpty()) {

            Gun mainPlayerGun = null;
            for (Gun gun : mainPlayer.getGunRepository().getModels()) {
                mainPlayerGun = gun;
                break;
            }

            while (mainPlayerGun.canFire()) {

                for (Player player : civilPlayers) {
                    while (player.isAlive()) {
                        player.takeLifePoints(mainPlayerGun.fire());
                        if (!mainPlayerGun.canFire()) {
                            mainPlayer.getGunRepository().remove(mainPlayerGun);
                            break;
                        }
                    }
                    if (!mainPlayerGun.canFire()) {
                        break;
                    }
                }

                long count = civilPlayers.stream().filter(player -> player.getLifePoints() <= 0).count();
                if (count == civilPlayers.size()) {
                    return;
                }
            }

        }

        for (Player civil : civilPlayers) {
            if (civil.isAlive()) {
                Gun gun = null;
                for (Gun g : civil.getGunRepository().getModels()) {
                    gun = g;
                    break;
                }
                if (gun != null) {
                    while (gun.canFire()) {
                        mainPlayer.takeLifePoints(gun.fire());
                        if (!mainPlayer.isAlive()) {
                            return;
                        }
                        if (!gun.canFire()) {
                            civil.getGunRepository().remove(gun);
                            break;
                        }
                    }
                }
            }
        }

    }
}
