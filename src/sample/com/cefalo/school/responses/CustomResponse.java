package sample.com.cefalo.school.responses;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by proshad on 10/25/16.
 */
public class CustomResponse {
//    status 1 for valid, 0 for invalid
    private String status;
    private List<String> messages = new ArrayList<String>();

    public CustomResponse(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<String> getMessages() {
        return messages;
    }

    public void addMessage(String msg){
        messages.add(msg);
    }
}
