/* Designer: Kevin Recupero
 * Class: Survey of Programming languages
 * Professor: Sheusi
 * Date: 10.02.2019
 */

//hello

package application;
	
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application {
	// meat = 1oz, vegie = 1/2 cup, fruit = 1 small, milk = 1 cup, bread = 1 slice, fat = 1oz
	int meat = 73, vegie = 28, fruit = 40, milk = 170, bread = 68, fat = 45;
	
	Alert infoAlert = new Alert(AlertType.INFORMATION);
	Button InfoBtn = new Button("Calorie Info");
	
	Button Calculate = new Button("Calculate");
	Label Calclbl = new Label("");
	
	Button Halfer = new Button("Add 1/2");
	TextField HalfTxt = new TextField("");
	
	Button Mabtn = new Button("Add");
	Button Mrbtn = new Button("Remove");
	Button Vabtn = new Button("Add");
	Button Vrbtn = new Button("Remove");
	Button Fabtn = new Button("Add");
	Button Frbtn = new Button("Remove");
	Button MIabtn = new Button("Add");
	Button MIrbtn = new Button("Remove");
	Button Babtn = new Button("Add");
	Button Brbtn = new Button("Remove");
	Button FAabtn = new Button("Add");
	Button FArbtn = new Button("Remove");
	
	Label Melbl = new Label("Meat");
	Label Vlbl = new Label("Vegies");
	Label Frlbl = new Label("Fruit");
	Label Milbl = new Label("Milk");
	Label Brlbl = new Label("Bread");
	Label Falbl = new Label("Fat");
	
	Label MeAlbl = new Label("0.0");
	Label VAlbl = new Label("0.0");
	Label FrAlbl = new Label("0.0");
	Label MiAlbl = new Label("0.0");
	Label BrAlbl = new Label("0.0");
	Label FaAlbl = new Label("0.0");
	
	VBox Nbox = new VBox();
	VBox Abox = new VBox();
	VBox Tbox = new VBox();
	VBox Rbox = new VBox();
	HBox vBox = new HBox();
	
	@Override
	public void start(Stage primaryStage) {
		setStage();
		setBtns();
		try {
			Scene scene = new Scene(vBox, 365, 304);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setResizable(false);
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
	
	public void setStage() {
		//This will be a dialog box with the calorie information
		infoAlert.setTitle("Calorie Information");
		infoAlert.setContentText("1 oz------------Meat--------------" + meat + "\r\n1/2 cup--------Vegie-------------" + vegie +
				"\r\nSmall-----------Fruit--------------" + fruit + "\r\n1 cup-----------Milk-------------" + milk +
				"\r\n1 slice---------Bread--------------" + bread + "\r\n1 oz------------Fat----------------" + fat);
		infoAlert.setHeaderText(null);
		
		// this is setting up the layout of the GUI
		Tbox.getChildren().addAll(MeAlbl, VAlbl, FrAlbl, MiAlbl, BrAlbl, FaAlbl, HalfTxt, Calclbl);
		Abox.getChildren().addAll(Mabtn, Vabtn, Fabtn, MIabtn, Babtn, FAabtn, Halfer, Calculate, InfoBtn);
		Nbox.getChildren().addAll(Melbl, Vlbl, Frlbl, Milbl, Brlbl, Falbl);
		Rbox.getChildren().addAll(Mrbtn, Vrbtn, Frbtn, MIrbtn, Brbtn, FArbtn);
		vBox.getChildren().addAll(Nbox, Abox, Tbox, Rbox);
		
		// Adding some space to make it look nicer and line up evenly
		Abox.setSpacing(10);
		Nbox.setSpacing(18);
		Tbox.setSpacing(18);
		Rbox.setSpacing(10);
		vBox.setSpacing(15);
	}
	
	public void setBtns() {
		// The InfoBtn will popup a dialog with the calorie information
		InfoBtn.setOnAction(e->{
			infoAlert.showAndWait();
		});
		
		// Calculate button will calculate the total calories and display it.
		Calculate.setOnAction(e->{
			double Total = ((meat * Double.parseDouble(MeAlbl.getText()) + (vegie * Double.parseDouble(VAlbl.getText()) +
					(fruit * Double.parseDouble(FrAlbl.getText())) + (milk * Double.parseDouble(MiAlbl.getText())) + 
					(bread * Double.parseDouble(BrAlbl.getText())) + (fat * Double.parseDouble(FaAlbl.getText())))));
			Calclbl.setText(Double.toString(Total) + " Calories");
		});
		
		
		// Halfer button allows addition of half of the standard ingrediant size.
		Halfer.setOnAction(e->{
			if (HalfTxt.getText().toLowerCase().contentEquals("meat")) {
				addAmt(MeAlbl, .5);
			}else if(HalfTxt.getText().toLowerCase().contentEquals("vegies")) {
				addAmt(Vlbl, .5);
			}else if(HalfTxt.getText().toLowerCase().contentEquals("fruit")) {
				addAmt(FrAlbl, .5);
			}else if(HalfTxt.getText().toLowerCase().contentEquals("milk")) {
				addAmt(MiAlbl, .5);
			}else if(HalfTxt.getText().toLowerCase().contentEquals("bread")) {
				addAmt(BrAlbl, .5);
			}else if(HalfTxt.getText().toLowerCase().contentEquals("fat")) {
				addAmt(FaAlbl, .5);
			}
		});
		
		/* if there is an 'a' before 'btn' then it is an add 1 button
		 * if there is a 'r' before 'btn' then it is a minus 1 button
		 */
		Mabtn.setOnAction(e->{
			addAmt(MeAlbl, 1);
		});
		Mrbtn.setOnAction(e->{
			remAmt(MeAlbl, 1);
		});
		
		Vabtn.setOnAction(e->{
			addAmt(VAlbl, 1);
		});
		Vrbtn.setOnAction(e->{
			remAmt(VAlbl, 1);
		});
		
		Fabtn.setOnAction(e->{
			addAmt(FrAlbl, 1);
		});
		Frbtn.setOnAction(e->{
			remAmt(FrAlbl, 1);
		});
		
		MIabtn.setOnAction(e->{
			addAmt(MiAlbl, 1);
		});
		MIrbtn.setOnAction(e->{
			remAmt(MiAlbl, 1);
		});
		
		Babtn.setOnAction(e->{
			addAmt(BrAlbl, 1);
		});
		Brbtn.setOnAction(e->{
			remAmt(BrAlbl, 1);
		});
		
		FAabtn.setOnAction(e->{
			addAmt(FaAlbl, 1);
		});
		FArbtn.setOnAction(e->{
			remAmt(FaAlbl, 1);
		});
	}
	
	public void addAmt(Label lbl,double amt) {
		// This adds the specified amount to the designated label
		double amount = 0;
		amount = Double.parseDouble(lbl.getText()) + amt;
		lbl.setText(Double.toString(amount));
	}
	
	public void remAmt(Label lbl, double amt) {
		// This removes the specified amount from the designated label
		double amount = 0;
		amount = Double.parseDouble(lbl.getText());
		if (amount < 1 && amount > 0) {
			amount -= .5;
		}else if (!(amount <= 0)) {
			amount -= amt;
		}
		lbl.setText(Double.toString(amount));
	}
}
