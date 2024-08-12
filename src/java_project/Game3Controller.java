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
public class Game3Controller implements Initializable {
    @FXML
    private TextField sum1,sum2,sum3,sum4,sum5,sum6,sum7,sum8,sum9,sum10;
    @FXML
    private Label mobile_number;
    @FXML
    private Button enter_sum,home_btn,reset_btn;
    public void findNumber(ActionEvent event)
    {
        if(sum1.getText().isEmpty()||sum2.getText().isEmpty()||
                sum3.getText().isEmpty()||sum4.getText().isEmpty()||
                sum5.getText().isEmpty()||sum6.getText().isEmpty()||
                sum7.getText().isEmpty()||sum8.getText().isEmpty()||
                sum9.getText().isEmpty()||sum10.getText().isEmpty())
            mobile_number.setText("Please fill all the sums");
        else
        {
            try
            {
        int[] sum = new int[10];
        sum[0]=Integer.parseInt(sum1.getText());
        sum[1]=Integer.parseInt(sum2.getText());
        sum[2]=Integer.parseInt(sum3.getText());
        sum[3]=Integer.parseInt(sum4.getText());
        sum[4]=Integer.parseInt(sum5.getText());
        sum[5]=Integer.parseInt(sum6.getText());
        sum[6]=Integer.parseInt(sum7.getText());
        sum[7]=Integer.parseInt(sum8.getText());
        sum[8]=Integer.parseInt(sum9.getText());
        sum[9]=Integer.parseInt(sum10.getText());
        int sum_even=0,sum_odd=0;
        for(int i=1;i<10;i++)
        {
            if(i%2==0)
                sum_odd+=sum[i];
            else
                sum_even+=sum[i];
        }
        int[] mob_num=new int[10];
        mob_num[1]=(sum_even-sum_odd)/2;
        mob_num[0]=sum[0]-mob_num[1];
        for(int i=2;i<10;i++)
            mob_num[i]=sum[i-1]-mob_num[i-1];
        StringBuffer sb=new StringBuffer();
        for(int i=0;i<10;i++)
            sb.append(mob_num[i]);
        mobile_number.setText("Your mobile number is "+sb);
        enter_sum.setDisable(true);
            }
            catch(Exception e)
            {
                reset_btn.fire();
                mobile_number.setText("Invalid "+e.getMessage());
            }
        }
    }
    public void clear(ActionEvent event)
    {
        sum1.setText("");
        sum2.setText("");
        sum3.setText("");
        sum4.setText("");
        sum5.setText("");
        sum6.setText("");
        sum7.setText("");
        sum8.setText("");
        sum9.setText("");
        sum10.setText("");
        enter_sum.setDisable(false);
        mobile_number.setText("");
    }
    /**
     * Initializes the controller class.
     */
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