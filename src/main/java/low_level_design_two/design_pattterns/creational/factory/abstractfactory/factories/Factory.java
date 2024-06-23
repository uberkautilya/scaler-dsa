package low_level_design_two.design_pattterns.creational.factory.abstractfactory.factories;


import low_level_design_two.design_pattterns.creational.factory.abstractfactory.buttons.Button;
import low_level_design_two.design_pattterns.creational.factory.abstractfactory.dropdowns.Dropdown;
import low_level_design_two.design_pattterns.creational.factory.abstractfactory.menus.Menu;

public interface Factory {
    Button createButton();
    Dropdown createDropdown();
    Menu createMenu();
}
