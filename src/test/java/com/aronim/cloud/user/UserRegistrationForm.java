package com.aronim.cloud.user;

import org.assertj.core.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

import static com.aronim.cloud.common.tests.AronimCloudExpectedConditions.bootstrapComplete;

/**
 * User: Kevin W. Sewell
 * Date: 2015-12-13
 * Time: 19h35
 */
public class UserRegistrationForm
{
    @FindBy(css = "form.ac-user-registration div.ac-first-name")
    private WebElement firstNameControl;

    @FindBy(css = "form.ac-user-registration div.ac-first-name label")
    private WebElement firstNameLabel;

    @FindBy(css = "form.ac-user-registration div.ac-last-name")
    private WebElement lastNameControl;

    @FindBy(css = "form.ac-user-registration div.ac-last-name label")
    private WebElement lastNameLabel;

    @FindBy(css = "form.ac-user-registration div.ac-email-address")
    private WebElement emailAddressControl;

    @FindBy(css = "form.ac-user-registration div.ac-email-address label")
    private WebElement emailAddressLabel;

    @FindBy(css = "form.ac-user-registration div.ac-password")
    private WebElement passwordControl;

    @FindBy(css = "form.ac-user-registration div.ac-password label")
    private WebElement passwordLabel;

    @FindBy(css = "form.ac-user-registration button.ac-register")
    private WebElement registerButton;

    private final WebDriver driver;

    public UserRegistrationForm(WebDriver driver)
    {
        this.driver = driver;
        new WebDriverWait(this.driver, 5000L)
                .ignoring(WebDriverException.class)
                .until(bootstrapComplete());
    }

    public UserRegistrationForm assertThatFirstNameControlExists()
    {
        Assertions.assertThat(firstNameControl).isNotNull();

        return this;
    }

    public UserRegistrationForm assertThatFirstNameLabelExists()
    {
        Assertions.assertThat(firstNameLabel).isNotNull();

        return this;
    }

    public UserRegistrationForm assertThatFirstNameLabelEquals(String label)
    {
        Assertions.assertThat(firstNameLabel.getText()).isEqualTo(label);

        return this;
    }

    public UserRegistrationForm assertThatLastNameControlExists()
    {
        Assertions.assertThat(lastNameControl).isNotNull();

        return this;
    }

    public UserRegistrationForm assertThatLastNameLabelExists()
    {
        Assertions.assertThat(lastNameLabel).isNotNull();

        return this;
    }

    public UserRegistrationForm assertThatLastNameLabelEquals(String label)
    {
        Assertions.assertThat(lastNameLabel.getText()).isEqualTo(label);

        return this;
    }

    public UserRegistrationForm assertThatEmailAddressControlExists()
    {
        Assertions.assertThat(emailAddressControl).isNotNull();

        return this;
    }

    public UserRegistrationForm assertThatEmailAddressLabelExists()
    {
        Assertions.assertThat(emailAddressLabel).isNotNull();

        return this;
    }

    public UserRegistrationForm assertThatEmailAddressLabelEquals(String label)
    {
        Assertions.assertThat(emailAddressLabel.getText()).isEqualTo(label);

        return this;
    }

    public UserRegistrationForm assertThatPasswordControlExists()
    {
        Assertions.assertThat(passwordControl).isNotNull();

        return this;
    }

    public UserRegistrationForm assertThatPasswordLabelExists()
    {
        Assertions.assertThat(passwordLabel).isNotNull();

        return this;
    }

    public UserRegistrationForm assertThatPasswordLabelEquals(String label)
    {
        Assertions.assertThat(passwordLabel.getText()).isEqualTo(label);

        return this;
    }

    public UserRegistrationForm assertThatRegisterButtonExists()
    {
        Assertions.assertThat(registerButton).isNotNull();

        return this;
    }
}
