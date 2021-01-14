package Jabberpoint.Menu;

import Jabberpoint.Presentation;

import java.awt.*;

public abstract class JabberPointMenu
{
    protected Menu menu;
    protected Presentation presentation;
    protected Frame parent;

    public JabberPointMenu(Frame parent, Presentation presentation)
    {
        this.presentation = presentation;
        this.parent = parent;
    }

    public Menu getMenu()
    {
        return menu;
    }

    public void setMenu(Menu menu)
    {
        this.menu = menu;
    }

    public abstract void addEventListeners();

    public MenuItem mkMenuItem(String name)
    {
        return new MenuItem(name, new MenuShortcut(name.charAt(0)));
    }
}
