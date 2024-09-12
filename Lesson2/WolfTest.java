public class WolfTest {
    public static void main(String[] args) {
        Wolf wolf = new Wolf();
        wolf.setSex('f');
        wolf.setName("Jef");
        wolf.setWeight(25);
        wolf.setAge(9);
        wolf.setColor("Grey");
        System.out.println(wolf.getSex());
        System.out.println(wolf.getName());
        System.out.println(wolf.getWeight());
        System.out.println(wolf.getAge());
        System.out.println(wolf.getColor() + "\n");
        wolf.go();
        wolf.sit();
        wolf.run();
        wolf.howl();
        wolf.hunt();
    }
}