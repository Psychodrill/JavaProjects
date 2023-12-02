
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;



public class Homework3{

    public static void main(String[] args) { 
        // int[] a;

        // if (args.length == 0) {
        // // При отправке кода на Выполнение, вы можете варьировать эти параметры
        //     a = new int[]{5, 1, 6, 2, 3, 4};
        // } else {
        //     a = Arrays.stream(args[0].split(", ")).mapToInt(Integer::parseInt).toArray();
        // }

        // MergeSort answer = new MergeSort();
        // String itresume_res = Arrays.toString(answer.mergeSort(a));
        // System.out.println(itresume_res);



        // Integer[] arr = {};
      
        // if (args.length == 0) {
        //   // При отправке кода на Выполнение, вы можете варьировать эти параметры
        //   arr = new Integer[]{1, 2, 3, 4, 5, 6, 7, 8, 9};
        // }
        // else{
        //   arr = Arrays.stream(args[0].split(", "))
        //                   .map(Integer::parseInt)
        //                   .toArray(Integer[]::new);
        // }     
        
        // Answer ans = new Answer();      
        // ans.removeEvenNumbers(arr);



        Integer[] arr = {};
      
        if (args.length == 0) {
          // При отправке кода на Выполнение, вы можете варьировать эти параметры
          //arr = new Integer[]{4, 2, 7, 5, 1, 3, 8, 6, 9};
          arr = new Integer[]{-2, -1, 0, 1, 2, 3, 4, 5};
        }
        else{
          arr = Arrays.stream(args[0].split(", "))
                          .map(Integer::parseInt)
                          .toArray(Integer[]::new);
        }     
        
        Answer ans = new Answer();      
        ans.analyzeNumbers(arr);




    }
}
//Внутри класса MergeSort напишите метод mergeSort, который принимает массив целых чисел a и реализует алгоритм сортировки слиянием. Метод должен возвращать отсортированный массив.
// class MergeSort {

//      public static int[] mergeSort(int[] sortArr) {
//         int[] buffer1 = Arrays.copyOf(sortArr, sortArr.length);
//         int[] buffer2 = new int[sortArr.length];
//         int[] result = mergeSortInner(buffer1, buffer2, 0, sortArr.length);
//         return result;
//     }

//     public static int[] mergeSortInner(int[] buffer1, int[] buffer2, int startIndex, int endIndex) {
//         if (startIndex >= endIndex - 1) {
//             return buffer1;
//         }

//         //уже отсортирован
//         int middle = startIndex + (endIndex - startIndex) / 2;
//         int[] sorted1 = mergeSortInner(buffer1, buffer2, startIndex, middle);
//         int[] sorted2 = mergeSortInner(buffer1, buffer2, middle, endIndex);

//         //слияние
//         int index1 = startIndex;
//         int index2 = middle;
//         int destIndex = startIndex;
//         int[] result = sorted1 == buffer1 ? buffer2 : buffer1;
//         while (index1 < middle && index2 < endIndex) {
//             result[destIndex++] = sorted1[index1] < sorted2[index2]
//                     ? sorted1[index1++] : sorted2[index2++];
//         }
//         while (index1 < middle) {
//             result[destIndex++] = sorted1[index1++];
//         }
//         while (index2 < endIndex) {
//             result[destIndex++] = sorted2[index2++];
//         }
//         return result;
//     }
// }


// Напишите функцию removeEvenNumbers, которая принимала бы произвольный список целых чисел, удаляла бы из него четные числа и выводила список без четных чисел.

// Напишите свой код в методе removeEvenNumbers класса Answer. Метод removeEvenNumbers принимает на вход один параметр:

// Integer[] arr - список целых чисел
// class Answer {
//     public static void removeEvenNumbers(Integer[] arr) {
//       // Введите свое решение ниже
      
//         ArrayList<Integer>numbers= new ArrayList<Integer>(Arrays.asList(arr));
//         java.util.Iterator<Integer> iterator =numbers.iterator();

//         while(iterator.hasNext()){
//             Object o = iterator.next();
//             if(Integer.parseInt(o.toString())%2==0){
//                 iterator.remove();
//             }
//         }
//        System.out.println(numbers);
//     }
// }

// Напишите функцию analyzeNumbers, которая принимает на вход целочисленный список arr и:

// Сортирует его по возрастанию и выводит на экран
// Находит минимальное значение в списке и выводит на экран - Minimum is {число}
// Находит максимальное значение в списке и выводит на экран - Maximum is {число}
// Находит среднее арифметическое значений списка и выводит на экран - Average is =  {число}
// Напишите свой код в методе analyzeNumbers класса Answer. Метод analyzeNumbers принимает на вход один параметр:

// Integer[] arr - список целых чисел

class Answer {
    public static void analyzeNumbers(Integer[] arr) {
      // Введите свое решение ниже
        

       ArrayList<Integer>numbers= new ArrayList<Integer>(Arrays.asList(arr));
       Collections.sort(numbers);
       System.out.println(numbers);
       System.out.println(String.format("Minimum is %s", numbers.getFirst()));
       System.out.println(String.format("Maximum is %s", numbers.getLast()));
       int averageIndex= (numbers.size()-1)/2;
        System.out.println(String.format("Average is = %s", numbers.get(averageIndex)));
    }
}