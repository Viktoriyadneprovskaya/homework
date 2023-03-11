//Задачи(Необходимо создать класс в котором будут реализованы методы для след задач):
//ToDO 1: Получить список всех файлов и папок по указанному пути.(строка которой задается путь передается в параметры метода)
//ToDo 2: Создать текстовый файл и заполнить несколько строк произвольным текстом, Результат считать и вывести на екран. создать два метода, один для чтения,
//          другой для ввода. Имя файла и текст вводить из консоли.
//ToDO 3: Создать текстовый файл произвольного содержания, считать его и вывести на екран кол-во символов в файле, кол-во слов в файле.(Два значения)
//ToDO 4: Создать текстовый файл произвольного содержания и переименовать его
//ToDO 5: Создать текстовый файл, заполнить несколько строк произвольным текстом, вывести строки на екран в обратном порядке. Со звездочкой - вывести и строки и символы в обратном порядке. Для реализации лучше всего создать отдельный класс на два метода
//ToDO 6: Создать текстовый файл, но с условием, что при достижении 12ого символа запись будет производиться с новой строки, потом считать содержимое файла и вывести на екран. Пользователь вводит текст из консоли
//ToDO 7: Создать текстовый файл с именем original.txt, который будет содержать строку "HellO from text filE", далее необходимо перезаписать содержимое этого файла
//        в новый файл с именем originalCOPY.txt, удалив все гласные из строки.
//ToDO 8: Реализовать метод который сравнивает содержание двух файлов, если они идентичны - вывести на экран, если нет - вывести на екран
//

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        String path = "D:\\Vika\\levelup\\git\\homework\\homework_14_01\\";
        InputOutputMethods methods = new InputOutputMethods();
        //1
        System.out.println("Task #1");
        System.out.println(methods.allDirAndFiles(path));
        //2
        System.out.println("Task #2");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("input file name for writting");
        String name = reader.readLine();
        File myFile = methods.createTextFile(path+name+".txt","We can build a wonder world\n" +
                "Just follow me and dance all night\n" +
                "Cause nothing stop the music in your mind\n" +
                "We can build a wonder world\n" +
                "Just follow me and dance all night\n" +
                "Cause nothing stop the music in your mind\n");
        methods.readTextFile(myFile);
        //3
        System.out.println("Task #3");
        methods.readCharAmount(myFile);
        //4
        System.out.println("Task #4");
        if (!(methods.renameFile(myFile,path+name+"_renamed.txt"))){
            throw new IOException("Renaming file exception");
        }
        //5
        System.out.println("Task #5");
        System.out.println("=======reversed text=========");
        Reverso reMethods = new Reverso();
        reMethods.reverseTextFile(path+"textFile.txt");
        //6
        System.out.println("Task #6");
        reMethods.showFile(path+"mytextFile.txt",reMethods.enterUntil12());
        //7
        System.out.println("Task #7");
        String path1 = "D:\\Vika\\levelup\\git\\homework\\homework_14_01\\original.txt";
        String path3 = "D:\\Vika\\levelup\\git\\homework\\homework_14_01\\";
        File fileEnd = new File(path1);
        methods.copyFile(fileEnd,path3);
        //8
        File file =new File("D:\\Vika\\levelup\\git\\homework\\homework_14_01\\1.txt");
        File file1 =new File("D:\\Vika\\levelup\\git\\homework\\homework_14_01\\original.txt");
        methods.compareFiles(file,file1);

    }
}