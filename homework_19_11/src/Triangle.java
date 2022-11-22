public class Triangle {
    float SideOne;
    float SideTwo;
    float SideThree;

    double Square;
    float Perimeter;

    Triangle (float SideOne, float SideTwo, float SideThree) {
        this.SideOne = SideOne;
        this.SideTwo = SideTwo;
        this.SideThree = SideThree;
    }
    public void CalculateTriangle() {
        Perimeter = SideOne + SideTwo + SideThree;
        Square = Math.sqrt(Perimeter/2 * (Perimeter/2 - SideOne) * (Perimeter/2 - SideTwo) * (Perimeter/2 - SideThree));
    }

}


