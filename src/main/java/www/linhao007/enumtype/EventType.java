package www.linhao007.enumtype;

/**
 * Created by linhu on 17/9/28.
 */
public enum EventType {
    CREATE_USER(2000, "发布订阅模式--创建新用户"),
    RETURN_USER_ID(3000, "请求应答模式--返回用户ID");

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
