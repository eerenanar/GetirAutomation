package getirAppTests;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class OnboardScreen {
	
	AppiumDriver<MobileElement> driver;

	public OnboardScreen(AppiumDriver<MobileElement> driver) {
		this.driver = driver;
	}

	public int onBoardingScreenContent(){
		List<MobileElement>	content =driver.findElements(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.support.v4.view.ViewPager/android.widget.RelativeLayout/android.widget.LinearLayout/*"));
		return content.size();
	}
	public WebElement onBoardingScreenNextBtn(){
    	WebElement nextBtn =driver.findElement(By.id("com.allandroidprojects.getirsample:id/btn_next"));
        return nextBtn;
    }

    public WebElement onBoardingScreenSkipBtn(){
        WebElement skipBtn =driver.findElement(By.id("com.allandroidprojects.getirsample:id/btn_skip"));
        return skipBtn;
    }

}
