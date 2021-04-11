import java.util.HashSet;
import java.util.Set;

public class CheckCurrency {

    public static void main(String[] args) {

    }

    public boolean checkCurr(String currency) {
        Set<Character> validSymbol = new HashSet<>();
        validSymbol.add('¥');
        validSymbol.add('$');
        validSymbol.add('€');


        int startInd = 0;
        if (currency.charAt(0) == '-' || currency.charAt(currency.length() - 1) == ')' && currency.charAt(0) == '(')
            startInd = 1;
        else if ((currency.charAt(currency.length() - 1) != ')' && currency.charAt(0) == '(') || (currency.charAt(currency.length() - 1) == ')' && currency.charAt(0) != '('))
            return false;

        if (!validSymbol.contains(currency.charAt(startInd))) return false;

        boolean isComma = false;

        if (currency.contains(",")) {
            String[] components = currency.split(",");
            if (!components[components.length - 1].contains(".") && components[components.length - 1].length() > 3 || components[components.length - 1].contains(".") && components[components.length - 1].length() <= 3)
                return false;
            for (int i = 1; i < components.length - 1; i++) {
                if (components[i].length() != 3) return false;
                if (!components[i].matches("[0-9]+")) return false;
            }
        }


        return true;
    }
}
