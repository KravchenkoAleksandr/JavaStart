public class Method {

    public static String getNameMethod() {
        return Thread.currentThread().getStackTrace()[2].getMethodName(); 
    }
}