import java.lang.reflect.Array;
import java.util.Arrays;

import javax.lang.model.util.Types;


/**给你一个整数数组 jobs ，其中 jobs[i] 是完成第 i 项工作要花费的时间。

请你将这些工作分配给 k 位工人。所有工作都应该分配给工人，且每项工作只能分配给一位工人。
工人的 工作时间 是完成分配给他们的所有工作花费时间的总和。请你设计一套最佳的工作分配方案，
使工人的 最大工作时间 得以 最小化 。

返回分配方案中尽可能 最小 的 最大工作时间 。
*/

public class leasttime1723 {

    /*
    //每次往里面最小的位置添加，但是这种方法不能通过所有，当用例的大部分与小部分之和相同的时候，就会发生问题
    public int minimumTimeRequired(int[] jobs, int k) {
        int max=0;//维护结果数组中的最大值
        int min_index=0; 
        int min;   
        Arrays.sort(jobs);//排序数组，便于后面从大到小添加
        int[] worker=new int[k];//工人
        for(int i=jobs.length-1;i>=0;i--){
            min=Integer.MAX_VALUE;
            for(int j=0;j<worker.length;j++){
                //每一步都找最小的加上
                if(worker[j]<min){
                    min=worker[j];
                    min_index=j;
                }
            }
            //给最小位置赋值，更新max
            worker[min_index]+=jobs[i];
            max=max>worker[min_index]?max:worker[min_index];

        }
        return max;
    }
*/

public int[] jobs;
public int ans=Integer.MAX_VALUE;
//采用带优化的dfs，有限分配给没有任务的工人，核心是剪枝处理
public int minimumTimeRequired(int[] jobs, int k) {
     int worker_num=0;
     int job_num=0;
     int[] worker=new int[k];   
     this.jobs=jobs;
     dfs(worker, job_num, worker_num, 0);
     int ans=this.ans;
     return ans;

}

    public void dfs(int[] worker, int job_num,int worker_num,int max){
        if(max>=ans) return;//结果比现有最小值小，跳过下一个
        if(job_num==jobs.length){
            ans=max;//
            return;
        }
        if(worker_num<worker.length){//关键：有限分配咩有工作的工人
            worker[worker_num]=jobs[job_num];
            dfs(worker, job_num+1, worker_num+1, Math.max(worker[worker_num],max));
            worker[worker_num]=0;//进行回溯操作
        }
        for(int i=0;i<worker_num;i++){//关键，只循环到已经使用过的工人
            worker[i]+=jobs[job_num];
            dfs(worker, job_num+1, worker_num, Math.max(worker[i], max));
            worker[i]-=jobs[job_num];//回溯并进行最大值更新
        }
    }
    

    public static void main(String[] args) {
        leasttime1723 ex=new leasttime1723();
        int[] jobs=new int[]{3,2,3};
        int k=3;
        System.out.print(ex.minimumTimeRequired(jobs, k));
    }
}
