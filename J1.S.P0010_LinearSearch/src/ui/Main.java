/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import java.util.Random;
import java.util.Scanner;

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
        int number = Validator.getInt("Enter number of array: ", "Please enter number > 0",
                "Please enter integer number", 1, Integer.MAX_VALUE);
        int key = Validator.getInt("Enter search value: ", "Error range!",
                "Please enter integer number", Integer.MIN_VALUE, Integer.MAX_VALUE);
        Array array = null;
        try {
            array = new Array(number);
            array.generateRandomArray();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        System.out.println("The array: " + array.toString());
        int index = array.searchFirstIndex(key);
        if (index == -1) {
            System.out.println("Can not found key!");
        } else {
            System.out.println("Found " + key + " at index: " + index);
        }
    }
}

 class Array {

    private int[] array;

    public Array(int number) throws Exception {
        if (number <= 0) {
            throw new Exception("number parameter must be > 0");
        }
        this.array = new int[number];
    }

    public int[] getArray() {
        return array;
    }

    public void setArray(int[] array) {
        this.array = array;
    }

    public void generateRandomArray() throws Exception {
        Random random = new Random();
        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(array.length);
        }
    }

    @Override
    public String toString() {
        String str = "[";
        for (int i = 0; i < array.length; i++) {
            str += array[i];
            if (i == array.length - 1) {
                str += "]";
            } else {
                str += ", ";
            }
        }
        return str;
    }

    public int searchFirstIndex(int key) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == key) {
                return i;
            }
        }
        return -1;
    }
}
 class Validator {
    private static final Scanner SCANNER = new Scanner(System.in);
    private Validator(){
        
    }
    public static int getInt(String messageInfo,String messsageErrorOutOfRange,
            String messageErrorNumber,int min,int max){
        do {            
            try {
                System.out.print(messageInfo);
                int number = Integer.parseInt(SCANNER.nextLine());
                if(number>=min&&number<=max){
                    return number;
                }else{
                    System.out.println(messsageErrorOutOfRange);
                }
            } catch (NumberFormatException e) {
                System.out.println(messageErrorNumber);
            }
        } while (true);
    }
    
    
}

