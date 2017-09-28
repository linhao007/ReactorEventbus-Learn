package www.linhao007.event.model;

import www.linhao007.event.BaseEvent;
import www.linhao007.pojo.User;


/**
 * Created by linhu on 17/9/28.
 */
public class UserEvent extends BaseEvent<User> {
    private User user;

    public UserEvent(User user) {
        this.user = user;
    }

    @Override
    public User getDto() {
        return user;
    }
}
