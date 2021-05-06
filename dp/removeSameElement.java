
//2021.4.19每日一题 移除重复元素
/*
给你一个数组 nums 和一个值 val，你需要 原地 移除所有数值等于 val 的元素，并返回移除后数组的新长度。

不要使用额外的数组空间，你必须仅使用 O(1) 额外空间并 原地 修改输入数组。

元素的顺序可以改变。你不需要考虑数组中超出新长度后面的元素。 */
public class removeSameElement {
    public int removeElement(int[] nums, int val) {
        if(nums.length==1 &&nums[0]!=val ) return 1;
        if(nums.length==1 &&nums[0]==val ) return 0;

        int sameNum=0;
        int record=-1;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==val){
                sameNum+=1;
                continue;
            }
            if(nums[i]!=val && sameNum==0){
               record=i;
               continue;//正常
            }
            if(nums[i]!=val && sameNum!=0){
              swap(nums, i, record+1);
              record+=1;
          
           }
        }
        return nums.length-sameNum;
            
    }
    public void swap(int[] nums,int i,int j){
        int temp=nums[i];
        nums[i]=nums[j];nums[j]=temp;
}
}
