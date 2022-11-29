public class Box {
    float boxLength;
    float boxWidth;
    float boxHeight;
    Box (float lengthBox, float widthBox, float heightBox) {
        boxLength= lengthBox;
        boxWidth = widthBox ;
        boxHeight = heightBox;
    }
    public float VolumeBox() {
        return boxLength*boxWidth*boxHeight;
    }
}
