import java.util.Date;

public abstract class  Vegetables {
    protected String productName;
    protected String productSort;
    protected Date harvestDate;
    protected int stock;

    int stockList[] = {1,2,3,4};
    Vegetables(String productName, String productSort,Date harvestDate,int stock){
        this.productName=productName;
        this.productSort=productSort;
        this.harvestDate=harvestDate;
        this.stock=stock;
    }

    abstract void getInfoProduct();

    final void moveToFourStock(){
        stock = stockList[3];
        System.out.println("Product was moved to " + stock+ "stock");
    };

    final boolean checkStorage(Vegetables veg1, Vegetables veg2) {
        return (veg1.stock == veg2.stock);
    }



}
