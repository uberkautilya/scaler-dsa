package low_level_design_two.design_pattterns.creational.factory.abstractfactory.factories;

import low_level_design_two.design_pattterns.creational.factory.abstractfactory.Android;
import low_level_design_two.design_pattterns.creational.factory.abstractfactory.IOS;
import low_level_design_two.design_pattterns.creational.factory.abstractfactory.Platform;

public class PlatformFactory {
    //Uses if-else to create the appropriate type of object - SimpleFactory
    public static Platform createPlatform(String platformName) {
        platformName = (platformName != null) ? platformName.trim().toUpperCase() : "NULL";

        if (platformName.equalsIgnoreCase("android")) {
            return new Android();
        } else if (platformName.equalsIgnoreCase("ios")) {
            return new IOS();
        }
        return null;
    }
}
