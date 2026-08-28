// Задача 1: Простая (Знакомство)
// Напиши программу, которая запрашивает у пользователя его имя и возраст, а затем здоровается с ним.
// Что нужно сделать:
//  * Выведи в консоль просьбу ввести имя.
//  * Считай строку (String) с клавиатуры.
//  * Выведи просьбу ввести возраст.
//  * Считай целое число (int).
//  * Выведи финальное сообщение, объединив текст и переменные.

import java.util.Scanner;
public class HelloUser
{
    public static void main(String[] args)
    {
        System.out.println("Enter username: ");
        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();
        System.out.println("Welcome - "+name);
    }
}