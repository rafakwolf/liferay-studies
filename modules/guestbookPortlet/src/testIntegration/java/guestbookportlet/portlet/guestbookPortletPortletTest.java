package guestbookportlet.portlet;

import com.liferay.arquillian.portal.annotation.PortalURL;
import com.thoughtworks.selenium.Selenium;
import org.jboss.arquillian.container.test.api.RunAsClient;
import org.jboss.arquillian.drone.api.annotation.Drone;
import org.jboss.arquillian.junit.Arquillian;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;


import java.net.MalformedURLException;
import java.net.URL;


@RunAsClient
@RunWith(Arquillian.class)
public class guestbookPortletPortletTest {


    @Test
    public void testLogin() throws InterruptedException, MalformedURLException {


        System.setProperty("webdriver.chrome.driver", "C:\\Program Files (x86)\\Google\\Chrome\\Application\\chrome.exe");

        WebDriver driver = new ChromeDriver();
        driver.get("http://localhost:8080/c/portal/login");

//        Thread.sleep(5000);

        //WebElement searchBox = driver.findElement(By.name("q"));
        //searchBox.sendKeys("ChromeDriver");
        //searchBox.submit();
        //Thread.sleep(5000);  // Let the user actually see something!
        //driver.quit();


        //ChromeOptions options = new ChromeOptions();
        //options.setBinary("C:\\Program Files (x86)\\Google\\Chrome\\Application\\chrome.exe");

        //WebDriver driver = new ChromeDriver(options);


        //driver.navigate().to("http://localhost:8080/c/portal/login");

        Thread.sleep(5000);


//        Capabilities capabilities = DesiredCapabilities.chrome();
//        WebDriver driver = new RemoteWebDriver(new URL("http://localhost:9515"),capabilities);
//        driver.navigate().to("http://localhost:8080/c/portal/login");

        _emailInput.clear();
        _emailInput.sendKeys("test@liferay.com");

        _passwordInput.clear();
        _passwordInput.sendKeys("R3m3mb3r1!");

        _signInButton.click();

        Thread.sleep(5000);

        Assert.assertTrue(_userAvatar.isDisplayed());

        driver.quit();
    }


    @Drone
    private WebDriver _browser;

    @PortalURL("http://localhost:8080/c/portal/login")
    private URL _loginUrl;

    @FindBy(id = "_com_liferay_login_web_portlet_LoginPortlet_login")
    private WebElement _emailInput;

    @FindBy(id = "_com_liferay_login_web_portlet_LoginPortlet_password")
    private WebElement _passwordInput;

    @FindBy(id = "_com_liferay_login_web_portlet_LoginPortlet_bswj")
    private WebElement _signInButton;

    @FindBy(css = "span[class='user-avatar-image']")
    private WebElement _userAvatar;
}
