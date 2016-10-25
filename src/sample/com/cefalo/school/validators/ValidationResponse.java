package sample.com.cefalo.school.validators;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by proshad on 10/25/16.
 */
public class ValidationResponse {
    private ValidationStatus status;
    private List<String> messages = new ArrayList<String>();

    public ValidationResponse() {
    }

    public ValidationResponse(ValidationStatus status) {
        this.status = status;
    }

    public ValidationResponse(ValidationStatus status, List<String> messages) {
        this.status = status;
        this.messages = messages;
    }

    public ValidationStatus getStatus() {
        return status;
    }

    public void setStatus(ValidationStatus status) {
        this.status = status;
    }

    public List<String> getMessages() {
        return messages;
    }

    public void setMessages(List<String> messages) {
        this.messages = messages;
    }
}
