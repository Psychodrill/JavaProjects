import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.ArrayDeque;
import java.util.Deque;


public class Homework4 {

    public static void main(String[] args) { 

        // LinkedList<Object> ll = new LinkedList<>();

        // if (args.length == 0 || args.length != 4) {
        // // При отправке кода на Выполнение, вы можете варьировать эти параметры
        //     ll.add(1);
        //     ll.add("One");
        //     ll.add(2);
        //     ll.add("Two");
        // } else {
        //     ll.add(Integer.parseInt(args[0]));
        //     ll.add(args[1]);
        //     ll.add(Integer.parseInt(args[2]));
        //     ll.add(args[3]);
        // }

        // LLTasks answer = new LLTasks();
        // System.out.println(ll);
        // LinkedList<Object> reversedList = answer.revert(ll);
        // System.out.println(reversedList);


        // MyQueue<Integer> queue;
        // queue = new MyQueue<>();

        // if (args.length == 0) {
        // // При отправке кода на Выполнение, вы можете варьировать эти параметры
        //     queue.enqueue(1);
        //     queue.enqueue(10);
        //     queue.enqueue(15);
        //     queue.enqueue(5);
        // } else {
        //     queue.enqueue(Integer.parseInt(args[0]));
        //     queue.enqueue(Integer.parseInt(args[1]));
        //     queue.enqueue(Integer.parseInt(args[2]));
        //     queue.enqueue(Integer.parseInt(args[3]));
        // }

        // System.out.println(queue.getElements());

        // queue.dequeue();
        // queue.dequeue();
        // System.out.println(queue.getElements());

        // System.out.println(queue.first());


        int a, b, c, d;
        char op, op2, undo;

        if (args.length == 0) {
        // При отправке кода на Выполнение, вы можете варьировать эти параметры
            a = 3;
            op = '+';
            b = 7;
            c = 4;
            op2 = '+';
            d = 7;
            undo = '<';
        } else {
            a = Integer.parseInt(args[0]);
            op = args[1].charAt(0);
            b = Integer.parseInt(args[2]);
            c = Integer.parseInt(args[3]);
            op2 = args[4].charAt(0);
            d = Integer.parseInt(args[5]);
            undo = args[6].charAt(0);
        }

        Calculator calculator = new Calculator();
        int result = calculator.calculate(op, a, b);
        System.out.println(result);
        int result2 = calculator.calculate(op2, c, d);
        System.out.println(result2);
        int prevResult = calculator.calculate(undo, 0, 0);
        System.out.println(prevResult);

    }
}
// //Дан LinkedList с несколькими элементами разного типа. В методе revert класса LLTasks реализуйте разворот этого списка без использования встроенного функционала.
// class LLTasks {
//     public static LinkedList<Object> revert(LinkedList<Object> ll) {
//         // Напишите свое решение ниже
        
//         LinkedList<Object> result = new LinkedList<Object>();
//         for (Object object : ll) {
//             result.addFirst(object);
//         }
//         return result;
//     }    
// }
// // В классе MyQueue реализуйте очередь для типа данных Integer с помощью LinkedList со следующими методами:

// // enqueue() - помещает элемент в конец очереди
// // dequeue() - возвращает первый элемент из очереди и удаляет его
// // first() - возвращает первый элемент из очереди, не удаляя
// // getElements() - возвращает все элементы в очереди
// class MyQueue<T> {
//         // Напишите свое решение ниже
//     private LinkedList<T> list = new LinkedList<>();
//     public void enqueue(T element){
//         // Напишите свое решение ниже
//         list.addLast(element);
//     }

//     public T dequeue(){
//         // Напишите свое решение ниже
//         return list.removeFirst();
//     }

//     public T first(){
//         // Напишите свое решение ниже
//         return list.getFirst();
//     }

//     public LinkedList<T> getElements() {
//         // Напишите свое решение ниже
//         return list;
//     }
// }


// В обычный калькулятор без логирования добавьте возможность отменить последнюю операцию.
// Отмена последней операции должна быть реализована следующим образом: если передан оператор '<' калькулятор должен вывести результат предпоследней операции.
class Calculator{

   private Deque<Integer> results = new ArrayDeque<Integer>();
public int calculate(char op, int a, int b) {
        // Напишите свое решение ниже
        int result = 0;

        switch(op){
            case '+':
            result = a+b;
            results.add(result);
            break;
            case '*':
            result = a*b;
            results.add(result);
            break;
            case '-':
            result = a-b;
            results.add(result);
            break;
            case '/':
            result = a/b;
            results.add(result);
            break;
            case '<':
            //results.pop();
            result= results.poll();

        }
        
        return result;
    }
} 


