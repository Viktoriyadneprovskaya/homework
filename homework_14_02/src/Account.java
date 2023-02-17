import java.time.LocalDate;

public class Account {
    String firstName;
    String lastName;
    String country;
    LocalDate birthday;
    double balance;
    String gender;
    public Account(String firstName, String lastName, String country, LocalDate birthday, double balance, String gender) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.country = country;
        this.birthday = birthday;
        this.balance = balance;
        this.gender = gender;
    }
    public String getFirstName() {
        return firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public String getCountry() {
        return country;
    }
    public LocalDate getBirthday() {
        return birthday;
    }
    public double getBalance() {
        return balance;
    }
    public String getGender() {
        return gender;
    }
    public Integer getAge(LocalDate currentDate){
        int ddB = this.getBirthday().getDayOfYear();
        int ddC = currentDate.getDayOfYear();
        int i = (ddC - ddB)>=0 ? 0:1;
        return currentDate.getYear()-this.getBirthday().getYear()-i;
    }

    @Override
    public String toString() {
        return "Account{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", country='" + country + '\'' +
                ", birthday=" + birthday +
                ", balance=" + balance +
                ", gender='" + gender + '\'' +
                '}';
    }
}
