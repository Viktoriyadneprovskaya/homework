public class Triangle {
    int sideA;
    int sideB;
    int sideC;
    float halfPerimeter;
    boolean isosceles;

    public Triangle (int sideA, int sideB, int sideC){
        this.sideA=sideA;
        this.sideB=sideB;
        this.sideC=sideC;
        if (!checkPifagor()) {
            throw new IllegalArgumentException("This triangle is not isosceles");
        }
    }

    public void getSides (){
        System.out.println("Side A= " + sideA);
        System.out.println("Side B= " + sideB);
        System.out.println("Side C= "+ sideC);
    }
    public float getPerimeter() {
        return sideA + sideB + sideC;
    }

    public double getSquare (){
            halfPerimeter = (sideA + sideB + sideC) / 2;
            return Math.sqrt(halfPerimeter * (halfPerimeter - sideA) * (halfPerimeter - sideB) * (halfPerimeter - sideC));
    }

    public boolean checkPifagor(){
        if (Math.pow(sideC,2) == Math.pow(sideA,2)+Math.pow(sideB,2)) {
            return true;
        }
        else{
            return false;
        }
    }
}
