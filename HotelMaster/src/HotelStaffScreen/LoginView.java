package HotelStaffScreen;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
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

    public LoginView() {
        usernameText = new Label("Username:  ");
        usernameText.setLayoutX(250);
        usernameText.setLayoutY(120);

        passwordText = new Label("Password:  ");
        passwordText.setLayoutX(250);
        passwordText.setLayoutY(200);

        usernameTextField = new TextField();
        usernameTextField.setPromptText("username");
        usernameTextField.setLayoutX(350);
        usernameTextField.setLayoutY(120);

        passwordField = new PasswordField();
        passwordField.setPromptText("password");
        passwordField.setLayoutX(350);
        passwordField.setLayoutY(200);

        loginButton = new Button("Login");
        loginButton.setMinWidth(100);
        loginButton.setLayoutX(350);
        loginButton.setLayoutY(300);

        getChildren().addAll(usernameText, passwordText, usernameTextField, passwordField, loginButton);
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