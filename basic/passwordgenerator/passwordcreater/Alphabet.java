package basic.passwordgenerator.passwordcreater;

public final class Alphabet {
    private final String UPPERCASE_LETTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private final String LOWERCASE_LETTERS = "abcdefghijklmnopqrstuvwxyz";
    private final String NUMBERS = "1234567890";
    private final String SYMBOLS = "!@#$%^&*()-_=+\\\\/~?";
 
    public final String getUPPERCASE_LETTERS() {
       return this.UPPERCASE_LETTERS;
    }
 
    public final String getLOWERCASE_LETTERS() {
       return this.LOWERCASE_LETTERS;
    }
 
    public final String getNUMBERS() {
       return this.NUMBERS;
    }
 
    public final String getSYMBOLS() {
       return this.SYMBOLS;
    }
 
    public final String getAlphabet(boolean isUppercase, boolean isLowercase, boolean isNumbers, boolean isSymbol) {
       String alphabet = "";
       if (isUppercase) {
          alphabet = alphabet + this.UPPERCASE_LETTERS;
       }
 
       if (isLowercase) {
          alphabet = alphabet + this.LOWERCASE_LETTERS;
       }
 
       if (isNumbers) {
          alphabet = alphabet + this.NUMBERS;
       }
 
       if (isSymbol) {
          alphabet = alphabet + this.SYMBOLS;
       }
 
       return alphabet;
    }
 }
 