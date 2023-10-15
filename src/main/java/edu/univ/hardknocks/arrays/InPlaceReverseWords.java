package edu.univ.hardknocks.arrays;

public class InPlaceReverseWords {
    

    public static void main(String[] args) {
        String input = "hello world testing";
        char[] chars = input.toCharArray();
        // Reverse the entire string
        reverse(chars, 0, chars.length - 1);
        // Reverse each word
        int leftIndex = 0;  
        for (int i = 0; i < chars.length; i++) {
            boolean endOfArray = i == chars.length - 1;
            if (chars[i] == ' ' || endOfArray) {
                reverse(chars, leftIndex, endOfArray ? i : i - 1);
                leftIndex = i + 1;
            }
        }
        
        System.out.println(new String(chars));
    }


    public static void reverse(char[] chars, int leftIndex, int rightIndex) {
        while (leftIndex < rightIndex) {
            char temp = chars[leftIndex];
            chars[leftIndex] = chars[rightIndex];
            chars[rightIndex] = temp;
            leftIndex++;
            rightIndex--;
        }
        
    }
}
