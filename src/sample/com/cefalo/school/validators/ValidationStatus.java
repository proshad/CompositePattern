package sample.com.cefalo.school.validators;

/**
 * Created by proshad on 10/25/16.
 */
public enum ValidationStatus {
    ERROR("Error"),
    WARNING("Warning"),
    SUCCESS("Success");

    String value;

    ValidationStatus(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }
}
