package tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import screens.OnboardingScreen;

import static io.qameta.allure.Allure.step;

public class OnboardingTests extends TestBase{

    @Test
    @DisplayName("Succesfull onboarding screen pass")
    void successfullOnboardingScreenPass(){

        OnboardingScreen onboarding = new OnboardingScreen();

        step("Page one - english language is visible", () ->{
            onboarding.checkLanguageVisible("English");
        });

        step("Switch to page two", () -> {
            onboarding.pressForwardButton();
        });

        step("Page two - header contains text 'New ways to explore'", () -> {
            onboarding.checkContainsPrimaryText("New ways to explore");
        });

        step("Switch to page three", () -> {
            onboarding.pressForwardButton();
        });

        step("Page three - header contains text 'Reading lists with sync'", () -> {
            onboarding.checkContainsPrimaryText("Reading lists with sync");
        });

        step("Switch to page four", () -> {
            onboarding.pressForwardButton();
        });

        step("Page four - header contains text 'Data & Privacy'", () -> {
            onboarding.checkContainsPrimaryText("Data & Privacy");
        });

        step("Click 'Get started' button", () -> {
            onboarding.pressGetStartedButton();
        });



    }
}
