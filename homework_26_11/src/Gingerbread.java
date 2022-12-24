public class Gingerbread extends Flour{
    boolean isCustard;

    public Gingerbread (String productComposition, String figureProduct,float productCookingTime,float flourPercent,boolean isCustard) {
        super(productComposition, figureProduct, productCookingTime, flourPercent);
        this.isCustard= isCustard;
    }

}