package lib.controller.baseWindow.internalWindow.editor.template;

import lib.service.Service;
import lib.service.file.ServiceFile;
import lib.service.internal.editor.template.ServiceInternalTemplateEditor;
import lib.app.Settings;
import lib.ui.screens.PrinterAppBaseWindow;
import lib.ui.screens.internal.PrinterAppInternalTemplateEditorWindow;
import lib.ui.templates.BaseWindow;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ActionInternalEditorTemplateWindowComboBoxFiles implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
        BaseWindow baseWindow = PrinterAppBaseWindow.getInstance().getBaseWindow();

        PrinterAppInternalTemplateEditorWindow printerAppInternalTemplateEditorWindow = PrinterAppInternalTemplateEditorWindow.getInstance(baseWindow);

        Object selectedItem = printerAppInternalTemplateEditorWindow.getFileTemplateChooseComboBox();

        if (selectedItem != null) {
            String filename = (String) selectedItem;

            Integer width = ServiceFile.getWidthFromFilename(filename);
            Integer height = ServiceFile.getHeightFromFilename(filename);
            Integer fillet = ServiceFile.getFilletFromFilename(filename);

            if (width != null && height != null && fillet != null) {
                printerAppInternalTemplateEditorWindow.setWidth(width.toString());
                printerAppInternalTemplateEditorWindow.setHeight(height.toString());
                printerAppInternalTemplateEditorWindow.setFillet(fillet.toString());
            } else {
                printerAppInternalTemplateEditorWindow.setWidth("");
                printerAppInternalTemplateEditorWindow.setHeight("");
                printerAppInternalTemplateEditorWindow.setFillet("");
            }

            ServiceInternalTemplateEditor.getInstance().setDefaultControlTextLabelTemplate();

            boolean enableButton = Service.isAllDataIntNumeric(printerAppInternalTemplateEditorWindow.getTextFieldsValues());

            ServiceInternalTemplateEditor.getInstance().enableComponentsControl(enableButton);

            ServiceInternalTemplateEditor.getInstance().updatePanelImage(Settings.TEMPLATE_FOLDER + selectedItem);
        }
    }
}
