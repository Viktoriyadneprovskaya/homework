import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        float boxLength;
        float boxWidth;
        float boxHeight;
        float radius;
        float percent;
        float newSalary;

        //calculate box volume
        Scanner input = new Scanner(System.in);
        System.out.println("Enter lengthBox: ");
        boxLength = input.nextFloat();
        System.out.println("Enter width: ");
        boxWidth = input.nextFloat();
        System.out.println("Enter height: ");
        boxHeight = input.nextFloat();
        Box myBox= new Box(boxLength, boxWidth, boxHeight);
        System.out.println("Box volume =" + myBox.VolumeBox());

        //calculate circle square
        System.out.println("Enter radius: ");
        radius = input.nextFloat();
        Circle myCircle = new Circle(radius);
        System.out.println("Circle square =" + myCircle.SquareCircle());

        //calculate triangle square
        Triangle myTriangle = new Triangle(2.0f, 4.0f, 5.0f);
        myTriangle.CalculateTriangle();
        System.out.println("Triangle perimeter = " + myTriangle.Perimeter);
        System.out.println("Triangle square = " + myTriangle.Square);


        //calculate employee salary
        Employee employeeOne = new Employee(5457, "Ivan", "Ivanov", 1300);
        Employee employeeTwo = new Employee(5458, "Max", "Maximov", 2100);
        System.out.println("Employee ID: " + employeeOne.getID());
        System.out.println("Employee firstname: " + employeeOne.getFirstName());
        System.out.println("Employee lastname: " + employeeOne.getLastName());
        System.out.println("Employee salary: " + employeeOne.getSalary());
        System.out.println("Employee year salary: " + employeeOne.year_salary());
        System.out.println("Enter salary increase percentage: ");
        percent = input.nextFloat();
        newSalary = employeeOne.increaseSalary(percent);
        System.out.println("Employee increase salary: " + newSalary);
        System.out.println("Employee increase year salary: " + employeeOne.new_year_salary(newSalary));
        System.out.println("Employee ID: " + employeeTwo.getID());
        System.out.println("Employee firstname: " + employeeTwo.getFirstName());
        System.out.println("Employee lastname: " + employeeTwo.getLastName());
        System.out.println("Employee salary: " + employeeTwo.getSalary());
        System.out.println("Employee year salary: " + employeeTwo.year_salary());
        System.out.println("Enter salary increase percentage: ");
        percent = input.nextFloat();
        newSalary = employeeTwo.increaseSalary(percent);
        System.out.println("Employee increase salary: " + newSalary);
        System.out.println("Employee increase year salary: " + employeeTwo.new_year_salary(newSalary));
        input.close();
    }
    }
