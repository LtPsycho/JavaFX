package lt.kvk.i9_2.jauga_dovydas.view;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.Alert.AlertType;
import lt.kvk.i9_2.jauga_dovydas.Main;
import lt.kvk.i9_2.jauga_dovydas.model.Daiktas;


public class DataOverviewController {
	private Main main;
	
	@FXML
	 private TableView<Daiktas> daiktasTable;
	@FXML
	 private TableColumn<Daiktas, String> idColumn;
	@FXML
	 private TableColumn<Daiktas, String> parduotuveColumn;
	@FXML
	 private TableColumn<Daiktas, String> pavadinimasColumn;
	@FXML
	 private TableColumn<Daiktas, Integer> kiekisColumn;
	@FXML
	 private TableColumn<Daiktas, Integer> kiekisUzsakColumn;
	@FXML
	 private TableColumn<Daiktas, Float> kainaColumn;
	@FXML
	 private TableColumn<Daiktas, String> spalvaColumn;
	
	@FXML
	 private Label idLabel;
	@FXML
	 private Label parduotuveLabel;
    @FXML
	 private Label pavadinimasLabel;
	@FXML
	 private Label kiekisLabel;
	
	public DataOverviewController() {
		
	}
	
	@FXML
    private void initialize() {
        // Initialize the person table with the two columns.
		idColumn.setCellValueFactory(cellData -> cellData.getValue().getIdProperty());
		parduotuveColumn.setCellValueFactory(cellData -> cellData.getValue().getParduotuveProperty());
		pavadinimasColumn.setCellValueFactory(cellData -> cellData.getValue().getPavadinimasProperty());
		kiekisColumn.setCellValueFactory(cellData -> cellData.getValue().getKiekisProperty().asObject());
		kiekisUzsakColumn.setCellValueFactory(cellData -> cellData.getValue().getKiekisUzsakProperty().asObject());
		kainaColumn.setCellValueFactory(cellData -> cellData.getValue().getKainaProperty().asObject());
		spalvaColumn.setCellValueFactory(cellData -> cellData.getValue().getSpalvaProperty());
		
    }
	
	 public void setMainApp(Main main) {
	        this.main = main;

	        // Add observable list data to the table
	        daiktasTable.setItems(main.getDaiktai());
	        
	    }
	 public void printInfo(){
		 Alert alert = new Alert(AlertType.INFORMATION);
		  alert.setTitle("Information Dialog");
		  alert.setHeaderText(null);
		  alert.setContentText("Duomenys buvo surikiuoti");
		  alert.showAndWait();
	 }
	
}
