import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.lang.String;

/**
 * Created By xfj on 2020/1/30
 * 给你一个餐馆信息数组 restaurants，其中  restaurants[i] = [idi, ratingi, veganFriendlyi, pricei, distancei]。你必须使用以下三个过滤器来过滤这些餐馆信息。

 其中素食者友好过滤器 veganFriendly 的值可以为 true 或者 false，如果为 true 就意味着你应该只包括 veganFriendlyi 为 true 的餐馆，为 false 则意味着可以包括任何餐馆。此外，我们还有最大价格 maxPrice 和最大距离 maxDistance 两个过滤器，它们分别考虑餐厅的价格因素和距离因素的最大值。

 过滤后返回餐馆的 id，按照 rating 从高到低排序。如果 rating 相同，那么按 id 从高到低排序。简单起见， veganFriendlyi 和 veganFriendly 为 true 时取值为 1，为 false 时，取值为 0 。

  

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/filter-restaurants-by-vegan-friendly-price-and-distance
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class FilterRestrunts {
    public List<Integer> filterRestaurants(int[][] restaurants, int veganFriendly, int maxPrice, int maxDistance) {
        // 过滤收集
        List<int[]> collector = new ArrayList<>();
        for (int[] restaurant : restaurants) {
            if (veganFriendly == 1 && restaurant[2] == 0 || restaurant[3] > maxPrice || restaurant[4] > maxDistance) {
                continue;
            }
            collector.add(restaurant);
        }
        // 排序
        collector.sort((o1, o2) -> o1[1] == o2[1] ? o2[0] - o1[0] : o2[1] - o1[1]);
        List<Integer> res = new ArrayList<>();
        for (int[] rest : collector) {
            res.add(rest[0]);
        }
        return res;
    }

    public List<Integer> filterRestaurants1(int[][] restaurants, int veganFriendly, int maxPrice, int maxDistance) {
        return Stream.of(restaurants)
                .filter(r -> veganFriendly != 1 || veganFriendly == r[2])
                .filter(r -> r[3] <= maxPrice)
                .filter(r -> r[4] <= maxDistance)
                .sorted((r1, r2) -> r1[1] != r2[1] ? r2[1] - r1[1] : r2[0] - r1[0])
                .map(r -> r[0])
                .collect(Collectors.toList());
    }

    public static void main(String[] args) {

        Integer[]str={1,3,4,5,7,2};
        List<Integer> collect = Arrays.stream(str).sorted(Comparator.naturalOrder()).collect(Collectors.toList());
        Integer[] integers = collect.toArray(new Integer[6]);
        String s = Arrays.toString(integers);
        System.out.println(s);

        Integer[]str1={1,3,4,5,7,2};
        Integer[] integers1 = Arrays.stream(str1).sorted(Comparator.reverseOrder()).collect(Collectors.toList()).toArray(new Integer[6]);
        s = Arrays.toString(integers1);
        System.out.println(s);
    }
}
