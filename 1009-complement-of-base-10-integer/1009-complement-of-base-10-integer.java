class Solution {
    public int bitwiseComplement(int n) {
        String binary = Integer.toBinaryString(n);
        StringBuilder sc = new StringBuilder();

        for(int i = 0; i<binary.length(); i++){
            if(binary.charAt(i) == '1'){
                sc.append('0');
            }
            else{
                sc.append('1');
            }
        }

        int number = Integer.parseInt(sc.toString(), 2);
        return number;
    }
}