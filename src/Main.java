import java.util.Random;

public class Main
{

    public static void main(String[] args)
    {
        System.out.println("Panzers!");

        Panzer panzers[] = {
                new Panzer("Russian 1", 100,
                        100, 30, 6.0, 20.0),
                new Panzer("Russian 2", 100,
                        100, 15, 6.5, 15.0),
                new Panzer("Russian 3", 100,
                        100, 17, 5.0, 15.0),
                new Panzer("Russian 4", 80,
                        100, 10, 5.0, 15.0),
                new Panzer("Russian 5", 80,
                        100, 10, 5.0, 9.0),
                new Panzer("Russian 6", 80,
                        100, 7, 4.7, 9.0),
                new Panzer("Russian 7", 80,
                        100, 7, 4.7, 8.0),
                new Panzer("Russian 8", 75,
                        100, 7, 3.0, 7.0),
                new Panzer("Russian 9", 75,
                        100, 7, 2.0, 6.0),
        };
        Panzer enemyPanzers[] = {
                new Panzer("German 1", 130,
                        100, 20, 6.5, 10.0),
                new Panzer("German 2", 100,
                        100, 13, 6.5, 10.0),
                new Panzer("German 3", 85,
                        100, 20, 5.0, 10.0),
                new Panzer("German 4", 85,
                        100, 15, 5.0, 10.0),
                new Panzer("German 5", 75,
                        100, 15, 5.0, 9.0),
                new Panzer("German 6", 75,
                        100, 15, 5.0, 9.0),
                new Panzer("German 7", 80,
                        100, 10, 4.3, 9.0),
                new Panzer("German 8", 70,
                        100, 20, 4.0, 7.0),
                new Panzer("German 9", 70,
                        100, 7, 1.0, 6.0),
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

    abstract int attack(Panzer panzer);
    abstract void defense();
}

interface Playable
{
    int attack(Panzer panzer);
    void defense();
}

class Panzer extends AbstractPanzer implements Playable
{
    Random rnd;
    Panzer(String name, int health, int armor, int damage, double shotTime, double turnaroundTime)
    {
        super(name, health, armor, damage, shotTime, turnaroundTime);
        rnd = new Random(System.currentTimeMillis());
    }
    @Override
    public int attack(Panzer panzer)
    {
        switch (rnd.nextInt(3)) {
            case 0:
                System.out.println("Head to head attack: damage: " +
                        (damage)/(panzer.armor + shotTime) * 10);

                panzer.health -= (damage)/(panzer.armor + shotTime) * 10;
                break;
            case 1:
                System.out.println("Side attack: damage: " +
                        (damage)/(panzer.armor * panzer.turnaroundTime + shotTime) * 10);
                panzer.health -= (damage)/(panzer.armor * panzer.turnaroundTime + shotTime) * 10;
                health += (damage * shotTime)/(panzer.armor * panzer.turnaroundTime) * 10;
                break;
            case 2:
                System.out.println("Attack from behind: damage: " +
                        (damage)/(panzer.armor * panzer.turnaroundTime + shotTime) * 10);
                panzer.health -= (damage)/(panzer.armor * panzer.turnaroundTime + shotTime) * 10;
                health += (damage * shotTime)/(panzer.armor * panzer.turnaroundTime) * 10;
                break;
        }

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
        int random;
        int randomEnemy;
        do {

            while(team[swith^1].panzers[random = rnd.nextInt(9)].health <= 0);

            System.out.print("Panzer " + team[swith].panzers[random].name + " with "
                    + team[swith].panzers[random].health + " health from " + team[swith].name + " is attacking ");

            while(team[swith^1].panzers[randomEnemy = rnd.nextInt(9)].health <= 0);

            System.out.println("enemy panzer " + team[swith^1].panzers[randomEnemy].name + " with "
                    + team[swith^1].panzers[randomEnemy].health + " health from " + team[swith^1].name);


            team[swith].panzers[random].attack(team[swith^1].panzers[randomEnemy]);

//            System.out.println("New step");

            swith ^= 1;

//            for(int i = 0; i < team[0].panzers.length; i++)
//            {
//                team[0].panzers[i].health -= 10;
//            }

            for (int i = 0; i < 2; i++)
            {
                panzersHelath = 0;
                for (int j = 0; j < team[i].panzers.length; j++)
                {
                    panzersHelath += team[i].panzers[j].health;
                }
                if (panzersHelath <= 0)
                {
                    System.out.println(team[i^1].name + " WIN!");
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