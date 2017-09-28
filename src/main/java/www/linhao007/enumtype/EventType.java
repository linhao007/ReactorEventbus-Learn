package www.linhao007.enumtype;

/**
 * Created by linhu on 17/9/28.
 */
public enum EventType {
    CREATE_USER(2000, "创建新用户");

    public int code;
    public String desc = "";

    EventType(int code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public static String getDescByCode(int code) {
        for (EventType c : EventType.values()) {
            if (code == c.code) {
                return c.desc;
            }
        }
        return "";
    }
}
