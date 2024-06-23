package low_level_design_two.design_pattterns.creational.abstractfactory;

import low_level_design_two.design_pattterns.creational.abstractfactory.buttons.Button;
import low_level_design_two.design_pattterns.creational.abstractfactory.dropdowns.Dropdown;
import low_level_design_two.design_pattterns.creational.abstractfactory.factories.Factory;
import low_level_design_two.design_pattterns.creational.abstractfactory.menus.Menu;

public class Client {
    public static void main(String[] args) {
        Platform platform1 = new Android();
        //Runtime polymorphism
        Factory factory1 = platform1.createComponentFactory();
        Button button1 = factory1.createButton();
        Dropdown dropdown1 = factory1.createDropdown();
        Menu menu1 = factory1.createMenu();

        Platform platform2 = new IOS();
        Factory factory2 = platform2.createComponentFactory();
        Button button2 = factory2.createButton();
        Dropdown dropdown2 = factory2.createDropdown();
        Menu menu2 = factory2.createMenu();
    }
}
