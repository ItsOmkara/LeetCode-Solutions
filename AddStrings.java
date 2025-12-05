public class AddStrings {
    public static void main(String args[]){
        String s = "12456785467889";
        String s2  = "22456585467489";
        StringBuilder str = new StringBuilder();
        int i = s.length() - 1;
        int j = s2.length() - 1;
        int carry = 0;
        while(i>=0||j>=0||carry>0){
            int d1 = i>=0?s.charAt(i) - '0':0;
            int d2 = j>=0?s2.charAt(j) - '0':0;
            int sum = d1+d2+carry;
            str.append(sum%10);
            carry = sum/10;
            i--;
            j--;
        }
        System.out.println(str.reverse().toString());
    }
}
