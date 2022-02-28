package pages.android;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Wait;
import utilities.Driver;

import java.time.Duration;

public class ForeksPages {
    public ForeksPages(){
        PageFactory.initElements(new AppiumFieldDecorator(Driver.getAppiumDriver(), Duration.ofSeconds(15)),this);
    }

    @AndroidFindBy(id = "foreks.android:id/layoutMainTab_linearLayout_varantTab")
    public MobileElement varantTab;

    @AndroidFindBy(id = "foreks.android:id/activityYouTube_youTubePlayerView")
    public WebElement youtubeReklam;

    @AndroidFindBy(id = "foreks.android:id/activityTutorial_textView_close")
    public MobileElement yanMenuReklamExit;
    @AndroidFindBy(xpath = "\t\n" +
            "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.FrameLayout/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View[1]/android.view.View/android.view.View[2]/android.view.View")
    public MobileElement reklamExit;

    @AndroidFindBy (id="foreks.android:id/screenWarrantMain_linearLayout_alternativeWarrantList")
    public MobileElement yukselenlerDusenler;

    @AndroidFindBy(id = "foreks.android:id/rowWarrantSymbolList_textView_column3")
    public MobileElement yukselenlerRow;

    @AndroidFindBy(xpath = "//android.widget.TextView[@content-desc=\"DÜŞENLER\"]")
    public MobileElement dusenlerTab;
}
