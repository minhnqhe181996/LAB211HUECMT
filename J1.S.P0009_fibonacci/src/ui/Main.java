/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

/**
 *
 * @author win
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int maxNumber = 45;
        Fibonacci fibonacci = new Fibonacci(maxNumber);
        fibonacci.displayFibonacci("The " + maxNumber + " sequence fibonacci: ");
    }

}

class Fibonacci {

    private int[] fibonacci;

    public Fibonacci(int number) {
        fibonacci = new int[number];
    }

    public void displayFibonacci(String message) {
        System.out.println(message);
        for (int i = 0; i < fibonacci.length; i++) {
            System.out.print(Fibonacci(i));
            if (i == fibonacci.length - 1) {
                System.out.print(".");
            } else {
                System.out.print(", ");
            }
        }
    }

    int Fibonacci(int n) {
        if (n == 0 || n == 1) {
            return n;
        }
        //Kiểm tra xem F[n] đã được tính hay chưa? F[n]==0 thì là chưa được tính, != là đã tính
        if (fibonacci[n] != 0) {
            return fibonacci[n];
        }
        //Nếu F[n] chưa được tính thì đi tính nó và lưu lại
        fibonacci[n] = Fibonacci(n - 1) + Fibonacci(n - 2);
        return fibonacci[n];
    }
}
