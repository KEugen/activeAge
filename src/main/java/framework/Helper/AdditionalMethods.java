package framework.Helper;

import framework.setup.Setup;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

public class AdditionalMethods extends Setup {

    // метод, который ждет наступления какого-то события, прежде чем продолжит выполнение команд
    public static void wait(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();

        }
    }

    // метод isDisplayed
    public static boolean elementIsDisplayed(WebElement element) {
        try {
            return element.isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    // метод isDisplayed с передаваемым параметром
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
