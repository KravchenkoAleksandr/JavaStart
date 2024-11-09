package com.startjava.lesson_2_3_4.method.naming;

public class BooleanMethods {
    
    public boolean shouldContinue() {
        System.out.print(Method.getNameMethod() + 
                "() -> программа выполняется далее или завершается? ");
        return true;
    }

    public boolean isDeleted() {
        System.out.print(Method.getNameMethod() + 
                "() -> удалился ли файл на жестком диске или флешке? ");
        return true;
    }

    public boolean hasUniqueDigit() {
        System.out.print(Method.getNameMethod() + 
                "() -> последовательность содержит уникальную цифру? ");
        return true;
    }

    public boolean isLetter() {
        System.out.print(Method.getNameMethod() + 
                "() -> пользователь ввел букву или что-то другое? ");
        return true;
    }

    public boolean hasEqualNumbers() {
        System.out.print(Method.getNameMethod() + 
                "() -> в проверяемых числах, есть равные цифры? ");
        return true;
    }

    public boolean hasAttempts() {
        System.out.print(Method.getNameMethod() + 
                "() -> в игре \"Марио\" остались попытки? ");
        return true;
    }

    public boolean isBlank() {
        System.out.print(Method.getNameMethod() + 
                "() -> пользователь ввёл пустую строку или из одних пробелов? ");
        return true;
    }

    public boolean isEven() {
        System.out.print(Method.getNameMethod() + 
                "() -> на кубике, который бросил компьютер, выпало четное число? ");
        return true;
    }

    public boolean isValidPath() {
        System.out.print(Method.getNameMethod() + 
                "() -> путь до файла, который вы ищите на ssd, действительный? ");
        return true;
    }

    public boolean hasFile() { 
        System.out.print(Method.getNameMethod() + 
                "() -> файл по указанному адресу существует? ");
        return true;
    }
}