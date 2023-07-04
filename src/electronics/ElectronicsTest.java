package electronics;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.Utility;

public class ElectronicsTest extends Utility
{
    String baseurl = "https://demo.nopcommerce.com/";
    String s1,expectedText,actualText;
    @Before
    public void setUp()
    {
        openBrowser(baseurl);
    }

    @Test
    public void verifyUserShouldNavigateToCellPhonesPageSuccessfully()
    {
        //Mouse Hover on “Electronics” Tab
        WebElement electronics = driver.findElement(By.xpath("//ul[@class='top-menu notmobile']//a[normalize-space()='Electronics']"));
        Actions action = new Actions(driver);
        action.moveToElement(electronics).build().perform();

        //Mouse Hover on “Cell phones” and click
        WebElement cellphone = driver.findElement(By.xpath("//ul[@class='top-menu notmobile']//a[normalize-space()='Cell phones']"));
        Actions action1 = new Actions(driver);
        action1.moveToElement(electronics).build().perform();
        action1.moveToElement(cellphone).click().build().perform();
        //clickOnElement(By.xpath("//ul[@class='top-menu notmobile']//a[normalize-space()='Cell phones']"));

        //Verify the text “Cell phones”
        actualText=getTextFromElement(By.xpath("//h1[normalize-space()='Cell phones']"));
        expectedText="Cell phones";
        Assert.assertEquals("Not Matched",expectedText,actualText);
    }

