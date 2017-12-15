package pages;

import framework.page.AbstractPage;
import org.openqa.selenium.WebDriver;

public class ProfilePage extends AbstractPage {
    private static String URL_MATCH = "/profile";

    public ProfilePage(WebDriver driver) {
        super(driver);
        if(!driver.getCurrentUrl().contains(URL_MATCH)) {
            throw new IllegalStateException(
                    "This is not profile page"
            );
        }
    }


}
