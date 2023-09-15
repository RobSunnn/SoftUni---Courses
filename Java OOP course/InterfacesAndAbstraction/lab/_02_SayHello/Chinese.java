package InterfacesAndAbstraction.lab._02_SayHello;

public class Chinese extends BasePerson {
    public Chinese(String name) {
        super(name);
    }

    @Override
    public String getName() {
        return null;
    }

    @Override
    public String sayHello() {
        return "你好";
    }

}
