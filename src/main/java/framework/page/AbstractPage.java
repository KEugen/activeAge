package framework.page;

import framework.setup.Setup;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public abstract class AbstractPage  {

    protected AbstractPage() {
        PageFactory.initElements(getDriver(), this);
    }

    protected WebDriver getDriver() {
        return Setup.getDriver();
    }

    protected void isCorrectPage(String expectedUrl) {
        if(!getDriver().getCurrentUrl().contains(expectedUrl)) {
            throw new IllegalStateException(
                    "This is not profile page"
            );
        }
    }
}
