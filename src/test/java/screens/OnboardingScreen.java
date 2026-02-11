package screens;

import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.appium.SelenideAppium.$;

public class OnboardingScreen {

    private final By languageOption =
            By.id("org.wikipedia.alpha:id/option_label");

    private final By forwardButton =
            By.id("org.wikipedia.alpha:id/fragment_onboarding_forward_button");

    private final By primaryTextView =
            By.id("org.wikipedia.alpha:id/primaryTextView");

    private final By getStartedButton =
            By.id("org.wikipedia.alpha:id/fragment_onboarding_done_button");

    public void checkLanguageVisible(String language){
        $(languageOption).shouldHave(text(language));
    }

    public void pressForwardButton(){
        $(forwardButton)
                .shouldBe(visible)
                .click();
    }

    public void checkContainsPrimaryText(String expectedText){
        $(primaryTextView).shouldHave(text(expectedText));
    }

    public void pressGetStartedButton(){
        $(getStartedButton)
                .click();
    }

}
