package sample.com.cefalo.school.validators;


import org.apache.commons.lang3.StringUtils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by proshad on 10/25/16.
 */
public class FieldValidator {
    private static final String NAME_REGEX = "^[\\p{L} .'-]+$";
    private static final String PHONE_REGEX = "^\\+(?:[0-9] ?){6,14}[0-9]$";
    private static final String EMAIL_REGEX = "^[_A-Za-z0-9]+([_A-Za-z0-9]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,6})$";
    private static final String DATE_REGEX = "^\\d{1,2}/\\d{1,2}/\\d{4}$";
    private static final String ZIP_CODE_REGEX = "^(0[1-9]|[1-4][0-9]|5[0-2])[0-9]{3}$";

    public static ValidationResponse validateComboEntry(String name, int selectedIndex) {
        ValidationResponse response = new ValidationResponse(ValidationStatus.SUCCESS);
        if(selectedIndex == -1) {
            response.setStatus(ValidationStatus.ERROR);
            response.getMessages().add(String.format("Field: %s is selected with invalid item", name));
        }

        return response;
    }

    public static ValidationResponse checkForEmptyField(String name, String value) {
        ValidationResponse response = new ValidationResponse(ValidationStatus.SUCCESS);
        if(StringUtils.isBlank(value)) {
            response.setStatus(ValidationStatus.ERROR);
            response.getMessages().add(String.format("Field: %s Empty.", name));
        }

        return response;
    }

    public static ValidationResponse validateName(String name, String value) {
        ValidationResponse response = checkForEmptyField(name, value);
        if(response.getStatus() == ValidationStatus.ERROR) {
            return response;
        }

        if(!checkRegEx(Pattern.compile(NAME_REGEX), name)) {
            response.setStatus(ValidationStatus.ERROR);
            response.getMessages().add(String.format("Field: %s contains invalid name."));
        }

        return response;
    }

    public static ValidationResponse validatePhone(String name, String value) {
        ValidationResponse response = checkForEmptyField(name, value);
        if(response.getStatus() == ValidationStatus.ERROR) {
            return response;
        }

        if(!checkRegEx(Pattern.compile(PHONE_REGEX), value)) {
            response.setStatus(ValidationStatus.ERROR);
            response.getMessages().add(String.format("Field: %s contains invalid phone number.", name));
        }

        return response;
    }

    public static ValidationResponse validateEmail(String name, String value) {
        ValidationResponse response = checkForEmptyField(name, value);
        if(response.getStatus() == ValidationStatus.ERROR) {
            return response;
        }

        if(!checkRegEx(Pattern.compile(EMAIL_REGEX), value)) {
            response.setStatus(ValidationStatus.ERROR);
            response.getMessages().add(String.format("Field: %s contains invalid email address.", name));
        }

        return response;
    }

    public static ValidationResponse validateDate(String name, String value) {
        ValidationResponse response = checkForEmptyField(name, value);
        if(response.getStatus() == ValidationStatus.ERROR) {
            return response;
        }

        if(!checkRegEx(Pattern.compile(DATE_REGEX), value)) {
            response.setStatus(ValidationStatus.ERROR);
            response.getMessages().add(String.format("Field: %s contains invalid date.", name));
        }

        return response;
    }

    public static ValidationResponse validateZipCode(String name, String value) {
        ValidationResponse response = checkForEmptyField(name, value);
        if(response.getStatus() == ValidationStatus.ERROR) {
            return response;
        }

        if(!checkRegEx(Pattern.compile(ZIP_CODE_REGEX), value)) {
            response.setStatus(ValidationStatus.ERROR);
            response.getMessages().add(String.format("Field: %s contains ZIP Code.", name));
        }

        return response;
    }

    public static ValidationResponse validatePassword(String password, String confirmPassword) {
        ValidationResponse response = new ValidationResponse(ValidationStatus.SUCCESS);
        if(StringUtils.isBlank(password)) {
            response.setStatus(ValidationStatus.ERROR);
            response.getMessages().add("Field: Password Empty.");
            return response;
        }

        if(StringUtils.isBlank(confirmPassword)) {
            response.setStatus(ValidationStatus.ERROR);
            response.getMessages().add("Field: Confirm Password Empty.");
            return response;
        }

        if(password.length() < 6 || confirmPassword.length() < 6) {
            response.setStatus(ValidationStatus.ERROR);
            response.getMessages().add("Password must be at least 6 characters.");
            return response;
        }

        if(!StringUtils.equals(password, confirmPassword)) {
            response.setStatus(ValidationStatus.ERROR);
            response.getMessages().add("Both Password and Confirm password should match.");
            return response;
        }

        return response;
    }

    private static boolean checkRegEx(Pattern p, String str) {
        Matcher matcher = p.matcher(str);
        return matcher.matches();
    }
}
