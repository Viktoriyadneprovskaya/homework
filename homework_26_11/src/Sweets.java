public class Sweets {
    String productComposition;
    String figureProduct;
    float productCookingTime;

    public Sweets (String productComposition, String figureProduct,float productCookingTime) {
        this.productComposition = productComposition;
        this.figureProduct = figureProduct;
        this.productCookingTime = productCookingTime;

    }

    public void Show (){
        System.out.println("Product composition: " + productComposition);
    }

    public void GetTime(){
        System.out.println("Product cooking time: " + productCookingTime);
    }
}
