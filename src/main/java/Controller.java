import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class Controller {

    @FXML
    private Button aboutButton;

    @FXML
    private Label test1;

    @FXML
    private Button statm;




    @FXML
    public void start(){

        Connection connection = new Connection();

        connection.connect();




    }



}
