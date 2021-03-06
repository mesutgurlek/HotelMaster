package HotelStaffScreen;

import HotelEntities.Hotel;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

import java.util.Observable;
import java.util.Observer;

/**
 * Created by Heaven on 12/2/2015.
 */
public class LoginView extends Pane implements Observer {
    private TextField usernameTextField;
    private PasswordField passwordField;
    private Button loginButton;
    private Label usernameText;
    private Label passwordText;
    private ImageView logo;
    private Hotel hotel;
    private ImageView loginImage1;

    public LoginView(Hotel hotel) {
        this.hotel = hotel;
        hotel.subscribe(this);

        loginImage1 = new ImageView(getClass().getResource("icons/hotel_WelcomePage.png").toExternalForm());
        loginImage1.setLayoutX(450);
        loginImage1.setLayoutY(60);


        logo = new ImageView(getClass().getResource("icons/logo.png").toExternalForm());
        logo.setLayoutX(200);
        logo.setLayoutY(0);

        usernameText = new Label("Username:  ");
        usernameText.setLayoutX(150);
        usernameText.setLayoutY(120);

        passwordText = new Label("Password:  ");
        passwordText.setLayoutX(150);
        passwordText.setLayoutY(200);

        usernameTextField = new TextField();
        usernameTextField.setPromptText("username");
        usernameTextField.setLayoutX(250);
        usernameTextField.setLayoutY(120);

        passwordField = new PasswordField();
        passwordField.setPromptText("password");
        passwordField.setLayoutX(250);
        passwordField.setLayoutY(200);

        loginButton = new Button("Login");
        loginButton.setMinWidth(100);
        loginButton.setLayoutX(250);
        loginButton.setLayoutY(300);

        getChildren().addAll(loginImage1, logo, usernameText, passwordText, usernameTextField, passwordField, loginButton);
    }

    public TextField getUsernameTextField() {
        return usernameTextField;
    }

    public void setUsernameTextField(TextField usernameTextField) {
        this.usernameTextField = usernameTextField;
    }

    public PasswordField getPasswordField() {
        return passwordField;
    }

    public void setPasswordField(PasswordField passwordField) {
        this.passwordField = passwordField;
    }

    public Button getLoginButton() {
        return loginButton;
    }

    public void setLoginButton(Button loginButton) {
        this.loginButton = loginButton;
    }

    @Override
    public void update(Observable o, Object arg) {

    }
}