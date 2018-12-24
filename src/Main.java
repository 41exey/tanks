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

class Team {
    String name;
    Panzer panzers[];

    Team(String name, Panzer panzers[]) {
        this.name = name;
        this.panzers = panzers;
    }
}

class BattleField
{
    Team team[];
    int panzersHelath;
    boolean endBattle;
    Random rnd;
    int swith;
    BattleField(Panzer panzers[], Panzer enemyPanzers[])
    {
        this.team = new Team[2];
        this.team[0] = new Team("Team 1", panzers);
        this.team[1] = new Team("Team 2", enemyPanzers);
        rnd = new Random(System.currentTimeMillis());
    }

    void battle()
    {
        do {

            System.out.println(team[swith].name + " is attacking the enemy");

            swith ^= 1;

            for(int i = 0; i < team[0].panzers.length; i++)
            {
                team[0].panzers[i].health -= 10;
            }

            for (int i = 0; i < 2; i++)
            {
                panzersHelath = 0;
                for (int j = 0; j < team[i].panzers.length; j++)
                {
                    panzersHelath += team[i].panzers[j].health;
                }
                if (panzersHelath <= 0)
                {
                    endBattle = true;
                    break;
                }

            }

        }
        while(!endBattle);

        getStat();
    }

    void getStat()
    {
        for(int i = 0; i < 2; i++) {
            System.out.println(" Team " + (i + 1) +" (" + team[i].panzers.length + ")");
            for (int j = 0; j < team[i].panzers.length; j++) {
                System.out.println(" - Name: " + team[i].panzers[j].name + " Health: " + team[i].panzers[j].health);
            }
        }
    }
}