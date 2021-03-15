package com.company;

/**
 * Программа находит и выводит все простые числа
 * меньше 100
 */
public class Primes {
    public static void main(String[] args) {
        for (int i = 2; i <= 100; i++) {
            if (isPrime(i)) {
                System.out.println("Число: " + i);
            }
        }
    }

    /**
     * Проверяет является ли переданное число простым
     *
     * @param number
     * @return
     */
    public static boolean isPrime(int number) {
        for (int i = 2; i < number; i++) {
            if (number % i == 0) {
                return false;
            }
        }

        return true;
    }
}
