package glacialExpedition.models.explorers;

public class NaturalExplorer extends BaseExplorer{

    private static final double INITIAL_ENERGY = 60.0;

    public NaturalExplorer(String name) {
        super(name, INITIAL_ENERGY);
    }

    @Override
    public void search() {
        double newEnergy = getEnergy() - 7;
        this.setEnergy(Math.max(newEnergy, 0.0));
    }
}

