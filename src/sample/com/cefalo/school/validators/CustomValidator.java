package sample.com.cefalo.school.validators;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by proshad on 10/25/16.
 */
public class CustomValidator {
    private static final String VALID_PHONE_REGEX = "^\\+(?:[0-9] ?){6,14}[0-9]$";
    private static final String VALID_EMAIL_REGEX = "^[_A-Za-z0-9]+([_A-Za-z0-9]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,6})$";
    private static final String VALID_ZIP_REGEX = "^(0[1-9]|[1-4][0-9]|5[0-2])[0-9]{3}$";


    public static CustomResponse checkForEmptyField(String name, String value) {
        CustomResponse response = new CustomResponse("1");
        if(value.equals(null) || value.isEmpty()){
            response.setStatus("0");
            response.getMessages().add(String.format("Invalid: %s cannot be Empty.", name));
        }

        return response;
    }

    public static CustomResponse validatePhone(String name, String value) {
        CustomResponse response = checkForEmptyField(name, value);
        if(response.getStatus().equals("0")) {
            return response;
        }

        if(!checkRegEx(Pattern.compile(VALID_PHONE_REGEX), value)) {
            response.setStatus("0");
            response.getMessages().add(String.format("Invalid: %s contains invalid phone number.", name));
        }

        return response;
    }

    public static CustomResponse validateEmail(String name, String value) {
        CustomResponse response = checkForEmptyField(name, value);
        if(response.getStatus().equals("0")) {
            return response;
        }

        if(!checkRegEx(Pattern.compile(VALID_EMAIL_REGEX), value)) {
            response.setStatus("0");
            response.getMessages().add(String.format("Invalid: %s contains invalid email address.", name));
        }

        return response;
    }

    public static CustomResponse validateZipCode(String name, String value) {
        CustomResponse response = checkForEmptyField(name, value);
        if(response.getStatus().equals("0")) {
            return response;
        }

        if(!checkRegEx(Pattern.compile(VALID_ZIP_REGEX), value)) {
            response.setStatus("0");
            response.getMessages().add(String.format("Invalid: %s contains wrong ZIP Code.", name));
        }

        return response;
    }


    private static boolean checkRegEx(Pattern p, String str) {
        Matcher matcher = p.matcher(str);
        return matcher.matches();
    }
}
