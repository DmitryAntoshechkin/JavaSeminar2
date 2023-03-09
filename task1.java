// Реализуйте алгоритм сортировки пузырьком числового массива (введён вами),
// результат после каждой итерации запишите в лог-файл.


package seminar2_Homework;

import java.util.Scanner;
import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.XMLFormatter;

public class task1 {
    public static void main(String[] args) throws SecurityException, IOException {
        Scanner myScanner = new Scanner(System.in, "Cp866");
        System.out.println("Введите  количество элементов массива: ");
        int size = myScanner.nextInt();
        myScanner.nextLine();
        int array[] = GetArray(size, myScanner);
        myScanner.close();
        Logger logger = Logger.getLogger(task1.class.getName());
        FileHandler fh = new FileHandler("log.xml");
        logger.addHandler(fh);
        XMLFormatter xml = new XMLFormatter();
        fh.setFormatter(xml);

        for (int i = 0; i < size-1; i++){
            StringBuilder iteration = new StringBuilder();
            iteration.append("Итерация "+i+" : ");

            boolean isSorted = true;
            for(int j = 0; j < size -1; j++){
                if (array[j] > array[j+1]){
                    int temp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = temp;
                    isSorted = false;
                }
                iteration.append(array[j]+ " ");
            }
            iteration.append(array[size-1]+ " ");
            logger.info(iteration.toString());
            if (isSorted == true) break;
        }
        System.out.println("Отсортированный массив ");
        for(int i = 0; i < size; i++){
            System.out.printf("%d ",array[i]);
        }  
    }

    public static int[] GetArray(int size, Scanner myScanner) {
        int[] new_array = new int[size];
        for (int i = 0; i < size; i++ ){
            System.out.printf("Введите %d элемент массива: ", i);
            new_array[i] = myScanner.nextInt();
            myScanner.nextLine();
        }
        return new_array;
    }
}
