import java.util.Date;

public class Main {
    public static void main(String[] args) {
      Person person=new Person("Ivanov", "Ivan");
      Immutable immutable= new Immutable("Ukraine",person, new Date(1986,01,06));
      System.out.println(immutable.getCountry());
      System.out.println(person.getFirstName());
      System.out.println(immutable.getBirthdate());
    }
}
