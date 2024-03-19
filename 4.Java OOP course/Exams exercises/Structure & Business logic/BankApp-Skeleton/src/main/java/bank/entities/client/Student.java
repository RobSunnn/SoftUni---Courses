package bank.entities.client;

public class Student extends BaseClient{

    private static final int STUDENT_INITIAL_INTEREST = 2;

    public Student(String name, String ID, double income) {
        super(name, ID, STUDENT_INITIAL_INTEREST, income);
    }

    @Override
    public void increase() {
        this.setInterest(STUDENT_INITIAL_INTEREST + 1);
    }
}
