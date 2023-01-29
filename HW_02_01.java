// Реализуйте алгоритм сортировки пузырьком числового массива, 
// результат после каждой итерации запишите в лог-файл.

//import java.io.FileWriter;
import java.util.logging.*;
import java.util.Scanner;
import java.io.IOException;
import java.util.Arrays;

public class HW_02_01 {
    public static void main(String[] args) {

        Logger logger = Logger.getLogger(HW_02_01.class.getName());
        FileHandler fh;

        try 
        {
            fh = new FileHandler("log_HW_02_01.txt",true);
        } 
        catch (SecurityException e) 
        {
            return;
        } 
        catch (IOException e) 
        {
            return;
        }
        
        logger.addHandler(fh);

        SimpleFormatter sFormat = new SimpleFormatter();
        fh.setFormatter(sFormat);
        
        String logMessage;

        logMessage = "---> Новый запуск";
        logger.info(logMessage);
        
        Scanner iScanner = new Scanner(System.in, "CP866");
        
        System.out.printf("Введите длину массива n : ");
        int length = iScanner.nextInt();
        logMessage = "Введена длина массива, n = " + Integer.toString(length);
        logger.info(logMessage);

        int[] arr = new int[length];
        System.out.printf("Введите массив для сортировки : ");
        for (int i=0;i<length;i++)
        {
            arr[i] = iScanner.nextInt();
        } 
        
        logMessage = "Введен массив, arr = "+ Arrays.toString(arr);
        // System.out.printf(logMessage);
        logger.info(logMessage);

        boolean isSorted = false;
        int temp;
        int count = 1;

        while(!isSorted) 
        {
            isSorted = true;
            for (int i = 0; i < arr.length-1; i++) 
            {
                if(arr[i] > arr[i+1])
                {
                    isSorted = false;
 
                    temp = arr[i];
                    arr[i] = arr[i+1];
                    arr[i+1] = temp;

                    logMessage = "сортировка "+ Integer.toString(count) +": "+ Arrays.toString(arr);
                    logger.info(logMessage);

                    count++;
                }
            }
        }

        // System.out.printf(logMessage);
        iScanner.close();

        logger.removeHandler(fh);
        fh.close();
    }
}
