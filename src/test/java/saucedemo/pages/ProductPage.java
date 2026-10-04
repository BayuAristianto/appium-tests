package saucedemo.pages;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;

public class ProductPage extends BasePage {
    public ProductPage(AndroidDriver driver) {
        super(driver);
    }

    @AndroidFindBy(accessibility = "title")
    private WebElement productTitle;

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.saucelabs.mydemoapp.android:id/productIV\").instance(0)")
    private WebElement getProductImage;

    @AndroidFindBy(accessibility = "Tap to add product to cart")
    private WebElement addToCartButton;

    @AndroidFindBy(id = "com.saucelabs.mydemoapp.android:id/cartIV")
    private WebElement getNumberOfItemsInCart;

    @AndroidFindBy(id = "com.saucelabs.mydemoapp.android:id/titleTV")
    private WebElement productTitleBackpack;

    @AndroidFindBy(id = "com.saucelabs.mydemoapp.android:id/noTV")
    private WebElement productBackpackSum;

    public String getTitle() {
        return productTitle.getText();
    }

    public void checkoutProduct() {
        getProductImage.click();
        addToCartButton.click();
        getNumberOfItemsInCart.click();
    }
    public String productTitleBackpack() {
        return productTitleBackpack.getText();
    }

    public String getBackpackSum() {
        return productBackpackSum.getText();
    }
}
