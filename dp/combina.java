/**
 *给你一个由 不同 整数组成的数组 nums ，和一个目标整数 target 。请你从 nums 中找出并返回总和为 target 的元素组合的个数。

题目数据保证答案符合 32 位整数范围。
请注意，顺序不同的序列被视作不同的组合。 
 */
//
public class combina {
    //递归版本
    public int combinationSum4(int[] nums, int target) {
         if(target==0){return 1;};
         int ans=0;
         for(int i=0;i<nums.length;i++){
             if(target-nums[i]>=0 ){
                 ans+=combinationSum4(nums, target-nums[i]);
             }
         }
         return ans;
    }
/*
    //DP版本
    public int combinationSum4(int[] nums, int target) {
        int[] dp = new int[target + 1];
        dp[0] = 1;
        for (int i = 1; i <= target; i++) {
            for (int num : nums) {
                if (num <= i) {
                    dp[i] += dp[i - num];
                }
            }
        }
        return dp[target];
    }

*/


    public static void main(String[] args) {
        combina ex=new combina();
        int[] num=new int[]{2,1,3};
        System.out.println(ex.combinationSum4(num, 35));
    }
}
