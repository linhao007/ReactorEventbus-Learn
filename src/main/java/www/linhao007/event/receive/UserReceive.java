package www.linhao007.event.receive;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import reactor.bus.Event;
import www.linhao007.event.BaseReceive;
import www.linhao007.event.model.UserEvent;

/**
 * Created by linhu on 17/9/28.
 */
@Service
public class UserReceive extends BaseReceive<Event<UserEvent>, Long> {

    protected static Logger LOGGER = LoggerFactory.getLogger(UserReceive.class);

    @Override
    public Long process(Event<UserEvent> userEventEvent) throws Exception {
        UserEvent userEvent = userEventEvent.getData();
        userEvent.getDto().setUserId(1008611L);
        return userEvent.getDto().getUserId();
    }
}
