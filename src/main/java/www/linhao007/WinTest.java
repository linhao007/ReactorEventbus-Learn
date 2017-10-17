package www.linhao007;


import com.google.common.collect.Lists;
import com.google.common.collect.Range;
import com.google.common.collect.RangeMap;
import com.google.common.collect.TreeRangeMap;
import org.apache.commons.lang3.tuple.ImmutableTriple;
import org.apache.commons.lang3.tuple.Triple;

import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.stream.Collectors;

/**
 * Created by linhu on 17/10/16.
 * 抽奖概率算法
 */
public class WinTest {
    public static void main(String[] args) {
        testWin();
    }


    public static void testWin() {
        Integer winrobabilityP = 100 / 20; //中奖概率

        Triple<Integer, Integer, String> product1 = new ImmutableTriple<>(1, 1, "iphone8");
        Triple<Integer, Integer, String> product2 = new ImmutableTriple<>(2, 10000, "奖品1");
        Triple<Integer, Integer, String> product3 = new ImmutableTriple<>(3, 10000, "奖品2");
        Triple<Integer, Integer, String> product4 = new ImmutableTriple<>(4, 10000, "奖品3");
        Triple<Integer, Integer, String> product5 = new ImmutableTriple<>(5, 10000, "奖品4");
        List<Triple<Integer, Integer, String>> result = Lists.newArrayList(product1, product2, product3, product4, product5);


        //根据中奖概率算出未中奖区间
        int totalWeight = (int) result.stream().collect(Collectors.summarizingInt(i -> i.getMiddle())).getSum();

        //总区间值
        Integer interval = totalWeight * winrobabilityP;
        System.out.println("总区间值:" + interval);

        Triple<Integer, Integer, String> product6 = new ImmutableTriple<>(6, interval - totalWeight, "未中奖");
        result.add(product6);

        //生成中奖区间号
        int randNum = new Random().nextInt(interval + 1); //生成一个在[0,totalWeight]的随机数

        //生成区间
        Map<Integer, List<Triple<Integer, Integer, String>>> tmpMap = result.stream().collect(Collectors.groupingBy(t -> t.getLeft()));

        RangeMap<Integer, String> rangeMap = TreeRangeMap.create();
        int j = 0;
        int i = 0;
        for (Integer key : tmpMap.keySet()) {
            List<Triple<Integer, Integer, String>> triples = tmpMap.get(key);
            Triple<Integer, Integer, String> triple = triples.stream().findFirst().get();
            i = triple.getMiddle() + j;
            rangeMap.put(Range.openClosed(j, i), triple.getRight());
            j = i;
        }

        System.out.println("中奖区间:" + rangeMap);
        //中奖号码
        if (rangeMap.get(randNum).equals("未中奖")) {
            System.out.println("未中奖号:" + randNum);
        }

    }
}
