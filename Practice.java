public class Practice {
    public static void main(String[] args){
        String s = "3902";
        StringBuilder s1 = new StringBuilder();

        for (int i = 0; i < s.length(); i += 2) {
            int a = s.charAt(i) - '0';
            int b = s.charAt(i + 1) - '0';
            int sum = (a + b) % 10;
            s1.append(sum);
        }

        String result = s1.toString();
        System.out.println(result);

    }
}
