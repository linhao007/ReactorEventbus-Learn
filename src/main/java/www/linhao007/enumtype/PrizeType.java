package www.linhao007.enumtype;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by linhu on 17/10/25.
 */
public enum PrizeType {
    NO_PRIZE(0, "未中奖奖品",""),
    PRIZE_COUPON(1, "代金券",""),
    PRIZE_ENTITY(2, "实物奖品","");

    private int code;
    private String desc;
    private String extra;

    PrizeType(int code, String desc, String extra) {
        this.code = code;
        this.desc = desc;
        this.extra = extra;
    }

    public int getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }

    public String getExtra() {
        return extra;
    }
}
