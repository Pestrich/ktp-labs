package com.company;

/**
 * Программа показывает являются ли строки переданные в
 * аргуметах командной строки палиндромами
 */
public class Palindrome {
    public static void main(String[] args) {
        for (int i = 0; i < args.length; i++) {
            String string = args[i];

            System.out.println(string + (isPalindrome(string) ? " - Палиндром" : " - Не палиндром"));
        }
    }

    /**
     * Переворачивает переданную строку
     *
     * @param string
     * @return
     */
    public static String reverseString(String string) {
        String outString = "";

        for (int i = string.length(); i > 0; i--) {
            outString += string.charAt(i - 1);
        }

        return outString;
    }

    /**
     * Проверяет является ли переданная строка палиндромом
     *
     * @param string
     * @return
     */
    public static boolean isPalindrome(String string) {
        String reverseString = reverseString(string);

        return string.equals(reverseString);
    }
}
