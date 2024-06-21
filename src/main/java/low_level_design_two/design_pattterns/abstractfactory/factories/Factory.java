package low_level_design_two.design_pattterns.abstractfactory.factories;


import low_level_design_two.design_pattterns.abstractfactory.buttons.Button;
import low_level_design_two.design_pattterns.abstractfactory.dropdowns.Dropdown;
import low_level_design_two.design_pattterns.abstractfactory.menus.Menu;

public interface Factory {
    Button createButton();
    Dropdown createDropdown();
    Menu createMenu();
}
