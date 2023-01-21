import java.io.*;

public class InputOutputMethods {

    public String allDirAndFiles(String path) {
        String files = "";
        File dir = new File(path);
        for (File s : dir.listFiles()) {
            files = files + s.getName() + "; ";
        }
        return files;
    }

    public void readTextFile(File file) {
        try (FileReader fileReader = new FileReader(file)) {
            int i;
            while ((i = fileReader.read()) != -1) {
                System.out.print((char) i);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }


    public void readCharAmount(File file) {
        //System.out.println(file.exists());
        try (FileReader fileReader = new FileReader(file)) {
            int count = 0, i, countWords = 0;
            while ((i = fileReader.read()) != -1) {
                count++;
                if ((char) i == ' ' || i == 10) {
                    countWords++;
                }
            }
            System.out.println(String.valueOf(count) + ":" + String.valueOf(countWords));
        } catch (Exception e) {
            System.out.println(e);
        }
    }


    public boolean renameFile(File myFile, String fullNewName) throws IOException {
        File newFile = new File(fullNewName);
        if (!newFile.exists()) {
            return myFile.renameTo(newFile);
        } else {
            throw new java.io.IOException("File exists");
        }
    }

    public void copyFile(File file, String path) {
        File fileOne = new File("originalCOPY.txt");
        StringBuilder current = new StringBuilder("");
        StringBuilder copyString = new StringBuilder("");
        try {
            fileOne.createNewFile();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
            int i;
            while ((i = bufferedReader.read()) != -1) {
                current.append((char) i);
            }

            String str = current.toString();
            char[] ao ={'a', 'o', 'i', 'u', 'e', 'O', 'I', 'U', 'E', 'A'};
            for (int j = 0; j < str.length(); j++) {
                boolean flag = false;
                for (char c : ao) {
                    if (str.charAt(j) == c) {
                        flag = true;
                        break;
                    }
                }
                if (!flag) {
                    copyString.append(str.charAt(j));
                }
            }
        } catch (IOException e) {
            System.out.println("Exc5");
        }
        try (FileWriter fileWriter = new FileWriter(fileOne)) {
            fileWriter.write(copyString.toString());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public File createTextFile(String filePath, String text) throws IOException {
        File fileWr = new File(filePath);
        if (!fileWr.exists()) {
            fileWr.createNewFile();
        }
        //System.out.println(fileWr.exists());
        try (FileWriter fileWriter = new FileWriter(fileWr, true)) {
            fileWriter.write(text);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return fileWr;
    }


    public void compareFiles(File file, File fileOne) {
        StringBuilder sb = new StringBuilder();
        StringBuilder sb1 = new StringBuilder();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
            int i;
            while ((i = bufferedReader.read()) != -1) {
                sb.append((char) i);
            }
        } catch (IOException e) {
            System.out.println("Exc7");
        }
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fileOne))) {
            int i;
            while ((i = bufferedReader.read()) != -1) {
                sb1.append((char) i);
            }

        } catch (IOException e) {
            System.out.println("Exc8");
        }
        if (sb.toString().equals(sb1.toString())) {
            System.out.println("the same");
        } else {
            System.out.println("different");
        }
    }
}


