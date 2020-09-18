
/**
 * Write a description of class Student here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Student extends Person
{
    // instance variables - replace the example below with your own
    private int id;

    /**
     * Constructor for objects of class Student
     */
    protected Student() {};
    
    protected Student(String name, int id)
    {
        // initialise instance variables
        this.name = name;
        this.id = id;
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
  
  protected void setId(int id) {
    this.id = id;
  }
  
  protected String getName() {
    return this.name;
  }
  
  protected int getId() {
    return this.id;
  }
}

