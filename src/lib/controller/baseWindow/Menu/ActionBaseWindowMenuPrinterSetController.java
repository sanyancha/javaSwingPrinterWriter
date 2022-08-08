package lib.controller.baseWindow.Menu;

import lib.service.internal.editor.ServiceInternalEditor;
import lib.ui.screens.PrinterAppBaseWindow;
import lib.ui.screens.internal.print.PrinterAppInternalPrintTemplateWindow;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ActionBaseWindowMenuPrinterSetController implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        JMenuItem menuItem = (JMenuItem) e.getSource();

        PrinterAppBaseWindow printerAppBaseWindow = PrinterAppBaseWindow.getInstance();

        printerAppBaseWindow.setStatusPrinterName(menuItem.getText());

        if (PrinterAppInternalPrintTemplateWindow.isExistInstance()) {
            PrinterAppInternalPrintTemplateWindow printerAppInternalPrintTemplateWindow = PrinterAppInternalPrintTemplateWindow.getInstance(printerAppBaseWindow.getBaseWindow());

            boolean enableTextControl = ServiceInternalEditor.isEnableComponentTextControl();

            printerAppInternalPrintTemplateWindow.setPrintButtonEnable(enableTextControl && PrinterAppBaseWindow.getInstance().getSelectedPrinter() != null);
        }
    }
}
