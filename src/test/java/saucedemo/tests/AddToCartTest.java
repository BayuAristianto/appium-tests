package saucedemo.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import saucedemo.core.BaseTest;
import saucedemo.core.DriverManager;
import saucedemo.pages.GlobalPage;
import saucedemo.pages.LoginPage;
import saucedemo.pages.ProductPage;

public class AddToCartTest extends BaseTest {
    @Test
    public void testSuccessAddToCart() {
        GlobalPage globalPage = new GlobalPage(DriverManager.getDriver());
        LoginPage loginPage = new LoginPage(DriverManager.getDriver());
        ProductPage productPage = new ProductPage(DriverManager.getDriver());

        // Steps
        globalPage.clickHamburgerMenu();
        globalPage.clickLoginMenu();

        loginPage.inputUsername("bod@example.com");
        loginPage.inputPassword("10203040");
        loginPage.clickLoginButton();

        String productPageTitle = productPage.getTitle();
        Assert.assertEquals(productPageTitle, "Products");

        productPage.checkoutProduct();

        String titleProductBackpack = productPage.productTitleBackpack();
        System.out.println("Nama Produk : "  + titleProductBackpack);
        Assert.assertEquals(titleProductBackpack, "Sauce Labs Backpack");

        String jumlahProduct = productPage.getBackpackSum();
        System.out.println("Jumlah Product : "  + jumlahProduct);
        Assert.assertEquals(jumlahProduct, "1");
    }

}
