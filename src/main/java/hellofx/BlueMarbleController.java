package hellofx;

import java.io.InputStream;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.DialogPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;

public class BlueMarbleController {
	BlueMarble BlueMarble = new BlueMarble ();
	

    @FXML
    private DatePicker dateInput;

    @FXML
    private Text textDescription;

    @FXML
    private ImageView earthImage;

    @FXML
    private Button button;

    @FXML
    private DialogPane messagePane;


    @FXML
    void giveResult(ActionEvent event) {
    	LocalDate dateIn = dateInput.getValue();
    	String date = null;
    	if (dateIn != null) {
    		date = dateIn.toString();
    		BlueMarble.setDate(date);  
    		earthImage.setImage(new Image(BlueMarble.getImage()));
       	}
    	else {
    		messagePane.setContentText("Enter a Date before current day");
    	}
    	
    	

    }

}
