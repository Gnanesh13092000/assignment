package Day10;

public abstract class Bird {
    protected String name;
    protected FlyBehavior flyBehavior;

    public Bird(String name) {
        this.name = name;
    }

    public void performFly() {
        flyBehavior.fly();
    }

    public abstract void display();
}

