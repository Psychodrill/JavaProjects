
import java.io.File;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.lang.System.Logger;
import java.util.Arrays;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.logging.*;

import javax.swing.text.DateFormatter;

public class Homework2 {
    
   // Сформируйте часть WHERE этого запроса, используя StringBuilder. Пример данных для фильтрации приведены ниже в виде json-строки.
   //Если значение null, то параметр не должен попадать в запрос.
   public static void main(String args[]){
        
    //String ans =answer("select * from students where ", "{\"name\":\"Ivanov\", \"country\":\"Russia\", \"city\":\"Moscow\", \"age\":\"null\"} " ).toString();

    //System.out.println(ans);

    java.util.logging.Logger logger = java.util.logging.Logger.getAnonymousLogger();
    ConsoleHandler ch = new ConsoleHandler();
    logger.addHandler(ch);
    SimpleFormatter sFormat =new SimpleFormatter();
    ch.setFormatter(sFormat);
    logger.log(Level.WARNING,"");

    int[] array =new int[]{9, 4, 8, 3, 1};
    BubbleSort ans = new BubbleSort();
    ans.sort(array);
    for(int i=0; i<array.length; i++){
        System.out.println(array[i]);
    }
    
}
    public static StringBuilder answer(String QUERY, String PARAMS){
        PARAMS =PARAMS.replace("{", "").replace("}", "");
        String[] stringArray =PARAMS.split(",");
        StringBuilder result = new StringBuilder();
        for(int i=0;i<stringArray.length;i++ ){
           
         if(result.length()!=0 && i!=stringArray.length-1){
                result.append(" and ");
           }
           // map.put(pair[0],pair[1]);
           if(!stringArray[i].contains("null")) {
                String[] pair =stringArray[i].split(":");
                String parameter =pair[0].replace("\"", "").trim();
                String value =pair[1].replace("\"", "'").trim();
                result.append(parameter).append("=").append(value);
            }

        }
        result.insert(0, QUERY);        
        return result;
    }

//     Реализуйте алгоритм сортировки пузырьком числового массива, результат после каждой итерации запишите в лог-файл.

// Напишите свой код в методе sort класса BubbleSort. Метод sort принимает на вход один параметр:

// int[] arr - числовой массив

// После каждой итерации, ваш код должен делать запись в лог-файл 'log.txt' в формате год-месяц-день час:минуты {массив на данной итерации}.

}
class BubbleSort {
    private static File log;
    private static FileWriter fileWriter;


    public static void sort(int[] mas){
        log = new File("log.txt");
        if(log.exists()){
            log.delete();
        }
         
       // int temp=0;
            // for (int i = 0; i < mas.length; i++) {

            // for (int j = 1; j < mas.length - i; j++) {
            //     if (mas[j-1] > mas[j]) {

            //         temp = mas[j-1];
            //         mas[j-1] = mas[j];
            //         mas[j] = temp;

            //     }
            // }
             int length = mas.length;
        while (length != 0){
            int max_index = 0;
            for (int i = 1; i < length; i++){
                if (mas[i-1] > mas[i]){
                    int temp = mas[i-1];
                    mas[i-1] = mas[i];
                    mas[i] = temp;

                    max_index = i;
                }
            }
            length = max_index;
           
        

            try(FileWriter writer = new FileWriter(log,true)){
               // CharSequence cs= mas.toString();
               LocalDateTime lt= LocalDateTime.now();
                //LocalTime localTime= LocalTime.now();
                String year= String.valueOf(lt.getYear());
                String month= String.valueOf(lt.getMonthValue());
                String day= String.valueOf(lt.getDayOfMonth());
                String hour= String.valueOf(lt.getHour());
                String minutes= String.valueOf(lt.getMinute());
                writer.write(year+ "-"+month+"-"+day+" "+hour+":"+minutes+ " "+ Arrays.toString(mas) +"\n");
                //writer.write(LocalDate.now().toString() + " "+ String.valueOf(localTime.getHour())+":"+String.valueOf(localTime.getMinute()) + " "+ Arrays.toString(mas) +"\n");
                //writer.write(localFormattedTime+ " "+ Arrays.toString(mas) +"\n");
                writer.flush();
            }
            catch(IOException e){
                e.printStackTrace();
            }

        }
        
        
  }

}

