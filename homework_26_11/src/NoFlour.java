public class NoFlour extends Sweets {
    float pectinPercent;

    public NoFlour (String productComposition, String figureProduct,float productCookingTime, float pectinPercent) {
        super(productComposition, figureProduct, productCookingTime);
        this.pectinPercent=pectinPercent;
    }
}