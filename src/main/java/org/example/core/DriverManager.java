package org.example.core;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import org.json.JSONObject;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.URL;
import java.util.Properties;

public class DriverManager {
    private static final ThreadLocal<RemoteWebDriver> driver = new ThreadLocal<>();

    public static RemoteWebDriver getDriver(){return  driver.get();}
    public static void setDriver(RemoteWebDriver driver1){driver.set(driver1);}

    public static void initDriver(String deviceName) throws Exception {
        RemoteWebDriver driverLocal = null;
        Properties props = new PropertyReader().getProperty();
        JSONObject object= new JSONObject(JsonReader.parseit("deviceData.json").getJSONObject(deviceName).toString());
        String PLATFORMNAME = object.getString("platformName");
        DesiredCapabilities caps= new CapabilityManager().getCapabilty();
        if(driverLocal == null){
            try{
                switch (PLATFORMNAME){
                    case "Android":
                        driverLocal = new AndroidDriver<>(new URL("https://"+props.getProperty("USERNAME")+":"+props.getProperty("ACCESSKEY")+"@mobile-hub.lambdatest.com/wd/hub"),caps);
                        break;
                    case "iOS":
                        driverLocal = new IOSDriver<>(new URL("https://"+props.getProperty("USERNAME")+":"+props.getProperty("ACCESSKEY")+"@mobile-hub.lambdatest.com/wd/hub"),caps);
                        break;
                    case "chrome":
                        break;
                }
                if(driverLocal ==null){
                    throw new Exception("Driver is null! Aborting....");
                }
                driver.set(driverLocal);
                Thread.sleep(5000);
            }catch (Exception e){
                e.printStackTrace();
                throw e;
            }
        }
    }
}