    @Test
    public void verifyThatTheProductAddedSuccessfullyAndPlaceOrderSuccessfully() throws InterruptedException
    {
        //Mouse Hover on “Electronics” Tab
        WebElement electronics = driver.findElement(By.xpath("//ul[@class='top-menu notmobile']//a[normalize-space()='Electronics']"));
        Actions action = new Actions(driver);
        action.moveToElement(electronics).build().perform();



        //Mouse Hover on “Cell phones” and click
        WebElement cellphone = driver.findElement(By.xpath("//ul[@class='top-menu notmobile']//a[normalize-space()='Cell phones']"));
        Actions action1 = new Actions(driver);
        action1.moveToElement(electronics).build().perform();
        action1.moveToElement(cellphone).click().build().perform();

        //Verify the text “Cell phones”
        actualText=getTextFromElement(By.xpath("//h1[normalize-space()='Cell phones']"));
        expectedText="Cell phones";
        Assert.assertEquals("Not Matched",expectedText,actualText);

        //Click on List View Tab
        clickOnElement(By.xpath("//a[@title='List']"));

        Thread.sleep(1000);
        //Click on product name “Nokia Lumia 1020” link
        clickOnElement(By.xpath("//body/div[6]/div[3]/div[1]/div[3]/div[1]/div[2]/div[2]/div[2]/div[1]/div[1]/div[3]/div[1]/div[2]/h2[1]/a[1]"));

        //Verify the text “Nokia Lumia 1020”
        actualText=getTextFromElement(By.xpath("//h1[normalize-space()='Nokia Lumia 1020']"));
        expectedText="Nokia Lumia 1020";
        Assert.assertEquals("Not Matched Nokia Lumia 1020",expectedText,actualText);

        //Verify the price “$349.00"
        actualText=getTextFromElement(By.xpath("//span[@id='price-value-20']"));
        expectedText="$349.00";
        Assert.assertEquals("Not Matched Prise",expectedText,actualText);

        Thread.sleep(1000);
        //Change quantity to 2
        driver.findElement(By.xpath("//input[@id='product_enteredQuantity_20']")).clear();
        driver.findElement(By.xpath("//input[@id='product_enteredQuantity_20']")).sendKeys("2");

        //Click on “ADD TO CART” tab
        clickOnElement(By.xpath("//button[@id='add-to-cart-button-20']"));

        //Verify the Message "The product has been added to your shopping cart" on Top
        //green Bar

        actualText=getTextFromElement(By.xpath("//p[@class='content']"));
        expectedText="The product has been added to your shopping cart";
        Assert.assertEquals("Text Not Matched",expectedText,actualText);
        clickOnElement(By.xpath("//span[@title='Close']"));

        Thread.sleep(1000);
        //Then MouseHover on "Shopping cart" and Click on "GO TO CART" button
        WebElement shopingcart = driver.findElement(By.xpath("//span[@class='cart-label']"));
        Actions action2 = new Actions(driver);
        action2.moveToElement(shopingcart).build().perform();
        WebElement addcart=driver.findElement(By.xpath("//button[normalize-space()='Go to cart']"));
        Actions action3 = new Actions(driver);
        action3.moveToElement(addcart).click();

        clickOnElement(By.xpath("//button[normalize-space()='Go to cart']"));

        //Verify the message "Shopping cart
        actualText=getTextFromElement(By.xpath("//h1[contains(text(),'Shopping cart')]"));
        expectedText="Shopping cart";
        Assert.assertEquals("Text Not Matched",expectedText,actualText);

        //Verify the quantity is 2
//        driver.findElement(By.xpath("//input[@class='qty-input']")).clear();
//        driver.findElement(By.xpath("//input[@class='qty-input']")).sendKeys("2");
//        clickOnElement(By.xpath("//button[@id='updatecart']"));
//        actualText=getTextFromElement(By.xpath("//input[@id='itemquantity11227']"));
//        expectedText="2";
//        Assert.assertEquals("Not Matched ",expectedText,actualText);



        //Verify the Total $698.00
        actualText=getTextFromElement(By.xpath("//span[@class='product-subtotal']"));
        expectedText="$698.00";
        Assert.assertEquals("Not Matched any text",expectedText,actualText);

        //click on checkbox “I agree with the terms of service”
        clickOnElement(By.xpath("//input[@id='termsofservice']"));

        //Click on “CHECKOUT”
        clickOnElement(By.xpath("//button[@id='checkout']"));

        //Verify the Text “Welcome, Please Sign In!”
        actualText=getTextFromElement(By.xpath("//h1[normalize-space()='Welcome, Please Sign In!']"));
        expectedText="Welcome, Please Sign In!";
        Assert.assertEquals("Text Not Matched",expectedText,actualText);

        //Click on “REGISTER” tab
        clickOnElement(By.xpath("//button[normalize-space()='Register']"));

        //Verify the text “Register”
        actualText=getTextFromElement(By.xpath("//h1[normalize-space()='Register']"));
        expectedText="Register";
        Assert.assertEquals("Not Matched any Text",expectedText,actualText);

        //Fill the mandatory fields
        driver.findElement(By.xpath("//input[@id='FirstName']")).sendKeys("Vicky");
        driver.findElement(By.xpath("//input[@id='LastName']")).sendKeys("Patel");
        driver.findElement(By.xpath("//input[@id='Email']")).sendKeys("vicky.shah79281@yahoo.com");
        driver.findElement(By.xpath("//input[@id='Password']")).sendKeys("abc@1234");
        driver.findElement(By.xpath("//input[@id='ConfirmPassword']")).sendKeys("abc@1234");

        //Click on “REGISTER” Button
        clickOnElement(By.xpath("//button[@id='register-button']"));

        //Verify the message “Your registration completed”
        actualText=getTextFromElement(By.xpath("//div[@class='result']"));
        expectedText="Your registration completed";
        Assert.assertEquals("Not Matched Any Result",expectedText,actualText);

        // Click on continue
        clickOnElement(By.xpath("//a[@class='button-1 register-continue-button']"));

        // Login again because cart is empty
        clickOnElement(By.xpath("//a[@class='ico-login']"));
        driver.findElement(By.xpath("//input[@id='Email']")).sendKeys("oopp1@gmail.com");
        driver.findElement(By.xpath("//input[@id='Password']")).sendKeys("xyz@0000");
        clickOnElement(By.xpath("//button[normalize-space()='Log in']"));

        //  Verify the text “Shopping card”
        String expectedShopping = "Shopping cart";
        String actualShopping = driver.findElement(By.xpath("//h1[normalize-space()='Shopping cart']")).getText();
        Assert.assertEquals("Text not verified", actualShopping, expectedShopping);

        //  click on checkbox “I agree with the terms of service”
        selectMenu("//input[@id='termsofservice']");

        //  Click on “CONTINUE”
        selectMenu("//button[@id='checkout']");

        //  Fill all the details
        // First name
        sendText(By.xpath("//input[@id='BillingNewAddress_FirstName']"), "jjj");

        // Last name
        sendText(By.xpath("//input[@id='BillingNewAddress_LastName']"), "yyy");

        // Email
        sendText(By.xpath("//input[@id='BillingNewAddress_Email']"), "");

        // Select country
        selectByValue(By.xpath("//select[@id='BillingNewAddress_CountryId']"), "1");

        // Select State
        selectByValue(By.xpath("//select[@id='BillingNewAddress_StateProvinceId']"), "47");

        // City
        sendText(By.xpath("//input[@id='BillingNewAddress_City']"), "Surat");

        // Address line 1
        sendText(By.xpath("//input[@id='BillingNewAddress_Address1']"), "Katargam");

        // Zip Code
        sendText(By.xpath("//input[@id='BillingNewAddress_ZipPostalCode']"), "395004");

        // Phone number
        sendText(By.xpath("//input[@id='BillingNewAddress_PhoneNumber']"), "1234567890");

        // click on continue button
        selectMenu("//button[@onclick='Billing.save()']");

        // Click on Radio Button “2nd Day Air ($0.00)”
        selectMenu("//input[@id='shippingoption_2']");

        // Click on continue button
        selectMenu("//button[@class='button-1 shipping-method-next-step-button']");

        //  Select Radio Button “Credit Card”
        selectMenu("//input[@id='paymentmethod_1']");

        // Click on continue
        selectMenu("//button[@class='button-1 payment-method-next-step-button']");

        // Select visa card option
        selectByValue(By.xpath("//select[@id='CreditCardType']"), "visa");

        //  Fill all the details

        // Cardholder name
        sendText(By.xpath("//input[@id='CardholderName']"), "jjjeee");

        // Card number
        sendText(By.xpath("//input[@id='CardNumber']"), "5555555555554444");

        // Expire date
        selectByValue(By.xpath("//select[@id='ExpireMonth']"), "4");

        // Expire Year
        selectByValue(By.xpath("//select[@id='ExpireYear']"), "2028");

        // Card code
        sendText(By.xpath("//input[@id='CardCode']"), "890");

        // Click on “CONTINUE”
        selectMenu("//button[@class='button-1 payment-info-next-step-button']");

        // Verify “Payment Method” is “Credit Card”
        String expectedMethod = "Credit Card";
        String actualMethod = driver.findElement(By.xpath("//span[normalize-space()='Credit Card']")).getText();
        Assert.assertEquals("Text not verified", expectedMethod, actualMethod);

        //  Verify “Shipping Method” is “2nd Day Air”
        String expectedShipping = "2nd Day Air";
        String actualShipping = driver.findElement(By.xpath("//span[normalize-space()='2nd Day Air']")).getText();
        Assert.assertEquals("Text not verified", actualShipping, expectedShipping);

        // Verify Total is “$698.00”
        String expectedValue = "$698.00";
        String actualValue = driver.findElement(By.xpath("//span[@class='product-subtotal']")).getText();
        Assert.assertEquals("Text not verified", expectedValue, actualValue);

        //  Click on “CONFIRM”
        selectMenu("//button[normalize-space()='Confirm']");

        // Verify the Text “Thank You”
        String expectedThank = "Thank you";
        String actualThank = driver.findElement(By.xpath("//h1[normalize-space()='Thank you']")).getText();
        Assert.assertEquals("Text not verified", expectedThank, actualThank);

        //  Verify the message “Your order has been successfully processed!”
        String expectedMessage = "Your order has been successfully processed!";
        String actualMessage = driver.findElement(By.xpath("//strong[normalize-space()='Your order has been successfully processed!']")).getText();
        Assert.assertEquals("Text not verified", expectedThank, actualThank);

        //  Click on “CONTINUE”
        selectMenu("//button[normalize-space()='Continue']");

        //  Verify the text “Welcome to our store”
        String expectedWelcome2 = "Welcome to our store";
        String actualWelcome2 = driver.findElement(By.xpath("//h2[normalize-space()='Welcome to our store']")).getText();
        Assert.assertEquals("Text not verified", expectedWelcome2, actualWelcome2);

        //  Click on “Logout” link
        selectMenu("//a[@class='ico-logout']");

        //  Verify the URL is “https://demo.nopcommerce.com/”
        String currentUrl = driver.getCurrentUrl();
        String expectedUrl2 = "https://demo.nopcommerce.com/";
        Assert.assertEquals("Url not verified", expectedUrl2, currentUrl);
  }


    @After
    public void tearDown()
    {
         closeBrowser();
    }
}
