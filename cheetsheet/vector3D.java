package cheetsheet;

public class vector3D extends vector2D {
  private int z;

  public vector3D(int x, int y, int z) {
    super(x, y);
    this.z = z;
  }

  @Override
  public void print() {
    System.out.printf("Current position is (%d, %d, %d)\n", 
      super.getValueX(), super.getValueY(), this.z);
  }
}