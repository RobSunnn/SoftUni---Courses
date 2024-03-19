package glacialExpedition.models.explorers;

public class GlacierExplorer extends BaseExplorer {

    private static final double INITIAL_ENERGY = 40.0;

    public GlacierExplorer(String name) {
        super(name, INITIAL_ENERGY);
    }
}
