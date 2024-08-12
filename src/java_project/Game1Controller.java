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
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
public class Game1Controller implements Initializable {
    int low_limit,up_limit,guessed;
    char c = ' ';
    @FXML
    private TextField from_range,to_range;
    @FXML
    private Label number_display;
    @FXML
    private Button set_btn,less_btn,equal_btn,greater_btn,home_btn,reset_btn;
    public static int guessNum(int low_limit,int up_limit)
    {
        return ((up_limit-low_limit)/2 +low_limit);
    }
    @FXML
    public void setRange(ActionEvent event)
    {
        if(from_range.getText().isEmpty() || to_range.getText().isEmpty())
        {
            number_display.setText("Please set range first");
        }
        else
        {
            try
            {
            low_limit=Integer.parseInt(from_range.getText());
            up_limit=Integer.parseInt(to_range.getText());
            guessed = guessNum(low_limit, up_limit);
            number_display.setText("Is it "+Integer.toString(guessed)+" ?");
            set_btn.setDisable(true);
            from_range.setDisable(true);
            to_range.setDisable(true);
            less_btn.setDisable(false);
            equal_btn.setDisable(false);
            greater_btn.setDisable(false);
            }
            catch(Exception e)
            {
                reset_btn.fire();
                number_display.setText("Invalid "+e.getMessage());
            }
        }
    }
    public void lessThan(ActionEvent event)
    {
        if(from_range.getText().isEmpty() || to_range.getText().isEmpty())
        {
            number_display.setText("Please set range first");
        }
        else
        {
            c='<';
            up_limit = guessed;
            guessed = guessNum(low_limit, up_limit);
            number_display.setText("Is it "+Integer.toString(guessed)+" ?");
        }
    }
    public void greaterThan(ActionEvent event)
    {
        if(from_range.getText().isEmpty() || to_range.getText().isEmpty())
        {
            number_display.setText("Please set range first");
        }
        else
        {
            c='>';
            low_limit = guessed;
            guessed = guessNum(low_limit, up_limit);
            number_display.setText("Is it "+Integer.toString(guessed)+" ?");
        }
    }
    public void equalTo(ActionEvent event)
    {
        if(from_range.getText().isEmpty() || to_range.getText().isEmpty())
        {
            number_display.setText("Please set range first");
        }
        else
        {
            number_display.setText("Bingo..."+Integer.toString(guessed)+" is your number");
            less_btn.setDisable(true);
            equal_btn.setDisable(true);
            greater_btn.setDisable(true);
        }
    }
    private Stage stage;
    private Scene scene;
    private Parent root;
    public void onHome(ActionEvent event) throws IOException
    {
        Parent root =FXMLLoader.load(getClass().getResource("FXML.fxml"));
        stage=(Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public void onReset(ActionEvent event)
    {
        number_display.setText("");
        set_btn.setDisable(false);
        from_range.setDisable(false);
        to_range.setDisable(false);
        from_range.setText("");
        to_range.setText("");
        less_btn.setDisable(true);
        equal_btn.setDisable(true);
        greater_btn.setDisable(true);
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        ImageView image = new ImageView(getClass().getResource("home_icon.png").toExternalForm());
        image.setFitHeight(25);
        image.setFitWidth(25);
        home_btn.setMaxSize(30, 30);
        home_btn.setGraphic(image);
        ImageView image1 = new ImageView(getClass().getResource("reset_icon.png").toExternalForm());
        image1.setFitHeight(25);
        image1.setFitWidth(25);
        reset_btn.setMaxSize(30, 30);
        reset_btn.setGraphic(image1);
    }
}