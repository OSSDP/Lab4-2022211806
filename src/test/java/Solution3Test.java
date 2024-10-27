
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.List;

public class Solution3Test {

    @Test
    public void testNormalInput() {
        // 测试目的：验证方法在正常输入下的正确性
        // 用到的测试用例：包含不同正整数的数组
        Solution3 solution = new Solution3();

        int[] nums1 = {1, 2, 3};
        List<Integer> result1 = solution.largestDivisibleSubset(nums1);
        // 由于 {1, 2} 和 {1, 3} 都是有效的最大整除子集，因此使用 containsAll 来检查
        assertTrue(result1.containsAll(List.of(1, 2)) || result1.containsAll(List.of(1, 3)));

        int[] nums2 = {1, 2, 4, 8};
        List<Integer> result2 = solution.largestDivisibleSubset(nums2);
        // 直接比较整个列表，因为期望的结果是排序好的
        assertEquals(List.of(8, 4, 2, 1), result2);
    }

    @Test
    public void testSingleLargestElement() {
        // 测试目的：验证当数组中存在一个元素远大于其他元素时的正确性
        // 用到的测试用例：包含一个远大于其他元素的数组
        Solution3 solution = new Solution3();
        int[] nums = {1, 2, 3, 1000000000};
        List<Integer> result = solution.largestDivisibleSubset(nums);
        assertTrue(result.contains(1000000000) || result.containsAll(List.of(1, 2, 3)));
    }
    @Test
    public void testBoundaryInput() {
        // 测试目的：验证方法在边界输入下的正确性
        // 用到的测试用例：空数组、只包含一个元素的数组
        Solution3 solution = new Solution3();
        int[] nums1 = {};
        List<Integer> result1 = solution.largestDivisibleSubset(nums1);
        assertTrue(result1.isEmpty());
        int[] nums2 = {1};
        List<Integer> result2 = solution.largestDivisibleSubset(nums2);
        assertEquals(List.of(1), result2);
    }
}