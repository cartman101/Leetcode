public class arraychongfu {
    /*给你一个有序数组 nums ，请你 原地 删除重复出现的元素，使每个元素 只出现一次 ，返回删除后数组的新长度。

不要使用额外的数组空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。

。*/ 
    public int removeDuplicates(int[] nums) {
          if(nums.length==1) return 1;

          int sameNum=0;
          int record=0;
          for(int i=1;i<nums.length;i++){
              if(nums[i]==nums[record]){
                  sameNum+=1;
                  continue;
              }
              if(nums[i]>nums[record] && sameNum==0){
                 record=i;
                 continue;//正常升降顺序
              }
              if(nums[i]>nums[record] && sameNum!=0){
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

    public  static void main(String[] args) {
        int[] exam={-1,0,1,1,1,1,2,2,2,3,3,4,5,6,7};
        arraychongfu test=new arraychongfu();
        int times=test.removeDuplicates(exam);
        for(int i=0;i<times;i++){
            System.out.println(exam[i]);
        }
    }
}
