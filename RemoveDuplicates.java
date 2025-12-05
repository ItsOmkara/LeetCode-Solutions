public class RemoveDuplicates {
    public static void main(String args[]){
        String s = "aabcdb";
//        char[] ch = s.toCharArray();
//        boolean isVisited = false;
//        for(int i=0;i<ch.length;i++){
//            for(int j=i+1;j<ch.length;j++){
//                if(ch[i] == ch[j]){
//                    isVisited = true;
//
//                }
//            }
//        }
//        StringBuilder str = new StringBuilder();
//        boolean[] seen = new boolean[256];
//
//        for (int i = 0; i < s.length(); i++) {
//            char currentChar = s.charAt(i);
//            if (!seen[currentChar]) {
//                str.append(currentChar);
//                seen[currentChar] = true;
//            }
//        }
//
//        System.out.println(str.toString());

        char[] arr = s.toCharArray();
        int n = arr.length;
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;){
                if(arr[i] == arr[j]){
                    for(int k = j;k<n-1;k++) {
                        arr[k] = arr[k + 1];
                    }
                    n--;
                }
                else{
                    j++;
                }
            }
        }
        for(int i=0;i<n;i++){
            System.out.print(arr[i]);
        }
    }
}
