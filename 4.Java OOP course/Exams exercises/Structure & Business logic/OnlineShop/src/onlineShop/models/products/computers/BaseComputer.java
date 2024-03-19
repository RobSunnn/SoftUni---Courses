package onlineShop.models.products.computers;

import onlineShop.common.constants.ExceptionMessages;
import onlineShop.common.constants.OutputMessages;
import onlineShop.models.products.BaseProduct;
import onlineShop.models.products.Product;
import onlineShop.models.products.components.Component;
import onlineShop.models.products.peripherals.Peripheral;

import java.util.ArrayList;
import java.util.List;


public abstract class BaseComputer extends BaseProduct implements Computer {

    private List<Component> components;
    private List<Peripheral> peripherals;

    protected BaseComputer(int id, String manufacturer, String model, double price, double overallPerformance) {
        super(id, manufacturer, model, price, overallPerformance);
        this.components = new ArrayList<>();
        this.peripherals = new ArrayList<>();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        double average = this.peripherals.stream().mapToDouble(Product::getOverallPerformance).sum() / this.peripherals.size();
        sb.append(String.format(OutputMessages.PRODUCT_TO_STRING,
                this.getOverallPerformance(), this.getPrice(), this.getClass().getSimpleName(), this.getManufacturer(),
                this.getModel(), this.getId())).append(System.lineSeparator());

        sb.append(" ").append(String.format(String.format(OutputMessages.COMPUTER_COMPONENTS_TO_STRING, this.components.size())))
                .append(System.lineSeparator());
        for (Component component : this.components) {
            sb.append("  ").append(component.toString())
                    .append(System.lineSeparator());
        }

        if (!this.peripherals.isEmpty()) {
            sb.append(" ").append(String.format(OutputMessages.COMPUTER_PERIPHERALS_TO_STRING, this.peripherals.size(), average))
                    .append(System.lineSeparator());
            for (Peripheral peripheral : this.peripherals) {
                sb.append("  ").append(peripheral.toString())
                        .append(System.lineSeparator());
            }
        } else {
            sb.append(" ").append(String.format(OutputMessages.COMPUTER_PERIPHERALS_TO_STRING, 0, 0.0))
                    .append(System.lineSeparator());
        }


        return sb.toString().trim();
    }

    @Override
    public List<Component> getComponents() {
        return components;
    }

    @Override
    public List<Peripheral> getPeripherals() {
        return peripherals;
    }

    @Override
    public double getOverallPerformance() {
        double overall = super.getOverallPerformance();
        if (!this.components.isEmpty()) {
            double average = this.components.stream().mapToDouble(Product::getOverallPerformance).sum();
            average = average / this.components.size();
            overall += average;
        }

        return overall;
    }

    @Override
    public double getPrice() {
        return super.getPrice() +
                this.components.stream().mapToDouble(Product::getPrice).sum() +
                this.peripherals.stream().mapToDouble(Product::getPrice).sum();
    }

    @Override
    public void addComponent(Component component) {
        for (Component c : this.components) {
            if (c.getClass().getSimpleName().equals(component.getClass().getSimpleName())) {
                throw new IllegalArgumentException
                        (String.format(ExceptionMessages.EXISTING_COMPONENT, c.getClass().getSimpleName(),
                                this.getClass().getSimpleName(), this.getId()));
            }
        }
        this.components.add(component);
    }

    @Override
    public Component removeComponent(String componentType) {
        if (this.components.isEmpty()) {
            throw new IllegalArgumentException(String.format(ExceptionMessages.NOT_EXISTING_COMPONENT,
                    componentType, this.getClass().getSimpleName(), this.getId()));
        }
        Component component = null;
        for (Component c : this.components) {
            if (c.getClass().getSimpleName().equals(componentType)) {
                component = c;
                break;
            }
        }
        if (component == null) {
            throw new IllegalArgumentException(String.format(ExceptionMessages.NOT_EXISTING_COMPONENT,
                    componentType, this.getClass().getSimpleName(), this.getId()));
        }
        this.components.remove(component);

        return component;
    }

    @Override
    public void addPeripheral(Peripheral peripheral) {
        for (Peripheral p : this.peripherals) {
            if (p.getClass().getSimpleName().equals(peripheral.getClass().getSimpleName())) {
                throw new IllegalArgumentException(String.format(ExceptionMessages.EXISTING_PERIPHERAL,
                        peripheral.getClass().getSimpleName(), this.getClass().getSimpleName(), this.getId()));
            }
        }
        this.peripherals.add(peripheral);
    }

    @Override
    public Peripheral removePeripheral(String peripheralType) {
        if (this.peripherals.isEmpty()) {
            throw new IllegalArgumentException(String.format(ExceptionMessages.NOT_EXISTING_PERIPHERAL,
                    peripheralType, this.getClass().getSimpleName(), this.getId()));
        }
        Peripheral peripheral = null;
        for (Peripheral p : this.peripherals) {
            if (p.getClass().getSimpleName().equals(peripheralType)) {
                peripheral = p;
                break;
            }
        }
        if (peripheral == null) {
            throw new IllegalArgumentException(String.format(ExceptionMessages.NOT_EXISTING_PERIPHERAL,
                    peripheralType, this.getClass().getSimpleName(), this.getId()));
        }
        this.peripherals.remove(peripheral);
        return peripheral;
    }
}
