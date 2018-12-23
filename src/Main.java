public class Main {

    public static void main(String[] args) {
        System.out.println("Panzers!");

        Panzer panzers[] = {
                new Panzer("Russian 1", 100,
                        100, 15, 5.0, 10.0),
                new Panzer("Russian 2", 100,
                        100, 15, 5.0, 10.0),
                new Panzer("Russian 3", 100,
                        100, 15, 5.0, 10.0),
                new Panzer("Russian 4", 100,
                        100, 15, 5.0, 10.0),
                new Panzer("Russian 5", 100,
                        100, 15, 5.0, 10.0),
                new Panzer("Russian 6", 100,
                        100, 15, 5.0, 10.0),
                new Panzer("Russian 7", 100,
                        100, 15, 5.0, 10.0),
                new Panzer("Russian 8", 100,
                        100, 15, 5.0, 10.0),
                new Panzer("Russian 9", 100,
                        100, 15, 5.0, 10.0),
        };
        Panzer enemyPanzers[] = {
                new Panzer("German 1", 100,
                        100, 15, 5.0, 10.0),
                new Panzer("German 2", 100,
                        100, 15, 5.0, 10.0),
                new Panzer("German 3", 100,
                        100, 15, 5.0, 10.0),
                new Panzer("German 4", 100,
                        100, 15, 5.0, 10.0),
                new Panzer("German 5", 100,
                        100, 15, 5.0, 10.0),
                new Panzer("German 6", 100,
                        100, 15, 5.0, 10.0),
                new Panzer("German 7", 100,
                        100, 15, 5.0, 10.0),
                new Panzer("German 8", 100,
                        100, 15, 5.0, 10.0),
                new Panzer("German 9", 100,
                        100, 15, 5.0, 10.0),
        };

        BattleField battle = new BattleField(panzers, enemyPanzers);
        System.out.println(battle.getSize());
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

class BattleField {
    Panzer[] panzers;
    Panzer[] enemyPanzers;
    BattleField(Panzer panzers[], Panzer enemyPanzers[]) {
        this.panzers = panzers;
        this.enemyPanzers = enemyPanzers;
    }

    int getSize() {
        return this.panzers.length;
    }

}