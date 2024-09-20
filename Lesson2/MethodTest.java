public class MethodTest {
    
    public static void main(String[] args) {
        callNotBooleanMethods();
        System.out.println();
        callBooleanMethods();
    }

    public static void callNotBooleanMethods() {
        NotBooleanMethods nbm = new NotBooleanMethods();
        nbm.findLongestWord();
        nbm.selectMenuItem();
        nbm.calculateAverageRatings();
        nbm.countUniqueWords();
        nbm.printsMessageError();
        nbm.synchronizуData();
        nbm.recoverData();
        nbm.stopDownload();
        nbm.resetSettings();
        nbm.writeToFile();
        nbm.enterMathExpression();
        nbm.determineWinner();
        nbm.findBookNameAutor();
    }

    public static void callBooleanMethods() {
        BooleanMethods bm = new BooleanMethods();
        bm.isContinues();
        bm.isDeleted();
        bm.hasUniqueDigit();
        bm.isLetter();
        bm.hasEqualNumbers();
        bm.hasAttempts();
        bm.isVacant();
        bm.isEven();
        bm.isValidPath();
        bm.hasFile();
    }
}