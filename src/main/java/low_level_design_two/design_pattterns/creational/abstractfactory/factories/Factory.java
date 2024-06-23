package low_level_design_two.design_pattterns.creational.abstractfactory.factories;


import low_level_design_two.design_pattterns.creational.abstractfactory.buttons.Button;
import low_level_design_two.design_pattterns.creational.abstractfactory.dropdowns.Dropdown;
import low_level_design_two.design_pattterns.creational.abstractfactory.menus.Menu;

public interface Factory {
    Button createButton();
    Dropdown createDropdown();
    Menu createMenu();
}
