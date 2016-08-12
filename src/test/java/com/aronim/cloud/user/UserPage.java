package com.aronim.cloud.user;

import org.assertj.core.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import static com.aronim.cloud.common.tests.AronimCloudExpectedConditions.bootstrapComplete;

public class UserPage
{
    @FindBy(css = "form.ac-user-registration")
    private WebElement registrationForm;

    private final WebDriver driver;

    public UserPage(WebDriver driver)
    {
        this.driver = driver;

        new WebDriverWait(this.driver, 5000L)
                .ignoring(WebDriverException.class)
                .until(bootstrapComplete());
    }

    public UserPage assertThatRegistrationFormExists()
    {
        Assertions.assertThat(registrationForm).isNotNull();

        return this;
    }

    public UserRegistrationForm registrationForm()
    {
        return PageFactory.initElements(driver, UserRegistrationForm.class);
    }
}