package com.kungfudev.cloud.user;

import com.kungfudev.cloud.common.tests.WebDriverFactory;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.WebIntegrationTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


/**
 * User: Kevin W. Sewell
 * Date: 2015-06-03
 * Time: 15h33
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = TestUserApplication.class)
@WebIntegrationTest(value = "server.port=8080")
public class UserApplicationTest {

    private WebDriver driver;

    private UserPage userPage;

    @Before
    public void setUp() throws Exception {

        driver = WebDriverFactory.init("/resources/user.html");

        userPage = PageFactory.initElements(driver, UserPage.class);
    }

    @Test
    public void containsActuatorLinks() throws Exception {
        userPage.assertThatRegistrationFormExists();

        userPage.registrationForm()
                // First Name Input
                .assertThatFirstNameControlExists()
                .assertThatFirstNameLabelExists()
                .assertThatFirstNameLabelEquals("First Name Required")
                // Last Name Input
                .assertThatLastNameControlExists()
                .assertThatLastNameLabelExists()
                .assertThatLastNameLabelEquals("Last Name Required")
                // Email Address Input
                .assertThatEmailAddressControlExists()
                .assertThatEmailAddressLabelExists()
                .assertThatEmailAddressLabelEquals("Email Address Required")
                // Password Input
                .assertThatPasswordControlExists()
                .assertThatPasswordLabelExists()
                .assertThatPasswordLabelEquals("Password Required")
                // Register Button
                .assertThatRegisterButtonExists();
    }


}
