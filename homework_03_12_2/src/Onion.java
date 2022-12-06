import java.util.Date;

public class Onion extends Vegetables {
    String productColor;

    Onion(String productName, String productSort, Date harvestDate,int stock, String productColor){
        super(productName, productSort,harvestDate,stock);
        this.productColor=productColor;
    }
    void getInfoProduct() {
        System.out.println("Product name is: " + productName);
        System.out.println("Onion sort is: " + productSort);
        System.out.println("Onion harvest date is: " + harvestDate);
        System.out.println("Onion was stored in "+ stock + "stock");
        System.out.println("Onion color is: "+ productColor);
    }
}
