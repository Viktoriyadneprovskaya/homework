public class Person {
    String name;
    int age;
    String gender;

    public Person(String name, int age, String gander) {
        this.name = name;
        this.age = age;
        this.gender = gander;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", gender='" + gender + '\'' +
                '}';
    }

    public int getAge() {
        return age;
    }

    public String getGender() {
        return gender;
    }
}
