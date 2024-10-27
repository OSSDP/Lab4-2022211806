package $org.example;

/**
 * Hello world!
 *
 */
class Solution3 {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        Arrays.sort(nums); // 先对数组进行排序

        int n = nums.length;
        int[] dp = new int[n]; // dp[i] 表示以 nums[i] 结尾的最大整除子集的大小
        Arrays.fill(dp, 1); // 初始化，每个元素自身构成一个子集

        int maxSize = 1; // 最大整除子集的大小
        int maxIndex = 0; // 最大整除子集中最后一个元素的索引

        // 动态规划计算最大整除子集的大小
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] % nums[j] == 0) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            if (dp[i] > maxSize) {
                maxSize = dp[i];
                maxIndex = i;
            }
        }

        // 从最大元素开始倒推构建最大整除子集
        List<Integer> result = new ArrayList<>();
        for (int i = maxIndex; i >= 0; i--) {
            if (dp[i] == maxSize) {
                result.add(nums[i]);
                maxSize--; // 逐步减小，确保只加入当前最大整除子集的元素
            }
        }
        // 由于是从后往前添加，结果集已经是正确的顺序，无需反转
        return result;
    }
}


