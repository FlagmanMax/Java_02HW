// Реализовать простой калькулятор 
// Scanner sc = ... int a = sc.nextLine int b = sc.nextLine
// К калькулятору из предыдущего дз добавить логирование.
import java.util.Scanner;
import java.util.logging.*;
import java.io.IOException;

public class HW_02_04 {
    public static void main(String[] args) {
        Logger logger = Logger.getLogger(HW_02_01.class.getName());
        FileHandler fh;
        try 
        {
            fh = new FileHandler("log_HW_02_04.txt",true);
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


        System.out.printf("Вас приветствует калькулятор!\n\n");
        
        Scanner iScanner = new Scanner(System.in, "CP866");
        while(true){  
            logMessage = "---> Новый запуск";
            logger.info(logMessage);
            
            System.out.printf("Введите пример в формате X a Y (не забывайте пробелы!), где X и Y - числа, a - операция +,-,*,/ и нажмите Enter. q - выход\n"); 
            
            String eq = iScanner.nextLine();

            if (eq.equalsIgnoreCase("q")){
                System.out.println("Выход из программы\n");
                break;
            }
            
            String[] eqElements = eq.split(" ", -1);

            float X =  Float.parseFloat(eqElements[0]);
            float Y =  Float.parseFloat(eqElements[2]);

            float res = 0;
            
            if (eqElements[1].charAt(0) == '+') {
                res =  X+Y;
            } else if (eqElements[1].charAt(0) == '-') {
                res =  X-Y;
            } else if (eqElements[1].charAt(0) == '/') {
                res =  X/Y;
            } else if (eqElements[1].charAt(0) == '*') {
                res =  X*Y;
            } else{
                System.out.println("Some error\n");
                continue;
            }

            
            logMessage = eq + " = " + Float.toString(res);
            // System.out.printf(logMessage);
            logger.info(logMessage);

            System.out.printf("%s %s %s = %.2f\n",eqElements[0],eqElements[1],eqElements[2],res);
        
        }  
        iScanner.close();   
    }
}
