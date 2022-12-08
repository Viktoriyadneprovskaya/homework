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
    Address(long index, String country, String region, String city, String street, int homeNumber, int flatNumber){
        this.index=index;
        this.country=country;
        this.region=region;
        this.city=city;
        this.street=street;
        this.homeNumber=homeNumber;
        this.flatNumber=flatNumber;
    }

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

    public void setAddress(){

    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Address address = (Address) o;

        if (index != address.index) return false;
        if (homeNumber != address.homeNumber) return false;
        if (flatNumber != address.flatNumber) return false;
        if (!country.equals(address.country)) return false;
        if (!region.equals(address.region)) return false;
        if (!city.equals(address.city)) return false;
        return street.equals(address.street);
    }

    @Override
    public int hashCode() {
        int result = (int) (index ^ (index >>> 32));
        result = 31 * result + country.hashCode();
        result = 31 * result + region.hashCode();
        result = 31 * result + city.hashCode();
        result = 31 * result + street.hashCode();
        result = 31 * result + homeNumber;
        result = 31 * result + flatNumber;
        return result;
    }

    @Override
    public String toString() {
        return "Address{" +
                "index=" + index +
                ", country='" + country + '\'' +
                ", region='" + region + '\'' +
                ", city='" + city + '\'' +
                ", street='" + street + '\'' +
                ", homeNumber=" + homeNumber +
                ", flatNumber=" + flatNumber +
                '}';
    }
}