package java_project;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
public class Game2Controller implements Initializable {
    @FXML
    private TextField bd_entry;
    @FXML
    private Button enter_btn,home_btn,reset_btn;
    @FXML
    private Label bd_label;

    public void enterButton(ActionEvent event)
    {
        if(bd_entry.getText().isEmpty())
        {
            bd_label.setText("Please enter the result of your calculation");
        }
        else
        {
            enter_btn.setDisable(true);
            try
            {
            int number=Integer.parseInt(bd_entry.getText());
            double result=number/10.0;
            result=result+11;
            result=result/100;
            int month=(int)result;
            result=result-month;
            int day=(int)(Math.round(result*100));
            if(day>0 && day<32)
            {
                switch(month)
                {
                    case 1->bd_label.setText("Your Birth Date is "+day+" January");
                    case 2->bd_label.setText("Your Birth Date is "+day+" February");
                    case 3->bd_label.setText("Your Birth Date is "+day+" March");
                    case 4->bd_label.setText("Your Birth Date is "+day+" April");
                    case 5->bd_label.setText("Your Birth Date is "+day+" May");
                    case 6->bd_label.setText("Your Birth Date is "+day+" June");
                    case 7->bd_label.setText("Your Birth Date is "+day+" July");
                    case 8->bd_label.setText("Your Birth Date is "+day+" August");
                    case 9->bd_label.setText("Your Birth Date is "+day+" September");
                    case 10->bd_label.setText("Your Birth Date is "+day+" October");
                    case 11->bd_label.setText("Your Birth Date is "+day+" November");
                    case 12->bd_label.setText("Your Birth Date is "+day+" December");
                    default->{bd_label.setText("Please do correct calculations");
                bd_entry.setDisable(true);}
                }
            }
            else
            {
                bd_label.setText("Please do correct calculations");
                bd_entry.setDisable(true);
            }
            }
            catch(Exception e)
            {
                reset_btn.fire();
                enter_btn.setDisable(true);
                bd_entry.setDisable(true);
                bd_label.setText("Invalid "+e.getMessage());
            }
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
        enter_btn.setDisable(false);
        bd_entry.setDisable(false);
        bd_entry.setText("");
        bd_label.setText("");
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