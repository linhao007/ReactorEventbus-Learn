package www.linhao007.event;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import reactor.fn.Consumer;

/**
 * Created by linhu on 17/9/28.
 */
public abstract class BaseListener<T> implements Consumer<T> {

    protected static Logger LOGGER = LoggerFactory.getLogger(BaseListener.class);

    @Override
    public void accept(T t) {
        try {
            // before event process
            LOGGER.info("BaseListener start process");
            process(t);
            // after event process
            LOGGER.info("BaseListener end process");
        } catch (Exception e) {
            LOGGER.info("BaseListener is error", e);
        } finally {

        }
    }

    public abstract void process(T t) throws Exception;

}
