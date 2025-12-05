public class Palindrome {
    public static void main(String args[]){
        int n = 1221;
        String nt = String.valueOf(n);
        String s = "2213";
        int num = Integer.valueOf(s);
        System.out.println(num);
        StringBuilder str = new StringBuilder(nt).reverse();
        System.out.println(str.toString().equals(nt));
    }
}
