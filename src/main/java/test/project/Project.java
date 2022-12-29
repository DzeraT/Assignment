package test.project;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import test.base.TestBase;
import test.utilities.Login_Utilities;

public class Project extends TestBase {

    @Test
    public  void test() {


        //Logs into https://www.saucedemo.com
        driver.get("https://www.saucedemo.com");

        //logIn functionalities using Username and Password

        //Calling my utility method to login,in this case we will be able to write different usernames and password and will be able to log in
        Login_Utilities.login_util(driver,"standard_user","secret_sauce");

        //Adds this product to cart: “Sauce Labs Fleece Jacket”
        WebElement addingProduct = driver.findElement(By.xpath("//button[@id='add-to-cart-sauce-labs-fleece-jacket']"));
        addingProduct.click();
//clicking on cart
        WebElement cart = driver.findElement(By.xpath("//span[.='1']"));
        cart.click();
//correct item was added

        WebElement correctItem = driver.findElement(By.xpath("//div[.='Sauce Labs Fleece Jacket']"));
        Assert.assertEquals(correctItem.getText(), "Sauce Labs Fleece Jacket", "This message will be shown in case there is something wrong with syntax");
        //cost is $49.99

        WebElement   cost = driver.findElement(By.xpath("//div[@class='inventory_item_price']"));
        Assert.assertEquals(cost.getText(),"$49.99","This message will be shown in case there is something wrong with syntax");
//checkout Button
        WebElement checkoutBtn=driver.findElement(By.xpath("//button[@id='checkout']"));
        checkoutBtn.click();
        //First Name,Last Name,Zip Code and Clicking on Continue Button

        WebElement firstName =driver.findElement(By.xpath("//input[@id='first-name']"));
        firstName.sendKeys("Dzera");
        WebElement lastName =driver.findElement(By.xpath("//input[@id='last-name']"));
        lastName.sendKeys("Temiraeva");
        WebElement zipcode =driver.findElement(By.xpath("//input[@id='postal-code']"));
        zipcode.sendKeys("11103");
        WebElement continueBtn=driver.findElement(By.xpath("//input[@id='continue']"));
        continueBtn.click();

        //Tax $4.00
        WebElement tax = driver.findElement(By.xpath("//div[@class='summary_tax_label']"));
        Assert.assertEquals(tax.getText(),"Tax: $4.00","This message will be shown in case there is something wrong with syntax");
        //Total: $53.99

        WebElement total =driver.findElement(By.xpath("//div[@class='summary_total_label']"));
        Assert.assertEquals(total.getText(),"Total: $53.99","This message will be shown in case there is something wrong with syntax");

//Click “Finish” and verify the confirmation page has the correct copy:
//“THANK YOU FOR YOUR ORDER
//Your order has been dispatched, and will arrive just as fast as the pony can get there!”

        WebElement finishBtn=driver.findElement(By.xpath("//button[.='Finish']"));
        finishBtn.click();

        WebElement thankYouForYourOrder = driver.findElement(By.xpath("//h2[.='THANK YOU FOR YOUR ORDER']"));
        Assert.assertEquals(thankYouForYourOrder.getText(),"THANK YOU FOR YOUR ORDER","This message will be shown in case there is something wrong with syntax");
        WebElement orderHasBeenDispatched = driver.findElement(By.xpath("//div[@class='complete-text']"));
        Assert.assertEquals(orderHasBeenDispatched.getText(),"Your order has been dispatched, and will arrive just as fast as the pony can get there!","This message will be shown in case there is something wrong with syntax");


    }





}

