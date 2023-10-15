package vehicleShop.core;

import vehicleShop.common.ConstantMessages;
import vehicleShop.common.ExceptionMessages;
import vehicleShop.models.shop.Shop;
import vehicleShop.models.shop.ShopImpl;
import vehicleShop.models.tool.Tool;
import vehicleShop.models.tool.ToolImpl;
import vehicleShop.models.vehicle.Vehicle;
import vehicleShop.models.vehicle.VehicleImpl;
import vehicleShop.models.worker.FirstShift;
import vehicleShop.models.worker.SecondShift;
import vehicleShop.models.worker.Worker;
import vehicleShop.repositories.VehicleRepository;
import vehicleShop.repositories.WorkerRepository;

import java.util.List;
import java.util.stream.Collectors;

public class ControllerImpl implements Controller {

    private WorkerRepository workerRepository;
    private VehicleRepository vehicleRepository;
    private int countMadeVehicles;

    public ControllerImpl() {
        this.workerRepository = new WorkerRepository();
        this.vehicleRepository = new VehicleRepository();
        this.countMadeVehicles = 0;
    }

    @Override
    public String addWorker(String type, String workerName) {
        Worker worker;
        switch (type) {
            case "FirstShift":
                worker = new FirstShift(workerName);
                break;
            case "SecondShift":
                worker = new SecondShift(workerName);
                break;
            default:
                throw new IllegalArgumentException(ExceptionMessages.WORKER_TYPE_DOESNT_EXIST);
        }

        this.workerRepository.add(worker);

        return String.format(ConstantMessages.ADDED_WORKER, type, workerName);
    }

    @Override
    public String addVehicle(String vehicleName, int strengthRequired) {
        Vehicle vehicle = new VehicleImpl(vehicleName, strengthRequired);
        this.vehicleRepository.add(vehicle);

        return String.format(ConstantMessages.SUCCESSFULLY_ADDED_VEHICLE, vehicleName);
    }

    @Override
    public String addToolToWorker(String workerName, int power) {
        Worker worker = this.workerRepository.findByName(workerName);
        if (worker == null) {
            throw new IllegalArgumentException(ExceptionMessages.HELPER_DOESNT_EXIST);
        }
        Tool tool = new ToolImpl(power);

        worker.addTool(tool);

        return String.format(ConstantMessages.SUCCESSFULLY_ADDED_TOOL_TO_WORKER, power, workerName);
    }

    @Override
    public String makingVehicle(String vehicleName) {

        List<Worker> workerList = this.workerRepository.getWorkers()
                .stream()
                .filter(worker -> worker.getStrength() > 70)
                .collect(Collectors.toList());

        if (workerList.isEmpty()) {
            throw new IllegalArgumentException(ExceptionMessages.NO_WORKER_READY);
        }

        Vehicle vehicle = this.vehicleRepository.findByName(vehicleName);
        Shop shop = new ShopImpl();

        for (Worker worker : workerList) {
            shop.make(vehicle, worker);
            if (vehicle.reached()) {
                break;
            }
        }

        String doneOrNot = "";
        if (vehicle.reached()) {
            doneOrNot = "done";
            this.countMadeVehicles++;
            this.vehicleRepository.remove(vehicle);
        } else {
            doneOrNot = "not done";
        }

        int countBrokenTools = 0;
        for (Worker worker : workerList) {
            for (Tool tool : worker.getTools()) {
                if (tool.isUnfit()) {
                    countBrokenTools++;
                }
            }
        }

        return String.format(ConstantMessages.VEHICLE_DONE, vehicleName, doneOrNot)
                + String.format(ConstantMessages.COUNT_BROKEN_INSTRUMENTS, countBrokenTools);
    }

    @Override
    public String statistics() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("%d vehicles are ready!", this.countMadeVehicles))
                .append(System.lineSeparator())
                .append("Info for workers:").append(System.lineSeparator());

        for (Worker worker : this.workerRepository.getWorkers()) {
            sb.append(String.format("Name: %s, Strength: %d", worker.getName(), worker.getStrength()))
                    .append(System.lineSeparator());
            int countFitInstruments = 0;
            for (Tool tool : worker.getTools()) {
                if (!tool.isUnfit()) {
                    countFitInstruments++;
                }
            }
            sb.append(String.format("Tools: %d fit left", countFitInstruments))
                    .append(System.lineSeparator());
        }

        return sb.toString().trim();
    }
}
