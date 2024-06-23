package low_level_design_two.design_pattterns.creational.abstractfactory.factories;

import low_level_design_two.design_pattterns.creational.abstractfactory.buttons.Button;
import low_level_design_two.design_pattterns.creational.abstractfactory.menus.IOSMenu;
import low_level_design_two.design_pattterns.creational.factory.components.dropdowns.Dropdown;
import low_level_design_two.design_pattterns.creational.factory.components.menus.Menu;

public class IOSFactory implements Factory {
    @Override
    public Button createButton() {
        return new IOS;
    }

    @Override
    public Dropdown createDropdown() {
        return new IOSMenu();
    }

    @Override
    public Menu createMenu() {
        return new IOSMenu();
    }
}
