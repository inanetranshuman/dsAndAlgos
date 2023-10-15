package edu.univ.hardknocks.arrays;

public class InPlaceReverseString {
    public static String reverse(String input) {
        char[] chars = input.toCharArray();
        int leftIndex = 0;
        int rightIndex = chars.length - 1;
        while (leftIndex < rightIndex) {
            char temp = chars[leftIndex];
            chars[leftIndex] = chars[rightIndex];
            chars[rightIndex] = temp;
            leftIndex++;
            rightIndex--;
        }
        return new String(chars);
    }

    public static void main(String[] args) {
        String input = "hello";
        System.out.println(reverse(input));
    }
}
