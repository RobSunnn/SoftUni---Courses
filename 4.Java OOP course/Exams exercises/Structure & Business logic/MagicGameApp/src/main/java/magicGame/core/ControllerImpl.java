package magicGame.core;

import magicGame.common.ExceptionMessages;
import magicGame.common.OutputMessages;
import magicGame.models.magicians.BlackWidow;
import magicGame.models.magicians.Magician;
import magicGame.models.magicians.Wizard;
import magicGame.models.magics.BlackMagic;
import magicGame.models.magics.Magic;
import magicGame.models.magics.RedMagic;
import magicGame.models.region.Region;
import magicGame.models.region.RegionImpl;
import magicGame.repositories.MagicRepositoryImpl;
import magicGame.repositories.MagicianRepositoryImpl;

import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class ControllerImpl implements Controller {

    private MagicRepositoryImpl magics;
    private MagicianRepositoryImpl magicians;
    private Region region;

    public ControllerImpl() {
        this.magics = new MagicRepositoryImpl();
        this.magicians = new MagicianRepositoryImpl();
        this.region = new RegionImpl();
    }

    @Override
    public String addMagic(String type, String name, int bulletsCount) {
        Magic magic;
        if (type.equals("RedMagic")) {
            magic = new RedMagic(name, bulletsCount);
        } else if (type.equals("BlackMagic")) {
            magic = new BlackMagic(name, bulletsCount);
        } else {
            throw new IllegalArgumentException(ExceptionMessages.INVALID_MAGIC_TYPE);
        }

        this.magics.addMagic(magic);

        return String.format(OutputMessages.SUCCESSFULLY_ADDED_MAGIC, name);
    }

    @Override
    public String addMagician(String type, String username, int health, int protection, String magicName) {
        Magic magic = this.magics.findByName(magicName);
        if (magic == null) {
            throw new NullPointerException(ExceptionMessages.MAGIC_CANNOT_BE_FOUND);
        }

        Magician magician;
        if (type.equals("Wizard")) {
            magician = new Wizard(username, health, protection, magic);
        } else if (type.equals("BlackWidow")) {
            magician = new BlackWidow(username, health, protection, magic);
        } else {
            throw new IllegalArgumentException(ExceptionMessages.INVALID_MAGICIAN_TYPE);
        }

        this.magicians.addMagician(magician);

        return String.format(OutputMessages.SUCCESSFULLY_ADDED_MAGICIAN, username);
    }

    @Override
    public String startGame() {
        return this.region.start(this.magicians.getData());
    }

    private static void sort(Collection<Magician> magicians) {
        Comparator.comparing(Magician::getHealth)
                .thenComparing(Magician::getUsername)
                .thenComparing(m -> m.getClass().getSimpleName());
    }

    @Override
    public String report() {
        List<Magician> list = this.magicians.getData().stream()
                .sorted(Comparator.comparing(Magician::getHealth)
                        .thenComparing(Magician::getUsername)
                        .thenComparing(m -> m.getClass().getSimpleName()))
                .collect(Collectors.toList());

        StringBuilder sb = new StringBuilder();

        for (Magician magician : list) {
            int health = magician.getHealth();
            if (magician.getHealth() < 0) {
                health = 0;
            }
            int protection = magician.getProtection();
            if (magician.getProtection() < 0) {
                protection = 0;
            }
            sb.append(String.format("%s: %s", magician.getClass().getSimpleName(), magician.getUsername()));
            sb.append(System.lineSeparator());
            sb.append(String.format("Health: %d", health));
            sb.append(System.lineSeparator());
            sb.append(String.format("Protection: %d", protection));
            sb.append(System.lineSeparator());
            sb.append(String.format("Magic: %s", magician.getMagic().getName()));
            sb.append(System.lineSeparator());
        }

        return sb.toString().trim();
    }
}
