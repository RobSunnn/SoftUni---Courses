package harpoonDiver.core;

import harpoonDiver.models.diver.DeepWaterDiver;
import harpoonDiver.models.diver.Diver;
import harpoonDiver.models.diver.OpenWaterDiver;
import harpoonDiver.models.diver.WreckDiver;
import harpoonDiver.models.diving.DivingImpl;
import harpoonDiver.models.divingSite.DivingSite;
import harpoonDiver.models.divingSite.DivingSiteImpl;
import harpoonDiver.repositories.DiverRepository;
import harpoonDiver.repositories.DivingSiteRepository;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class ControllerImpl implements Controller{

    private DiverRepository diverRepository;

    private DivingSiteRepository divingSiteRepository;

    private int countDivingSites;

    public ControllerImpl() {
        this.diverRepository = new DiverRepository();
        this.divingSiteRepository = new DivingSiteRepository();
        this.countDivingSites = 0;
    }

    @Override
    public String addDiver(String kind, String diverName) {

        Diver diver;

        switch (kind) {
            case "DeepWaterDiver":
                diver = new DeepWaterDiver(diverName);
                break;
            case "OpenWaterDiver":
                diver = new OpenWaterDiver(diverName);
                break;
            case "WreckDiver":
                diver = new WreckDiver(diverName);
                break;
            default:
                throw new IllegalArgumentException("Diver kind doesn't exist.");
        }

        this.diverRepository.add(diver);

        return String.format("Added %s: %s.", kind, diverName);
    }

    @Override
    public String addDivingSite(String siteName, String... seaCreatures) {

        DivingSite divingSite = new DivingSiteImpl(siteName);

        for (String creature : seaCreatures) {
            divingSite.getSeaCreatures().add(creature);
        }

        this.divingSiteRepository.add(divingSite);

        return String.format("Added site: %s.", siteName);
    }

    @Override
    public String removeDiver(String diverName) {
        Diver diver = null;

        for (Diver d : this.diverRepository.getCollection()) {
            if (d.getName().equals(diverName)) {
                diver = d;
                break;
            }
        }

        if (diver == null) {
            throw new IllegalArgumentException(String.format("Diver %s doesn't exist.", diverName));
        }

        this.diverRepository.remove(diver);

        return String.format("Diver %s has removed!", diverName);
    }

    @Override
    public String startDiving(String siteName) {

        DivingImpl diving = new DivingImpl();
        DivingSite divingSite = this.divingSiteRepository.byName(siteName);


        List<Diver> diversWithEnoughOxygen =
                this.diverRepository.getCollection().stream()
                        .filter(diver -> diver.getOxygen() > 30)
                        .collect(Collectors.toList());

        if (diversWithEnoughOxygen.isEmpty()) {
            throw new IllegalArgumentException("You must have at least one diver to start diving.");
        }
        diving.searching(divingSite, diversWithEnoughOxygen);
        this.countDivingSites++;
        long countOfDiversWithZeroOxygen = diversWithEnoughOxygen.stream().filter(diver -> diver.getOxygen() == 0).count();

        return String.format("The dive took place at %s. %d diver/s was/were removed on this dive.",
                siteName, countOfDiversWithZeroOxygen);
    }

    @Override
    public String getStatistics() {
        StringBuilder sb = new StringBuilder();

        sb.append(String.format("The dive took place at %d site/s.", this.countDivingSites))
                .append(System.lineSeparator())
                .append("Diver's statistics:")
                .append(System.lineSeparator());

        for (Diver diver : this.diverRepository.getCollection()) {
            sb.append(diver.toString()).append(System.lineSeparator());
        }


        return sb.toString().trim();
    }
}
