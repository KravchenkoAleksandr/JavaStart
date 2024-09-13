public class JaegerTest {
    public static void main(String[] args) {
        Jaeger jaeger = new Jaeger();
        jaeger.setName("Bracer Phoenix");
        jaeger.setLaunched(2025);
        jaeger.setStatus("Destroyed");
        jaeger.setHeight(71);
        jaeger.setWeapons("Vortex Cannon");
        jaeger.setAmountAmmunition(100);
        System.out.println(jaeger.getName());
        jaeger.useWeapon();
        Jaeger jaeger2 = new Jaeger("Apex", 2035, "Deceased", 88, "Energy beam", 100);
        System.out.println(jaeger2.getName());
        jaeger2.useWeapon();
    }
}