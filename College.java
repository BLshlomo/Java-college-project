import java.util.Arrays;
import java.util.ArrayList;
import java.util.Iterator;

class College {
  private String clg_name;
  private Department [] all_deps = new Department[0];
  private ArrayList<Lecturer> all_lects = new ArrayList<Lecturer>();
  private ArrayList<Student> all_stns = new ArrayList<Student>();
  private int deps = 0, lects = 0, stns = 0;
  
  protected College() {};
  
  protected College(String name) {
    clg_name = name;
  }
  
  
  protected void set_clg_name(String name) {
    this.clg_name = name;
  }
  
  protected String get_clg_name() {
    return this.clg_name;
  }
  
  protected void add_department(Department dep) {
    all_deps = Arrays.copyOf(all_deps, deps + 2);
    all_deps[deps++] = dep;
    }
  
  protected void add_lect(Lecturer lect) {
    all_lects.add(lect);
    lects++;
  }
  
  protected void add_stn(Student stn) {
    all_stns.add(stn);
    stns++;
  }
  
  protected Department find_dep(String name) {
    int i;
    for (i = 0; i < all_deps.length; i++) {
      if (all_deps[i].getDepName().equals(name))
        return all_deps[i];
    }
    System.out.println("Name not found !");
    return null;
  }
  
  protected Lecturer find_lect(String name) {
    int i;
    for (i = 0; i < all_lects.size(); i++) {
      if (all_lects.get(i).getName().equals(name))
        return all_lects.get(i);
    }
    System.out.println("Name not found !");
    return null;
  }
  
  protected Student find_stn(String name) {
    Student stn;
    Iterator<Student> i = all_stns.iterator();
    while (i.hasNext())
    	if ((stn = i.next()).getName().equals(name))
      		return stn;
    System.out.println("Name not found !");
    return null;
  }
  
  protected void assign_lect_or_stn(Person lect_or_stn, Department dep) {
    int i = -1;
    while (all_deps[++i] != null && all_deps[i] != dep);
    if (all_deps[i] != null) {
      if (lect_or_stn instanceof Lecturer)
        all_deps[i].add_lec((Lecturer)lect_or_stn);
      else all_deps[i].add_stn((Student)lect_or_stn);
    }
  }
  
  protected void assign_lect_or_stn(Person lect_or_stn, String dep_name) {
    int i = -1;
    while (all_deps[++i] != null)
      if (all_deps[i].getDepName().equals(dep_name)) {
        if (lect_or_stn instanceof Lecturer)
        	all_deps[i].add_lec((Lecturer)lect_or_stn);
      	else all_deps[i].add_stn((Student)lect_or_stn);
        return;
      }
    System.out.println("Department name not found");
  }
  
  protected Department biggest_dep_by_stn() {
    int i = 0;
    if (all_deps.length < 0)
      return null;
    int maxStn = all_deps[0].getAmountOfStns();
    Department maxDep = all_deps[0];
    while (all_deps[++i] != null) {
      if (all_deps[i].getAmountOfStns() > maxStn) {
        maxStn = all_deps[i].getAmountOfStns();
        maxDep = all_deps[i];
      }
    }
    return maxDep;
  }
}
