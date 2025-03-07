import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Exercises {

    /*
        complete the method below, so it will validate an email address
     */

    public boolean validateEmail(String email) {
        if (email == null || email.isEmpty()) {
            return false;
        }

        String regex = "^[A-Za-z0-9._%+-]+@[A-Za-z0-9]+(-[A-Za-z0-9]+)*\\.[A-Za-z]{2,}$";


        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(email);

        return matcher.matches();
    }
    /*
        this method should find a date in string
        note that it should be in british or american format
        if there's no match for a date, return null
     */
    public String findDate(String input) {
        if (input == null || input.isEmpty()) {
            return null;
        }

        String regex = "\\b(0?[1-9]|[12][0-9]|3[01])([/.-])(0?[1-9]|1[0-2])\\2(\\d{4})\\b"
                + "|\\b(0?[1-9]|1[0-2])([/.-])([0-2]?[0-9]|3[01])\\6(\\d{4})\\b";

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);

        if (matcher.find()) {
            return matcher.group();
        }

        return null;
    }

    /*
        given a string, implement the method to detect all valid passwords
        then, it should return the count of them

        a valid password has the following properties:
        - at least 8 characters
        - has to include at least one uppercase letter, and at least a lowercase
        - at least one number and at least a special char "!@#$%^&*"
        - has no white-space in it
     */
    public int findValidPasswords(String string) {
        String specialChars = "!@#$%^&*";
        int count = 0;

        for (int i = 0; i <= string.length() - 8; i++) {
            for (int j = i + 8; j <= string.length(); j++) {
                String substring = string.substring(i, j);

                if (isValidPassword(substring, specialChars)) {
                    count++;
                }
            }
        }

        return count;
    }

    private boolean isValidPassword(String password, String specialChars) {
        if (password.contains(" ")) {
            return false;
        }

        boolean hasUpper = false, hasLower = false, hasDigit = false, hasSpecialChar = false;

        for (char c : password.toCharArray()) {
            if (Character.isUpperCase(c)) {
                hasUpper = true;
            } else if (Character.isLowerCase(c)) {
                hasLower = true;
            } else if (Character.isDigit(c)) {
                hasDigit = true;
            } else if (specialChars.indexOf(c) != -1) {
                hasSpecialChar = true;
            }
        }

        return hasUpper && hasLower && hasDigit && hasSpecialChar;
    }


    /*
        you should return a list of *words* which are palindromic
        by word we mean at least 3 letters with no whitespace in it

        note: your implementation should be case-insensitive, e.g. Aba -> is palindrome
     */
    public List<String> findPalindromes(String string) {
        List<String> list = new ArrayList<>();

        String[] words = string.split("[^a-zA-Z]+");

        for (String word : words) {
            if (word.length() >= 3 && isPalindrome(word)) {
                list.add(word.toLowerCase());
            }
        }

        return list;
    }

    private boolean isPalindrome(String word) {
        int left = 0;
        int right = word.length() - 1;

        while (left < right) {
            if (Character.toLowerCase(word.charAt(left)) != Character.toLowerCase(word.charAt(right))) {
                return false;
            }
            left++;
            right--;
        }

        return true;
    }
    public static void main(String[] args) {
        // you can test your code here
    }
}
