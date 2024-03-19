package viceCity.core;

import viceCity.common.ConstantMessages;
import viceCity.common.ExceptionMessages;
import viceCity.core.interfaces.Controller;
import viceCity.models.guns.Gun;
import viceCity.models.guns.Pistol;
import viceCity.models.guns.Rifle;
import viceCity.models.neighbourhood.GangNeighbourhood;
import viceCity.models.players.CivilPlayer;
import viceCity.models.players.MainPlayer;
import viceCity.models.players.Player;
import viceCity.repositories.interfaces.GunRepository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class ControllerImpl implements Controller {

    private GunRepository gunRepository;
    private Player mainPlayer;
    private Collection<Player> civilPlayers;

    public ControllerImpl() {
        this.gunRepository = new GunRepository();
        this.mainPlayer = new MainPlayer();
        this.civilPlayers = new ArrayList<>();
    }

    @Override
    public String addPlayer(String name) {
        Player civil = new CivilPlayer(name);
        this.civilPlayers.add(civil);
        return String.format(ConstantMessages.PLAYER_ADDED, name);
    }

    @Override
    public String addGun(String type, String name) {
        Gun gun;
        if (type.equals("Pistol")) {
            gun = new Pistol(name);
        } else if (type.equals("Rifle")) {
            gun = new Rifle(name);
        } else {
            return ConstantMessages.GUN_TYPE_INVALID;
        }

        this.gunRepository.add(gun);
        return String.format(ConstantMessages.GUN_ADDED, name, type);
    }

    @Override
    public String addGunToPlayer(String name) {

        Gun gun = this.gunRepository.find();

        if (gun == null) {
            return ConstantMessages.GUN_QUEUE_IS_EMPTY;
        }
        if (!name.equals("Vercetti")) {

            Player player = this.civilPlayers.stream().filter(p -> p.getName().equals(name))
                    .findFirst().orElse(null);
            if (player == null) {
                return ConstantMessages.CIVIL_PLAYER_DOES_NOT_EXIST;
            }
            player.getGunRepository().add(gun);
            this.gunRepository.remove(gun);
            return String.format(ConstantMessages.GUN_ADDED_TO_CIVIL_PLAYER, gun.getName(), name);


        }

        mainPlayer.getGunRepository().add(gun);
        this.gunRepository.remove(gun);
        return String.format(ConstantMessages.GUN_ADDED_TO_MAIN_PLAYER, gun.getName(), mainPlayer.getName());
    }

    @Override
    public String fight() {

        GangNeighbourhood gangNeighbourhood = new GangNeighbourhood();
        gangNeighbourhood.action(mainPlayer, this.civilPlayers);

        if (mainPlayer.getLifePoints() == 100 && gangNeighbourhood.getCivilDied() == 0) {
            return ConstantMessages.FIGHT_HOT_HAPPENED;
        }
        String sb = ConstantMessages.FIGHT_HAPPENED +
                System.lineSeparator() +
                String.format(ConstantMessages.MAIN_PLAYER_LIVE_POINTS_MESSAGE,
                        mainPlayer.getLifePoints()) +
                System.lineSeparator() +
                String.format(ConstantMessages.MAIN_PLAYER_KILLED_CIVIL_PLAYERS_MESSAGE,
                        gangNeighbourhood.getCivilDied()) +
                System.lineSeparator() +
                String.format(ConstantMessages.CIVIL_PLAYERS_LEFT_MESSAGE,
                        gangNeighbourhood.getCivilPlayersLeft()) +
                System.lineSeparator();
        return sb.trim();

    }
}
