package magicGame.models.region;

import magicGame.models.magicians.Magician;
import magicGame.models.magicians.MagicianImpl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class RegionImpl implements Region {

    @Override
    public String start(Collection<Magician> magicians) {
        List<Magician> wizards = new ArrayList<>();
        List<Magician> blackWidows = new ArrayList<>();


        for (Magician magician : magicians) {
            if (magician.getClass().getSimpleName().equals("Wizard")) {
                wizards.add(magician);
            } else if (magician.getClass().getSimpleName().equals("BlackWidow")) {
                blackWidows.add(magician);
            }
        }

        while (!wizards.isEmpty() && !blackWidows.isEmpty()) {

            Magician wizard = wizards.get(0);
            Magician blackWidow = blackWidows.get(0);

            blackWidow.takeDamage(wizard.getMagic().fire());

            if (blackWidow.isAlive()) {
                wizard.takeDamage(blackWidow.getMagic().fire());
                if (!wizard.isAlive()) {
                    wizards.remove(wizard);
                }
            } else {
                blackWidows.remove(blackWidow);
            }

        }

        if (wizards.size() > blackWidows.size()) {
            return "Wizards win!";
        } else {
            return "Black widows win!";
        }


    }
}
