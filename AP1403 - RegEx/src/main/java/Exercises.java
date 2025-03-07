import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Exercises {

    public boolean validateEmail(String email) {
        String regex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(email);

        return matcher.matches();
    }

    public String findDate(String string) {
        String regex = "\\b(\\d{1,2}[/-]\\d{1,2}[/-]\\d{2,4}|\\d{4}[/-]\\d{1,2}[/-]\\d{1,2})\\b";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(string);

        while (matcher.find()) {
            String date = matcher.group();

            String[] parts;
            if (date.contains("/")) {
                parts = date.split("/");
            } else if (date.contains("-")) {
                parts = date.split("-");
            } else {
                continue;
            }

            int day, month, year;
            if (parts[0].length() == 4) {
                year = Integer.parseInt(parts[0]);
                month = Integer.parseInt(parts[1]);
                day = Integer.parseInt(parts[2]);
            } else {
                day = Integer.parseInt(parts[0]);
                month = Integer.parseInt(parts[1]);
                year = Integer.parseInt(parts[2]);
            }

            if (month < 1 || month > 12) {
                continue;
            }
            if (day < 1 || day > 31) {
                continue;
            }
            if ((month == 4 || month == 6 || month == 9 || month == 11) && day > 30) {
                continue;
            }
            if (month == 2) {
                boolean isLeapYear = (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
                if (day > 29 || (day == 29 && !isLeapYear)) {
                    continue;
                }
            }

            return date;
        }

        return null;
    }

    public int findValidPasswords(String string) {
        String regex = "(?=\\S{8,})(?=\\S*[a-z])(?=\\S*[A-Z])(?=\\S*\\d)(?=\\S*[!@#$%^&*])\\S+";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(string);

        int count = 0;
        while (matcher.find()) {
            String password = matcher.group();
            if (!password.matches(".*\\s.*")) {
                count++;
            }
        }
        return count;
    }

    public List<String> findPalindromes(String string) {
        List<String> list = new ArrayList<>();

        String regex = "\\b[a-zA-Z]{3,}\\b";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(string);

        while (matcher.find()) {
            String word = matcher.group();
            String lowerCaseWord = word.toLowerCase();

            boolean isPalindrome = true;
            int length = lowerCaseWord.length();
            for (int i = 0; i < length / 2; i++) {
                if (lowerCaseWord.charAt(i) != lowerCaseWord.charAt(length - 1 - i)) {
                    isPalindrome = false;
                    break;
                }
            }

            if (isPalindrome) {
                list.add(word);
            }
        }

        return list;
    }
    public static void main(String[] args) {
    }
}
