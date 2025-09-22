package pages;

import io.appium.java_client.MobileBy;
import org.example.core.FwkVariables;
import org.openqa.selenium.By;

public class LoginPage extends BasePage{

    public FwkVariables fwkVariables = new FwkVariables();
    private By UserName;
    private By PassKey;
    private By LoginBtn;

    public LoginPage() {
        if (fwkVariables.getPlatformName().equalsIgnoreCase("Android" )) {


        } else if (fwkVariables.getPlatformName().equalsIgnoreCase("iOS" )) {
            UserName = MobileBy.iOSNsPredicateString("name == 'test-Username'");
            PassKey = MobileBy.iOSNsPredicateString("name == 'test-Password'");
            LoginBtn = MobileBy.iOSNsPredicateString("name == 'test-LOGIN' AND type==\"XCUIElementTypeOther\"");
        }
    }

    public void enterUserText(String userText){
        inpuTextField(UserName,userText);
    }
    public void enterPasskeyText(String passText){
        inpuTextField(PassKey,passText);
    }

    public void clickLoginBtn(){
        click(LoginBtnn);
    }
}
