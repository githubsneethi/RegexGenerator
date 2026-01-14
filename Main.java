import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

public class Main {

    private static final Scanner scanner = new Scanner(System.in);

    public static String generateEmailRegex() {
        return "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}$";
    }

    public static String generatePhoneRegex() {
        return "^(?:\\+91|91|0)?[6-9]\\d{9}$";
    }

    public static String generatePositiveIntegerRegex() {
        return "^[1-9]\\d*$";
    }

    public static String generateAlphanumericRegex(int minLength, int maxLength) {
        if (minLength < 0 || maxLength < minLength) {
            throw new IllegalArgumentException("Invalid length parameters");
        }
        return "^[a-zA-Z0-9]{" + minLength + "," + maxLength + "}$";
    }

    public static String generatePasswordRegex() {
        return "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,20}$";
    }

    public static String generateUrlRegex() {
        return "^https?://[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}(/.*)?$";
    }

    public static String generateDateRegex() {
        return "^(0[1-9]|1[0-2])/(0[1-9]|[12]\\d|3[01])/(19|20)\\d{2}$";
    }

    public static String generateCreditCardRegex() {
        return "^(?:4[0-9]{12}(?:[0-9]{3})?|5[1-5][0-9]{14}|3[47][0-9]{13})$";
    }

    public static String generateIpAddressRegex() {
        return "^(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)$";
    }

    public static String generateHexColorRegex() {
        return "^#([A-Fa-f0-9]{6}|[A-Fa-f0-9]{3})$";
    }

    public static boolean validate(String text, String regexPattern) {
        try {
            return Pattern.matches(regexPattern, text);
        } catch (PatternSyntaxException e) {
            System.out.println("Invalid regex pattern: " + e.getMessage());
            return false;
        }
    }

    public static void testCustomRegex() {
        System.out.print("Enter your custom regex pattern: ");
        String pattern = scanner.nextLine();

        System.out.print("Enter text to test against the pattern: ");
        String text = scanner.nextLine();

        boolean isValid = validate(text, pattern);
        System.out.println("Result: " + (isValid ? "MATCH" : "NO MATCH"));
        System.out.println();
    }

    public static void showMenu() {
        System.out.println("\n=== REGEX GENERATOR MENU ===");
        System.out.println("1. Email Validation");
        System.out.println("2. Phone Number Validation");
        System.out.println("3. Password Validation");
        System.out.println("4. URL Validation");
        System.out.println("5. Date Validation (MM/DD/YYYY)");
        System.out.println("6. IP Address Validation");
        System.out.println("7. Hex Color Code Validation");
        System.out.println("8. Credit Card Validation");
        System.out.println("9. Custom Regex Tester");
        System.out.println("10. Show All Patterns");
        System.out.println("0. Exit");
        System.out.print("Choose an option: ");
    }

    public static void showAllPatterns() {
        System.out.println("\n=== ALL REGEX PATTERNS ===");
        System.out.println("Email: " + generateEmailRegex());
        System.out.println("Phone: " + generatePhoneRegex());
        System.out.println("Password: " + generatePasswordRegex());
        System.out.println("URL: " + generateUrlRegex());
        System.out.println("Date: " + generateDateRegex());
        System.out.println("IP Address: " + generateIpAddressRegex());
        System.out.println("Hex Color: " + generateHexColorRegex());
        System.out.println("Credit Card: " + generateCreditCardRegex());
        System.out.println();
    }

    public static void main(String[] args) {
        System.out.println("Welcome to the Regex Generator!");
        System.out.println("This tool helps you generate and test regular expressions.");

        while (true) {
            showMenu();

            try {
                int choice = Integer.parseInt(scanner.nextLine());

                switch (choice) {
                    case 1:
                        System.out.print("Enter the email to validate: ");
                        String mailInput = scanner.nextLine();
                        boolean isMailValid = validate(mailInput, generateEmailRegex());
                        System.out.println("Result: " + (isMailValid ? "VALID" : "INVALID"));
                        break;

                    case 2:
                        System.out.print("Enter the phone number to validate: ");
                        String phoneInput = scanner.nextLine();
                        boolean isPhoneValid = validate(phoneInput, generatePhoneRegex());
                        System.out.println("Result: " + (isPhoneValid ? "VALID" : "INVALID"));
                        break;

                    case 3:
                        System.out.print("Enter the password to validate: ");
                        String pwdInput = scanner.nextLine();
                        boolean isPwdValid = validate(pwdInput, generatePasswordRegex());
                        System.out.println("Result: " + (isPwdValid ? "VALID" : "INVALID"));
                        break;

                    case 4:
                        System.out.print("Enter the URL to validate: ");
                        String urlInput = scanner.nextLine();
                        boolean isUrlValid = validate(urlInput, generateUrlRegex());
                        System.out.println("Result: " + (isUrlValid ? "VALID" : "INVALID"));
                        break;

                    case 5:
                        System.out.print("Enter the date to validate: ");
                        String dateInput = scanner.nextLine();
                        boolean isDateValid = validate(dateInput, generateDateRegex());
                        System.out.println("Result: " + (isDateValid ? "VALID" : "INVALID"));
                        break;

                    case 6:
                        System.out.print("Enter the IP Address to validate: ");
                        String ipInput = scanner.nextLine();
                        boolean isIpValid = validate(ipInput, generateIpAddressRegex());
                        System.out.println("Result: " + (isIpValid ? "VALID" : "INVALID"));
                        break;

                    case 7:
                        System.out.print("Enter the hex color to validate: ");
                        String hexInput = scanner.nextLine();
                        boolean isHexValid = validate(hexInput, generateHexColorRegex());
                        System.out.println("Result: " + (isHexValid ? "VALID" : "INVALID"));
                        break;

                    case 8:
                        System.out.print("Enter the credit card number to validate: ");
                        String ccInput = scanner.nextLine();
                        boolean isCCValid = validate(ccInput, generateCreditCardRegex());
                        System.out.println("Result: " + (isCCValid ? "VALID" : "INVALID"));
                        break;

                    case 9:
                        testCustomRegex();
                        break;

                    case 10:
                        showAllPatterns();
                        break;

                    case 0:
                        System.out.println("Thank you for using Regex Generator!");
                        scanner.close();
                        return;

                    default:
                        System.out.println("Invalid option. Please try again.\n");
                }

            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number.\n");
            }
        }
    }
}

