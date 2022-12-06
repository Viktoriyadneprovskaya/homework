import java.util.Scanner;

public class Address {
    long index;
    String country;
    String region;
    String city;
    String street;
    int homeNumber;
    int flatNumber;

    Address(){
    };

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public long getIndex() {
        return index;
    }

    public void setIndex(long index) {
        this.index = index;
    }

    public int getHomeNumber() {
        return homeNumber;
    }

    public void setHomeNumber(int homeNumber) {
        this.homeNumber = homeNumber;
    }

    public int getFlatNumber() {
        return flatNumber;
    }

    public void setFlatNumber(int flatNumber) {
        this.flatNumber = flatNumber;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    Address(long index, String country, String region, String city, String street, int homeNumber, int flatNumber){
        this.index=index;
        this.country=country;
        this.region=region;
        this.city=city;
        this.street=street;
        this.homeNumber=homeNumber;
        this.flatNumber=flatNumber;
    }

    public void setAddress(){

    }
    public String toString(){
        String address = "";
        address = "Index: "+ index+"\n";
        address = address +"Country: "+country+"\n";
        address = address +"Region: "+region+"\n";
        address = address +"City: "+city+"\n";
        address = address +"Street: "+street+"\n";
        address = address +"Home number: "+ homeNumber+"\n";
        address = address +"Flat number: "+flatNumber;
        return address;
    }

    public boolean equals(Address address){
        if (this.index == address.index) {
            return true;
        } else {
            return false;
        }
    }
    public int hashCode() {
        return (int) index * city.hashCode() * street.hashCode() ;
    }
}
