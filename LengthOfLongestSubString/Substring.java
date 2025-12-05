package LengthOfLongestSubString;
public class Substring {
    public int LengthOfLongestSubString(String s){

        int maxlen = 0;
        int left = 0;
        int [] map = new int[256];

        for(int right = 0;right < s.length();right++){
            char ch = s.charAt(right);
            left = Math.max(left, map[ch]);
            maxlen = Math.max(maxlen, right - left + 1);
            map[ch] = right + 1;
        }
        return maxlen;
    }
    public static void main(String args[]){
        Substring s = new Substring();
        String str = "wwekwe";
        System.out.println(s.LengthOfLongestSubString(str));
    }
}
