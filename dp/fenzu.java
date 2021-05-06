import java.sql.Array;
import java.util.Arrays;
import java.util.Stack;

/** 给定一副牌，每张牌上都写着一个整数。

此时，你需要选定一个数字 X，使我们可以将整副牌按下述规则分成 1 组或更多组：

每组都有 X 张牌。
组内所有的牌上都写着相同的整数。
仅当你可选的 X >= 2 时返回 true。
输入：[1,2,3,4,4,3,2,1]
输出：true
解释：可行的分组是 [1,1]，[2,2]，[3,3]，[4,4]
*/
public class fenzu {

    public boolean hasGroupsSizeX(int[] deck) {
        if(deck.length==1) return false;
        Arrays.sort(deck);
        Stack<Integer> record=new Stack<>();

        record.push(-1);
        for(int i=0;i<deck.length-1;i++){
            if(deck[i]!=deck[i+1]){
                record.push(i);
            }
        }

        int point=record.pop();
        int distance=deck.length-1-point;
        if(distance==1) return false;
        int ans=0;
        while(!record.isEmpty()){          
            int newPoint=record.pop();
            int newDistance=point-newPoint;
            ans=gcd(distance, newDistance);
            point=newPoint;
            distance=newDistance;

        }
        if(ans>=2)        return true;
 
    }


    public int gcd  (int a,int b){
        return a == 0 ? b : gcd(b % a, a);
         }


    public static void main(String[] args) {
        fenzu ex=new fenzu();
        int[] deck=new int[]{1,1,2,2,2,3,3,3};
        System.out.println(ex.hasGroupsSizeX(deck));
    }
}
