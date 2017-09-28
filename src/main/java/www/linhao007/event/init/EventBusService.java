package www.linhao007.event.init;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import reactor.Environment;
import reactor.bus.EventBus;
import reactor.core.config.ConfigurationReader;
import reactor.core.config.PropertiesConfigurationReader;
import www.linhao007.enumtype.EventType;
import www.linhao007.event.Lifecycle;
import www.linhao007.event.Listener.UserListener;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

import java.io.IOException;

import static reactor.bus.selector.Selectors.$;


/**
 * Created by linhu on 17/9/28.
 */
@Component
public class EventBusService implements Lifecycle {
    protected static Logger LOGGER = LoggerFactory.getLogger(EventBusService.class);

    private Environment userEnv;

    private EventBus userEventBus;

    @Resource
    private UserListener userListener;

    /**
     * 初始化事件驱动模型
     */
    @PostConstruct
    public void init() {
        LOGGER.info(".................event bus start............");
        ConfigurationReader reader = new PropertiesConfigurationReader("reactor-environment-config");
        userEnv = new Environment(reader);
        userEventBus = EventBus.create(userEnv, Environment.THREAD_POOL);
        initListener();
        LOGGER.info(".................event bus end............");
    }

    private void initListener() {
        LOGGER.info(".................init listener start............");
        userEventBus.on($(EventType.CREATE_USER), userListener);
        LOGGER.info(".................init listener end............");
    }

    public EventBus fireUserEventBus() {
        return userEventBus;
    }

    public void destory() {
        LOGGER.info("start close userEnv");
        try {
            userEnv.close();
        } catch (IOException e) {
            LOGGER.error("destroy env error", e);
        }
        LOGGER.info("end close userEnv");
    }
}
