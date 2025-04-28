package ru.innopolis.StyleFit.utils;

import java.util.regex.Pattern;

public class EmailUtil {

    // Regular expression for validating an email address
    private static final String EMAIL_REGEX = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";
    private static final Pattern EMAIL_PATTERN = Pattern.compile(EMAIL_REGEX);

    /**
     * Validates the given email address.
     *
     * @param email the email address to validate
     * @return true if the email is valid, false otherwise
     */
    public static boolean isValidEmail(String email) {
        return email != null && EMAIL_PATTERN.matcher(email).matches();
    }

    /**
     * Sends an email (this is a placeholder; actual implementation would require a mail library).
     *
     * @param to      the recipient's email address
     * @param subject the subject of the email
     * @param body    the body of the email
     */
    public static void sendEmail(String to, String subject, String body) {
        // Implementation would go here, for example using JavaMail API
        System.out.println("Sending email to: " + to);
        System.out.println("Subject: " + subject);
        System.out.println("Body: " + body);
    }

    // Additional utility methods can be added here
}
