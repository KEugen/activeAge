package framework.Helper;

import framework.setup.Setup;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Set;

public class Utils extends Setup {

    // Метод, который ждет millis миллисекунд
    public static void wait(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    // Метод, генерирующий рандомный имейл, привязанный к темп-мэил
    public static String generateRandomEmail(){
        String str1 = "test";
        String str2 = "@p33.org";

        int a = 0;
        int b = 1000;
        int FirstRandomNumber = a + (int) (Math.random() * b);
        int SecondRandomNumber = a + (int) (Math.random() * b);

        String str3 =  FirstRandomNumber + str1 + SecondRandomNumber + str2;
        return str3;
    }

    // Изменение фокуса с одной страницы на вторую
    public static void moveFocusToTheNewWindow(final Set<String> oldWindowsSet){
        String newWindows = (new WebDriverWait(getDriver(), 10)).until(new ExpectedCondition<String>()
        {
            //@Override
            public String apply(WebDriver webDriver) {
                Set<String> newWindowsSet = webDriver.getWindowHandles();
                newWindowsSet.removeAll(oldWindowsSet);
                return newWindowsSet.size() > 0 ?
                        newWindowsSet.iterator().next() : null;
            }
        });
        getDriver().switchTo().window(newWindows);
    }

    // Метод isDisplayed
    public static boolean elementIsDisplayed(WebElement element) {
        try {
            return element.isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    // Метод isDisplayed с передаваемым параметром
    public static boolean elementsIsDisplayedWithType(String type, WebElement firstElement, WebElement secondElement) {
        try {
            if(type.equalsIgnoreCase("selected")){
                return firstElement.isDisplayed();
            }
            else {
                return firstElement.isDisplayed();
            }
        } catch (NoSuchElementException e) {
            return false;
        }
    }

}
