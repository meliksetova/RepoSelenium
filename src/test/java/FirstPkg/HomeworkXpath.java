package FirstPkg;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.annotations.TestInstance;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Date;

public class HomeworkXpath {
    /**
     * Homework 1:
     * 1. Launch Darksky
     * 2. Go to DarkSy API Homepage
     * 3. Click on 'blog Past' link
     * 4. Verify Blog page title is 'Dark Sky Blog'
     * 5. Verify Page Banner Text is SAME as Tile Header-Text (Dark Sky Has a New Home).
     * 6. Verify the Tile-Date is SAME as Blog Date
     * 7. Go Back and Verify user lands on Dark Sky API HomePage
     */

    /**
     * Homepage 2:
     * Sign Up Flow:
     * Enter data in all fields as per your wish but use emailAddress as given below.
     * Verify user get "Please enter a valid mobile number or email address." for below email addresses:
     * 1. test####
     * 2. %%winvalied$$$
     * 3. %%$$emailAddress.co^^
     */

    @Test
    public void Darsky() throws ParseException {
        System.setProperty("webdriver.chrome.driver", "./Driver/chromedriver.exe");
        WebDriver driver=new ChromeDriver ();
        driver.get ("https://darksky.net/forecast/40.7127,-74.0059/us12/en");
        By APILocator=By.xpath ("//a[contains(text(),'Dark Sky API')]");
        By blogpostLocator=By.xpath ("//a[contains(text(),'blog post')]");
        By pageBannerLocator=By.xpath ("//a[@itemprop='name headline']");
        By tileHeaderLocator=By.xpath ("//p[@class='post_link_title']");
        By pageBannerDate=By.xpath ("//time[@itemprop='datePublished']");
        By blogDate=By.xpath ("//p[@class='post_link_date']");


        driver.findElement (APILocator).click ();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        driver.findElement (blogpostLocator).click ();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        String blogpost=driver.findElement (pageBannerLocator).getText ();
        String pageBanner=driver.findElement (pageBannerLocator).getText ();
        Assert.assertEquals (blogpost,pageBanner);
        String bannerdate=driver.findElement (pageBannerDate).getText ();
        String postdate=driver.findElement (blogDate).getText ();
        SimpleDateFormat formatter=new SimpleDateFormat("MMMM dd, yyyy");
        Date date1=formatter.parse (bannerdate);
        Date date2=formatter.parse (postdate);
        Assert.assertEquals (date1,date2);
        driver.navigate ().back ();
        String url=driver.getCurrentUrl ();
        Assert.assertEquals (url,"https://darksky.net/dev");
    }

    @Test

    public void facebookEmail(){
        System.setProperty("webdriver.chrome.driver", "./Driver/chromedriver.exe");
        WebDriver driver=new ChromeDriver ();
        driver.get ("https://facebook.com");

        By fNameLocator = By.xpath("//input[@aria-label='First name']");
        By lNameLocator = By.name("lastname");
        By mobileLocator = By.xpath("//input[contains(@aria-label, 'Mobile number')]");
        By passwordLocator = By.xpath("//input[@autocomplete='new-password' or @aria-label='New password']");
        By signUpLocator = By.xpath("//button[text()='Sign Up' and @name='websubmit']");
        By FemaleLocator=By.xpath ("//input[@type='radio' and @value='1']");
        By messageLocator=By.xpath ("//div[contains(text(),'valid mobile number')]");


        String[] emails={"test####","%%winvalied$$$","%%$$emailAddress.co^^"};

        for (int i=0; i<emails.length; i++) {
            driver.findElement (fNameLocator).sendKeys ("Karina");

            driver.findElement (lNameLocator).sendKeys ("Melik");

            driver.findElement (mobileLocator).sendKeys (emails[i]);

            driver.findElement (passwordLocator).sendKeys ("test@1234");

            driver.findElement (FemaleLocator).click ();

            driver.findElement (signUpLocator).click ();

            try {
                Thread.sleep (2000);
            } catch (InterruptedException e) {
                e.printStackTrace ();
            }

            WebElement message = driver.findElement (messageLocator);
            boolean ismMessageDisplayed = message.isDisplayed ();

            Assert.assertTrue (ismMessageDisplayed);
            driver.navigate ().refresh ();

        }



    }


}
