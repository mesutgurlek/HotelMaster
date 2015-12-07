package HotelStaffScreen;

import javafx.scene.control.*;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Line;

/**
 * Created by Heaven on 12/7/2015.
 */
public class RoomEditorView extends Pane {
    private Button backButton;
    private Button confirmButton;
    final ComboBox roomTypeBox;
    private Label roomTypeLabel;
    private Line separator1;
    private Label roomNolabel, floorNoLabel,dailyPriceLabel,adultCountLabel, childCountLabel, extraInfoLabel;
    private TextField roomNoField, floorNoField, dailyPriceField, adultCountField, childCountField;
    private TextArea extraInfoField;

    public RoomEditorView(){
        backButton = new Button("Back");
        backButton.setLayoutX(700);
        backButton.setLayoutY(25);
        backButton.setMinWidth(50);

        confirmButton = new Button("Confirm");
        confirmButton.setLayoutX(800);
        confirmButton.setLayoutY(25);

        separator1 = new Line(0,70, 950, 72);

        roomTypeLabel = new Label("Select Room Type: ");
        roomTypeLabel.setLayoutX(50);
        roomTypeLabel.setLayoutY(105);

        roomTypeBox  = new ComboBox();
        roomTypeBox.getItems().addAll(
                "regular",
                "family",
                "king"
        );
        roomTypeBox.setLayoutX(170);
        roomTypeBox.setLayoutY(100);
        roomTypeBox.setValue("regular");

        roomNolabel = new Label("Room Number: ");
        roomNolabel.setLayoutX(50);
        roomNolabel.setLayoutY(150);

        roomNoField = new TextField();
        roomNoField.setPromptText("room no");
        roomNoField.setLayoutX(150);
        roomNoField.setLayoutY(150);

        floorNoLabel = new Label("Floor No: ");
        floorNoLabel.setLayoutX(50);
        floorNoLabel.setLayoutY(200);

        floorNoField = new TextField();
        floorNoField.setPromptText("floor no");
        floorNoField.setLayoutX(150);
        floorNoField.setLayoutY(200);

        dailyPriceLabel = new Label("Daily Price: ");
        dailyPriceLabel.setLayoutX(50);
        dailyPriceLabel.setLayoutY(250);

        dailyPriceField = new TextField();
        dailyPriceField.setPromptText("daily price");
        dailyPriceField.setLayoutX(150);
        dailyPriceField.setLayoutY(250);

        adultCountLabel = new Label("Adult Count: ");
        adultCountLabel.setLayoutX(50);
        adultCountLabel.setLayoutY(300);

        adultCountField = new TextField();
        adultCountField.setPromptText("adult count");
        adultCountField.setLayoutX(150);
        adultCountField.setLayoutY(300);

        childCountLabel = new Label("Child Count: ");
        childCountLabel.setLayoutX(50);
        childCountLabel.setLayoutY(350);

        childCountField = new TextField();
        childCountField.setPromptText("child count");
        childCountField.setLayoutX(150);
        childCountField.setLayoutY(350);

        extraInfoLabel = new Label("Extra Information: ");
        extraInfoLabel.setLayoutX(50);
        extraInfoLabel.setLayoutY(400);

        extraInfoField = new TextArea();
        extraInfoField.setPromptText("extra info");
        extraInfoField.setPrefHeight(75);
        extraInfoField.setPrefWidth(200);
        extraInfoField.setLayoutX(150);
        extraInfoField.setLayoutY(400);

        getChildren().addAll(extraInfoField, extraInfoLabel, childCountField, childCountLabel, adultCountField, adultCountLabel, dailyPriceField, dailyPriceLabel, floorNoLabel, floorNoField, roomNolabel, roomNoField, roomTypeLabel, roomTypeBox, separator1, backButton, confirmButton);
    }


    public Button getBackButton() {
        return backButton;
    }

    public void setBackButton(Button backButton) {
        this.backButton = backButton;
    }

    public Button getConfirmButton() {
        return confirmButton;
    }

    public void setConfirmButton(Button confirmButton) {
        this.confirmButton = confirmButton;
    }

    public ComboBox getRoomTypeBox() {
        return roomTypeBox;
    }

    public TextField getRoomNoField() {
        return roomNoField;
    }

    public void setRoomNoField(TextField roomNoField) {
        this.roomNoField = roomNoField;
    }

    public TextField getFloorNoField() {
        return floorNoField;
    }

    public void setFloorNoField(TextField floorNoField) {
        this.floorNoField = floorNoField;
    }

    public TextArea getExtraInfoField() {
        return extraInfoField;
    }

    public void setExtraInfoField(TextArea extraInfoField) {
        this.extraInfoField = extraInfoField;
    }

    public TextField getDailyPriceField() {
        return dailyPriceField;
    }

    public void setDailyPriceField(TextField dailyPriceField) {
        this.dailyPriceField = dailyPriceField;
    }

    public TextField getChildCountField() {
        return childCountField;
    }

    public void setChildCountField(TextField childCountField) {
        this.childCountField = childCountField;
    }

    public TextField getAdultCountField() {
        return adultCountField;
    }

    public void setAdultCountField(TextField adultCountField) {
        this.adultCountField = adultCountField;
    }

}
