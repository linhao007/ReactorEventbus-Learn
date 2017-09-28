package www.linhao007.event.service;

import org.springframework.stereotype.Service;
import reactor.bus.Event;
import www.linhao007.enumtype.EventType;
import www.linhao007.event.Listener.ReturnUserIdListener;
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

    @Resource
    private ReturnUserIdListener returnUserIdListener;

    /**
     * 异步发送创建用户事件
     * 发布订阅模型
     *
     * @param user
     */
    public void SyncCreateUser(User user) {
        eventBusService.fireUserEventBus().notify(EventType.CREATE_USER, Event.wrap(new UserEvent(user)));
    }

    /**
     * 请求应答模型
     *
     * @param user
     * @return
     */
    public void getUserId(User user) {
        eventBusService.fireUserEventBus().sendAndReceive(EventType.RETURN_USER_ID,Event.wrap(new UserEvent(user)),returnUserIdListener);
    }
}
