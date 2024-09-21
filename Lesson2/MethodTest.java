public class MethodTest {
    
    public static void main(String[] args) {
        doNotBooleanMethods();
        System.out.println();
        doBooleanMethods();
    }

    private static void doNotBooleanMethods() {
        NotBooleanMethods nbm = new NotBooleanMethods();
        nbm.findLongestWord();
        nbm.selectMenuItem();
        nbm.avgGrades();
        nbm.countUniqueWords();
        nbm.printsMessageError();
        nbm.sync();
        nbm.recoverData();
        nbm.pauseDownload();
        nbm.resetSettings();
        nbm.writeToFile();
        nbm.enterMathExpression();
        nbm.determineWinner();
        nbm.findBookByAuthor();
        nbm.toFahrenheit();
    }

    private static void doBooleanMethods() {
        BooleanMethods bm = new BooleanMethods();
        System.out.println(bm.shouldContinue());
        System.out.println(bm.isDeleted());
        System.out.println(bm.hasUniqueDigit());
        System.out.println(bm.isLetter());
        System.out.println(bm.hasEqualNumbers());
        System.out.println(bm.hasAttempts());
        System.out.println(bm.isBlank());
        System.out.println(bm.isEven());
        System.out.println(bm.isValidPath());
        System.out.println(bm.hasFile());
    }
}