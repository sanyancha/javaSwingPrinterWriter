package main.java.ui.templates.window.menu;

import javax.swing.*;
import javax.swing.event.MenuListener;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.HashMap;

public class MenuDefinition {
    private JMenu jMenu;

    private HashMap<String, JMenuItem> menuItems = new HashMap<String, JMenuItem>();
    private HashMap<String, SubMenuDefinition> subMenus = new HashMap<String, SubMenuDefinition>();

    public MenuDefinition(JMenu jMenu){
        this.jMenu = jMenu;
    }

    public void addSubMenu(String key, String name){
        JMenu submenu = new JMenu(name);
        SubMenuDefinition subMenusDefinition = new SubMenuDefinition(submenu);

        jMenu.add(submenu);
        subMenus.put(key, subMenusDefinition);
    }

    public void addSubMenuItem(String keySubmenu, String keySubmenuItem, String name){
        SubMenuDefinition subMenuDefinition = subMenus.get(keySubmenu);
        subMenuDefinition.addSubMenuItem(keySubmenuItem, name);
    }

    public void addMenuItem(String key, String name, int width, int height){
        JMenuItem jMenuItem = new JMenuItem(name);

        jMenuItem.setMaximumSize(new Dimension(width, height));
        jMenuItem.setMinimumSize(new Dimension(width, height));
        jMenuItem.setPreferredSize(new Dimension(width, height));
        jMenuItem.setHorizontalAlignment(SwingConstants.RIGHT);

        jMenu.add(jMenuItem);
        menuItems.put(key, jMenuItem);
    }

    public void addMenuListener(MenuListener menuListener){
        jMenu.addMenuListener(menuListener);
    }

    public void addMenuItemActionListener(String keyItem, ActionListener actionListener){
        JMenuItem jMenuItem = menuItems.get(keyItem);

        jMenuItem.addActionListener(actionListener);
    }

    public void addSubMenuListener(String keySubmenu, MenuListener menuListener){
        SubMenuDefinition submenuDefinition = subMenus.get(keySubmenu);

        submenuDefinition.addSubMenuListener(menuListener);
    }

    public void addSubMenuItemActionListener(String keySubMenu, String keySubMenuItem,  ActionListener actionListener){
        SubMenuDefinition subMenuDefinition = subMenus.get(keySubMenu);

        subMenuDefinition.addSubMenuItemActionListener(keySubMenuItem, actionListener);
    }
}
