package low_level_design_two.design_pattterns.creational.factory.abstractfactory.factories;

import low_level_design_two.design_pattterns.creational.factory.abstractfactory.buttons.Button;
import low_level_design_two.design_pattterns.creational.factory.abstractfactory.buttons.IOSButton;
import low_level_design_two.design_pattterns.creational.factory.abstractfactory.dropdowns.Dropdown;
import low_level_design_two.design_pattterns.creational.factory.abstractfactory.dropdowns.IOSDropdown;
import low_level_design_two.design_pattterns.creational.factory.abstractfactory.menus.IOSMenu;
import low_level_design_two.design_pattterns.creational.factory.abstractfactory.menus.Menu;

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
