
/**
 * Write a description of class Lecturer here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Lecturer extends Person
{
    // instance variables - replace the example below with your own
    private int hourly = 75;

    /**
     * Constructor for objects of class Lecturer
     */
    protected Lecturer() {};
  
    protected Lecturer(String name, int hourly) {
    this.name = name;
    this.hourly = hourly;
}

    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    protected void setName(String name) {
    this.name = name;
  }
  
  protected void setHourly(int hourly) {
    this.hourly = hourly;
  }
  
  protected String getName() {
    return this.name;
  }
  
  protected int getHourly() {
    return this.hourly;
  }
}
