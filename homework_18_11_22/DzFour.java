//вывести в консоль все элементы командной строки, а если их нет выводит сообщение, что их кол-во ранво нулю

public class DzFour {
  
    public static void main(String[] args) {
    if (args.length == 0) {
	System.out.println("No arguments");
	} 
	else {
    for (int i = 0; i < args.length; i++) {
    System.out.println(args[i]);
    }
	}
}
}
