package www.linhao007.event.service;

import org.springframework.stereotype.Service;
import reactor.bus.Event;
import www.linhao007.enumtype.EventType;
import www.linhao007.event.init.EventBusService;
import www.linhao007.event.model.UserEvent;
import www.linhao007.pojo.User;

import javax.annotation.Resource;

/**
 * Created by linhu on 17/9/28.
 */
@Service("userService")
public class UserService {
    @Resource
    private EventBusService eventBusService;

    /**
     * 异步发送创建用户事件
     *
     * @param user
     */
    public void SyncCreateUser(User user) {
        eventBusService.fireUserEventBus().notify(EventType.CREATE_USER, Event.wrap(new UserEvent(user)));
    }
}
