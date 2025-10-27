/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import entity.Matrix;
import utils.Validator;

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
        Matrix matrix1 = new Matrix();
        Matrix matrix2 = new Matrix();
        Matrix result;
        while (true) {
            int choice = Validator.getInt("==========Calculator program============\n"
                    + "1. Addition Matrix\n"
                    + "2. Subtraction Matrix\n"
                    + "3. Multiplication Matrix\n"
                    + "4. Quit\n"
                    + "Enter your choice: ", "Just be 1 -> 4", "Please enter integer number", 1, 4);
            switch (choice) {
                case 1:
                    System.out.println("---------Addition---------");
                    matrix1.input(1);
                    matrix2.input(2);
                    System.out.println("-------------Result-------------");
                    try {
                        result = matrix1.add(matrix2);
                        System.out.print(matrix1.toString());
                        System.out.println("+");
                        System.out.print(matrix2.toString());
                        System.out.println("=");
                        System.out.println(result.toString());
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 2:
                    System.out.println("---------Subtraction---------");
                    matrix1.input(1);
                    matrix2.input(2);
                    System.out.println("-------------Result-------------");
                    try {
                        result = matrix1.subtract(matrix2);
                        System.out.print(matrix1.toString());
                        System.out.println("-");
                        System.out.print(matrix2.toString());
                        System.out.println("=");
                        System.out.println(result.toString());
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 3:
                    System.out.println("---------Multiplication---------");
                    matrix1.input(1);
                    matrix2.input(2);
                    System.out.println("-------------Result-------------");
                    try {
                        result = matrix1.multiply(matrix2);
                        System.out.print(matrix1.toString());
                        System.out.println("*");
                        System.out.print(matrix2.toString());
                        System.out.println("=");
                        System.out.println(result.toString());
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 4:
                    System.exit(0);
                    break;
            }
        }
    }

}
