package com.kungfudev.cloud.user;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.PageFactory;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.WebIntegrationTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.net.URL;


/**
 * User: Kevin W. Sewell
 * Date: 2015-06-03
 * Time: 15h33
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = TestUserApplication.class)
@WebIntegrationTest(value = "server.port=8080")
//@SeleniumTest(driver = ChromeDriver.class, baseUrl = "http://gocd-build-agent:8080/resources/user.html")
public class UserApplicationTest {

    private WebDriver driver;

    private UserPage userPage;

    @Before
    public void setUp() throws Exception {
        userPage = PageFactory.initElements(driver, UserPage.class);
        URL remoteAddress = new URL("http://selenium.aronim.com");
        DesiredCapabilities desiredCapabilities = DesiredCapabilities.firefox();
        driver = new RemoteWebDriver(remoteAddress, desiredCapabilities);
        driver.get("http://gocd-build-agent:8080/resources/user.html");
    }

    @Test
    public void containsActuatorLinks() {
//        userPage.assertThat().
//                .hasActuatorLink("autoconfig", "beans", "configprops", "dump", "env", "health", "info", "metrics", "mappings", "trace")
//                .hasNoActuatorLink("shutdown");
    }
}
