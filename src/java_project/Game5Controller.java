package java_project;
import java.io.IOException;
import java.net.URL;
import java.util.Random;
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
public class Game5Controller implements Initializable {
    @FXML
    private Button reset_btn,start_btn,enter_user,home_btn;
    @FXML
    private TextField computer_entry,user_entry;
    @FXML
    private Label computer_lbl,user_lbl;
    Random random = new Random();
    int user=0,comp=0;
    public void onStart(ActionEvent event)
    {
        start_btn.setDisable(true);
        enter_user.setDisable(false);
        user_entry.setDisable(false);
        computer_entry.setDisable(false);
        computer_lbl.setText("Compuer: 0");
        computer_entry.setText("0");
    }
    public void onReset(ActionEvent event)
    {
        start_btn.setDisable(false);
        computer_lbl.setText("Ready ?");
        user_lbl.setText("");
        computer_entry.setText("");
        user_entry.setText("");
        enter_user.setDisable(true);
        user_entry.setDisable(true);
        computer_entry.setDisable(true);
        user=0;
        comp=0;
    }
    public void onEnter(ActionEvent event)
    {
        try
        {
            user=Integer.parseInt(user_entry.getText());
        }
        catch(Exception e)
        {
            reset_btn.fire();
            computer_lbl.setText("Invalid "+e.getMessage());
            user_lbl.setText("Please enter valid input");
        }
        if(comp<100 && user<100)
        {
            if(user>0 && user<=10)
            {
                user_lbl.setText("You: "+comp + " + " + user + " = " + (comp + user));
                user = comp + user;
                if (user < 100) 
                {
                    int temp=100-comp;
                    if(temp<=10)
                    {
                        computer_entry.setText(Integer.toString(temp));
                        comp = user + temp;
                        computer_lbl.setText("Computer: " + user + " + " + temp + " = " + comp);
                    }
                    else
                    {
                        int r = random.nextInt(1,10);
                        computer_entry.setText(Integer.toString(r));
                        comp = user + r;
                        computer_lbl.setText("Computer: " +user + " + " + r + " = " + comp);
                    }
                }
            }
            else
                user_lbl.setText("Please enter a number from 1 to 10");
        }
        if(user>=100)
        {
            computer_lbl.setText("Brilliant....You WON ;)");
            enter_user.setDisable(true);
            user_entry.setDisable(true);
            computer_entry.setDisable(true);
            user=0;
            comp=0;
        }
        else if(comp>=100)
        {
            String temp=computer_lbl.getText();
            computer_lbl.setText("Computer won this roundBetter luck next time :)");
            user_lbl.setText(user_lbl.getText()+"\n"+temp);
            enter_user.setDisable(true);
            user_entry.setDisable(true);
            computer_entry.setDisable(true);
            user=0;
            comp=0;
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