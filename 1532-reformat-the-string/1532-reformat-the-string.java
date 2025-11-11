class Solution {
    public String reformat(String s) {
        StringBuilder letter = new StringBuilder();
        StringBuilder digit = new StringBuilder();

        for(char c:s.toCharArray()){
            if(Character.isLetter(c)){
                letter.append(c);
            }
            else{
                digit.append(c);
            }
        }

        if(Math.abs(letter.length() - digit.length()) > 1){
            return  "";
        }

        StringBuilder result = new StringBuilder();
        StringBuilder longer = letter.length() >= digit.length() ? letter : digit;
        StringBuilder shorter = letter.length() < digit.length() ? letter : digit;
        
        for (int i = 0; i < shorter.length(); i++) {
            result.append(longer.charAt(i));
            result.append(shorter.charAt(i));
        }

        if(longer.length() > shorter.length()) {
         result.append(longer.charAt(longer.length() - 1));
        }

        return result.toString();

    }
}