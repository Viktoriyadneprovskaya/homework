import java.util.Date;

public final class Immutable{
    private Date birthdate;
    private final String country;
    private final Person person;

    public Immutable(String country, Person person, Date birthdate){
        this.country=country;
        this.person = new Person(person.getFirstName(),person.getLastName());
        this.birthdate = birthdate;
    }

    public String getCountry(){
        return country;
    }

    public Date getBirthdate() {
        return birthdate;
    }
}
