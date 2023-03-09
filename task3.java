// Напишите метод, который принимает на вход строку (String) и определяет является ли строка палиндромом (возвращает boolean значение).
// Без встр. функций


package seminar2_Homework;
import java.util.Scanner;

public class task3 {
    public static void main(String[] args) {
        Scanner myScanner = new Scanner(System.in, "Cp866");
        System.out.println("Введите строку: ");
        String textLine = myScanner.nextLine();
        myScanner.close();

        boolean isPal = IsPalindrom(textLine);
        if (isPal == true){
            System.out.println("Строка - палиндром");
        }else{
            System.out.println("Строка - не палиндром");
        }
    }

    public static boolean IsPalindrom(String textLine) {
        boolean isPal = true;
        int i = 0;
        while(isPal == true && i < textLine.length()/2 ){
            if(textLine.charAt(i) != textLine.charAt(textLine.length()-i-1)){
                isPal = false;
            }
            i++;
        }
        return isPal;
    }
}
