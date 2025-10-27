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
public final class Rectangle extends Shape {

    private double width;
    private double length;

    public Rectangle() {
    }

    public Rectangle(double width, double length) throws Exception {
        setWidth(width);
        setLength(length);
    }

    public void setWidth(double width) throws Exception {
        if (width > 0) {
            this.width = width;
        } else {
            throw new Exception("Width must be >0");
        }
    }

    public void setLength(double length) throws Exception {
        if (length >= width && length > 0) {
            this.length = length;
        } else {
            throw new Exception("Lenght must be >= Width");
        }
    }

    @Override
    public double getPerimeter() {
        return 2 * (width + length);
    }

    @Override
    public double getArea() {
        return width * length;
    }

    @Override
    public void printResult() {
        System.out.println("-----Rectangle-----");
        System.out.println("Width: " + width);
        System.out.println("Length: " + length);
        System.out.println("Area: " + getArea());
        System.out.println("Perimeter: " + getPerimeter());
    }

}
