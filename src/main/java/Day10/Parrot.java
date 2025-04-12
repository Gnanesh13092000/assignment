package Day10;

public class Parrot extends Bird {
    public Parrot(String name) {
        super(name);
        this.flyBehavior = new FlyWithWings();
    }

    @Override
    public void display() {
        System.out.println("I am a Parrot named " + name);
    }
}

