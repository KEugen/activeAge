package framework.Helper;

public class AdditionalMethods {

    // метод, который ждет наступления какого-то события, прежде чем продолжит выполнение команд
    public void wait(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();

        }
    }

}
