package lt.kvk.i9_2.jauga_dovydas.view;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceDialog;
import javafx.scene.control.Menu;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class WindowController {
	
	@FXML
	public Button button;
	@FXML
    private void initialize() {
		

	}
	  public void openHelp(){
		    try{
	            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/lt/kvk/i9_2/jauga_dovydas/view/HelpWindow.fxml"));
	            Parent root = fxmlLoader.load();
	            Stage stage = new Stage();
	            stage.setTitle("Help");
	            stage.setScene(new Scene(root));  
	            stage.show();
	          }
		    catch (IOException e) {
	            e.printStackTrace();
	        }
		}
	  public void openAbout(){
		    try{
	            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/lt/kvk/i9_2/jauga_dovydas/view/AboutWindow.fxml"));
	            Parent root = fxmlLoader.load();
	            Stage stage = new Stage();
	            stage.setTitle("About");
	            stage.setScene(new Scene(root));  
	            stage.show();
	          }
		    catch (IOException e) {
	            e.printStackTrace();
	        }
		}
	  
	  public void closeWindow(){
		  Stage stage = (Stage) button.getScene().getWindow();
		  stage.close();
		}
	  public void exitApplication(){
		  System.exit(0);
	  }
	  public void setTextBold(){
		  button.setFont(Font.font(button.getFont().getFamily(), FontWeight.BOLD, button.getFont().getSize()));
		}
	  public void resetText(){
		  button.setFont(Font.font(button.getFont().getFamily(), FontWeight.NORMAL, button.getFont().getSize()));
		}
	  public void presentFileChoices(){
		  List<String> choices = new ArrayList<>();
		  choices.add("pridėti duomenu faila");
		  choices.add("pridėti rezultatu faila");

		  ChoiceDialog<String> dialog = new ChoiceDialog<>("pridėti duomenu faila", choices);
		  dialog.setTitle("Choice Dialog");
		  dialog.setHeaderText("Koki faila norite pridėti?");

		  // Traditional way to get the response value.
		  Optional<String> result = dialog.showAndWait();
		  if (result.isPresent()){
			  Alert alert = new Alert(AlertType.INFORMATION);
			  alert.setTitle("Information Dialog");
			  alert.setHeaderText(null);
			  alert.setContentText("Jus pasirinkote "+result.get());
			  alert.showAndWait();
		  }
	  }
}
