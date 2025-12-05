public class Patterns {
    public static void main(String args[]){
        int n = 5;
//        Right Angle Trinagle  //

//        for(int i=1;i<n;i++){
//            for(int j=0;j<i;j++){
//                System.out.print("*");
//            }
//            System.out.println();
//        }

//        1,01,101,0101 pattern right angle triangle   //

//        for(int i=1;i<=n;i++){
//            for(int j=1;j<=i;j++){
//                if((i+j)%2 == 0){
//                    System.out.print(1 + " ");
//                }
//                else{
//                    System.out.print(0 + " ");
//                }
//            }
//            System.out.println();
//        }

        // traingle with 1,22,333,4444   //
//        for(int i=1;i<=n-1;i++){
//            for(int j=1; j<=n-i; j++){
//                System.out.print(" ");
//            }
//            for(int j = 1; j <= i; j++){
//                System.out.print(i + " ");
//            }
//            System.out.println();
//        }

        // 1234,1234,123,12,1//
//        for(int i=n;i>=0;i--){
//            int k = 1;
//            for(int j=i; j>0;j--){
//                System.out.print(k);
//                k++;
//            }
//            System.out.println();
//        }

        for(int i=1;i<=n;i++){
            for(int j=1;j<=n;j++){
                if(i==1 || i == n || j == 1 || j == n){
                    System.out.print("* ");
                }
                else{
                    System.out.print("  ");
                }
            }
            System.out.println();
        }
    }
}
