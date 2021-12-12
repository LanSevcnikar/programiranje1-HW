package cheetsheet;

public class vector2D {
  private int x;
  private int y;
  private static boolean writeWithHardBreckets = false;

  public vector2D(int _x, int _y) {
    this.x = _x;
    this.y = _y;
  }

  // These two are here because x is set to private
  public void setValueX(int _x) {
    this.x = _x;
  }

  public int getValueX() {
    return this.x;
  }
  public int getValueY() {
    return this.y;
  }

  public void print() {
    if (writeWithHardBreckets) {
      System.out.printf("Current position is (%d, %d)\n", this.x, this.y);
    } else {
      System.out.printf("Current position is [%d, %d]\n", this.x, this.y);
    }
  }

  public void add(vector2D v) {
    this.x += v.x;
    this.y += v.y;
  }

  // This can be called without any real vector having been designed. THis is
  // usefull beacuse it is just another function that knows how this should behave
  // without it
  // being attached to anything else
  public static double mag(vector2D v) {
    return Math.sqrt(v.x * v.x + v.y * v.y);
  }

  public static void setWritingStyle(boolean style) {
    writeWithHardBreckets = style;
  }
}


