
public class Homework1{
    //Вычислить n-ое треугольного число(сумма чисел от 1 до n).
    //Внутри класса Answer напишите метод countNTriangle, который принимает число n и возвращает его n-ое треугольное число.

    public static void main(String args[]){
        
        //System.out.println(countNTriangle(6));
        //printPrimeNums();

        Calculator calc = new Calculator();
        System.out.println(calc.calculate('*', 4, 7));
    }
    public static int  countNTriangle(int number){
        int result =0;
        while(number>0){
            result+=number;
            number--;
        }
        return result;
    }

    //Напишите функцию printPrimeNums, которая выведет на экран все простые числа в промежутке от 1 до 1000, каждое на новой строке.
    //Напишите свой код в методе printPrimeNums класса Answer.

    public static void printPrimeNums(){
        for (int i =2; i<=1000;i++){
            boolean isPrime=true;
            for(int j=2; j<i;j++){
                
                if(i%j==0) isPrime=false;
            }
            if(isPrime) System.out.println(i);
        }
    }

    //Напишите класс Calculator, который будет выполнять математические операции (+, -, *, /) над двумя числами и возвращать результат. В классе должен быть метод calculate, который принимает оператор и значения аргументов и возвращает результат вычислений.

}
    class Calculator {
        public int calculate(char op, int a, int b) {
            int result=0;

            switch(op){
                case '+': result =a+b;
                break;
                case '-': result =a-b;
                break;
                case '*': result =a*b;
                break;
                case '/': result =a/b;
                break;
             
            }
            return result;
        }
    }