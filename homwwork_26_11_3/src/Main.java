 //написать класс Triangle имитирующий прямоугольній треугольник со сторонами a,b,c и методами получения величины каждой стороны, площади, периметра
 //написать метод, проверяющий выполнение теоремы Пифагора
 //если стороны заданы не верно вывести сообщение на экран

import java.util.Scanner;

import static java.lang.System.exit;

 public class Main
{
    public static void main(String[] args) {
        int sideA;
        int sideB;
        int sideC;
        Scanner in = new Scanner(System.in);
        System.out.println("Enter side A volume: ");
        sideA =  in.nextInt();
        System.out.println("Enter side B volume: ");
        sideB = in.nextInt();
        System.out.println("Enter side C volume: ");
        sideC = in.nextInt();
        Triangle triangle = new Triangle(sideA, sideB, sideC);

        triangle.getSides();
        System.out.println("Triangle perimeter = " + triangle.getPerimeter());
        System.out.println("Triangle square = " + triangle.getSquare());
        triangle.checkPifagor();

    }
}