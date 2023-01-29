// Дана json строка (читать из файла и сохранить в файл) 
// [{"фамилия":"Иванов","оценка":"5","предмет":"Математика"},{"фамилия":"Петрова",
// "оценка":"4","предмет":"Информатика"},{"фамилия":"Краснов","оценка":"5","предмет":"Физика"}]
//
// Написать метод(ы), который распарсит json и, используя StringBuilder, создаст строки вида:
// Студент [фамилия] получил [оценка] по предмету [предмет].
// Пример вывода:
// Студент Иванов получил 5 по предмету Математика.
// Студент Петрова получил 4 по предмету Информатика.
// Студент Краснов получил 5 по предмету Физика.

import java.io.FileWriter;
import java.io.FileReader;
import java.util.logging.*;
import java.util.Scanner;
import java.io.IOException;


public class HW_02_02
{
    public static void main(String[] args) 
    {

        String[][] DB = new String[10][3];
        int recordCnt = getData(DB,"in.json");

        for (int i=0;i<recordCnt;i++)
        {
            System.out.printf("Студент %s получил %s по предмету %s.\n",DB[i][0],DB[i][1],DB[i][2]);
        }

    }
    public static int getData(String DB[][], String path)
    {
        int recordCnt = 0;
        try (FileReader fr = new FileReader(path)) 
        {
            Scanner inScanner = new Scanner(fr);
        
            StringBuilder sb = new StringBuilder();
            while(inScanner.hasNext()) {
                sb.append(inScanner.next());
            }
            inScanner.close();
            
            String[] records = sb.toString().split("}",-1);
            recordCnt = records.length - 1; //Exclude "}]"
            String[] dataTemp;

            for (int i = 0;i<recordCnt;i++)
            {
                dataTemp = records[i].split("\"", -1);
                 DB[i][0] = dataTemp[3]; // Get surname
                 DB[i][1] = dataTemp[7]; // Get mark
                 DB[i][2] = dataTemp[11];// Get subject
            }
            fr.close();
 
        } 
        catch (IOException ex) 
        {
            System.out.println(ex.getMessage());
        }
        return recordCnt;
    }
}
