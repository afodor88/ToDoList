module JavaFxApplication {
    requires javafx.controls;
    requires javafx.fxml;
    //if below red, download Java look and feel Graphics Repository https://www.oracle.com/java/technologies/java-look-and-feel-graphics-repository.html
    requires jlfgr;

    opens com.alex.todolist;
}