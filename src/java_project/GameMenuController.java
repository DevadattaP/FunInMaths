package java_project;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.RadioButton;
import javafx.stage.Stage;
public class GameMenuController implements Initializable {
    private Stage stage;
    private Scene scene;
    private Parent root;
    @FXML
    private RadioButton guess_no,birthday,mob_no,erased_no,century;
    public void playGame(ActionEvent event) throws IOException
    {
        if(guess_no.isSelected())
        {
            root =FXMLLoader.load(getClass().getResource("Game1.fxml"));
            stage=(Stage)((Node)event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }
        else if(birthday.isSelected())
        {
            root =FXMLLoader.load(getClass().getResource("Game2.fxml"));
            stage=(Stage)((Node)event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }
        else if(mob_no.isSelected())
        {
            root =FXMLLoader.load(getClass().getResource("Game3.fxml"));
            stage=(Stage)((Node)event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }
        else if(erased_no.isSelected())
        {
            root =FXMLLoader.load(getClass().getResource("Game4.fxml"));
            stage=(Stage)((Node)event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }
        else if(century.isSelected())
        {
            root =FXMLLoader.load(getClass().getResource("Game5.fxml"));
            stage=(Stage)((Node)event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }
}