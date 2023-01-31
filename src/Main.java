import java.util.concurrent.ThreadLocalRandom;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;


public class Main {
    public static void main(String[] args) {
        //ex1.1
        Predicate<Integer> isPositive = new Predicate<Integer>() {
            @Override
            public boolean test(Integer num) {
                return num > 0;
            }
        };
        System.out.println(isPositive.test(5)); // true
        System.out.println(isPositive.test(-2)); // false
        System.out.println("++++++++++++++++++++++++");
        Predicate<Integer> isPositive1 = num -> num > 0;
        //ex1.2
        System.out.println(isPositive1.test(5)); // true
        System.out.println(isPositive1.test(-2)); // false
        System.out.println("++++++++++++++++++++++++");
        //ex2.1
        Consumer<String> greet = new Consumer<String>() {
            @Override
            public void accept(String name) {
                System.out.println("Hello, " + name + "!");
            }
        };
        greet.accept("Begali Mashrapov"); // prints "Hello, Begali Mashrapov!"
        System.out.println("++++++++++++++++++++++++");
        //ex2.2
        Consumer<String> greet1 = name -> System.out.println("Hello, " + name + "!");
        greet1.accept("Begali Mashrapov"); // prints "Hello, Begali Mashrapov!"
        System.out.println("++++++++++++++++++++++++");
        //ex3.1
        Function<Double, Long> round = new Function<Double, Long>() {
            @Override
            public Long apply(Double num) {
                return Math.round(num);
            }
        };
        System.out.println(round.apply(5.7)); // 6
        System.out.println("++++++++++++++++++++++++");
        //ex3.2
        Function<Double, Long> round1 = num -> Math.round(num);
        System.out.println(round1.apply(5.7)); // 6
        System.out.println("++++++++++++++++++++++++");
        //ex4.1
        Supplier<Integer> randomNum = new Supplier<Integer>() {
            @Override
            public Integer get() {
                return (int) (Math.random() * 101);
            }
        };
        System.out.println(randomNum.get());
        System.out.println("++++++++++++++++++++++++");
        //ex4.2
        Supplier<Integer> randomNum1 = () -> ThreadLocalRandom.current().nextInt(100);
        System.out.println(randomNum1.get());
        System.out.println("++++++++++++++++++++++++");
        //ex5
        Function<Integer, Integer> addTen = x -> x + 10;
        Function<Integer, Integer> addTwenty = x -> x + 20;
        Predicate<Integer> isEven = x -> x % 2 == 0;
        Function<Integer, Integer> test = ternaryOperator(isEven, addTen, addTwenty);
        test.apply(5);
        test.apply(6);
    }

    public static <T, U> Function<T, U> ternaryOperator(Predicate<? super T> condition,
                                                        Function<? super T, ? extends U> ifTrue,
                                                        Function<? super T, ? extends U> ifFalse) {
        return input -> {
            U result = condition.test(input) ? ifTrue.apply(input) : ifFalse.apply(input);
            System.out.println(result);
            return result;
        };
    }

}