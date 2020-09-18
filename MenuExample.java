import javax.swing.*;
/**
 * Write a description of class MenuExample here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class MenuExample
{
    // instance variables - replace the example below with your own
    JMenu menu, submenu;
    JMenuItem i1, i2, i3, i4, i5;

    /**
     * Constructor for objects of class MenuExample
     */
    public MenuExample()
    {
        JFrame f= new JFrame("Menu and MenuItem Example");
          JMenuBar mb=new JMenuBar();
          menu=new JMenu("Menu");
          submenu=new JMenu("Sub Menu");
          i1=new JMenuItem("Item 1");
          i2=new JMenuItem("Item 2");
          i3=new JMenuItem("Item 3");
          i4=new JMenuItem("Item 4");
          i5=new JMenuItem("Item 5");
          menu.add(i1); menu.add(i2); menu.add(i3);
          submenu.add(i4); submenu.add(i5);
          menu.add(submenu);
          mb.add(menu);
          f.setJMenuBar(mb);
          f.setSize(400,400);
          f.setLayout(null);
          f.setVisible(true);
    }

}
