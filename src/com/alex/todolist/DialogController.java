package com.alex.todolist;

import com.alex.todolist.datamodel.TodoData;
import com.alex.todolist.datamodel.TodoItem;
import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.time.LocalDate;

public class DialogController {

    @FXML
    private TextField shortDescriptionField;
    @FXML
    private TextArea detailsArea;
    @FXML
    private DatePicker deadlinePicker;


    public TodoItem processResults() {
        String shortDescription = shortDescriptionField.getText().trim();
        String details = detailsArea.getText().trim();
        LocalDate deadlineValue = deadlinePicker.getValue();

        TodoItem newItem = new TodoItem(shortDescription, details, deadlineValue);
        TodoData.getInstance().addTodoItem(newItem);
        return newItem;
    }

    public TodoItem editItem(TodoItem item) {
        String shortDescription = shortDescriptionField.getText().trim();
        String details = detailsArea.getText().trim();
        LocalDate deadlineValue = deadlinePicker.getValue();

        int positionFound = TodoData.getInstance().getTodoItems().indexOf(item);
        TodoItem foundItem = TodoData.getInstance().getTodoItems().get(positionFound);
        foundItem.setShortDescription(shortDescription);
        foundItem.setDetails(details);
        foundItem.setDeadline(deadlineValue);

        return foundItem;
    }
}
