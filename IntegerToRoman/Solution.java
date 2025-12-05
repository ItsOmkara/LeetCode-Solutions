package IntegerToRoman;

public class Solution {

    // Roman to Integer //

    public  int RomantoInt(String r){
        int result = 0;
        int prev = 0;

        for(int i=r.length() - 1;i>=0;i--){
          int curr = value(r.charAt(i));
          if(curr<prev)
          {
              result-=curr;
          }
          else {
              result += curr;
          }
          prev =  curr;
        }
        return result;
    }

    public int value(char ch){
        switch(ch){
            case 'I': return 1;
            case 'V': return 5;
            case 'X': return 10;
            case 'L': return 50;
            case 'C': return 100;
            case 'D': return 500;
            case 'M': return 1000;
        }
        return 0;
    }

    public static void main(String args[]){
        int nums = 14;
        String [] RomanNumerals = {"M","CM","D","CD","C","XC","L","XL", "X","IX","V","IV","I"};
        int [] values = {1000,900,500,400,100,90,50,40,10,9,5,4,1};
        StringBuilder sc = new StringBuilder();
        for(int i=0;i<values.length;i++){
            while(nums>=values[i]) {
                sc.append(RomanNumerals[i]);
                nums-=values[i];
            }
        }
        System.out.println(sc.toString());

        // Roman to Integer //

        String r = "X";
        Solution sce = new Solution();
        System.out.println(sce.RomantoInt(r));
    }
}
