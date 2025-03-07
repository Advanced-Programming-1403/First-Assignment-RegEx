import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Exercises {

    /*
        complete the method below, so it will validate an email address
     */
    public boolean validateEmail(String email) {
        String regex ="^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@" + "(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$" ;
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(email);

        return matcher.matches();
    }

    /*
        this method should find a date in string
        note that it should be in british or american format
        if there's no match for a date, return null
     */
    public String findDate(String string) {
        String regex = "(0[1-9]|[12][0-9]|3[01])[-/](0[1-9]|1[0-2])[-/](\\d{4})|\\d{4}[-/](0[1-9]|1[0-2])[-/](0[1-9]|[12][0-9]|3[01])";

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(string);

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
        String regex = "(?=.*[A-Z])(?=.*[a-z])(?=.*\\d)(?=.*[!@#$%^&*])[^\\s]{8,}";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(string);
        int v = 0;
        String[] words = string.split(" ");
        for (String word : words) {
            if (matcher.reset(word).find()) {
                v++;
            }
        }
        return v;
    }

    /*
        you should return a list of *words* which are palindromic
        by word we mean at least 3 letters with no whitespace in it

        note: your implementation should be case-insensitive, e.g. Aba -> is palindrome
     */
    public List<String> findPalindromes(String string) {
        List<String> list = new ArrayList<>();
        string = string.replaceAll("[^a-zA-Z ]", "");
        String[] words = string.split("\\s+");
        for (String word : words) {
            if (word.length() >= 3) {
                String lowerWord = word.toLowerCase();
                String reversed = new StringBuilder(lowerWord).reverse().toString();
                if (lowerWord.equals(reversed)) {
                    list.add(word);
                }
            }
        }

        return list;
    }

    public static void main(String[] args) {
        Exercises ex = new Exercises();
        System.out.println(ex.validateEmail("example@example.com"));
        System.out.println(ex.findDate("12/09/2023"));
        System.out.println(ex.findValidPasswords("P@ssw0rd test Invalid Pass1"));
        List<String> palindromes = ex.findPalindromes("Madam, did you see Bob running? Kayak radar civic level");
        System.out.println(palindromes);
    }
}
