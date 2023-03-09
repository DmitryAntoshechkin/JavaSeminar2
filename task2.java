// Дана строка (получение через обычный текстовый файл!!!)

// "фамилия":"Иванов","оценка":"5","предмет":"Математика"
// "фамилия":"Петрова","оценка":"4","предмет":"Информатика"

// Написать метод(ы), который распарсит строку и, используя StringBuilder, создаст строки вида:
// Студент [фамилия] получил [оценка] по предмету [предмет].

// Пример вывода:
// Студент Иванов получил 5 по предмету Математика.
// Студент Петрова получил 4 по предмету Информатика.
// Студент Краснов получил 5 по предмету Физика.
package seminar2_Homework;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.BufferedReader;

public class task2 {
    public static void main(String[] args) {
        String file_name = "scores.txt";
        File file = new File(file_name);
        try{
            FileReader rd = new FileReader(file);
            BufferedReader reader = new BufferedReader(rd);
            String textLine = reader.readLine();
            while (textLine != null){
                System.out.println(ParceLine(textLine));
                textLine = reader.readLine();
            }
            System.out.println("Обработка файла завершена");
            reader.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();      
        } catch (IOException e) {
            e.printStackTrace();
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String ParceLine(String line) {
        StringBuilder parcedLine = new StringBuilder();    
        line = line.replace("\"","");
        String[] words = line.split(":|,"); 
        parcedLine.append("Студент "+words[1]+" получил "+words[3]+" по предмету "+words[5]+".");
        return parcedLine.toString();
    }
}
