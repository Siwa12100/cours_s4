import operations.Operations;

public class Main {
    public static void main(String[] args) {
        System.out.println("Debut du tp");

        long val1 = Operations.additionner(2, 3, 4);
        long val2 = Operations.multiplier(2, 8, 2);
        long val3 = Operations.diviser(8, 2);
        long val4 = Operations.diviser(9, 2);
        boolean val5 = Operations.pythagore(8, 6, 10);
        boolean val6 = Operations.pythagore(2, 9, 8);

        System.out.println("Val5 : " + val5);
        System.out.println("Val6 : " + val6);

    }
}