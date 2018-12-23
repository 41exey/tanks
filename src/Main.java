public class Main {

    public static void main(String[] args) {
        System.out.println("Panzer!");
        Panzer panzer1 = new Panzer("Russian", 100,
                100, 15, 5.0, 10.0);
    }
}

abstract class AbstractPanzer {
    String name;
    int health;
    int armor;
    int damage;
    double shotTime;
    double turnaroundTime;

    AbstractPanzer(String name, int health, int armor, int damage,
           double shotTime, double turnaroundTime) {
        this.name = name;
        this.health = health;
        this.armor = armor;
        this.damage = damage;
        this.shotTime = shotTime;
        this.turnaroundTime = turnaroundTime;
    }

    abstract int attack();
    abstract void defense();
}

interface Playable {
    int attack();
    void defense();
}

class Panzer extends AbstractPanzer implements Playable {

    Panzer(String name, int health, int armor, int damage,
           double shotTime, double turnaroundTime) {
        super(name, health, armor, damage,
                shotTime, turnaroundTime);
    }
    @Override
    public int attack() {
        return 0;
    }

    @Override
    public void defense() {

    }
}