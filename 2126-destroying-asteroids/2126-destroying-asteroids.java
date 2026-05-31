class Solution {
    public boolean asteroidsDestroyed(int mass, int[] asteroids) {
        Arrays.sort(asteroids);
        long planetMass = mass;
        for (int asteroid : asteroids) {
            if (planetMass < asteroid) return false;
            planetMass += asteroid;
        }
        return true;
    }
}