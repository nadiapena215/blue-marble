package hellofx;


import java.time.LocalDate;
import javax.naming.directory.InvalidAttributesException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.CheckBox;
import javafx.scene.control.DatePicker;
import javafx.scene.effect.ColorAdjust;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
 
public class BlueMarbleController {
	@FXML
    private DatePicker dateInput;

    @FXML
    private Text textDescription;

    @FXML
    private ImageView earthImage;

    @FXML
    private CheckBox enhancedImage;

    @FXML
    private CheckBox blackAndWhite;


    @FXML
    void dateEnter(ActionEvent event) {
    	LocalDate Date = LocalDate.now();
		LocalDate dateEntered = LocalDate.of(dateInput.getValue().getYear(), dateInput.getValue().getMonthValue(), dateInput.getValue().getDayOfMonth());
		try {
			if(dateEntered.isAfter(Date)) throw  new InvalidAttributesException();
			BlueMarble blueMarble = new BlueMarble ();
			if((dateInput.getValue().getYear() == 2018 && dateInput.getValue().getMonthValue() > 6) && enhancedImage.isSelected()) {
				enhancedImage.setSelected(false);
			}
			blueMarble.setDate(dateInput.getValue().getYear() + "-0" + dateInput.getValue().getMonthValue() + "-" + dateInput.getValue().getDayOfMonth());
			blueMarble.setEnhanced(enhancedImage.isSelected());
			earthImage.setImage(new Image(blueMarble.getImage()));
			
			if(blackAndWhite.isSelected()) {
				ColorAdjust color = new ColorAdjust();
				color.setSaturation(-1);
				color.setContrast(1);
				earthImage.setEffect(color);
			}else {
				ColorAdjust color = new ColorAdjust();
				color.setSaturation(0);
				color.setContrast(0);
				earthImage.setEffect(color);
			}
		}catch(InvalidAttributesException error) {
			Alert alert = new Alert(AlertType.WARNING);
			alert.setTitle("Date is after June 2018");
			alert.showAndWait();
		}catch(Exception error2) {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("ERROR");
			alert.setContentText("Invalid date!");
			alert.showAndWait();
		}
    }
	
    }
