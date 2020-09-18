
/**
 * Write a description of class Department here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Department
{
    // instance variables - replace the example below with your own
    private String dep_name;
    private Lecturer [] dep_lects = new Lecturer[0];
    private Student [] dep_stns = new Student[0];
    int lectsAmount = 0, stnAmount = 0, i;

    /**
     * Constructor for objects of class Department
     */
    protected Department() {};

    protected Department(String name)
    {
        // initialise instance variables
        dep_name = name;
    }

    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    protected void add_lec(Lecturer lec) {
        if (lectsAmount >= dep_lects.length) {
            Lecturer [] temp = new Lecturer[lectsAmount + 1];
            for (i = 0; i < lectsAmount; i++)
                temp[i] = dep_lects[i];
            dep_lects = temp;
        }
        dep_lects[lectsAmount++] = lec;
    }

    protected void add_stn(Student stn) {
        if (stnAmount >= dep_stns.length) {
            Student [] temp = new Student[stnAmount + 1];
            System.arraycopy(dep_stns, 0, temp, 0, stnAmount);
            dep_stns = temp;
        }
        dep_stns[stnAmount++] = stn;
    }

    protected String getDepName() {
        return dep_name;
    }

    public String toString() {
        return "Department name: " + dep_name + ", Lecturers: " + lectsAmount + ", Students: " + stnAmount; 
    }

    protected void get_dep_lects() {
        if (lectsAmount == 0) System.out.println("No lecturers");
        for (i = 0; i < lectsAmount; i++)
            System.out.println("name: " + dep_lects[i].getName() + ", hourly: " + dep_lects[i].getHourly() + ", hash: " + dep_lects[i]);
    }

    protected void get_dep_stns() {
        if (stnAmount == 0) System.out.println("No students");
        for (i = 0; i < stnAmount; i++)
            System.out.println("name: " + dep_stns[i].getName() + ", id: " + dep_stns[i].getId() + ", hash: " + dep_stns[i]);
    }

    protected int getAmountOfStns() {
        return stnAmount;
    }
}

