package Day10;

public class CannotFly implements FlyBehavior {
    @Override
    public void fly() {
        System.out.println("I can't fly.");
    }
}

