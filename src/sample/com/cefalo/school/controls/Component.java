package sample.com.cefalo.school.controls;


import sample.com.cefalo.school.responses.CustomResponse;

/**
 * Created by proshad on 10/25/16.
 */
public interface Component {
    void add(Component component);
    void remove(Component component);
    CustomResponse validate();
}
