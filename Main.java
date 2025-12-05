import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0) {
            int n = sc.nextInt();
            int k = sc.nextInt();
            String s = sc.next();

            int blockTill = -1;
            int sleep = 0;

            for(int i = 0; i < n; i++) {
                if(s.charAt(i) == '1') {

                    blockTill = Math.max(blockTill, i + k);
                } else {

                    if(i > blockTill) {
                        sleep++;
                    }
                }
            }

            System.out.println(sleep);
        }
    }
}
