package getirAppTests;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;


import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class Whislist {
	AppiumDriver<MobileElement> driver;
	public Whislist(AppiumDriver<MobileElement> driver) {
		this.driver = driver;
	}
    public int removeWhishList(){
        List<MobileElement> whislistList =driver.findElements(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[2]/android.support.v7.widget.RecyclerView/*"));
        for(int i=0;i<whislistList.size();i++){
            WebElement removeBtn =driver.findElement(By.xpath("//android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[2]/android.support.v7.widget.RecyclerView/android.widget.LinearLayout[1]/android.widget.LinearLayout/android.widget.ImageView[2]"));
            removeBtn.click();
        }
        return whislistList.size();
    }
    public int whislistSize(){
        List<MobileElement> whislistElement =driver.findElements(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[2]/android.support.v7.widget.RecyclerView/*"));
        return whislistElement.size();
    }

}
