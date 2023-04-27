package luisrrleal.com.threadcounterjava;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

public class HelloController {
    @FXML
    private Label title, counter1, counter2, counter3;

    @FXML
    protected void onStartButtonClick() {
        startCounter1(ThreadLocalRandom.current().nextInt(1,20));
        startCounter2(ThreadLocalRandom.current().nextInt(1,20));
        startCounter3(20);
    }

    private void startCounter1(int counterLimit) {
        counter1.setText("0");
        new Thread(()->{
            for(int i=1;i<=counterLimit;i++){
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                int finalI = i;
                Platform.runLater(()->counter1.setText(String.valueOf(finalI)+" / "+counterLimit));
            }
        }, "Thread Counter 1").start();
    }

    private void startCounter2(int counterLimit){
        counter2.setText("0");
        new Thread(()->{
            for (int i=1;i<=counterLimit;i++ ){
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                int finalI = i;
                Platform.runLater(()->counter2.setText(String.valueOf(finalI)+" / "+counterLimit));
            }
        }, "Thread Counter 2").start();
    }

    private void startCounter3(int counterLimit) {
        Counter3 counter = new Counter3(counterLimit);
        counter3.textProperty().bind(counter.counterProperty());
        counter.start();
    }
}