import java.util.List;

public class BrikeWall {
    public int leastBricks(List<List<Integer>> wall) {
        int n=wall.size();
        int ans=0;
        int[] path=new int[wall.size()];
        int[] record=new int[wall.size()];
        int[] index=new int[wall.size()];
        for(int i=0;i<path.length;i++){//every col of birck wall
            int xx=0;
            for(int j=0;j<record.length;j++){
                record[j]=record[j]+wall.get(i).get(index[j]);
                index[j]+=1;
            }
            for(int m=0;m<n;m++){
                if ( record[m]==i) xx++;

            }
        ans=ans>xx?ans:xx;
        }
       return ans;
    }
}
