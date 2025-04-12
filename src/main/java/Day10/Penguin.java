package Day10;

public class Penguin extends Bird {
    public Penguin(String name) {
        super(name);
        this.flyBehavior = new CannotFly();
    }

    @Override
    public void display() {
        System.out.println("I am a Penguin named " + name);
    }
}

