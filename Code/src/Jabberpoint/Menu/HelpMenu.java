package Jabberpoint.Menu;

import Jabberpoint.AboutBox;
import Jabberpoint.Presentation;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HelpMenu extends JabberPointMenu
{
    public HelpMenu(Frame parent, Presentation presentation)
    {
        super(parent, presentation);
        this.menu = new Menu("Help");
        addEventListeners();
    }
    @Override
    public void addEventListeners()
    {
        MenuItem menuItem;
        this.menu.add(menuItem = mkMenuItem("About"));
        menuItem.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent actionEvent)
            {
                AboutBox.show(parent);
            }
        });
    }
}
