public class Marshmallow extends NoFlour {
    String formMethod;
    int shelfTime;

    public Marshmallow (String productComposition, String figureProduct,float productCookingTime, float pectinPercent, String formMethod, int shelfTime) {
        super(productComposition,figureProduct,productCookingTime,pectinPercent);
        this.formMethod=formMethod;
        this. shelfTime=shelfTime;
    }

    public void GetTime(){
        System.out.println("Product cooking time: " + productCookingTime + "\nShelf time: " + shelfTime);
    }
}