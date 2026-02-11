package drivers;

import com.codeborne.selenide.WebDriverProvider;
import config.AndroidConfig;
import config.ConfigProvider;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import javax.annotation.Nonnull;
import java.net.MalformedURLException;
import java.net.URL;

public class BrowserstackDriver implements WebDriverProvider {

    @Nonnull
    @Override
    public WebDriver createDriver(@Nonnull Capabilities capabilities) {

        AndroidConfig config = ConfigProvider.getConfig();

        /*До этого была конфигурация, как в лекции. Попробовал запросить помощи у гпт,
        скопипастил драйвер, но результата не дало, ничего не заводится :(
         */



        // W3C root capabilities
        MutableCapabilities caps = new MutableCapabilities();
        caps.setCapability("platformName", "Android");

        // Appium capability for the app (НЕ внутри bstack:options)
        caps.setCapability("appium:app", config.app());

        // BrowserStack vendor namespace
        MutableCapabilities bstackOptions = new MutableCapabilities();
        bstackOptions.setCapability("userName", config.browserstackUser());
        bstackOptions.setCapability("accessKey", config.browserstackKey());

        bstackOptions.setCapability("deviceName", config.deviceName());
        bstackOptions.setCapability("osVersion", config.osVersion());

        bstackOptions.setCapability("projectName", config.projectName());
        bstackOptions.setCapability("buildName", config.buildName());
        bstackOptions.setCapability("sessionName", config.testName());

        caps.setCapability("bstack:options", bstackOptions);

        try {
            return new RemoteWebDriver(
                    new URL("https://hub.browserstack.com/wd/hub"),
                    caps
            );
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }
}
