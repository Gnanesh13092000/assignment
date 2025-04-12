package Day10;

public class Crow extends Bird {
    public Crow(String name) {
        super(name);
        this.flyBehavior = new FlyWithWings();
    }

    @Override
    public void display() {
        System.out.println("I am a Crow named " + name);
    }
}

