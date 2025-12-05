package Collections;

import java.util.*;

public class Practice {
    public static void main(String args[]){

//        char c = 'A';
//        boolean isDigit = Character.isDigit(c);
//        boolean isLetter = Character.isLetter(c);
//        boolean isUpperCase = Character.isUpperCase(c);
//        boolean isLowerCase = Character.isLowerCase(c);
//        System.out.println(isDigit);
//        System.out.println(isLetter);
//        System.out.println(isUpperCase);
//
//        char b = '5';
//        int digit = Character.getNumericValue(b);
//        System.out.println(digit);
//
//        String s = "abcxyz";
//        for(char ch:s.toCharArray()){
//            if(Character.isLetter(ch)){
//                int d = Character.toLowerCase(ch) - 'a' + 0;
//                System.out.println(ch + "->" + d);
//            }
//        }
//
//        LinkedList<Integer> l = new LinkedList<>();
//        l.add(23);
//        l.add(25);
//        l.add(27);
//        l.add(30);
//        l.add(35);
//
//
//        for(Integer num:l){
//            System.out.print(num + " ");
//        }
//        System.out.println(l.isEmpty());
//        System.out.println(l.remove(4));
//        for(Integer num:l){
//            System.out.println(num + " ");
//        }
//        // SubString //
//        String str = "ababcdabc";
//        String sub = "abc";
//        if(str.contains(sub)){
//            int index = str.indexOf(sub);
//            System.out.println("Index " + index);
//        }
//        else{
//            System.out.println("Substring not found");
//        }
//
//        List<List<Integer>> res = new ArrayList<>();
//        List <Integer> a = Arrays.asList(1,2,3,4,5);
//        List<Integer> b1 = Arrays.asList(6,7,8,9,10);
//        res.add(a);
//        res.add(b1);
//        System.out.println(res);
//
//        //Count number of Vowel Strings in Range //
//
//        String arr[] = {"are","ooo","le","india"};
//        int left = 0;
//        int right  = 3;
//
//        String vowels = "aeiou";
//        int count = 0;
//        for(int i = left; i<= right; i++){
//            String word = arr[i];
//            char first = word.charAt(0);
//            char last = word.charAt(word.length() - 1);
//
//            if(vowels.indexOf(first) != -1 && vowels.indexOf(last) != -1) {
//                count++;
//            }
//        }
//        System.out.println(count);

        int arr[] = {2,6,45,0,78,0,93,2,45};
//        int min = Integer.MAX_VALUE;
//        int max = Integer.MIN_VALUE;
//        int secMax = Integer.MIN_VALUE;
//        int secMin = Integer.MIN_VALUE;
//
//        for(int i = 0;i<arr.length;i++){
//            if(arr[i]>max){
//                secMax = max;
//                max = arr[i];
//            }
//            else if(arr[i] != max && arr[i]>secMax){
//                secMax = arr[i];
//            }
//            if(arr[i]<min){
//                secMin = min;
//                min = arr[i];
//            }
//            else if(arr[i] != min && arr[i]<secMin){
//                secMin = arr[i];
//            }
//        }
//        System.out.println("Max " + max);
//        System.out.println("Min " + min);
//        System.out.println("Secmin " + secMin);
//        System.out.println("Sexmax " + secMax);
//
//
//        Map<Integer,Integer> m = new HashMap<>();
//        for(int i=0;i<arr.length;i++){
//            {
//            m.put(arr[i],m.getOrDefault(arr[i],0) + 1);
//            }
//        }
//
//        m.forEach((key,value)->{
//            if(value == 1){
//                System.out.println(key + " - " + value);
//            }
//        });
//
//        int brr[] = {1, 2, 3, 5, 6, 7};
//        int num = 0;
//        for(int i=1;i<=brr.length;i++){
//            if(i != brr[i - 1]){
//                num = i;
//                break;
//            }
//        }
//        System.out.println(num);

//        int nonzeroNumber = 0;
//        for(int i=0;i<arr.length;i++){
//            if(arr[i] != 0){
//                arr[nonzeroNumber++] = arr[i];
//            }
//        }
//        for(int n:arr){
//            System.out.print(n + " ");
//        }
//        System.out.println();
//        while(nonzeroNumber<arr.length){
//            arr[nonzeroNumber++] = 0;
//        }
//
//        for(int n:arr){
//            System.out.print(n + " ");
//        }

//        int[] nrr = {1,3,4,3,1};
//        StringBuilder sc = new StringBuilder();
//        for(int n:nrr){
//            sc.append(n);
//        }
//        int m = Integer.parseInt(sc.toString());
//        int n = m;
//        int sum = 0;
//        while(m>0){
//            sum = sum * 10 + (m%10);
//            m = m/10;
//        }
//        if(n == sum){
//            System.out.println("Array is Palindrome");
//        }
//        else{
//            System.out.println("Array is not Palindrome");
//        }
//        int [] arr1 = {2,3,1,3,2,4,6,7,9,2,19};
//        int [] arr2 = {2,1,4,3,9,6};
//
//        Map<Integer,Integer> m = new HashMap<>();
//        for(int i=0;i<arr1.length;i++){
//            m.put(arr1[i],m.getOrDefault(arr1[i],0) + 1);
//        }
//
//        int [] arr3 = new int[arr1.length];
//        for(int i=0;i<arr2.length;i++){
//            if(arr2[i] == arr1[i]){
//                if(m.containsKey(arr2[i])){
//
//                }
//            }
//        }

//        String s = "A man, a plan, a canal: Panama";
//        StringBuilder s4 = new StringBuilder();
//
//        for(int i=0;i<s.length();i++){
//            if(s.charAt(i) != ' ' && s.charAt(i) != ',' && s.charAt(i) != ':'){
//
//                s4.append(s.toLowerCase().charAt(i));
//            }
//        }
//        String s6 = s4.toString();
//        StringBuilder s5 = new StringBuilder();
//        for(int i = s6.length() - 1;i>=0;i--){
//            char ch  = s.charAt(i);
//            if(Character.isLetterOrDigit(ch)){
//                s5.append(Character.toLowerCase(ch));
//            }
//        }
//        System.out.println(s6);
//        System.out.println(s5.toString());

        int array[] = {3,5,6,7,8};
        int brr[] = new int[3];

        brr = array;
        for(int b:brr){
            System.out.print(b + " ");
        }
    }
}
