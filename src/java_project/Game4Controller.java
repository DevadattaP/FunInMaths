package java_project;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import java.util.Random;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
public class Game4Controller implements Initializable {
    @FXML
    private Label erased_number,instruction_lbl;
    @FXML
    private Button enter_btn,reset_btn,home_btn;
    @FXML
    private TextField value_entered;
    Random random=new Random();
    int r=random.nextInt(1,10);
    public static int add(int val)
    {
        int res=0,rem,temp=val;
        while(temp>0)
        {
            rem=temp%10;
            temp=temp/10;
            res=res+rem;
        }
        return res;
    }
    public void enterValue(ActionEvent event)
    {
        if(value_entered.getText().isEmpty())
            erased_number.setText("Please enter the specified digits");
        else
        {
            try
            {
                int num=Integer.parseInt(value_entered.getText());
                while(num%10 !=num)
                {
                    num=add(num);
                }
                if(num==0 || num==9)
                    erased_number.setText("You have erased 9");
                else
                    erased_number.setText(9-num +" is the digit you erased");
                enter_btn.setDisable(true);
            }
            catch(Exception e)
            {
                reset_btn.fire();
                enter_btn.setDisable(true);
                erased_number.setText("Invalid "+e.getMessage());
            }
        
        }
    }
    public void clearField(ActionEvent event)
    {
        value_entered.setText("");
        erased_number.setText("");
        enter_btn.setDisable(false);
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
        instruction_lbl.setText(instruction_lbl.getText()+(r*9));
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