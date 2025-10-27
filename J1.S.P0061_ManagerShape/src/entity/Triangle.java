/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

/**
 *
 * @author win
 */
public final class Triangle extends Shape {

    private double sideA;
    private double sideB;
    private double sideC;

    public Triangle() {
    }

    public Triangle(double sideA, double sideB, double sideC) throws Exception {
        if (sideA + sideB > sideC && sideA + sideC > sideB && sideB + sideC > sideA) {
            setSideA(sideA);
            setSideB(sideB);
            setSideC(sideC);
        } else {
            throw new Exception("Sum of two side must be more than side remaining! Try again");
        }
    }

    public double getSideA() {
        return sideA;
    }

    public void setSideA(double sideA) throws Exception {
        if (sideA > 0) {
            this.sideA = sideA;
        } else {
            throw new Exception("Side A must be >0");
        }
    }

    public void setSideB(double sideB) throws Exception {
        if (sideB > 0) {
            this.sideB = sideB;
        } else {
            throw new Exception("Side B must be >0");
        }
    }

    public void setSideC(double sideC) throws Exception {
        if (sideC > 0) {
            this.sideC = sideC;
        } else {
            throw new Exception("Side C must be >0");
        }
    }

    public double getSideB() {
        return sideB;
    }

    public double getSideC() {
        return sideC;
    }

    @Override
    public double getPerimeter() {
        return (sideA + sideB + sideC);
    }

    @Override
    public double getArea() {
        double p = getPerimeter() / 2;
        return Math.sqrt(p * (p - sideA) * (p - sideB) * (p - sideC));
    }

    @Override
    public void printResult() {
        System.out.println("-----Triangle-----");
        System.out.println("Side A: " + sideA);
        System.out.println("Side B: " + sideB);
        System.out.println("Side C: " + sideC);
        System.out.println("Area: " + getArea());
        System.out.println("Perimeter: " + getPerimeter());
    }

}
