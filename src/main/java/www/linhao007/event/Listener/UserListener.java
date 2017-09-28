package www.linhao007.event.Listener;

import com.alibaba.fastjson.JSON;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import reactor.bus.Event;
import www.linhao007.event.BaseListener;
import www.linhao007.event.model.UserEvent;
import www.linhao007.pojo.User;

/**
 * Created by linhu on 17/9/28.
 */
@Service
public class UserListener extends BaseListener<Event<UserEvent>> {
    protected static Logger LOGGER = LoggerFactory.getLogger(UserListener.class);

    @Override
    public void process(Event<UserEvent> userEventEvent) throws Exception {
        LOGGER.info("start UserListener req : {}", JSON.toJSONString(userEventEvent));

        UserEvent data = userEventEvent.getData();
        User user = data.getDto();
        LOGGER.info("accept userEvent message : {}", JSON.toJSONString(user));

        LOGGER.info("end UserListener ");
    }
}
