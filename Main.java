/**
 * Write a description of class Main here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import java.util.Scanner;
import javax.swing.JOptionPane;
import java.util.ArrayList;
import java.util.Arrays;

class Main 
{
    static private ArrayList<College> colleges = new ArrayList<College>();

    interface mFunc {
        // Method that takes a "method" as argument
        //static void funcRun(Runnable toRun, ArrayList<College> colleges) {
        abstract void funcRun();
        /*
        change_collge(colleges);
        toRun.run();
         */
    }

    static mFunc[] mn = new mFunc[] {
            new mFunc() { public void funcRun() { Menu.add_college(colleges); } },
            new mFunc() { public void funcRun() { Menu.add_department(Menu.change_collge(colleges)); } },
            new mFunc() { public void funcRun() { Menu.add_lecturer(Menu.change_collge(colleges)); } },
            new mFunc() { public void funcRun() { Menu.asgn_lect_to_dep(Menu.change_collge(colleges)); } },
            new mFunc() { public void funcRun() { Menu.add_student_dep(Menu.change_collge(colleges)); } },
            new mFunc() { public void funcRun() { Menu.show_dep_stns(Menu.change_collge(colleges)); } },
            new mFunc() { public void funcRun() { Menu.biggest_dep(Menu.change_collge(colleges)); } }
        };

    public static void options() {
        System.out.println("\t\t Menu");
        System.out.println("\t1. Add college");
        System.out.println("\t2. Add department");
        System.out.println("\t3. Add lecturer");
        System.out.println("\t4. Assign lecturer to a department");
        System.out.println("\t5. Add student");
        System.out.println("\t6. Show all department students");
        System.out.println("\t7. Show the largest department");
        System.out.println("\t8. Exit");
    }

    public static void select(ArrayList<College> college) {
        int opt;
        Scanner s = new Scanner(System.in);
        while (true) {
            System.out.print("Select option: ");
            if (s.hasNext() && s.hasNextInt()) {
                opt = s.nextInt();
                //s.close();
                if (opt == 8)
                    return;
                else if (opt < 1 || opt > 8)
                    System.out.println("1 - 8 only");
                else mn[opt - 1].funcRun();
            }
        }
    }

    public static void main(String[] args) {

        System.out.println("Hello Codiva");
        options();
        System.out.println();
        select(colleges);
        System.out.println();
        // Until here !
        Lecturer lect = new Lecturer();
        lect.setHourly(100);
        System.out.println(lect.getName());
        System.out.println(lect.getHourly());
        //System.out.println(lect.name);
        //System.out.println(lect.hourly);

        College ort = new College();
        Lecturer lec = new Lecturer();
        ort.add_lect(lec);
        lec.setName("Shay");
        lec.setHourly(150);
        System.out.println(lec);
        Department dep = new Department("SpeedTech");
        ort.add_department(dep);
        ort.assign_lect_or_stn(lec, dep);
        System.out.println(dep.toString());
        dep.get_dep_lects();
        Student stn = new Student("Shlomo", 1234);
        ort.add_stn(stn);
        ort.assign_lect_or_stn(stn, dep);
        Department maxStn = ort.biggest_dep_by_stn();
        if (maxStn != null) {
            System.out.println(maxStn.toString());
        }
        //new MenuExample();

    }
}