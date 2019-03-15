package sample.Controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import sample.DBServices.Account;
import sample.DBServices.DBHandler;

public class RegisterController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField regNameField;

    @FXML
    private TextField regLoginField;

    @FXML
    private TextField regSurnameField;

    @FXML
    private PasswordField regPassField;

    @FXML
    private TextField Sign;

    @FXML
    private RadioButton gender1;

    @FXML
    private RadioButton gender2;

    @FXML
    private Button regButton;



    @FXML
    void initialize() {
        regButton.setOnAction(event -> {
            signUpNewUser();
            regButton.getScene().getWindow().hide();
            loadPage("/sample/ViewFXMLs/sample.fxml");

        });

    }

    private void signUpNewUser(){
         String name = regNameField.getText();
         String surname = regSurnameField.getText();
         String password = regPassField.getText();
         String login = regLoginField.getText();;
         String genger;
         String sign = Sign.getText();
         if(gender1.isSelected()){
             genger = "Male";
         } else {
             genger = "Female";
         }

         Account user = new Account(name, surname, password, login, genger, sign);

        DBHandler dbHandler = new DBHandler();
        dbHandler.signUp(user);
    }

    private void loadPage(String url){
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource(url));

        try {
            fxmlLoader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Parent root = fxmlLoader.getRoot();
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.showAndWait();
    }
}

