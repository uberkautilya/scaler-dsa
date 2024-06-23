package low_level_design_two.design_pattterns.creational.abstractfactory.factories;

import low_level_design_two.design_pattterns.creational.abstractfactory.buttons.Button;
import low_level_design_two.design_pattterns.creational.abstractfactory.buttons.IOSButton;
import low_level_design_two.design_pattterns.creational.abstractfactory.dropdowns.Dropdown;
import low_level_design_two.design_pattterns.creational.abstractfactory.dropdowns.IOSDropdown;
import low_level_design_two.design_pattterns.creational.abstractfactory.menus.IOSMenu;
import low_level_design_two.design_pattterns.creational.abstractfactory.menus.Menu;

public class IOSFactory implements Factory {
    @Override
    public Button createButton() {
        return new IOSButton();
    }

    @Override
    public Dropdown createDropdown() {
        return new IOSDropdown();
    }

    @Override
    public Menu createMenu() {
        return new IOSMenu();
    }
}
