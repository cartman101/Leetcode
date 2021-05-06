public class strStr {
    public int strStr(String haystack, String needle) {
           if(needle=="") { return 0;}
           int index=0;
           boolean flag=false;
           for(int i=0;i<haystack.length()-needle.length()+1 ;i++){
                   int ppit=i;int qpit=0;
                   while(ppit<haystack.length() && qpit<needle.length()){

                       if(haystack.charAt(ppit)==needle.charAt(qpit) ){
                            ppit+=1;
                            qpit+=1;
                            index=ppit;//更新坐标点
                             if(qpit==needle.length()-1) { flag=true; break; }
                       }else{
                           qpit=0;
                           break;
                       }
                   }
           }
           if(flag) { return index-needle.length()+1; }
           else{
                 return -1;
           }
    }
    public static void main(String[] args) {
        String hay="";
        String needle="";
        strStr ex=new strStr();
        int ans=ex.strStr(hay, needle);
        System.out.println(ans);
    }
}
