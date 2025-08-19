package org.example.core;

import org.openqa.selenium.remote.DesiredCapabilities;

public class CapabilityManager {

    public DesiredCapabilities getCapabilty(){
        FwkVariables fwkVariables = new FwkVariables();
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName",fwkVariables.getPlatformName());
        capabilities.setCapability("deviceName",fwkVariables.getDeviceName());
        capabilities.setCapability("platformVersion",fwkVariables.getPlatformVersion());
        capabilities.setCapability("isRealMobile",true);
        capabilities.setCapability("app",fwkVariables.getApp());
        return capabilities;
    }
}
