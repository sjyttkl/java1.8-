import java.util.Collections;
import java.util.Comparator;

public class lamb {

    final static String salutation = "Hello! ";
    public static void main(String args[]){
        lamb tester = new lamb();

        // 类型声明
        MathOperation addition = (int a, int b) -> a + b;

        // 不用类型声明
        MathOperation subtraction = (a, b) -> a - b;

        // 大括号中的返回语句
        MathOperation multiplication = (int a, int b) -> { return a * b; };

        // 没有大括号及返回语句
        MathOperation division = (int a, int b) -> a / b;

        System.out.println("10 + 5 = " + tester.operate(10, 5, addition));
        System.out.println("10 - 5 = " + tester.operate(10, 5, subtraction));
        System.out.println("10 x 5 = " + tester.operate(10, 5, multiplication));
        System.out.println("10 / 5 = " + tester.operate(10, 5, division));

        // 不用括号
        GreetingService greetService1 = message ->
                System.out.println("Hello " + message);

        // 用括号
        GreetingService greetService2 = (message) ->
                System.out.println("Hello " + message);

        //ambda 表达式只能引用标记了 final 的外层局部变量，这就是说不能在 lambda 内部修改定义在域外的局部变量，否则会编译错误。

        GreetingService greetingService3 = message ->
                System.out.println(salutation+message);

        //我们也可以直接在 lambda 表达式中访问外层的局部变量：
        //lambda 表达式的局部变量可以不用声明为 final，但是必须不可被后面的代码修改（即隐性的具有 final 的语义）

        final int num = 1;
        Converter<Integer, String> s = (param) -> System.out.println(String.valueOf(param + num));
        s.convert(2);  // 输出结果为 3

        //在 Lambda 表达式当中不允许声明一个与局部变量同名的参数或者局部变量。
//        String first = "";
//        Comparator<String> comparator = (first, second) -> Integer.compare(first.length(), second.length());  //编译会出错
        greetService1.sayMessage("Runoob");
        greetService2.sayMessage("Google");

    }

    interface MathOperation {
        int operation(int a, int b);
//        int op(int a, int b);  不允许有两个未实现的方法
        //但是允许有默认方法
        default  int addition(int a, int b){
            return a+b;
            }
    }

    interface GreetingService {
        void sayMessage(String message);
    }

    private int operate(int a, int b, MathOperation mathOperation){
        return mathOperation.operation(a, b);
    }

    public interface Converter<T1, T2> {
        void convert(int i);
    }
}