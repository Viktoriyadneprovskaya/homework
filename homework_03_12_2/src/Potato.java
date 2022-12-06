import java.util.Date;

public class Potato extends Vegetables {
    String productForm;

    Potato(String productName, String productSort, Date harvestDate, int stock,String productForm) {
        super(productName, productSort,harvestDate,stock);
        this.productForm=productForm;
    }
    void getInfoProduct() {
        System.out.println("Product name is: " + productName);
        System.out.println("Potato sort is: " + productSort);
        System.out.println("Potato harvest date is: " + harvestDate);
        System.out.println("Potato was stored in "+ stock + "stock");
        System.out.println("Potato form is: "+ productForm);
    }

}
