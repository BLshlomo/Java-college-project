import java.util.ArrayList;
import java.util.Scanner;

class Menu {
    static Scanner s = new Scanner(System.in);
    // return the college
    // part of menu
    // return chosen College class, think of changeing to return only index
    protected static College change_collge(ArrayList<College> colleges) {
        int i, len = colleges.size();
        String name;
        if (len == 0) { 
            System.out.println("Create college first");
            return Menu.add_college(colleges);
        }
        while (true) {
            System.out.printf("College name or index ('back' to go back): ");
            s.hasNext();
            if (s.hasNextInt()) {
                i = s.nextInt();
                s.nextLine();
                if (i > -1 && i < len)
                    return colleges.get(i);
                else System.out.format("Index out of range (%d) !",  len);
            }
            else {
                name = s.nextLine();
                if (name.equals("back"))
                    return null;
                for (College c : colleges) {
                    if (c.get_clg_name().equals(name))
                        return c;
                }
                System.out.println("College name not found !");
            }
        }
    }

    protected static College add_college(ArrayList<College> colleges) {
        College college;
        String name;
        //s.nextLine();
        System.out.print("Enter college name ('back' to go back): ");
        name = s.nextLine();
        if (name.equals("back")) 
            return null;
        colleges.add(college = new College(name));
        return college;
    }

    protected static void add_department(College college) {
        String name;
        if (college == null) return;
        System.out.print("Enter department name ('back' to go back): ");
        name = s.nextLine();
        if (name.equals("back")) 
            return;
        college.add_department(new Department(name));
    }

    protected static void add_lecturer(College college) {
        String name;
        int hourly;
        if (college == null) return;
        //s.nextLine();
        System.out.print("Enter lecturer name ('back' to go back): ");
        if ((name = s.nextLine()).equals("back")) 
            return;
        System.out.println("Enter lecturer hourly wage: ");
        while (s.hasNext()) {
            if (s.hasNextInt()) {
                hourly = s.nextInt();
                s.nextLine();
                if (hourly < 0)
                    System.out.println("Hourly wage has to be above -1");
                else {
                    college.add_lect(new Lecturer(name, hourly));
                    return;
                }
            }
        }
    }

    protected static void asgn_lect_to_dep(College college) {
        String name;
        Lecturer lect;
        if (college == null) return;
        //s.nextLine();
        System.out.print("Enter lecturer name ('back' to go back): ");
        if ((name = s.nextLine()).equals("back")) 
            return;
        if ((lect = college.find_lect(name)) == null) {
            System.out.print("Name not found");
            return;
        }
        //s.nextLine();
        System.out.print("Enter department name ('back' to go back): ");
        if ((name = s.nextLine()).equals("back")) 
            return;
        college.assign_lect_or_stn(lect, name);
    }

    protected static void add_student_dep(College college) {
        String name;
        Student stn;
        int id = -1;
        if (college == null) return;
        //s.nextLine();
        System.out.print("Enter student name ('back' to go back): ");
        if ((name = s.nextLine()).equals("back")) 
            return;
        System.out.print("Enter student ID: ");
        while (s.hasNext()) {
            if (s.hasNextInt()) {
                id = s.nextInt();
                s.nextLine();
                if (id < 0)
                    System.out.println("ID cant be negative number");
                else
                    break;
            }
        }
        college.add_stn(stn = new Student(name, id));
        //s.nextLine();
        System.out.print("Enter department name ('back' to go back): ");
        if ((name = s.nextLine()).equals("back")) 
            return;
        college.assign_lect_or_stn(stn, name);
    }

    protected static void show_dep_stns(College college) {
        String name;
        Department dep;
        if (college == null) return;
        //s.nextLine();
        System.out.print("Enter department name ('back' to go back): ");
        if ((name = s.nextLine()).equals("back")) 
            return;
        if ((dep = college.find_dep(name)) == null)
            return;
        dep.get_dep_stns();
    }

    protected static void biggest_dep(College college) {
        Department dep;
        if (college == null) return;
        if ((dep = college.biggest_dep_by_stn()) == null)
            return;
        System.out.println(dep.toString());
        dep.get_dep_stns();
    }

    /*
    interface mFunc {
    // Method that takes a "method" as argument
    static void funcRun(Runnable toRun, ArrayList<College> colleges) {
    }

    /*
    static mFunc[] menu = new mFunc[] {
    new mFunc() { public void funcRun() { add_department(Menu.change_collge(c1)); } }
    };
     */

    /*
    static Example ex = new Example {
    exampleMethod(Menu_college::add_department, );  // prints "Hello"
    }
     */

}


