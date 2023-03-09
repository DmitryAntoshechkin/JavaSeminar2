// 4*дополнительно. К калькулятору из предыдущего дз добавить логирование.

package seminar2_Homework;

import java.text.DecimalFormat;
import java.util.Scanner;
import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.XMLFormatter;

public class task4 {
    public static void main(String[] args) throws SecurityException, IOException {

        Logger logger = Logger.getLogger(task1.class.getName());
        FileHandler fh = new FileHandler("log.xml");
        logger.addHandler(fh);
        XMLFormatter xml = new XMLFormatter();
        fh.setFormatter(xml);

        Scanner myScanner = new Scanner(System.in, "Cp866");
        while (true) {
            System.out.println("Для выхода из калькулятора введите любое некорректное значение");
            try {
                DecimalFormat decimalFormat = new DecimalFormat("#.#####");
                System.out.printf("Введите первое число: ");
                double number1 = myScanner.nextDouble();
                System.out.printf("Введите действие: ");
                String action = myScanner.next();
                System.out.printf("Введите второе число: ");
                double number2 = myScanner.nextDouble();
                StringBuilder iteration = new StringBuilder();
                switch (action) {
                    case "+":
                        iteration.append("Результат операции: " + decimalFormat.format(number1 + number2));
                        break;
                    case "-":
                        iteration.append("Результат операции: " + decimalFormat.format(number1 - number2));
                        break;
                    case "*":
                        iteration.append("Результат операции: " + decimalFormat.format(number1 * number2));
                        break;
                    case "/":
                        iteration.append("Результат операции: " + decimalFormat.format(number1 / number2));
                        break;
                    default:
                        iteration.append("Введена некорректная операция");
                }
                System.out.println(iteration.toString());
                logger.info(iteration.toString());
            } catch (Exception ex) {
                System.out.println("Введены некорректные данные");
                break;
            }          
        }
        myScanner.close();
    }
}
