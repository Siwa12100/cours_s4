import fibonacci.Fibonacci;

public class Main {
    public static void main(String[] args) {
        Fibonacci f = new Fibonacci();
        System.out.println("fibo de 1 : " + f.calculFibonacci(1));
        System.out.println("fibo de 10 : " + f.calculFibonacci(10));
        System.out.println("fibo de 0 : " + f.calculFibonacci(0));
    }


}