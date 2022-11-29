public class Employee {
    int id;
    String firstName;
    String lastName;
    float salary;

    Employee(int id, String firstName, String lastName, float salary){
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.salary = salary;
    }

    int getID(){
        return id;
    }
    String getFirstName(){
        return firstName;
    }

    String getLastName(){
        return lastName;
    }

    //String getAllData(){
    //  return id+" | "+firstName+" | "+lastName+" | "+salary;
    // }

    float getSalary() {
        return salary;
    }

    float year_salary(){
        return salary*12;
    }

    float increaseSalary(float percent) {
        float new_salary;
        new_salary = salary + (salary*percent/100);
        return new_salary;
    }

    float new_year_salary(float new_salary){
        return new_salary*12;
    }
}
