package utilities;

import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.offset.ElementOption;

import java.util.HashMap;
import java.util.List;

public class ReusableMethods {

      public static void clickOnPage(String pageName) throws InterruptedException {
          Thread.sleep(4000);
          List<MobileElement> pages = Driver.getAppiumDriver().findElementsByClassName("android.widget.TextView");
          for (MobileElement page: pages) {
              if (page.getText().equals(pageName)){
                  page.click();
                  break;
              }else{
                  scrollWithUiScrollable(pageName);
                  break;
              }
          }
      }



    public static void clickOnPage1(String pageName) throws InterruptedException {
        Thread.sleep(4000);
        List<MobileElement> pages = Driver.getAppiumDriver().findElementsByXPath("//android.widget.TextView[@text='"+pageName+"']");
        if (pages.size()>0){
            pages.get(0).click();
        }else scrollWithUiScrollable(pageName);
    }
    public static void waitSeconds(int seconds) {
        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


      public static void scrollWithUiScrollable(String elementText){
          AndroidDriver  driver = (AndroidDriver) Driver.getAppiumDriver();
          driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\""+elementText+"\"))");
          driver.findElementByXPath("//*[@text='"+elementText+"']").click();
      }

      public static void longPressOnElement(MobileElement mobileElement){
          TouchAction touchAction = new TouchAction(Driver.getAppiumDriver());
          touchAction.longPress(ElementOption.element(mobileElement)).release().perform();
      }

}
