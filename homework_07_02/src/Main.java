//Создать класс Person в котором будут поля age, gender, name. Создать вспомагательный класс, в котором создать список Личностей,
//заполнить его произвольно и  реализовать последавательно методы которые будут выводить на екран :
//1) Всех девушек
//2) Всех старше n возраста
//3) Всех мужчин младше n возраста
//Проверить как работает,  далее создать метод который оптимизирует предидущие методы через реализацию интерфейса(который так же нужно создать.
//Для каждого кейса своя реализации через класс)
//Далее проверить как это работает с анонимными классами
//Далее заменить анонимные классы на лямбды.

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
       Person personOne =new Person("Max", 25, "male");
       Person personTwo =new Person("Sonya", 18, "female");
       Person personThree =new Person("Iren", 23, "female");
       Person personFour =new Person("Eric", 26, "male");
       Person personFive =new Person("John", 29, "male");
       Person personSix =new Person("Santa", 24, "female");
       Person personSeven =new Person("Peter", 27, "male");

        List<Person> personList=new ArrayList<>();
        personList.add(personOne);
        personList.add(personTwo);
        personList.add(personThree);
        personList.add(personFour);
        personList.add(personFive);
        personList.add(personSix);
        personList.add(personSeven);

        System.out.println("==========");
        femaleSort(personList);
        System.out.println();
        ageUnder(personList,25);
        System.out.println();
        maleBelowAge(personList,27);
        System.out.println("==========");
        System.out.println("***********");
        checkPerson(personList,new CheckFemaleSort());
        System.out.println();
        checkPerson(personList,new CheckAgeUnder());
        System.out.println();
        checkPerson(personList, new CheckMaleBelowAge());
        System.out.println("*************");
        System.out.println("++++++++++++++");
        checkPerson(personList, new PersonChecks() {
            @Override
            public boolean check(Person person) {
                return person.getGender().equals("female");
            }
        });
        System.out.println();
        checkPerson(personList, new PersonChecks() {
            @Override
            public boolean check(Person person) {
                return person.getAge()>25;
            }
        });
        System.out.println();
        checkPerson(personList, new PersonChecks() {
            @Override
            public boolean check(Person person) {
                return person.getGender().equals("male")&& person.getAge()<27;
            }
        });
        System.out.println("+++++++++++++++++");
        checkPerson(personList, person -> person.getGender().equals("female"));
        System.out.println();
        checkPerson(personList, person -> person.getAge() > 25);
        System.out.println();
        checkPerson(personList, person -> person.getGender().equals("male")&& person.getAge()<27);
    }
    public static void femaleSort(List<Person> personList){
        for (Person person: personList){
            if(person.getGender().equals("female")){
                System.out.println(person);
            }
        }
    }
    public static void ageUnder(List<Person> personList, int age){
        for (Person person: personList){
            if(person.getAge()>age){
                System.out.println(person);
            }
        }
    }
    public static void maleBelowAge(List<Person> personList, int age){
        for (Person person: personList){
            if(person.getGender().equals("male")){
                if (person.getAge()<age) System.out.println(person);
            }
        }
    }
    interface  PersonChecks{
        boolean check (Person person);
    }
    public static void checkPerson(List<Person> personList, PersonChecks checks){
        for (Person person: personList){
            if(checks.check(person)){
                System.out.println(person);
            }
        }
    }
    static class CheckFemaleSort implements PersonChecks{
        public boolean check(Person person){
            return person.getGender().equals("female");
        }
    }
    static class CheckAgeUnder implements PersonChecks{
        @Override
        public boolean check(Person person) {
            return person.getAge()>25;
        }
    }
    static class CheckMaleBelowAge implements PersonChecks{
        @Override
        public boolean check(Person person) {
            return person.getGender().equals("male")&& person.getAge()<27;
        }
    }
}