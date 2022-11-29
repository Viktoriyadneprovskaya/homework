public class Cookie extends Flour {
    boolean isYeast;

    public Cookie (String productComposition, String figureProduct,float productCookingTime,float flourPercent, boolean isYeast) {
        super(productComposition, figureProduct, productCookingTime, flourPercent);
        this.isYeast=isYeast;
    }
}