package fairyShop.core;

import fairyShop.common.ConstantMessages;
import fairyShop.common.ExceptionMessages;
import fairyShop.models.Helpers.Happy;
import fairyShop.models.Helpers.Helper;
import fairyShop.models.Helpers.Sleepy;
import fairyShop.models.Instruments.Instrument;
import fairyShop.models.Instruments.InstrumentImpl;
import fairyShop.models.Presents.Present;
import fairyShop.models.Presents.PresentImpl;
import fairyShop.models.Shop.Shop;
import fairyShop.models.Shop.ShopImpl;
import fairyShop.repositories.HelperRepository;
import fairyShop.repositories.PresentRepository;

import java.util.List;
import java.util.stream.Collectors;

public class ControllerImpl implements Controller {

    private HelperRepository helperRepository;
    private PresentRepository presentRepository;
    private int countCraftedPresents;

    public ControllerImpl() {
        this.helperRepository = new HelperRepository();
        this.presentRepository = new PresentRepository();
        this.countCraftedPresents = 0;
    }

    @Override
    public String addHelper(String type, String helperName) {
        Helper helper;
        if (type.equals("Happy")) {
            helper = new Happy(helperName);
        } else if (type.equals("Sleepy")) {
            helper = new Sleepy(helperName);
        } else {
            throw new IllegalArgumentException(ExceptionMessages.HELPER_TYPE_DOESNT_EXIST);
        }

        this.helperRepository.add(helper);

        return String.format(ConstantMessages.ADDED_HELPER, type, helperName);
    }

    @Override
    public String addInstrumentToHelper(String helperName, int power) {
        Instrument instrument = new InstrumentImpl(power);
        Helper helper = this.helperRepository.findByName(helperName);
        if (helper == null) {
            throw new IllegalArgumentException(ExceptionMessages.HELPER_DOESNT_EXIST);
        }

        helper.getInstruments().add(instrument);
        return String.format(ConstantMessages.SUCCESSFULLY_ADDED_INSTRUMENT_TO_HELPER, power, helperName);
    }

    @Override
    public String addPresent(String presentName, int energyRequired) {
        Present present = new PresentImpl(presentName, energyRequired);
        this.presentRepository.add(present);
        return String.format(ConstantMessages.SUCCESSFULLY_ADDED_PRESENT, presentName);
    }

    @Override
    public String craftPresent(String presentName) {
        List<Helper> helpers = this.helperRepository.getModels().stream()
                .filter(helper -> helper.getEnergy() > 50)
                .collect(Collectors.toList());
        if (helpers.isEmpty()) {
            throw new IllegalArgumentException(ExceptionMessages.NO_HELPER_READY);
        }

        Present present = this.presentRepository.findByName(presentName);
        Shop shop = new ShopImpl();
        for (Helper helper : helpers) {
            shop.craft(present, helper);
        }
        long count = 0;
        for (Helper helper : helpers) {
            for (Instrument instrument : helper.getInstruments()) {
                if (instrument.isBroken()) {
                    count++;
                }
            }

        }
        String isPresentDone = "";
        if (present.isDone()) {
            isPresentDone = "done";
            this.countCraftedPresents++;
            this.presentRepository.remove(present);
        } else {
            isPresentDone = "not done";
        }

        return String.format(ConstantMessages.PRESENT_DONE, presentName, isPresentDone) +
                String.format(ConstantMessages.COUNT_BROKEN_INSTRUMENTS, count);
    }

    @Override
    public String report() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("%d presents are done!", this.countCraftedPresents))
                .append(System.lineSeparator())
                .append("Helpers info:")
                .append(System.lineSeparator());

        for (Helper helper : this.helperRepository.getModels()) {
            sb.append(String.format("Name: %s", helper.getName()))
                    .append(System.lineSeparator())
                    .append(String.format("Energy: %d", helper.getEnergy()))
                    .append(System.lineSeparator());
            long count = 0;
            for (Instrument instrument : helper.getInstruments()) {
                if (!instrument.isBroken()) {
                    count++;
                }
            }
            sb.append(String.format("Instruments: %d not broken left", count))
                    .append(System.lineSeparator());
        }

        return sb.toString().trim();
    }
}
