public class ReplaceStringElements {
    public static char[] replaceStr(char[] str, int truelength) {
        int spaceCount = 0, index, i = 0;
        for (i = 0; i < truelength; i++) {
            if (str[i] == ' ')
                spaceCount++;
        }

        index = truelength + spaceCount * 2;
        char[] newStr = new char[index];
        if (truelength < str.length) str[truelength] = '\0';
        for (i = truelength - 1; i >= 0; i--) {
            if (str[i] == ' ') {
                newStr[index - 1] = '0';
                newStr[index - 2] = '2';
                newStr[index - 3] = '%';
                index -= 3;
            } else {
                newStr[index - 1] = str[i];
                index--;
            }
        }
        return newStr;
    }


    public static void main(String[] args) {
        char[] str = "Mr John Smith    ".toCharArray();
        str = replaceStr(str, str.length);
        for (char i : str) {
            System.out.print(i);
        }
    }
}
