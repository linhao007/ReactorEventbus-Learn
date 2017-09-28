package www.linhao007.event;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import reactor.fn.Function;

/**
 * Created by linhu on 17/9/28.
 */
public abstract class BaseReceive<T, R> implements Function<T, R> {

    protected static Logger LOGGER = LoggerFactory.getLogger(BaseReceive.class);

    @Override
    public R apply(T t) {
        R r = null;
        try {
            // before event process
            LOGGER.info("BaseReceive start process");
            r = process(t);
            // after event process
            LOGGER.info("BaseReceive end process");
        } catch (Exception e) {
            LOGGER.info("BaseReceive is error", e);
        } finally {

        }
        return r;
    }

    public abstract R process(T t) throws Exception;
}
