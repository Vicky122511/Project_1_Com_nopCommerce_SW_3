package homepage;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.Utility;

public class TopMenuTest extends Utility
{
    //1.1 create method with name "selectMenu" it has one parameter name "menu" of type
    //string
    String baseurl = "https://demo.nopcommerce.com/";
    String menu,expectedText;
    @Before
    public void setUp()
    {
        openBrowser(baseurl);
    }

   public void selectMenu(String menu)
   {
       this.menu=menu;
       //This method should click on the menu whatever name is passed as parameter.
       clickOnElement(By.xpath(menu));
    }

   @Test
   public void verifyTopMenuTest()
   {
       menu=getTextFromElement(By.xpath("//body/div[6]/div[2]/ul[1]/li[1]/a[1]"));
       //selectMenu(menu);
   }

   @Test
   public void verifyPageNavigation()
   {
       verifyTopMenuTest();
       //select the Menu and click on it and verify the page navigation
       expectedText="Computers";
       Assert.assertEquals("Text Not Matched",expectedText,menu);
   }

    @After
    public void tearDown()
    {
        closeBrowser();
    }
}
