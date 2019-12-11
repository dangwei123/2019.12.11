给定两个表示复数的字符串。

返回表示它们乘积的字符串。注意，根据定义 i2 = -1 。

示例 1:输入: "1+1i", "1+1i"
输出: "0+2i"
解释: (1 + i) * (1 + i) = 1 + i2 + 2 * i = 2i ，你需要将它转换为 0+2i 的形式。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/complex-number-multiplication
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
class Solution {
    public String complexNumberMultiply(String a, String b) {
        StringBuffer sb=new StringBuffer();
        int[] arr1=complexNumberMultiply(a);
        int[] arr2=complexNumberMultiply(b);
        int c=arr1[0]*arr2[0]-arr1[1]*arr2[1];
        int d=arr1[0]*arr2[1]+arr1[1]*arr2[0];
        sb.append(c).append("+").append(d).append("i");       
        return new String(sb);
    }

    private int[] complexNumberMultiply(String a){
        int i=0;
        int a1=0;
        int a2=0;
        int flag=0;
        for(;a.charAt(i)!='+';i++){
            if(a.charAt(i)=='-'){
                flag=1;
                continue;
            }
            a1=a1*10+(a.charAt(i)-'0');
        }
        if(flag==1){
            a1=-a1;
        }
        flag=0;
        for(i+=1;a.charAt(i)!='i';i++){
            if(a.charAt(i)=='-'){
                flag=1;
                continue;
            }
            a2=a2*10+(a.charAt(i)-'0');
        }
        if(flag==1){
            a2=-a2;
        }
        return new int[] {a1,a2};
    }
}


给定两个单词 word1 和 word2，找到使得 word1 和 word2 相同所需的最小步数，每步可以删除
任意一个字符串中的一个字符。

class Solution {
    public int minDistance(String word1, String word2) {
        int[][] dp=new int[word1.length()+1][word2.length()+1];
        int len=0;
        for(int i=0;i<word1.length();i++){
            for(int j=0;j<word2.length();j++){
                if(word2.charAt(j)==word1.charAt(i)){
                    dp[i+1][j+1]=dp[i][j]+1;      
                }else{
                    dp[i+1][j+1]=Math.max(dp[i][j+1],dp[i+1][j]);
                }
                len=Math.max(len,dp[i+1][j+1]);
            }
        }
        return word1.length()+word2.length()-2*len;
    }
}