package www.linhao007.prize;

import com.google.common.collect.Range;
import com.google.common.collect.RangeMap;
import com.google.common.collect.TreeRangeMap;
import org.apache.commons.lang3.tuple.ImmutableTriple;
import org.apache.commons.lang3.tuple.Triple;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import www.linhao007.enumtype.PrizeType;

import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.stream.Collectors;

/**
 * @author: linhu
 * @date: 17/10/25 15:05
 * @description: 抽奖算法实现
 */
public class DrawPrize {

    private final static Logger LOGGER = LoggerFactory.getLogger(DrawPrize.class);

    /**
     * 生成离散区间
     *
     * @param prize              奖品列表(奖品ID,奖品权重,奖品title)
     * @param lotteryProbability 中奖概率
     * @return Triple<最大区间数值,范围,中奖概率></>
     */
    public static Triple<Integer, RangeMap<Integer, Integer>, Integer> buildLotteryRange(List<Triple<Integer, Integer, String>> prize, Integer lotteryProbability) {
        LOGGER.info("DrawLotteryUtils buildLotteryRange prize : {}  lotteryProbability : {}", prize, lotteryProbability);

        //生成区间
        Map<Integer, List<Triple<Integer, Integer, String>>> tmpMap = prize.stream().collect(Collectors.groupingBy(t -> t.getLeft()));
        int totalWeight = (int) prize.stream().collect(Collectors.summarizingInt(i -> i.getMiddle())).getSum();

        RangeMap<Integer, Integer> rangeMap = TreeRangeMap.create();
        int prizeUp = 0;
        int prizeLow = 0;
        for (Integer key : tmpMap.keySet()) {
            List<Triple<Integer, Integer, String>> triples = tmpMap.get(key);
            Triple<Integer, Integer, String> triple = triples.stream().findFirst().get();
            prizeLow = triple.getMiddle() + prizeUp;
            rangeMap.put(Range.openClosed(prizeUp, prizeLow), triple.getLeft());
            prizeUp = prizeLow;
        }

        LOGGER.info("lottery range : {}", rangeMap);
        return new ImmutableTriple<>(totalWeight,
                rangeMap, lotteryProbability);
    }

    /**
     * 抽奖
     *
     * @param integerRangeMapIntegerTriple
     * @return
     */
    public static Integer drawLottery(Triple<Integer, RangeMap<Integer, Integer>, Integer> integerRangeMapIntegerTriple) {
        //生成一个在[0,99]的随机整数
        int drawPrizeRandNum = new Random().nextInt(100);

        if (drawPrizeRandNum > integerRangeMapIntegerTriple.getRight() - 1) {
            return PrizeType.NO_PRIZE.getCode();
        }

        LOGGER.info("drawLottery rangeMap :{}", integerRangeMapIntegerTriple.getMiddle());
        //生成中奖区间号
        // 生成一个在[0,interval]的随机数
        int randNum = new Random().nextInt(integerRangeMapIntegerTriple.getLeft() + 1);
        LOGGER.info("drawLottery randNum :{}", randNum);

        //生成一个在[0,interval]的随机数
        int winPrizeRandNum = new Random().nextInt(integerRangeMapIntegerTriple.getLeft() + 1);
        LOGGER.info("drawLottery winPrizeRandNum :{}", winPrizeRandNum);

        return integerRangeMapIntegerTriple.getMiddle().get(winPrizeRandNum);
    }

}