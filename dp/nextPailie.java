/*实现获取 下一个排列 的函数，算法需要将给定数字序列重新排列成字典序中下一个更大的排列。

如果不存在下一个更大的排列，则将数字重新排列成最小的排列（即升序排列）。
。 */
// 方法 从后往前遍历，找到第一个不是升序排列的位置，然后从后面找到比这个位置差最小的替换，再将
//所有后面从新从小到大排列
public class nextPailie {
    public void nextPermutation(int[] nums) {
        int i = nums.length - 2;
        while (i >= 0 && nums[i] >= nums[i + 1]) {
            i--;
        }
        if (i >= 0) {
            int j = nums.length - 1;
            while (j >= 0 && nums[i] >= nums[j]) {
                j--;
            }
            swap(nums, i, j);
        }
        reverse(nums, i + 1);
    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public void reverse(int[] nums, int start) {
        int left = start, right = nums.length - 1;
        while (left < right) {
            swap(nums, left, right);
            left++;
            right--;
        }
    }


    public static void main(String[] args) {
        int[] wex=new int[]{4,2,0,2,3,2,0};
        nextPailie instance=new nextPailie();
        instance.nextPermutation(wex);
        for(int i:wex){ System.out.println(i);}
        }
}
