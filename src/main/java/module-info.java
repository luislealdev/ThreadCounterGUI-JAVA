module luisrrleal.com.threadcounterjava {
    requires javafx.controls;
    requires javafx.fxml;


    opens luisrrleal.com.threadcounterjava to javafx.fxml;
    exports luisrrleal.com.threadcounterjava;
}