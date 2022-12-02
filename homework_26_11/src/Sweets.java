public class Sweets {
    protected String productComposition;
    protected String figureProduct;
    protected float productCookingTime;

    public Sweets (String productComposition, String figureProduct,float productCookingTime) {
        this.productComposition = productComposition;
        this.figureProduct = figureProduct;
        this.productCookingTime = productCookingTime;

    }

    public void show (){
        System.out.println("Product composition: " + productComposition);
    }

    public void getTime(){
        System.out.println("Product cooking time: " + productCookingTime);
    }
}
