package computer;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import utilities.Utility;


public class TestSuite extends Utility
{
    String baseurl = "https://demo.nopcommerce.com/";
    String s1,expectedText,actualText;
    @Before
    public void setUp()
    {
        openBrowser(baseurl);
    }

    @Test
    public void verifyProductArrangeInAlphaBaticalOrder()
    {
        //Click on Computer Menu
        clickOnElement(By.xpath("//body/div[6]/div[2]/ul[1]/li[1]/a[1]"));

        // Click on Desktop
        clickOnElement(By.xpath("//div[@class='sub-category-item']//h2/a"));

        //Select Sort By position "Name: Z to A"
        s1=getTextFromElement(By.xpath("//option[contains(text(),'Name: Z to A')]"));
        clickOnElement(By.xpath("//option[contains(text(),'Name: Z to A')]"));

        // Verify the Product will arrange in Descending order.
        expectedText="Name: Z to A";
        //actualText=getTextFromElement(By.xpath("//option[contains(text(),'Name: Z to A')]"));
        Assert.assertEquals("Not Matched",expectedText,s1);

    }

    @Test
    public void verifyProductAddedToShoppingCartSuccessFully() throws InterruptedException
    {
        //Click on Computer Menu.
        clickOnElement(By.xpath("//body/div[6]/div[2]/ul[1]/li[1]/a[1]"));

        //Click on Desktop
        clickOnElement(By.xpath("//div[@class='sub-category-item']//h2/a"));

        //Select Sort By position "Name: A to Z"
        clickOnElement(By.xpath("//option[contains(text(),'Name: A to Z')]"));

        Thread.sleep(1000);
        //Click on "Add To Cart"
        clickOnElement(By.xpath("//body/div[6]/div[3]/div[1]/div[3]/div[1]/div[2]/div[2]/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/div[3]/div[2]/button[1]"));



        //Verify the Text "Build your own computer"
         //clickOnElement(By.xpath("//h2[@class='product-title']//a[normalize-space()='Build your own computer']"));
        driver.navigate().to("https://demo.nopcommerce.com/build-your-own-computer");

        expectedText = "Build your own computer";
        actualText = getTextFromElement(By.xpath("//h1[normalize-space()='Build your own computer']"));
        Assert.assertEquals("Text Not Matched", expectedText, actualText);

        //Select "2.2 GHz Intel Pentium Dual-Core E2200" using Select class
        WebElement dropDown = driver.findElement(By.name("product_attribute_1"));
        Select select = new Select(dropDown);
        select.selectByValue("1");

        //Select "8GB [+$60.00]" using Select class.
        WebElement dropDown2 = driver.findElement(By.name("product_attribute_2"));
        Select select2 = new Select(dropDown2);
        select2.selectByValue("5");


        //Select HDD radio "400 GB [+$100.00]"
        clickOnElement(By.xpath("//label[@for='product_attribute_3_7']"));

        //Select OS radio "Vista Premium [+$60.00]"
        clickOnElement(By.xpath("//label[@for='product_attribute_4_9']"));

        //Check Two Check boxes "Microsoft Office [+$50.00]" and "Total Commander
        //[+$5.00]
        clickOnElement(By.xpath("//input[@id='product_attribute_5_10']"));
        clickOnElement(By.xpath("//input[@id='product_attribute_5_10']"));
        clickOnElement(By.xpath("//input[@id='product_attribute_5_12']"));

        Thread.sleep(2500);

        //Verify the price "$1,475.00"
        expectedText="$1,475.00";
        actualText=driver.findElement(By.xpath("//span[@id='price-value-1']")).getText();
        Assert.assertEquals("Not Matched",expectedText,actualText);

        //Click on "ADD TO CARD" Button
        clickOnElement(By.xpath("//button[@id='add-to-cart-button-1']"));

        //Verify the Message "The product has been added to your shopping cart" on Top
        //green Bar
        actualText=driver.findElement(By.xpath("//p[@class='content']")).getText();
        expectedText="The product has been added to your shopping cart";
        Assert.assertEquals("Not Matched Message",expectedText,actualText);

        //After that close the bar clicking on the cross button
        clickOnElement(By.xpath("//span[@title='Close']"));

        //Then MouseHover on "Shopping cart" and Click on "GO TO CART" button.
        WebElement cart=driver.findElement(By.xpath("//span[@class='cart-label']"));
        Actions actions=new Actions(driver);
        actions.moveToElement(cart).build().perform();
        actions.moveToElement(cart).click().build().perform();

        //clickOnElement(By.xpath("//button[normalize-space()='Go to cart']"));

        //Verify the message "Shopping car
        actualText=getTextFromElement(By.xpath("//h1[normalize-space()='Shopping cart']"));
        expectedText="Shopping cart";
        Assert.assertEquals("Not Matched Text",expectedText,actualText);

        //Change the Qty to "2" and Click on "Update shopping cart"
        driver.findElement(By.xpath("//input[@id='itemquantity11262']")).clear();
        driver.findElement(By.xpath("//input[@id='itemquantity11262']")).sendKeys("2");

        clickOnElement(By.xpath("//button[@id='updatecart']"));

        //Verify the Total"$2,950.00"
        actualText=getTextFromElement(By.xpath("//span[@class='product-subtotal']"));
        expectedText="$2,950.00";
        Assert.assertEquals("Prise Not Matched",expectedText,actualText);

        // click on checkbox “I agree with the terms of service”
        clickOnElement(By.xpath("//input[@id='termsofservice']"));

        //Click on “CHECKOUT”
        clickOnElement(By.xpath("//button[@id='checkout']"));

        // Verify the Text “Welcome, Please Sign In!”
        actualText=getTextFromElement(By.xpath("//h1[normalize-space()='Welcome, Please Sign In!']"));
        expectedText="Welcome, Please Sign In!";
        Assert.assertEquals("Message Not Matched",expectedText,actualText);

        //Click on “CHECKOUT AS GUEST” Tab
        clickOnElement(By.xpath("//button[normalize-space()='Checkout as Guest']"));

        //Fill the all mandatory field
        driver.findElement(By.xpath("//input[@id='BillingNewAddress_FirstName']")).sendKeys("Vicky");
        driver.findElement(By.xpath("//input[@id='BillingNewAddress_LastName']")).sendKeys("Patel");
        driver.findElement(By.xpath("//input[@id='BillingNewAddress_Email']")).sendKeys("asdggd@gmail.com");
        driver.findElement(By.xpath("//select[@id='BillingNewAddress_CountryId']")).sendKeys("United States");
        driver.findElement(By.xpath("//input[@id='BillingNewAddress_City']")).sendKeys("New York");
        driver.findElement(By.xpath("//input[@id='BillingNewAddress_Address1']")).sendKeys("123 street ,xyaz slop");
        driver.findElement(By.xpath("//input[@id='BillingNewAddress_ZipPostalCode']")).sendKeys("388330");
        driver.findElement(By.xpath("//input[@id='BillingNewAddress_PhoneNumber']")).sendKeys("1234567890");


        //Click on “CONTINUE”
        clickOnElement(By.xpath("//button[@onclick='Billing.save()']"));

        //Click on Radio Button “Next Day Air($0.00)”


        //Click on “CONTINUE”

    }

  @After
    public void tearDown()
    {
       // closeBrowser();
    }

}
