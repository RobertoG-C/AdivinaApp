package dad.adivina;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class AdivinaApp extends Application {

	private Label infoLabel;
	private TextField numeroField;
	private Button comprobarButton;
	private VBox root;
	int numAleatorio;
	int intentos;

	public AdivinaApp() {
		numAleatorio=aleatorio();
	}

	@Override
	public void start(Stage primaryStage) throws Exception {

		infoLabel = new Label("Introduce un número del 1 al 100");

		numeroField = new TextField();
		numeroField.setMaxWidth(150);

		comprobarButton = new Button("Comprobar");
		comprobarButton.setDefaultButton(true);
		comprobarButton.setOnAction(e -> comprobarButtonOnAction());

		root = new VBox(5, infoLabel, numeroField, comprobarButton);
		root.setAlignment(Pos.CENTER);

		Scene scene = new Scene(root, 320, 200);
		primaryStage.setTitle("Adivina el número");
		primaryStage.setScene(scene);
		primaryStage.show();

	}

	private void comprobarButtonOnAction() {
		
		String dato = numeroField.getText();
		try {
		int num=(Integer.parseInt(dato));
		if (num>0 && num <=100) {
		if (num==numAleatorio) {
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("Adivina App");
			alert.setHeaderText("¡Has Ganado!");
			alert.setContentText("Intentos:"+intentos);
			alert.showAndWait();
			intentos=0;
			numAleatorio=aleatorio();
			
		} else {  
				if (num>numAleatorio) {
				Alert alert = new Alert(AlertType.WARNING);
				alert.setTitle("AdivinaApp");
				alert.setHeaderText("Es menor que "+num);
				alert.setContentText("Vuelve a intentarlo");
				alert.showAndWait();
				intentos++;
			} 
			else {
				Alert alert = new Alert(AlertType.WARNING);
				alert.setTitle("AdivinaApp");
				alert.setHeaderText("Es mayor que "+num);
				alert.setContentText("Vuelve a intentarlo");
				alert.showAndWait();
				intentos++;
			}
		}
		} else {
			errorData();
		}
		} catch (java.lang.NumberFormatException e) {
			errorData();
		}
		

	}
	public int aleatorio() {
		return (int) (Math.random() * 100 + 1);
	}
	public void errorData() {
		Alert alert = new Alert(AlertType.ERROR);
		alert.setTitle("AdivinaApp");
		alert.setHeaderText("ERROR");
		alert.setContentText("El número introducido no es válido");
		alert.showAndWait();
	}
 


	public static void main(String[] args) {
		launch(args);

	}

}
