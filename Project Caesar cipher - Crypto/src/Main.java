import java.util.*;

public class Main {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);

        String stringToEncrypt = input.nextLine();
        int key = input.nextInt();
        int numberOfGroups = input.nextInt();

        String cyphertext = encryptString(stringToEncrypt, key, numberOfGroups);
        System.out.println(cyphertext);

        String plaintext = decryptString(cyphertext, key);
        System.out.println("\n" + plaintext);

    }

    public static String normalizeText(String s){
        s = s.replace(" ", "");
        s = s.replace(".", "");
        s = s.replace(",", "");
        s = s.replace("!", "");
        s = s.replace("?", "");
        s = s.replace("/", "");
        s = s.replace("\\", "");
        s = s.replace("(", "");
        s = s.replace(")", "");
        s = s.replace("[", "");
        s = s.replace("]", "");
        s = s.replace("{", "");
        s = s.replace("}", "");
        s = s.replace(";", "");
        s = s.replace(":", "");
        s = s.replace("<", "");
        s = s.replace(">", "");
        s = s.replace("'", "");
        s = s.replace("\"", "");
        s = s.replace("*", "");
        s = s.replace("&", "");
        s = s.replace("%", "");
        s = s.replace("$", "");
        s = s.replace("#", "");
        s = s.replace("@", "");
        s = s.replace("+", "");
        s = s.replace("-", "");
        s = s.replace("=", "");
        s = s.toUpperCase();
        return s;
    }

    public static String caesarify(String s, int n){
        StringBuilder builder = new StringBuilder();

        String encryptedAlphabet = shiftAlphabet(n);
        for (int i = 0; i < s.length(); i++){
            if (s.charAt(i) == 'A'){
                builder.append(encryptedAlphabet.charAt(0));
            }
            else if (s.charAt(i) == 'B'){
                builder.append(encryptedAlphabet.charAt(1));
            }
            else if(s.charAt(i) == 'C'){
                builder.append(encryptedAlphabet.charAt(2));
            }
            else if (s.charAt(i) == 'D'){
                builder.append(encryptedAlphabet.charAt(3));
            }
            else if (s.charAt(i) == 'E'){
                builder.append(encryptedAlphabet.charAt(4));
            }
            else if (s.charAt(i) == 'F'){
                builder.append(encryptedAlphabet.charAt(5));
            }
            else if (s.charAt(i) == 'G'){
                builder.append(encryptedAlphabet.charAt(6));
            }
            else if (s.charAt(i) == 'H'){
                builder.append(encryptedAlphabet.charAt(7));
            }
            else if (s.charAt(i) == 'I'){
                builder.append(encryptedAlphabet.charAt(8));
            }
            else if (s.charAt(i) == 'J'){
                builder.append(encryptedAlphabet.charAt(9));
            }
            else if (s.charAt(i) == 'K'){
                builder.append(encryptedAlphabet.charAt(10));
            }
            else if (s.charAt(i) == 'L'){
                builder.append(encryptedAlphabet.charAt(11));
            }
            else if (s.charAt(i) == 'M'){
                builder.append(encryptedAlphabet.charAt(12));
            }
            else if (s.charAt(i) == 'N'){
                builder.append(encryptedAlphabet.charAt(13));
            }
            else if (s.charAt(i) == 'O'){
                builder.append(encryptedAlphabet.charAt(14));
            }
            else if (s.charAt(i) == 'P'){
                builder.append(encryptedAlphabet.charAt(15));
            }
            else if (s.charAt(i) == 'Q'){
                builder.append(encryptedAlphabet.charAt(16));
            }
            else if (s.charAt(i) == 'R'){
                builder.append(encryptedAlphabet.charAt(17));
            }
            else if (s.charAt(i) == 'S'){
                builder.append(encryptedAlphabet.charAt(18));
            }
            else if (s.charAt(i) == 'T'){
                builder.append(encryptedAlphabet.charAt(19));
            }
            else if (s.charAt(i) == 'U'){
                builder.append(encryptedAlphabet.charAt(20));
            }
            else if (s.charAt(i) == 'V'){
                builder.append(encryptedAlphabet.charAt(21));
            }
            else if (s.charAt(i) == 'W'){
                builder.append(encryptedAlphabet.charAt(22));
            }
            else if (s.charAt(i) == 'X'){
                builder.append(encryptedAlphabet.charAt(23));
            }
            else if (s.charAt(i) == 'Y'){
                builder.append(encryptedAlphabet.charAt(24));
            }
            else {
                builder.append(encryptedAlphabet.charAt(25));
            }
        }
        return builder.toString();
    }

    public static String shiftAlphabet(int shift) {
        StringBuilder result = new StringBuilder();
        int start;
        if (shift < 0) {
            start = (int) 'Z' + shift + 1;
        } else {
            start = 'A' + shift;
        }
        char currChar = (char) start;
        for(; currChar <= 'Z'; ++currChar) {
            result.append(currChar);
        }
        if(result.length() < 26) {
            for(currChar = 'A'; result.length() < 26; ++currChar) {
                result.append(currChar);
            }
        }
        return result.toString();
    }

    public static String groupify(String s, int n){
        StringBuilder builder = new StringBuilder();
        int aux1 = n;

        for (int i = 0; i < s.length(); i++){
            builder.append(s.charAt(i));
            --aux1;
            if (aux1 == 0 && i < (s.length() - 1)){
                builder.append(" ");
                aux1 = n;
            }
        }
        if (s.length()%n != 0){
            while (aux1 > 0){
                builder.append("x");
                --aux1;
            }
        }
        return builder.toString();
    }

    public static String ungroupfy(String s){
        s = s.replace(" ", "");
        s = s.replace("x", "");

        return s;
    }

    public static String encryptString(String s, int n, int i){
        s = normalizeText(s);
        s = caesarify(s, n);
        s = groupify(s, i);

        return s;
    }

    public static String decryptString(String s, int n){
        s = ungroupfy(s);
        s= caesarify(s, (n*(-1)));
        return s;
    }
}