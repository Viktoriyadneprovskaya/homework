import java.util.Arrays;

public class StringMethods {

    public void delChar(String str) {
        String s2 = "";
        for (int i = 0; i < str.length(); i++) {
            boolean found = false;
            for (int j = 0; i < str.length(); j++) {
                if (str.charAt(i) == s2.charAt(j)) {
                    found = true;
                    break;
                }
            }
            if (found == false) {
                s2 = s2.concat(String.valueOf(str.charAt(i)));
            }
        }
        System.out.println(s2);
    }

    public boolean isPalindrome(String str) {

        int j = 0;
        String str3 =str.replaceAll("\\s+", "");
        int i = str3.length() - 1;
        while (i > j) {
            if (str3.charAt(i) != str3.charAt(j)) {
                return false;
            }
        i--;
        j++;
        }
        return true;
    }
    public void validate(boolean a){
        if(a == true){
            System.out.println("Yes, this is a palindrome word");
        }
        else {
            System.out.println("No, this isn't a palindrome word");
        }
    }

    public static String delDublicate (String s){
        String s2 = "";
        for (int i = 0; i < s.length(); i++) {
            boolean found = false;
            for (int j = 0; j < s2.length(); j++) {
                if (s.charAt(i) == s2.charAt(j)) {
                    found = true;
                    break; //don't need to iterate further
                }
            }
            if (found == false) {
                s2 = s2.concat(String.valueOf(s.charAt(i)));
            }
        }
        return s2;
    }

    public String repeat(String str) {
        String strNoDubl=delDublicate(str);
        int q = strNoDubl.length();
        char[] resSimb = new char[q];
        int[] resQuan = new int[q];

        for (int i = 0; i < q; i++) {
            int coutDub=0;
            for (int j = 0; j<str.length(); j++) {
                if (strNoDubl.charAt(i) == str.charAt(j)) {
                    coutDub++;
                }
            }
            resSimb[i] = strNoDubl.charAt(i);
            resQuan[i] = coutDub;
        }
        int maxI=0;
        for (int i = 0; i < q; i++) {
 //           System.out.println(resSimb[i]+"-"+resQuan[i]);
            if (resQuan[i]>resQuan[maxI]){
                maxI = i;
            }
        }
        return "Maximum symbol '"+resSimb[maxI]+"' occurs in text "+ resQuan[maxI] +" times";
    }

}
