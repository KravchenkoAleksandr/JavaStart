
public class WolfTest {
    public static void main(String[] args) {
        Wolf wolf = new Wolf();
        wolf.sex = 'f';
        wolf.name = "Jef";
        wolf.weight = 25;
        wolf.age = 12;
        wolf.color = "Grey";
        System.out.println(wolf.sex);
        System.out.println(wolf.name);
        System.out.println(wolf.weight);
        System.out.println(wolf.age);
        System.out.println(wolf.color + "\n");
        wolf.go();
        wolf.sit();
        wolf.run();
        wolf.howl();
        wolf.hunt();
    }
}