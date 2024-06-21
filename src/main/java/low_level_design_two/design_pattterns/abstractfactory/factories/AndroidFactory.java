package low_level_design_two.design_pattterns.abstractfactory.factories;

import low_level_design_two.design_pattterns.abstractfactory.buttons.AndroidButton;
import low_level_design_two.design_pattterns.abstractfactory.buttons.Button;
import low_level_design_two.design_pattterns.abstractfactory.dropdowns.AndroidDropdown;
import low_level_design_two.design_pattterns.abstractfactory.dropdowns.Dropdown;
import low_level_design_two.design_pattterns.abstractfactory.menus.AndroidMenu;
import low_level_design_two.design_pattterns.abstractfactory.menus.Menu;

public class AndroidFactory implements Factory {
    @Override
    public Button createButton() {
        return new AndroidButton();
    }

    @Override
    public Dropdown createDropdown() {
        return new AndroidDropdown();
    }

    @Override
    public Menu createMenu() {
        return new AndroidMenu();
    }
}
