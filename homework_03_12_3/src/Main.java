//Создать иерархию классов от Animal, (Bird, Cat -> Eagle, Lion),
// но методы действий животных(плавать, летать, бежать, и тп.) расширять через интерфейс, подходящий соотв. типу животного

public class Main {
    public static String main(String[] args) {

    Eagle eagle = new Eagle("Africa",true,false, "brown");
    Lion lion = new Lion("Forest", false, true, 10);
    Cat cat=new Cat("Home",false, true);
    Bird bird=new Bird("Sky", true, false);
    System.out.println("Eagle's habit: "+ eagle.getHabit());
    System.out.println("Does eagle fly?  "+ eagle.convert(eagle.getIsFly()));
    System.out.println("Is eagle mammals? "+ eagle.convert(eagle.getIsMammals()));
    System.out.println("Eagle's color is "+ eagle.getColor());
    System.out.println(eagle.move());
    System.out.println("Lion's habit: "+ lion.getHabit());
    System.out.println("Does lion fly?: "+ lion.convert(lion.getIsFly()));
    System.out.println("Is lion mammals? "+ lion.convert(lion.getIsMammals()));
    System.out.println("Lion maximum length is "+lion.getMaxLength()+ "m");
    System.out.println(lion.move());
    System.out.println("Cat's habit: "+ cat.getHabit());
    System.out.println("Does cat fly?: "+ cat.convert(cat.getIsFly()));
    System.out.println("Is cat mammals? "+ lion.convert(lion.getIsMammals()));
    System.out.println(cat.move());
    System.out.println("Bird's habit: "+ bird.getHabit());
    System.out.println("Does bird fly?: "+ bird.convert(bird.getIsFly()));
    System.out.println("Is bird mammals? "+ bird.convert(bird.getIsMammals()));
    System.out.println(bird.move());
    }
}
