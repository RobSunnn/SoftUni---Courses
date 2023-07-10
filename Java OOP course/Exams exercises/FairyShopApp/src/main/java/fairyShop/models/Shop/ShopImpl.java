package fairyShop.models.Shop;

import fairyShop.models.Helpers.Helper;
import fairyShop.models.Instruments.Instrument;
import fairyShop.models.Presents.Present;

public class ShopImpl implements Shop {


    @Override
    public void craft(Present present, Helper helper) {

        if (helper.canWork() && !helper.getInstruments().isEmpty()) {

            while (helper.canWork() && !present.isDone()) {
                for (Instrument instrument : helper.getInstruments()) {
                    long count = helper.getInstruments().stream().filter(i -> i.getPower() > 0).count();
                    if (count == 0) {
                        return;
                    }
                    while (!instrument.isBroken()) {
                        helper.work();
                        instrument.use();
                        present.getCrafted();
                        if (!helper.canWork()) {
                            return;
                        }
                        if (present.isDone()) {
                            return;
                        }
                    }

                }
            }
        }
    }
}
