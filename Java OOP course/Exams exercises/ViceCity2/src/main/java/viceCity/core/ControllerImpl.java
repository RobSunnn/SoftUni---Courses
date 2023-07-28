package viceCity.core;

import viceCity.common.ConstantMessages;
import viceCity.core.interfaces.Controller;
import viceCity.models.guns.Gun;
import viceCity.models.guns.Pistol;
import viceCity.models.guns.Rifle;
import viceCity.models.neighbourhood.GangNeighbourhood;
import viceCity.models.neighbourhood.Neighbourhood;
import viceCity.models.players.CivilPlayer;
import viceCity.models.players.MainPlayer;
import viceCity.models.players.Player;
import viceCity.repositories.GunRepository;
import viceCity.repositories.interfaces.Repository;

import java.util.ArrayList;
import java.util.List;


public class ControllerImpl implements Controller {

    private Repository<Gun> gunRepository;
    private Player mainPlayer;
    private List<Player> civilPlayers;

    public ControllerImpl() {
        this.gunRepository = new GunRepository();
        this.mainPlayer = new MainPlayer();
        this.civilPlayers = new ArrayList<>();
    }

    @Override
    public String addPlayer(String name) {
        Player civilPlayer = new CivilPlayer(name);
        this.civilPlayers.add(civilPlayer);
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
        if (this.gunRepository.getModels().isEmpty()) {
            return ConstantMessages.GUN_QUEUE_IS_EMPTY;
        }
        Gun gun = null;
        for (Gun g : this.gunRepository.getModels()) {
            gun = g;
            break;
        }
        if (name.equals("Vercetti")) {
            this.mainPlayer.getGunRepository().add(gun);
            this.gunRepository.remove(gun);
            return String.format(ConstantMessages.GUN_ADDED_TO_MAIN_PLAYER, gun.getName(), this.mainPlayer.getName());
        } else {
            Player civilPlayer = null;
            for (Player player : this.civilPlayers) {
                if (player.getName().equals(name)) {
                    civilPlayer = player;
                    break;
                }
            }
            if (civilPlayer == null) {
                return ConstantMessages.CIVIL_PLAYER_DOES_NOT_EXIST;
            }
            civilPlayer.getGunRepository().add(gun);
            this.gunRepository.remove(gun);
            return String.format(ConstantMessages.GUN_ADDED_TO_CIVIL_PLAYER, gun.getName(), civilPlayer.getName());
        }
    }

    @Override
    public String fight() {
        Neighbourhood gangsters = new GangNeighbourhood();
        gangsters.action(this.mainPlayer, this.civilPlayers);
        long countCivilDied = this.civilPlayers.stream().filter(player -> player.getLifePoints() <= 0).count();
        long countCivilLeft = this.civilPlayers.stream().filter(player -> player.getLifePoints() > 0).count();

        if (this.mainPlayer.getLifePoints() == 100 &&
        this.civilPlayers.stream().filter(player -> player.getLifePoints() == 50).count() == this.civilPlayers.size()) {
            return ConstantMessages.FIGHT_HOT_HAPPENED;
        } else {
            StringBuilder sb = new StringBuilder();
            sb.append(ConstantMessages.FIGHT_HAPPENED)
                    .append(System.lineSeparator())
                    .append(String.format(ConstantMessages.MAIN_PLAYER_LIVE_POINTS_MESSAGE, this.mainPlayer.getLifePoints()))
                    .append(System.lineSeparator())
                    .append(String.format(ConstantMessages.MAIN_PLAYER_KILLED_CIVIL_PLAYERS_MESSAGE, countCivilDied))
                    .append(System.lineSeparator())
                    .append(String.format(ConstantMessages.CIVIL_PLAYERS_LEFT_MESSAGE, countCivilLeft))
                    .append(System.lineSeparator());
            return sb.toString().trim();
        }
    }
}
