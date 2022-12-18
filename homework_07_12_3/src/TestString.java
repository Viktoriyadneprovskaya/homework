public class TestString {
    String currentStr;


    public TestString(String currentStr) {
        this.currentStr = currentStr;
    }
    public  TestString(){

    }

    public String getString() {
        return currentStr;
    }

    public void setString(String currentStr) {
        this.currentStr = currentStr;
    }

    public Integer getVowels(){
        char[] arrayVow = {'a', 'e', 'i', 'o', 'u', 'y','A','E','I','O','U','Y'};
        int counter = 0;
        char[] arrayToProc = this.currentStr.toCharArray();
        for (char ch : arrayToProc) {
            for (char ch2 : arrayVow) {
                if (ch == ch2){
                    counter++;
                }
            }
        }
        return counter;
    }
    public String getCentralElement() {
        return currentStr.substring(currentStr.length()/2,currentStr.length()/2+1);
    }
    public String getShortElement() {
        String[] words = currentStr.split(" ");
        String shortestword = words[0];
        for (int i = 1; i < words.length; i++){
            if (shortestword.length() > words[i].length()){
                shortestword = words[i];
            }
        }
        return shortestword;
    }

    public String getViceVersa(String myString){
        char[] arrCh= myString.toCharArray();
        String newStr = "";
        for (int i=arrCh.length-1;i>=0;i--){
            newStr = newStr + arrCh[i];
        }
        return newStr;
    }

}
