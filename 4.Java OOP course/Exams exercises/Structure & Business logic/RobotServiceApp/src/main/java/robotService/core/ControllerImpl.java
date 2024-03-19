package robotService.core;

import robotService.common.ConstantMessages;
import robotService.common.ExceptionMessages;
import robotService.entities.robot.FemaleRobot;
import robotService.entities.robot.MaleRobot;
import robotService.entities.robot.Robot;
import robotService.entities.services.MainService;
import robotService.entities.services.SecondaryService;
import robotService.entities.services.Service;
import robotService.entities.supplements.MetalArmor;
import robotService.entities.supplements.PlasticArmor;
import robotService.entities.supplements.Supplement;
import robotService.repositories.SupplementRepository;

import java.util.ArrayList;
import java.util.Collection;

public class ControllerImpl implements Controller {

    private SupplementRepository supplements;
    private Collection<Service> services;

    public ControllerImpl() {
        this.supplements = new SupplementRepository();
        this.services = new ArrayList<>();
    }

    @Override
    public String addService(String type, String name) {
        Service service;
        if (type.equals("MainService")) {
            service = new MainService(name);
        } else if (type.equals("SecondaryService")) {
            service = new SecondaryService(name);
        } else {
            throw new NullPointerException(ExceptionMessages.INVALID_SERVICE_TYPE);
        }

        this.services.add(service);

        return String.format(ConstantMessages.SUCCESSFULLY_ADDED_SERVICE_TYPE, type);
    }

    @Override
    public String addSupplement(String type) {
        Supplement supplement;
        if (type.equals("MetalArmor")) {
            supplement = new MetalArmor();
        } else if (type.equals("PlasticArmor")) {
            supplement = new PlasticArmor();
        } else {
            throw new IllegalArgumentException(ExceptionMessages.INVALID_SUPPLEMENT_TYPE);
        }
        this.supplements.addSupplement(supplement);

        return String.format(ConstantMessages.SUCCESSFULLY_ADDED_SUPPLEMENT_TYPE, type);
    }

    @Override
    public String supplementForService(String serviceName, String supplementType) {
        Supplement supplement = this.supplements.findFirst(supplementType);
        if (supplement == null) {
            throw new IllegalArgumentException
                    (String.format(ExceptionMessages.NO_SUPPLEMENT_FOUND, supplementType));
        }

        Service service = getService(serviceName);
        service.addSupplement(supplement);
        this.supplements.removeSupplement(supplement);

        return String.format(ConstantMessages.SUCCESSFULLY_ADDED_SUPPLEMENT_IN_SERVICE,
                supplementType, serviceName);
    }

    private Service getService(String serviceName) {
        return this.services.stream().filter(service -> service.getName().equals(serviceName))
                .findFirst()
                .orElse(null);
    }

    @Override
    public String addRobot(String serviceName, String robotType, String robotName, String robotKind, double price) {
        Robot robot;
        if (robotType.equals("FemaleRobot")) {
            robot = new FemaleRobot(robotName, robotKind, price);
        } else if (robotType.equals("MaleRobot")) {
            robot = new MaleRobot(robotName, robotKind, price);
        } else {
            throw new IllegalArgumentException(ExceptionMessages.INVALID_ROBOT_TYPE);
        }
        Service service = getService(serviceName);
        if (!canRobotBeInService(service, robot)) {
            return ConstantMessages.UNSUITABLE_SERVICE;
        }
        service.addRobot(robot);
        return String.format(ConstantMessages.SUCCESSFULLY_ADDED_ROBOT_IN_SERVICE, robotType, serviceName);
    }

    private boolean canRobotBeInService(Service service, Robot robot) {
        boolean canRobotBeThere = robot.getClass().getSimpleName().equals("FemaleRobot") &&
                service.getClass().getSimpleName().equals("SecondaryService");
        if (!canRobotBeThere) {
            canRobotBeThere = robot.getClass().getSimpleName().equals("MaleRobot") &&
                    service.getClass().getSimpleName().equals("MainService");
        }
        return canRobotBeThere;
    }

    @Override
    public String feedingRobot(String serviceName) {
        Service service = getService(serviceName);
        service.getRobots().forEach(Robot::eating);
        return String.format(ConstantMessages.FEEDING_ROBOT, service.getRobots().size());
    }

    @Override
    public String sumOfAll(String serviceName) {
        Service service = getService(serviceName);

        double value = service.getRobots().stream().mapToDouble(Robot::getPrice).sum() +
                service.getSupplements().stream().mapToDouble(Supplement::getPrice).sum();

        return String.format(ConstantMessages.VALUE_SERVICE, serviceName, value);
    }

    @Override
    public String getStatistics() {
        StringBuilder sb = new StringBuilder();

        for (Service service : this.services) {
            sb.append(service.getStatistics())
                    .append(System.lineSeparator());
        }

        return sb.toString().trim();
    }
}
