// Напишите метод, который принимает на вход строку (String) и определяет 
// является ли строка палиндромом (возвращает boolean значение).

import java.util.Scanner;
public class HW_02_03 
{
    public static void main(String[] args) 
    {
        System.out.printf("Введите строку для анализа: ");

        Scanner iScanner = new Scanner(System.in, "CP866");
        String line = iScanner.nextLine();
        iScanner.close();

        if (isPalindrom(line))
        {
            System.out.println("Строка является палиндромом!");
        }
        else
        {
            System.out.println("Строка не является палиндромом!");
        }
    }
    public static boolean isPalindrom(String line)
    {       
        int start = 0;
        int end = line.length() - 1;
        while(end > start)
        {
            if (line.charAt(start) != line.charAt(end))
            {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }


}
