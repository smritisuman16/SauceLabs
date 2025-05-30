package Screens;

public class CommonElements {
    public void waitForSeconds(int seconds){
        try{
            Thread.sleep(seconds* 1000L);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
