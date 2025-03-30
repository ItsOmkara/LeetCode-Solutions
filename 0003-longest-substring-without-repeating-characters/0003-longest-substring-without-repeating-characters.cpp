class Solution {
public:
    int lengthOfLongestSubstring(string s) {
     int freq[256] = {0};  
    int left = 0, maxLength = 0;

    for (int right = 0; right < s.length(); right++) {
        freq[s[right]]++;  

        while (freq[s[right]] > 1) {  
            freq[s[left]]--;  
            left++;
        }
        
        maxLength = max(maxLength, right - left + 1);  
    }

    return maxLength;   
    }
};