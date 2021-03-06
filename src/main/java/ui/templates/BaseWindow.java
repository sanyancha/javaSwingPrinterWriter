package main.java.ui.templates;


import main.java.ui.templates.window.ElementActionListener;
import main.java.ui.templates.window.button.WindowButtonsDefinition;
import main.java.ui.templates.window.label.WindowLabelsDefinition;
import main.java.ui.templates.window.menu.MenuBarDefinition;
import main.java.ui.templates.window.textField.WindowTextFieldsDefinition;

import javax.swing.*;
import javax.swing.event.MenuListener;
import java.awt.*;
import java.util.HashMap;

public class BaseWindow extends  JFrame{
    private JMenuBar jMenuBar;
    JDesktopPane jDesktopPane = new JDesktopPane();

    /*Item definition base window*/
    private MenuBarDefinition menuBarDefinition;
    private WindowButtonsDefinition windowButtonDefinition;
    private WindowLabelsDefinition windowLabelDefinition;
    private WindowTextFieldsDefinition windowTextFieldsDefinition;

    private HashMap<String, JPanel> panelHashMap = new HashMap<String, JPanel>();

    public BaseWindow(int x, int y, int width, int height, int menuHeight) {
        this.setTitle("Base window");
        /*this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);*/
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        this.setSize(width, height);
        this.setPreferredSize(new Dimension(10,10));
        this.setLocation(x, y);

        if (menuHeight != 0) {
            jMenuBar = new JMenuBar();
            jMenuBar.add(Box.createRigidArea(new Dimension(0, menuHeight)));

            menuBarDefinition = new MenuBarDefinition(jMenuBar);
            this.setJMenuBar(jMenuBar);
        }

        /*frame.setLayout(null);*/
        this.setContentPane(jDesktopPane);
        /*jPanel.setDragMode(JDesktopPane.OUTLINE_DRAG_MODE);*/
        this.setVisible(true);


        windowButtonDefinition = new WindowButtonsDefinition(this);
        windowLabelDefinition = new WindowLabelsDefinition(this);
        windowTextFieldsDefinition = new WindowTextFieldsDefinition(this);
    }

    public void updateWindowIcon(String filename){
        try {
            this.setIconImage(Toolkit.getDefaultToolkit().getImage(filename));
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public JFrame getJFrame(){
        return this;
    }

    public JDesktopPane getDesktopPane(){
        return jDesktopPane;
    }

    public BaseWindow(){
        this(0,0,100,100,0);
    }

    public void addButton(String key, String text, int x, int y, int width, int height){
        windowButtonDefinition.add(key, text, x, y,width, height);
    }

    public void addButtonListener(String key, ElementActionListener elementActionListener){
        windowButtonDefinition.addActionListener(key, elementActionListener);
    }

    public void addLabel(String key, String text, int x, int y, int width, int height){
        windowLabelDefinition.add(key, text, x, y,width, height);
    }

    public void addTextField(String key, String text, int x, int y, int width, int height){
        windowTextFieldsDefinition.add(key, text, x, y,width, height);
    }

    public void addTextFieldListener(String key, ElementActionListener elementActionListener){
        windowTextFieldsDefinition.addActionListener(key, elementActionListener);
    }

    public void addTextFieldToolTip(String key, String text){
        windowTextFieldsDefinition.addToolTipText(key, text);
    }

    public void addMenu(String keyMenu, String name){
        menuBarDefinition.addMenu(keyMenu, name);

        //repaint Menu bar
        this.setJMenuBar(jMenuBar);
    }
    public void addInternalFrame(JInternalFrame jInternalFrame){
        jDesktopPane.add(jInternalFrame);

        this.setContentPane(jDesktopPane);
    }
    public void addMenuItem(String keyMenu, String keyItem, String name){
        menuBarDefinition.addMenuItem(keyMenu, keyItem, name);
    }

    public void addSubMenu(String keyMenu, String keySubmenu, String name){
        menuBarDefinition.addSubMenu(keyMenu, keySubmenu, name);
    }

    public void addSubMenuItem(String keyMenu, String keySubmenu, String keySubmenuItem, String name){
        menuBarDefinition.addSubMenuItem(keyMenu, keySubmenu, keySubmenuItem, name);
    }

    public void addMenuListener(String keyMenu, MenuListener menuListener){
        menuBarDefinition.addMenuListener(keyMenu, menuListener);
    }

    public void addMenuItemActionListener(String keyMenu, String keyItem, ElementActionListener elementActionListener){
        menuBarDefinition.addMenuItemActionListener(keyMenu, keyItem, elementActionListener);
    }

    public void addSubMenuListener(String keyMenu, String keySubMenu, MenuListener menuListener){
        menuBarDefinition.addSubMenuListener(keyMenu, keySubMenu, menuListener);
    }

    public void addSubMenuItemActionListener(String keyMenu, String keySubMenu, String keySubMenuItem, ElementActionListener elementActionListener){
        menuBarDefinition.addSubMenuItemActionListener(keyMenu, keySubMenu, keySubMenuItem, elementActionListener);
    }

    @Override
    protected void finalize() throws Throwable
    {
        System.out.println("Garbage collector in action! Deleted one BaseWindow object;");
    }
}