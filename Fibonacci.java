public class Fibonacci {
    public int fibonnaci(int n){
        if(n==0) return 0;
        if(n==1) return 1;
        return fibonnaci(n-1) + fibonnaci(n-2);
    }
    public static void main(String args[]){
        int n = 7;
        int num1 = 0; int num2  = 1;
        System.out.print(num1 + "," + num2 );
        for(int i = 2;i<n;i++){
            int num3 = num1 + num2;
            System.out.print("," + num3);
            num1 = num2;
            num2 = num3;
        }
        System.out.println();
        Fibonacci m = new Fibonacci();
        for(int i=0;i<n;i++){
            System.out.print(m.fibonnaci(i) + "," );
        }
    }
}
