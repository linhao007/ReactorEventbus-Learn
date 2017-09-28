package www.linhao007.event;

/**
 * Created by linhu on 17/9/28.
 */
public abstract class BaseEvent<T> {
    private static final long serialVersionUID = 1000L;
    public abstract T getDto();
}
