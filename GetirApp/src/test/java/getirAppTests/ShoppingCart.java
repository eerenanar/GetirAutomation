package getirAppTests;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class ShoppingCart {
	AppiumDriver<MobileElement> driver;
	public ShoppingCart(AppiumDriver<MobileElement> driver) {
		this.driver = driver;
	}
    public int removeShoppingCart(){
        List<MobileElement> shoppingCartList =driver.findElements(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[2]/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.support.v7.widget.RecyclerView/*"));
        for(int i=0;i<shoppingCartList.size();i++){
            WebElement removeBtn =driver.findElement(By.xpath("//android.view.ViewGroup/android.widget.FrameLayout[2]/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.support.v7.widget.RecyclerView//android.widget.LinearLayout[2]/android.widget.LinearLayout[1]"));
            removeBtn.click();
        }
        return shoppingCartList.size();
    }
    public int shoppingCartSize(){
        List<MobileElement> shoppingElement =driver.findElements(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[2]/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.support.v7.widget.RecyclerView/*"));
        return shoppingElement.size();
    }
    public WebElement totalPriceOnBasket(){
        WebElement totalPrice =driver.findElement(By.id("com.allandroidprojects.getirsample:id/text_action_bottom1"));
        return totalPrice;
    }

}
