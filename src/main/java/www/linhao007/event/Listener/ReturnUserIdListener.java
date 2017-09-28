package www.linhao007.event.Listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import reactor.bus.Event;
import www.linhao007.event.BaseListener;

/**
 * Created by linhu on 17/9/28.
 */
@Service
public class ReturnUserIdListener extends BaseListener<Event<Long>> {

    protected static Logger LOGGER = LoggerFactory.getLogger(ReturnUserIdListener.class);

    @Override
    public void process(Event<Long> longEvent) throws Exception {
        Long data = longEvent.getData();
        LOGGER.info("返回的用户ID:{}", data);
    }
}
