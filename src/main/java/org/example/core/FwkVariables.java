package org.example.core;

import org.json.JSONObject;

public class FwkVariables {

    private static ThreadLocal<String> platformName = new ThreadLocal<>();
    private static ThreadLocal<String> deviceName = new ThreadLocal<>();
    private static ThreadLocal<String> platformVersion= new ThreadLocal<>();
    private static ThreadLocal<String> isRealMobile = new ThreadLocal<>();
    private static ThreadLocal<String> app = new ThreadLocal<>();


    public String getPlatformName() {
        return platformName.get();
    }

    public  void setPlatformName(String platformName1) {
        platformName.set(platformName1);
    }

    public String getDeviceName() {
        return deviceName.get();
    }

    public  void setDeviceName(String deviceName1) {
        deviceName.set(deviceName1);
    }

    public String getPlatformVersion() {
        return platformVersion.get();
    }

    public  void setPlatformVersion(String platformVersion1) {
        platformVersion.set(platformVersion1);
    }

    public String getisRealMobile() {
        return isRealMobile.get();
    }

    public  void setIsRealMobile(String isRealMobile1) {
        isRealMobile.set(isRealMobile1);
    }

    public String getApp() {
        return app.get();
    }

    public  void setApp(String app1) {
        app.set(app1);
    }

    public void initFwkVariable(String deviceName){
        FwkVariables fwkVariables = new FwkVariables();
        JSONObject object= new JSONObject(JsonReader.parseit("deviceData.json").getJSONObject(deviceName).toString());

        fwkVariables.setDeviceName(object.getString("deviceName"));
        fwkVariables.setApp(object.getString("app"));
        fwkVariables.setPlatformVersion(object.getString("platfromVersion"));
        fwkVariables.setPlatformName(object.getString("platformName"));
    }

}
