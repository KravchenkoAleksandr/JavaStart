public class NameMethod {

    public static String getNameMethod() {
        String methodName = Thread.currentThread().getStackTrace()[2].getMethodName();
        return methodName;
    }
}