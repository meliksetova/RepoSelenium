package FirstPkg;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class First {
    public static void main (String[] args) {

        System.setProperty("webdriver.chrome.driver", "./Driver/chromedriver.exe");
        WebDriver driver=new ChromeDriver ();
        driver.get ("https://amazon.com");
    }
}
