package warmup;

public class Main {

    public static void main(String[] args) {
        int num = 0;
        int sum = 0;
        while (num < 1000) {
            if (num % 3 == 0 || num % 5 == 0) {
                sum += num;
            }
            num++;
        }
        System.out.println("The sum of all the multiples of 3 or 5 below 1000 is: " + sum);
    }
}
