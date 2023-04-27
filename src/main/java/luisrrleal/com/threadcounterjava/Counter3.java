package luisrrleal.com.threadcounterjava;

import javafx.application.Platform;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.util.concurrent.TimeUnit;

public class Counter3 extends Thread {
    private int counterLimit;
    private final StringProperty counter= new SimpleStringProperty("0");
    public Counter3(int counterLimit) {
        this.counterLimit = counterLimit;
    }

    @Override
    public void run() {
        for(int i = 1; i<=counterLimit; i++){
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            int finalI = i;
            Platform.runLater(()->setCounter(finalI +" / "+counterLimit));
        }
    }

    public String getCounter() {
        return counter.get();
    }

    public StringProperty counterProperty() {
        return counter;
    }

    public void setCounter(String counter) {
        this.counter.set(counter);
    }
}
