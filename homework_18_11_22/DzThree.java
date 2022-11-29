//вывести сумму чисел элементов массива с плав.точкой. Числа могут быть отрицательными или не целыми. Если длина массива=0, вернуть 0, Длима массива и значения элементов рандомные

public class DzThree {
  
    public static void main(String[] args) {
          
        int size = (int) (Math.random()*9);
        if (size == 0) {
        System.out.println("Your random massive length =0");
        }
        else {
        double[] Arr = new double[size]; 
        System.out.println("Your random massive elements: ");
        for (int i=0; i<Arr.length; i++) {
        Arr[i] = (Math.random()*20.0) - 10.0;
        System.out.println(Arr[i]);
        }
	    System.out.println();
        double sum=0;
        for (int i=0; i<Arr.length; i++){
	    sum+= Arr[i];
        }
	    System.out.print("The massive elements sum is: " + sum);
	    }
}
}