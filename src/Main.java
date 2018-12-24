import java.util.Random;

public class Main
{

    public static void main(String[] args)
    {
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
//        System.out.println(battle.getSize());
//        battle.getStat();
        battle.battle();
    }
}

abstract class AbstractPanzer
{
    String name;
    int health;
    int armor;
    int damage;
    double shotTime;
    double turnaroundTime;

    AbstractPanzer(String name, int health, int armor, int damage,
           double shotTime, double turnaroundTime)
    {
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

interface Playable
{
    int attack();
    void defense();
}

class Panzer extends AbstractPanzer implements Playable
{

    Panzer(String name, int health, int armor, int damage,
           double shotTime, double turnaroundTime)
    {
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

class BattleField
{
    Panzer[] panzers;
    int panzersHelath;
    Panzer[] enemyPanzers;
    int enemyPanzersHaalth;
    Random rnd;
    BattleField(Panzer panzers[], Panzer enemyPanzers[])
    {
        this.panzers = panzers;
        this.enemyPanzers = enemyPanzers;
        rnd = new Random(System.currentTimeMillis());
    }

    int getSize()
    {
        return this.panzers.length;
    }

    void battle()
    {
        do {

            for(int i = 0; i < this.panzers.length; i++)
            {
                this.panzers[i].health -= 50;
            }

            panzersHelath = 0;
            for(int i = 0; i < this.panzers.length; i++)
            {
                panzersHelath += this.panzers[i].health;
            }
            enemyPanzersHaalth = 0;
            for(int i = 0; i < this.enemyPanzers.length; i++)
            {
                enemyPanzersHaalth += this.enemyPanzers[i].health;
            }
        }
        while(panzersHelath > 0 && enemyPanzersHaalth > 0);

        getStat();
    }

    void getStat()
    {
//        this.panzers[0] = null;
        System.out.println(" Team 1 (" + this.panzers.length + ")");
        for(int i = 0; i < this.panzers.length; i++)
        {
             System.out.println(" - Name: " + panzers[i].name + " Health: " + panzers[i].health);
        }
        System.out.println(" Team 2 (" + this.enemyPanzers.length + ")");
        for(int i = 0; i < this.enemyPanzers.length; i++)
        {
            System.out.println(" - Name: " + enemyPanzers[i].name + " Health: " + enemyPanzers[i].health);
        }
    }
}