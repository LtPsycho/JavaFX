package lt.kvk.i9_2.jauga_dovydas;
	
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Optional;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import lt.kvk.i9_2.jauga_dovydas.model.Daiktas;
import lt.kvk.i9_2.jauga_dovydas.view.DataOverviewController;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;

public class Main extends Application {
	private Stage primaryStage;
	private BorderPane rootLayout;
	private ObservableList<Daiktas> daiktai = FXCollections.observableArrayList();
	private String id;
	private String parduotuve;
	private String pavadinimas;
	private int kiekis;
	private float kaina;
	String spalva;
	private int kiekisUzsak;
	public Main() throws IOException{
		try (BufferedReader br = new BufferedReader(new FileReader("src\\lt\\kvk\\i9_2\\jauga_dovydas\\duomenys\\sandelys.txt"))) {
			BufferedReader br2 = new BufferedReader(new FileReader("src\\lt\\kvk\\i9_2\\jauga_dovydas\\duomenys\\uzsakymai.txt"));
			String eilute;
			br.readLine();
			br2.readLine();
			while ((eilute = br.readLine()) != null) {
				String[] dalys = eilute.split(";\\s", -1);
				id = dalys[0];
				parduotuve = dalys[1];
				pavadinimas = dalys[2];
				kiekis = Integer.parseInt(dalys[3]);
				eilute = br2.readLine();
				dalys = eilute.split(";\\s", -1);
				id = dalys[0];
				kiekisUzsak = Integer.parseInt(dalys[1]);
				kaina = Float.parseFloat(dalys[2]);
				spalva = dalys[3];
				daiktai.add(new Daiktas(id, parduotuve, pavadinimas, kiekis, kiekisUzsak, kaina, spalva ));
				
			}
			br.close();
			br2.close();
		} catch (java.util.NoSuchElementException e) {
			System.out.println("nebera daugiau elementu");
		}
		
	}
	
	 @Override
	    public void start(Stage primaryStage) {
	        this.primaryStage = primaryStage;
	        this.primaryStage.setTitle("Sandelio duomenys");
	        this.primaryStage.setOnCloseRequest(event -> {
	        	Alert alert = new Alert(AlertType.CONFIRMATION);
	        	alert.setTitle("Confirmation Dialog");
	        	alert.setHeaderText("Ar norite išjungti programą?");

	        	Optional<ButtonType> result = alert.showAndWait();
	        	if (result.get() == ButtonType.OK){
	        	    System.exit(0);
	        	} else {
	        	   event.consume();
	        	}
			});
	        initRootLayout();
	        showPersonOverview();
	    

	    }

	    /**
	     * Initializes the root layout.
	     */
	    public void initRootLayout() {
	        try {
	            // Load root layout from fxml file.
	            FXMLLoader loader = new FXMLLoader();
	            loader.setLocation(Main.class.getResource("view/RootLayout.fxml"));
	            rootLayout = loader.load();

	            // Show the scene containing the root layout.
	            Scene scene = new Scene(rootLayout);
	            primaryStage.setScene(scene);
	            primaryStage.show();
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    }

	    /**
	     * Shows the person overview inside the root layout.
	     */
	    public void showPersonOverview() {
	        try {
	            // Load person overview.
	            FXMLLoader loader = new FXMLLoader();
	            loader.setLocation(Main.class.getResource("view/DataOverview.fxml"));
	            AnchorPane dataOverview = loader.load();

	            // Set person overview into the center of root layout.
	            rootLayout.setCenter(dataOverview);
	            
	            DataOverviewController controller = loader.getController();
	            controller.setMainApp(this);
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    }

	    /**
	     * Returns the main stage.
	     * @return
	     */
	    public Stage getPrimaryStage() {
	        return primaryStage;
	    }

	    public static void main(String[] args) {
	        launch(args);
	    }
	    
	    public ObservableList<Daiktas> getDaiktai() {
	        return daiktai;
	    }
	    
	  
}
