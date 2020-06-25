package FirstPkg;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class First {

@Test
    public void Facebook () {

        System.setProperty("webdriver.chrome.driver", "./Driver/chromedriver.exe");
        WebDriver driver=new ChromeDriver ();
        driver.get ("https://facebook.com");

        By fNameLocator = By.xpath("//input[@aria-label='First name']");
        By lNameLocator = By.name("lastname");
        By mobileLocator = By.xpath("//input[contains(@aria-label, 'Mobile number')]");
        By passwordLocator = By.xpath("//input[@autocomplete='new-password' or @aria-label='New password']");
        By signUpLocator = By.xpath("//button[text()='Sign Up' and @name='websubmit']");


        driver.findElement(fNameLocator).sendKeys("Karina");

        driver.findElement(lNameLocator).sendKeys("Melik");

        driver.findElement(mobileLocator).sendKeys("4187589456");

        driver.findElement(passwordLocator).sendKeys("test@1234");

        WebElement signUp = driver.findElement(signUpLocator);
        signUp.click();


        By messageLocator=By.xpath ("//div[contains(@class,'LayerLeft')]");
        WebElement textmes=driver.findElement (messageLocator);
        String text=textmes.getText();
        if (text.contains ("Please choose a gender. You can change who can see this later.")){
            System.out.println ("Message is verified");
        }


    }
@Test

    public void Temperature () {
        System.setProperty ("webdriver.chrome.driver","./Driver/chromedriver.exe");
        WebDriver driver = new ChromeDriver ();
        driver.get ("https://weather.gov");
        By  localweatherLocator=By.xpath("//input[@value='Enter location ...']");
        By goLocator=By.xpath ("//input[@value='Go' and @name='btnSearch']");
        driver.findElement(localweatherLocator).click ();
        driver.findElement(localweatherLocator).sendKeys("11230");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        By brooklynLocator=By.xpath("//div[@class='autocomplete-suggestion' and text()=', Brooklyn, NY, USA']");
        driver.findElement (brooklynLocator).click ();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        By currenttempLOcator=By.xpath ("//p[@class='myforecast-current-lrg']");
        By hightempLocator= By.xpath ("//div[@class='tombstone-container' and p[@class='temp temp-high'] and p[text()='Afternoon']]");
        By lowtempLocator=By.xpath("//div[@class='tombstone-container' and p[@class='temp temp-low'] and p[text()='Tonight']]");
        String curtemp=driver.findElement (currenttempLOcator).getText ();
        String hightemp=driver.findElement (hightempLocator).getText ();
        String lowtemp=driver.findElement (lowtempLocator).getText ();
        String clean = curtemp.replaceAll("\\D+",""); //remove non-digits
        int current=Integer.parseInt(clean);
        String clean2 = hightemp.replaceAll("\\D+",""); //remove non-digits
        int high=Integer.parseInt (clean2);
        String clean3 = lowtemp.replaceAll("\\D+",""); //remove non-digits
        int low = Integer.parseInt (clean3);


        if (current<high && current>low){
            System.out.println ("Temperature is within the limit");
        }
    }

}
