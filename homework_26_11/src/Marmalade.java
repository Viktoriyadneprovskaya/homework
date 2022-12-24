public class Marmalade extends NoFlour {
    boolean haveSugar;

    public Marmalade(String productComposition, String figureProduct,float productCookingTime, float pectinPercent, boolean haveSugar){
        super(productComposition,figureProduct,productCookingTime,pectinPercent);
        this.haveSugar=haveSugar;
    }
}