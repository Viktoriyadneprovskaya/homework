public class Cake extends Flour {
    boolean haveFilling;

    public Cake (String productComposition, String figureProduct, float productCookingTime, float flourPercent, boolean haveFilling) {
        super(productComposition, figureProduct, productCookingTime, flourPercent);
        this.haveFilling= haveFilling;

    }
    public void Show (){
        System.out.println("Product composition: " + productComposition + "Cake figure: "+ figureProduct);
    }
}
