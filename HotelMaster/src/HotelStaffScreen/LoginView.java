package HotelStaffScreen;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

/**
 * Created by Heaven on 12/2/2015.
 */
public class LoginView extends Pane {
    private TextField usernameTextField;
    private PasswordField passwordField;
    private Button loginButton;
    private Label usernameText;
    private Label passwordText;
    private ImageView logo;

    public LoginView() {
        logo = new ImageView(getClass().getResource("icons/logo.png").toExternalForm());
        logo.setLayoutX(180);
        logo.setLayoutY(30);

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

        getChildren().addAll(logo, usernameText, passwordText, usernameTextField, passwordField, loginButton);
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
}