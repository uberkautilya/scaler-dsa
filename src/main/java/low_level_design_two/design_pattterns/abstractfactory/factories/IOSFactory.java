package low_level_design_two.design_pattterns.abstractfactory.factories;

import low_level_design_two.design_pattterns.abstractfactory.buttons.Button;
import low_level_design_two.design_pattterns.abstractfactory.menus.IOSMenu;
import low_level_design_two.design_pattterns.factory.components.dropdowns.Dropdown;
import low_level_design_two.design_pattterns.factory.components.menus.Menu;

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
