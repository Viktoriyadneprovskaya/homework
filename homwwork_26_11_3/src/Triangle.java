public class Triangle {
    float sideA;
    float sideB;
    float sideC;
    float halfPerimeter;

    public Triangle (float sideA, float sideB, float sideC){
        this.sideA=sideA;
        this.sideB=sideB;
        this.sideC=sideC;
    }

    public void getSides (){
        System.out.println("Side A= " + sideA);
        System.out.println("Side B= " + sideB);
        System.out.println("Side C= "+ sideC);
    }
    public float getPerimeter() {
        return sideA+sideB+sideC;
    }

    public double getSquare (){
        halfPerimeter = (sideA+sideB+sideC)/2;
        return Math.sqrt(halfPerimeter * (halfPerimeter - sideA) * (halfPerimeter - sideB) * (halfPerimeter - sideC));
    }

    public void getPifagor(){
        if (Math.pow(sideC,2) == Math.pow(sideA,2)+Math.pow(sideB,2)) {
            System.out.println("This triangle is isosceles");
        }
        else{
            System.out.println("This triangle is not isosceles");
        }
    }
}
