package www.linhao007;

import com.google.common.collect.Lists;
import com.google.common.collect.RangeMap;
import org.apache.commons.lang3.tuple.ImmutableTriple;
import org.apache.commons.lang3.tuple.Triple;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import www.linhao007.prize.DrawPrize;

import java.util.List;

/**
 * @author: linhu
 * @date: 17/10/25 15:40
 * @description:
 */
public class DrawPrizeApplication {
    private final static Logger LOGGER = LoggerFactory.getLogger(DrawPrizeApplication.class);

    public static void main(String[] args) {
        Triple<Integer, Integer, String> prize01 = new ImmutableTriple<>(1, 20, "奖品01");
        Triple<Integer, Integer, String> prize02 = new ImmutableTriple<>(2, 60, "奖品02");
        Triple<Integer, Integer, String> prize03 = new ImmutableTriple<>(3, 5, "奖品03");
        Triple<Integer, Integer, String> prize04 = new ImmutableTriple<>(4, 5, "奖品04");
        Triple<Integer, Integer, String> prize05 = new ImmutableTriple<>(5, 10, "奖品05");
        List<Triple<Integer, Integer, String>> prize = Lists.newArrayList(prize01, prize02, prize03, prize04, prize05);

        Triple<Integer, RangeMap<Integer, Integer>, Integer> integerRangeMapIntegerTriple = DrawPrize.buildLotteryRange(prize, 20);
        LOGGER.info("中奖离散区间:{}", integerRangeMapIntegerTriple);

        for (int i = 0; i < 10; i++) {
            Integer prizeId = DrawPrize.drawLottery(integerRangeMapIntegerTriple);
            if (prizeId == 0) {
                LOGGER.info("未中奖");
            } else {
                LOGGER.info("获奖奖品Id:{}", prizeId);
            }
        }

    }
}