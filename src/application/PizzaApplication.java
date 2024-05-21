/**********************************************
Workshop 2
Course: APD545
Last Name: Kotadia
First Name: Khushi
ID: 167632215
Section: NAA
This assignment represents my own work in accordance with Seneca Academic Policy.
Signature
Date:11-02-2024
**********************************************/

package application;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.Parent;
import javafx.fxml.FXMLLoader;

public class PizzaApplication extends Application {
	@Override
	public void start(Stage ps) throws Exception {
			Parent root = FXMLLoader.load(getClass().getResource("/application/PizzaShop.fxml"));
		
			Scene scene = new Scene(root);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			ps.setTitle("My Pizza Shop");
			ps.setScene(scene);
			ps.show();
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
