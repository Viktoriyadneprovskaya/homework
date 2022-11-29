public class Flour extends Sweets {
    float flourPercent;

    public Flour (String productComposition, String figureProduct,float productCookingTime,float flourPercent) {
        super(productComposition, figureProduct, productCookingTime);
        this.flourPercent= flourPercent;
    }

}