public class Wolf {

    private char sex;
    private String name;
    private int weight;
    private int age;
    private String color;

    public char getSex() {
        return sex;
    }

    public void setSex(char sex) {
        this.sex = sex;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void go() {
        System.out.println("go");
    }

    public void sit() {
        System.out.println("sit");
    }

    public void run() {
        System.out.println("run");
    }

    public void howl() {
        System.out.println("howl");
    }

    public void hunt() {
        System.out.println("hunt");
    }
}