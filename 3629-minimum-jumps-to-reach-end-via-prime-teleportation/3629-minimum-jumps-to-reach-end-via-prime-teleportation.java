class Solution {
    public int minJumps(int[] nums) {
        int n = nums.length;
        if (n == 1) return 0;
        
        int maxVal = 0;
        for (int num : nums) maxVal = Math.max(maxVal, num);
        boolean[] isPrime = sieveOfEratosthenes(maxVal);
        
        Map<Integer, List<Integer>> primeToIndices = new HashMap<>();
        for (int i = 0; i < n; i++) {
            Set<Integer> primes = getPrimeFactors(nums[i], isPrime);
            for (int prime : primes) {
                primeToIndices.computeIfAbsent(prime, k -> new ArrayList<>()).add(i);
            }
        }
        
        boolean[] visited = new boolean[n];
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(0);
        visited[0] = true;
        int jumps = 0;
        
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int s = 0; s < size; s++) {
                int curr = queue.poll();
                
                if (curr == n - 1) return jumps;
                
                if (curr + 1 < n && !visited[curr + 1]) {
                    visited[curr + 1] = true;
                    queue.offer(curr + 1);
                }
                if (curr - 1 >= 0 && !visited[curr - 1]) {
                    visited[curr - 1] = true;
                    queue.offer(curr - 1);
                }
                
                if (isPrime[nums[curr]]) {
                    int prime = nums[curr];
                    List<Integer> targets = primeToIndices.get(prime);
                    if (targets != null) {
                        for (int target : targets) {
                            if (!visited[target] && target != curr) {
                                visited[target] = true;
                                queue.offer(target);
                            }
                        }
                        primeToIndices.remove(prime);
                    }
                }
            }
            jumps++;
        }
        
        return -1;
    }
    
    private Set<Integer> getPrimeFactors(int num, boolean[] isPrime) {
        Set<Integer> factors = new HashSet<>();
        int temp = num;
        for (int i = 2; i * i <= temp; i++) {
            if (isPrime[i] && temp % i == 0) {
                factors.add(i);
                while (temp % i == 0) temp /= i;
            }
        }
        if (temp > 1 && isPrime[temp]) factors.add(temp);
        return factors;
    }
    
    private boolean[] sieveOfEratosthenes(int max) {
        boolean[] isPrime = new boolean[max + 1];
        Arrays.fill(isPrime, true);
        isPrime[0] = isPrime[1] = false;
        for (int i = 2; i * i <= max; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j <= max; j += i) {
                    isPrime[j] = false;
                }
            }
        }
        return isPrime;
    }
}