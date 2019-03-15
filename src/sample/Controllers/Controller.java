package sample.Controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import sample.DBServices.DBHandler;

import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class Controller {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private PasswordField welcomePassField;

    @FXML
    private Button enterButton;

    @FXML
    private Button registerButton;

    @FXML
    private TextField welcomeLoginField;



    @FXML
    void initialize() {
         registerButton.setOnAction(event ->{
             registerButton.getScene().getWindow().hide();
             loadPage("/sample/ViewFXMLs/register.fxml");
         });

         enterButton.setOnAction(event -> {
             String login = welcomeLoginField.getText().trim();
             String password = welcomePassField.getText().trim();

             if(!login.isEmpty() && !password.isEmpty()){
                 signIn(login, password);
             } else {
                 welcomeLoginField.setText("Login is empty!");
                 welcomePassField.setText("Password is empty!");
             }
         });

    }

    private void signIn(String login, String password) {
        DBHandler dbHandler = new DBHandler();
        ResultSet set = dbHandler.getResultSet(login, password);
        try {
            if(set.next()){
                enterButton.getScene().getWindow().hide();
                loadPage("/sample/ViewFXMLs/hellouser.fxml");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
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

