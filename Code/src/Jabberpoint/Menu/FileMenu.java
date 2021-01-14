package Jabberpoint.Menu;
import Jabberpoint.Accessor;
import Jabberpoint.Presentation;
import Jabberpoint.XMLAccessor;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class FileMenu extends JabberPointMenu
{
    public FileMenu(Frame parent, Presentation presentation)
    {
        super(parent, presentation);
        this.menu = new Menu("File");
        addEventListeners();
    }

    @Override
    public void addEventListeners()
    {
        MenuItem menuItem;
        this.menu.add(menuItem = mkMenuItem("Open"));
        menuItem.addActionListener(actionEvent ->
        {
            presentation.clear();
            Accessor xmlAccessor = new XMLAccessor();
            try {
                xmlAccessor.loadFile(presentation, "testPresentation.xml");
                presentation.setSlideNumber(0);
            } catch (IOException exc) {
                JOptionPane.showMessageDialog(parent, "IO Exception: " + exc,
                        "Load error", JOptionPane.ERROR_MESSAGE);
            }
            parent.repaint();
        });
        this.menu.add(menuItem = mkMenuItem("New"));
        menuItem.addActionListener(actionEvent ->
        {
            presentation.clear();
            parent.repaint();
        });
        this.menu.add(menuItem = mkMenuItem("Save"));
        menuItem.addActionListener(e ->
        {
            Accessor xmlAccessor = new XMLAccessor();
            try {
                xmlAccessor.saveFile(presentation, "savedPresentation.xml");
            } catch (IOException exc) {
                JOptionPane.showMessageDialog(parent, "IO Exception: " + exc,
                        "Save Error", JOptionPane.ERROR_MESSAGE);
            }
        });
        this.menu.addSeparator();
        this.menu.add(menuItem = mkMenuItem("Exit"));
        menuItem.addActionListener(actionEvent -> presentation.exit(0));
    }
}
