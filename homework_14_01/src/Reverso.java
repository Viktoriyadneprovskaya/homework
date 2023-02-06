import java.io.*;
import java.util.Stack;

public class Reverso {
    public void reverseTextFile(String path){
        File file =new File(path);
        try (FileWriter fileWriter=new FileWriter(file,true)){
//            BufferedReader input = new BufferedReader(
//                    new InputStreamReader(System.in));
//            String s = input.readLine();
//            fileWriter.write(s);
            fileWriter.write("File writer test\n");
            fileWriter.write("File1 writer1 test1\n");
            fileWriter.write("File2 writer2 test2\n");
        }catch (IOException e){
            System.out.println("Ex1");
        }
        try (BufferedReader bufferedReader =new BufferedReader(new FileReader(file))) {
            StringBuilder sb = new StringBuilder();
            while (true) {
                int i;
                if ((i = bufferedReader.read()) == -1) {
                    break;
                } else {
                    sb.append((char) i);
                    sb.append(bufferedReader.readLine());
                    sb.append("\n");
                }
            }
            System.out.println(sb);

            String s = sb.toString();
            String[] arr = s.split("\n");
            //вывод строк в обратном порядке
            for (int i = arr.length - 1; i >= 0; i--) {
                System.out.println(arr[i]);
            }
            //вывод символов в обратном порядке
            String newString = ""; String s1 = "";
            for (int i = arr.length - 1; i >= 0; i--) {
                s1 = arr[i];
                System.out.println(arr[i]);
                for (int j = s1.length() - 1; j >= 0; j--) {
//                    newString = newString + s1.charAt(j);
                    System.out.print(s1.charAt(j));
                }
//                newString = newString + "\n";
                System.out.println();
            }
//            try (FileWriter fileWriter = new FileWriter(file, true)) {
//                fileWriter.write(s1);
//            } catch (IOException e) {
//                System.out.println("Ex1");
//            }
        }catch (IOException e){
            System.out.println("Ex2");
        }
    }

    public String enterUntil12() throws IOException {
        StringBuilder line = new StringBuilder("");
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        String s = input.readLine();

        for (int i=0; i < s.length(); i++){
            if ((i+1) % 12 == 0 ) {
                line.append(s.charAt(i)+"\n");
            }else {
                line.append(s.charAt(i));
            }
        }
        return line.toString();
    }
    public void showFile(String path, String line){
        File file =new File(path);
        try  (FileWriter fileWriter = new FileWriter(file)){
            fileWriter.write(line);
        }catch (IOException e){
            System.out.println("Exc4");
        }

    }
}
