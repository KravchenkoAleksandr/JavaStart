public class JaegerTest {
    public static void main(String[] args) {
        Jaeger jaeger = new Jaeger("Bracer Phoenix", 2025, "Destroyed", 71, "Vortex Cannon", 100);
        System.out.println(jaeger.getName());
        jaeger.useWeapon();
        Jaeger jaeger2 = new Jaeger("Apex", 2035, "Deceased", 88, "Energy beam", 100);
        System.out.println(jaeger2.getName());
        jaeger2.useWeapon();

    }
}