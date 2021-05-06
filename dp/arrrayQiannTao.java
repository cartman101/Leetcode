import java.util.HashSet;

public class arrrayQiannTao {
   
    public int arrayNesting(int[] nums) {
        if(nums.length==0) return 0;
        int ans=1;
        HashSet<Integer> record=new HashSet<>();
        for(int i=0;i<nums.length;i++){
           record.add(nums[i]);
           ans=ans>findMax(nums, nums[i], record)?ans:findMax(nums, nums[i], record);
           record.remove(nums[i]);
        }
        return ans;

    }

    public int findMax(int[] num,int a,HashSet<Integer> record ){
        while(!record.contains(num[a])){
               record.add(num[a]);
               a=num[a];
        }
        return record.size();

    }
  

}
