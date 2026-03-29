class Solution {
    public boolean canBeEqual(String s1, String s2) {
        char[] e1 = {s1.charAt(0), s1.charAt(2)};
        char[] e2 = {s2.charAt(0), s2.charAt(2)};
        Arrays.sort(e1);
        Arrays.sort(e2);

        char[] o1 = {s1.charAt(1), s1.charAt(3)};
        char[] o2 = {s2.charAt(1), s2.charAt(3)};
        Arrays.sort(o1);
        Arrays.sort(o2);

        return Arrays.equals(e1, e2) && Arrays.equals(o1, o2);
    }
}