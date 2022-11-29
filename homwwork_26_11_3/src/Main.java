 //написать класс Triangle имитирующий прямоугольній треугольник со сторонами a,b,c и методами получения величины каждой стороны, площади, периметра
 //написать метод, проверяющий выполнение теоремы Пифагора
 //если стороны заданы не верно вывести сообщение на экран

import java.util.Scanner;
public class Main
{
    public static void main(String[] args) {
        float sideA;
        float sideB;
        float sideC;
        Scanner in = new Scanner(System.in);
        System.out.println("Enter side A volume: ");
        sideA =  in.nextFloat();
        System.out.println("Enter side B volume: ");
        sideB = in.nextFloat();
        System.out.println("Enter side C volume: ");
        sideC = in.nextFloat();
        Triangle triangle = new Triangle(sideA, sideB, sideC);

        triangle.getSides();
        System.out.println("Triangle perimeter = " + triangle.getPerimeter());
        System.out.println("Triangle square = " + triangle.getSquare());
        triangle.getPifagor();

    }
}