package test.java;

import lib.ui.templates.InternalWindow;
import lib.ui.templates.BaseWindow;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class TestInternalWindow {
    public static void main(String[] args) {
       /* HomeController mn = HomeController.getInstance();*/

        internalWindowClearMemory();
    }

    public static void internalWindowWithSplitAndScroll(){
        BaseWindow baseWindow = new BaseWindow("TestBaseWindow", 200,0,500,500, 25);

        InternalWindow internalWindow = new InternalWindow(baseWindow, "Internal1", 0,0,200,200);
        internalWindow.addLabel("Pane1","MyFirstLabel","Label11", 10,10,100,10);
        internalWindow.addLabel("Pane1","MyFirstLabel2","Label12", 10,20,100,10);
        internalWindow.addLabel("Pane2","MyFirstLabel3","Label13", 10,30,100,10);
        internalWindow.addButton("Pane1", "MyFirstButton","1", 0,100,100,100);
        internalWindow.addSplitPain(SwingConstants.VERTICAL, "Pane2", "Pane1", 100);
        internalWindow.addScrolPaneOneComponent( "ScrolPane1", "Pane1", false);

        internalWindow.addTextField("Pane2", "MyFirstTextField","1", 100,200,100,100);
        internalWindow.addSplitPain(SwingConstants.HORIZONTAL, "Pane1", "Pane3", 50);
       /* internalWindow.addButtonListener("MyFirstButton", new MyFirstButtonActionController());
        internalWindow.addTextFieldListener("MyFirstTextField", new MyFirstTextFieldActionController());
     */   internalWindow.addLabel("Pane2","MyFirstLabel4","Label14", 10,20,100,100);

        internalWindow.saveComponentAsImage("Pane2", "bmp");

        InternalWindow internalWindow2 = new InternalWindow(baseWindow, "Internal2", 10,10,200,200);
        internalWindow2.addLabel("Pane1","MyFirstLabel","Label21", 10,10,100,10);
        internalWindow2.addLabel("Pane1","MyFirstLabel2","Label22", 10,20,100,10);
        internalWindow2.addLabel("Pane1","MyFirstLabel3","Label23", 10,30,100,10);
        internalWindow2.addScrolPaneOneComponent( "ScrolPane1", "Pane1", false);

        internalWindow2 = new InternalWindow(baseWindow, "Internal2", 10,10,200,200);
        internalWindow2.addLabel("Pane1","MyFirstLabel","Label21", 10,10,100,10);
        internalWindow2.addLabel("Pane1","MyFirstLabel2","Label22", 10,20,100,10);
        internalWindow2.addLabel("Pane1","MyFirstLabel3","Label23", 10,30,100,10);
        internalWindow2.addScrolPaneOneComponent( "ScrolPane1", "Pane1", false);

        internalWindow2 = new InternalWindow(baseWindow, "Internal2", 10,10,200,200);
        internalWindow2.addLabel("Pane1","MyFirstLabel","Label21", 10,10,100,10);
        internalWindow2.addLabel("Pane1","MyFirstLabel2","Label22", 10,20,100,10);
        internalWindow2.addLabel("Pane1","MyFirstLabel3","Label23", 10,30,100,10);
        internalWindow2.addScrolPaneOneComponent( "ScrolPane1", "Pane1", false);

        internalWindow2 = new InternalWindow(baseWindow, "Internal2", 10,10,200,200);
        internalWindow2.addLabel("Pane1","MyFirstLabel","Label21", 10,10,100,10);
        internalWindow2.addLabel("Pane1","MyFirstLabel2","Label22", 10,20,100,10);
        internalWindow2.addLabel("Pane1","MyFirstLabel3","Label23", 10,30,100,10);
        internalWindow2.addScrolPaneOneComponent( "ScrolPane1", "Pane1", false);

        /*internalWindow = null;
        internalWindow2 = null;*/

        internalWindow.repaint();
        baseWindow.repaint();
    }

    public static void addScrollPane(){
        BaseWindow baseWindow = new BaseWindow("TestBaseWindow",200,0,500,500, 25);
        InternalWindow internalWindow = new InternalWindow(baseWindow, "Internal1*", 0,0,200,200);
        internalWindow.addLabel("Pane1","MyFirstLabel","Label11__________________________________________________________________" +
                "_____________________________________________________________" +
                "_____________________________________________________________", 10,20,500,50);
        internalWindow.addLabel("Pane1","MyFirstLabel2","Label12", 10,10,500,50);
        internalWindow.addLabel("Pane1","MyFirstLabel3","Label13", 10,30,500,50);

        internalWindow.addScrolPaneOneComponent( "ScrolPane1", "Pane1", false);
        internalWindow.addLabel("Pane2","MyFirstLabel3","Label13", 10,30,100,10);
        internalWindow.addSplitPain(SwingConstants.VERTICAL, "Pane2", "Pane1", 100);

        /*internalWindow.repaint();
        baseWindow.repaint();*/
    }

    public static void internalWindowAddImageWithScaleTest(){
        BaseWindow baseWindow = new BaseWindow("TestBaseWindow",0,0,500,500, 25);
        baseWindow.updateWindowIcon("src/main/resources/img/myimage.png");
        baseWindow.addLabel("Pane2","MyFirstLabel3", 10,30,100,10);

        InternalWindow internalWindow = new InternalWindow(baseWindow, "Internal1*", 0,0,500,500);
        internalWindow.addButton("Pane2","MyFirstLabel3","Label13", 10,30,100,10);
        internalWindow.addLabelAsImage("Pane1","MyFirstLabel","smile.jpg", 0,10,100,100);
        internalWindow.addSplitPain(SwingConstants.VERTICAL, "Pane2", "Pane1", 100);
        internalWindow.addScrolPaneOneComponent( "ScrolPane1", "Pane1", true);
    }

    public static void internalWindowClearMemory(){
        BaseWindow baseWindow = new BaseWindow("TestBaseWindow",0,0,500,500, 25);
        baseWindow.updateWindowIcon("src/main/resources/img/myimage.png");
        baseWindow.addLabel("Pane2","MyFirstLabel3", 10,30,100,10);

        InternalWindow internalWindow = new InternalWindow(baseWindow, "Internal1*", 0,0,500,500);
        internalWindow.addButton("Pane2","MyFirstLabel3","Label13", 10,30,100,10);
        internalWindow.addLabelAsImage("Pane1","MyFirstLabel","src/main/resources/editor/img/printer__.png", 0,10,100,100);
        internalWindow.addSplitPain(SwingConstants.VERTICAL, "Pane2", "Pane1", 100);
        internalWindow.addScrolPaneOneComponent( "ScrolPane1", "Pane1", true);

        internalWindow.updateLabelImage("ScrolPane1", "MyFirstLabel","snapshot.bmp");

        internalWindow.updateLabelImage("ScrolPane1", "MyFirstLabel","smile.jpg");
        internalWindow.updateLabelImage("ScrolPane1", "MyFirstLabel","smile.jpg");
        internalWindow.updateLabelImage("ScrolPane1", "MyFirstLabel","smile.jpg");
        internalWindow.updateLabelImage("ScrolPane1", "MyFirstLabel","smile.jpg");
        internalWindow.updateLabelImage("ScrolPane1", "MyFirstLabel","smile.jpg");
        internalWindow.updateLabelImage("ScrolPane1", "MyFirstLabel","snapshot.bmp");


        TestGC test = new TestGC();
        test = null;

        System.gc();
    }

    public static void internalWindowComboBox(){
        BaseWindow baseWindow = new BaseWindow("TestBaseWindow",0,0,500,500, 25);
        baseWindow.updateWindowIcon("src/main/resources/img/myimage.png");
        baseWindow.addLabel("Pane2","MyFirstLabel3", 10,30,100,10);

        final InternalWindow internalWindow = new InternalWindow(baseWindow, "Internal1*", 0,0,500,500);
        internalWindow.addButton("Pane2","MyFirstLabel3","Label13", 10,30,100,10);
        internalWindow.addComboBox("Pane2","MyFirstComboBox1", null, 10,50,100,20);
        internalWindow.addComboBoxItem("MyFirstComboBox1", "Hello");
        internalWindow.addComboBoxItem("MyFirstComboBox1", "Hello2");
        internalWindow.addComboBoxItem("MyFirstComboBox1", "Hello3");

        internalWindow.addComboBoxActionListener("MyFirstComboBox1", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println(internalWindow.getComboBoxSelectedItem("MyFirstComboBox1"));
            }
        });


        internalWindow.addLabelAsImage("Pane1","MyFirstLabel","smile.jpg", 0,10,100,100);
        internalWindow.addSplitPain(SwingConstants.VERTICAL, "Pane2", "Pane1", 100);
        internalWindow.addScrolPaneOneComponent( "ScrolPane1", "Pane1", true);
    }
}
