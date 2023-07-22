package vehicleShop.models.shop;

import vehicleShop.models.tool.Tool;
import vehicleShop.models.vehicle.Vehicle;
import vehicleShop.models.worker.Worker;

public class ShopImpl implements Shop {

    @Override
    public void make(Vehicle vehicle, Worker worker) {

        for (Tool tool : worker.getTools()) {
            if (worker.getTools().isEmpty() || !worker.canWork()) {
                return;
            }
            while (!tool.isUnfit()) {
                vehicle.making();
                tool.decreasesPower();
                worker.working();

                if (vehicle.reached()) {
                    return;
                }
            }
        }

    }
}
