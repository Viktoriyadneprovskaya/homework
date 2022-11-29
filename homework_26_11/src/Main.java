// иерархия классов, реализация наследования, полиморфизма и инкапсуляции

public class Main {
    public static void main(String[] args) {
        Gingerbread gingerbread = new Gingerbread("flour, sugar, water","round", 5, 80, true);
        Cake cake = new Cake("flour,sugar,water", "bear", 1, 60, true);
        Marshmallow marshmallow= new Marshmallow("pectin, apple, sugar", "round", 2, 10, "hand work", 3);
        Marmalade marmalade =new Marmalade("juice, sugar, pectin", "heart", 9, 20, true);
        Cookie cookie =new Cookie("flour, water, sugar", "square", 3, 90, false);
        System.out.println("Gingerbread figure: " + gingerbread.figureProduct);
        cake.Show(); //переопределение метода
        marmalade.Show();
        cookie.Show();
        cake.GetTime();
        marshmallow.GetTime(); //переопределение метода
    }
}