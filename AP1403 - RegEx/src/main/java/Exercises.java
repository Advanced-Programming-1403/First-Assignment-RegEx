import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Exercises {

    public boolean validateEmail(String email) {
        //Universal format for Emails
        String regex = "^(?=.{1,64}@)[A-Za-z0-9]+([._%+-]?[A-Za-z0-9]+)*@" +
                "[A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$";

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(email);

        return matcher.matches();
    }

    public String findDate(String string) {

        String regex = "\\b(?:" +
                // ISO format:
                "(\\d{4})[-/](0?[1-9]|1[0-2])[-/](0?[1-9]|[12][0-9]|3[01])" +
                "|" +
                // British format:
                "(0?[1-9]|[12][0-9]|3[01])[-/](0?[1-9]|1[0-2])[-/](\\d{4})" +
                "|" +
                // American format:
                "(0?[1-9]|1[0-2])[-/](0?[1-9]|[12][0-9]|3[01])[-/](\\d{4})" +
                ")\\b";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(string);
        if (matcher.find()) {
            return matcher.group();
        }
        return null;
    }

    public int findValidPasswords(String string) {

        int count = 0;
        String regex = "^(?=.*[A-Z])(?=.*[a-z])(?=.*\\d)(?=.*[!@#$%^&*])[^\\s]{8,}$";
        Pattern pattern = Pattern.compile(regex);

        String[] tokens = string.split("\\s+");

        for (String token : tokens) {
            Matcher matcher = pattern.matcher(token);

            if (matcher.matches()) {
                count++;
            }
        }
        return count;
    }

    public List<String> findPalindromes(String string) {

        List<String> list = new ArrayList<>();

        // Extract words that consist only of letters and have at least 3 characters.
        Pattern wordPattern = Pattern.compile("\\b[a-zA-Z]{3,}\\b");

        Matcher matcher = wordPattern.matcher(string);

        while (matcher.find()) {

            String word = matcher.group();
            String lower = word.toLowerCase();
            String reversed = new StringBuilder(lower).reverse().toString();

            if (lower.equals(reversed)) {
                list.add(word);
            }
        }
            return list;
        }

    public static void main(String[] args) {
        System.out.println("All of them are tested:)))");

    }
}
