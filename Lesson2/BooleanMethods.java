public class BooleanMethods {
    
    public boolean isContinues() {
        System.out.println(NameMethod.getNameMethod() + 
                "() -> программа выполняется далее или завершается?");
        return true;
    }

    public boolean isDeleted() {
        System.out.println(NameMethod.getNameMethod() + 
                "() -> удалился ли файл на жестком диске или флешке?");
        return true;
    }

    public boolean hasUniqueDigit() {
        System.out.println(NameMethod.getNameMethod() + 
                "() -> последовательность содержит уникальную цифру?");
        return true;
    }

    public boolean isLetter() {
        System.out.println(NameMethod.getNameMethod() + 
                "() -> пользователь ввел букву или что-то другое?");
        return true;
    }

    public boolean hasEqualNumbers() {
        System.out.println(NameMethod.getNameMethod() + 
                "() -> в проверяемых числах, есть равные цифры?");
        return true;
    }

    public boolean hasAttempts() {
        System.out.println(NameMethod.getNameMethod() + 
                "() -> в игре \"Марио\" остались попытки?");
        return true;
    }

    public boolean isVacant() {
        System.out.println(NameMethod.getNameMethod() + 
                "() -> пользователь ввёл пустую строку или из одних пробелов?");
        return true;
    }

    public boolean isEven() {
        System.out.println(NameMethod.getNameMethod() + 
                "() -> на кубике, который бросил компьютер, выпало четное число?");
        return true;
    }

    public boolean isValidPath() {
        System.out.println(NameMethod.getNameMethod() + 
                "() -> путь до файла, который вы ищите на ssd, действительный?");
        return true;
    }

    public boolean hasFile() { 
        System.out.println(NameMethod.getNameMethod() + 
                "() -> файл по указанному адресу существует?");
        return true;
    }
}