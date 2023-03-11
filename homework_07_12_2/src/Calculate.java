public class Calculate {

    Calculate(){

    }
    public static int getSum(int a, int b){
        return a+b;
    }

    public static double getSum(double a, double b){
       return a+b;
    }

    public static int getDifference(int a, int b){
       return a-b;
    }
    public static double getDifference(double a, double b){
        return a-b;
    }
    public static int getMultiply(int a, int b){
        return a*b;
    }
    public static double getMultiply(double a, double b){
        return a*b;
    }
    public static int getDivided(int a, int b){
        int result = b==0?0:a/b;
        return result;
    }
    public static double getDivided(double a, double b){
        double result = b==0?0:a/b;
        return result;
    }
    public static int getMaximum(int a, int b){
        if(a<b){
            return b;
        }
        else{
           return a;
        }
    }
    public static double getMaximum(double a, double b){
        if(a<b){
            return b;
        }
        else{
            return a;
        }
    }
    public static int getMinimum(int a, int b){
        if(a<b){
            return a;
        }
        else{
            return b;
        }
    }
    public static double getMinimum(double a, double b){
        if(a<b){
            return a;
        }
        else{
            return b;
        }
    }
    public static int getExponentiation(int a, int b){
        int curA = a;
        for(int i=1;i<b;i++){
            a = a * curA;
        }
        return a;
    }
    public static double getExponentiation(double a, int b){//double не может быть
        double curA = a;
        for(int i=1;i<b;i++){
            a= a * curA;
        }
        return a;
    }
    public static int getPercent(int a, int b){
        return a*b/100;
    }
    public static double getPercent(double a, double b){
        return b*100/a;
    }//b не может быть double

    public static double getSquare(int a){
        double precision = 0.01;
        double x0 = a;
        double a1 = a/x0;
        double x1 = 0.5*(x0+(a/x0));
        double d = x1-x0;
        d = getMaximum(d,-d);
        while ((d>=2*precision) && (d*d>=2*precision)) {
            x0 = x1;
            x1 = 0.5*(x0+(a/x0));
            d = x1-x0;
            d = getMaximum(d,-d);
        }
        return x1;
    }

    public static int getMaxInt(double a){
        return (int) a+1;
    }
    public static int getMinInt(double a){
        return (int) a;
    }
}
