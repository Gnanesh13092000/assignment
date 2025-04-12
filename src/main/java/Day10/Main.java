package Day10;

public class Main {
    public static void main(String[] args) {
        Bird crow = new Crow("Crowie");
        crow.display();
        crow.performFly();

        Bird parrot = new Parrot("Polly");
        parrot.display();
        parrot.performFly();

        Bird penguin = new Penguin("Pingu");
        penguin.display();
        penguin.performFly();
    }
}

