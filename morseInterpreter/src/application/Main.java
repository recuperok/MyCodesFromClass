package application;
	
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Hashtable;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class Main extends Application {
	public static final Stage mainStage = new Stage();
	Font f = new Font("Verdana", 20);
	
	String morseCode = "";
	
	Hashtable<String, String> morse = new Hashtable<String, String>();
	Text Alphatxt = new Text("A = .-       B = -...     C = -.-."
			+ "    D = -..     E = .        F = ..-.    G = --.      H = ....\n"
			+ "I  = ..        J = .---     K = -.-     L = .-..    M = --    "
			+ "N = -.     O = ---      P = .--.\nQ = --.-   R = .-.       "
			+ "S = ...      E = .        T = -      U = ..-     V = ...-      "
			+ "W = .--\nX = -..-    Y = -.--     Z = --..\n0 = -----    1 = .----     "
			+ "2 = ..---    3 = ...--    4 = ....-   5 = .....   6 = -....\n"
			+ "7 = --...      8 = ---..     9 = ----. "),
			Display = new Text(""), Output = new Text("");
	
	Button Mabtn = new Button("Dash"), Mrbtn = new Button("Dot"), 
			Spbtn = new Button("Space"), Babtn = new Button("Back"),
			Imbtn = new Button("Import");
	
	VBox vbox = new VBox();
	HBox hbox = new HBox(), debox = new HBox();
	
	@Override
	public void start(Stage primaryStage) throws ClassNotFoundException, IOException {
		setup();
		Scene scene = new Scene(vbox,700,700);
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		mainStage.setScene(scene);
		mainStage.show();
	}
	
	public static void main(String[] args) {
		launch(args);
	}
	
	public void setup() {
		Display.setFont(f);
		Display.setTextAlignment(TextAlignment.CENTER);
		Display.setWrappingWidth(650);
		
		Output.setFont(f);
		Output.setTextAlignment(TextAlignment.CENTER);
		Output.setWrappingWidth(650);
		
		Alphatxt.setWrappingWidth(450);
		
		debox.setSpacing(25);
		hbox.setSpacing(15);
		vbox.setSpacing(15);
		
		hbox.getChildren().addAll(Mabtn, Mrbtn, Spbtn, Babtn, Imbtn);
		vbox.getChildren().addAll(Display, hbox, Output, Alphatxt);
		
		Mabtn.setOnAction(e->{
			Display.setText(Display.getText() + "-");
			Output.setText(morse_interpret(Display.getText()));
		});
		Mrbtn.setOnAction(e->{
			Display.setText(Display.getText() + ".");
			Output.setText(morse_interpret(Display.getText()));
		});
		Spbtn.setOnAction(e->{
			Display.setText(Display.getText() + " ");
			Output.setText(morse_interpret(Display.getText()));
		});
		Babtn.setOnAction(e->{
			if (!(Display.getText().length() <= 0)) {
				Display.setText(Display.getText().substring(0, Display.getText().length() - 1));
				Output.setText(morse_interpret(Display.getText()));	
			}
		});		
		Imbtn.setOnAction(e->{
			FileChooser fc = new FileChooser();
			File file = fc.showOpenDialog(Main.mainStage);
			String imported = file.toString();
			try {
				imported = new String(Files.readAllBytes(Paths.get(imported)));
				Display.setText(imported);
				
				Output.setText(morse_interpret(Display.getText()));
				//Output.setText(morse_interpret(Display.getText()));
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		});
	}
	public String morse_interpret(String str) {
		morse.put(".-", "A");
		morse.put("-...", "B");
		morse.put("-.-.", "C");
		morse.put("-..", "D");
		morse.put(".", "E");
		morse.put("..-.", "F");
		morse.put("--.", "G");
		morse.put("....", "H");
		morse.put("..", "I");
		morse.put(".---", "J");
		morse.put("-.-", "K");
		morse.put(".-..", "L");
		morse.put("--", "M");
		morse.put("-.", "N");
		morse.put("---", "O");
		morse.put(".--.", "P");
		morse.put("--.-", "Q");
		morse.put(".-.", "R");
		morse.put("...", "S");
		morse.put("-", "T");
		morse.put("..-", "U");
		morse.put("...-", "V");
		morse.put(".--", "W");
		morse.put("-..-", "X");
		morse.put("-.--", "Y");
		morse.put("--..", "Z");	
		morse.put("----.", "9");
		morse.put("---..", "8");
		morse.put("--...", "7");
		morse.put("-....", "6");
		morse.put(".....", "5");
		morse.put("....-", "4");
		morse.put("...--", "3");
		morse.put("..---", "2");
		morse.put(".----", "1");
		morse.put("-----", "0");
					
		String english = "";
		String more[] = str.split(" ");
		for (int x = 0; x < more.length; x++) {
				if (morse.get(more[x]) != null) {
					english = english + morse.get(more[x]);	
				}else {
					english += " ";
				}			
		}
		return english;
	}
	
	/*public String reverse(String str) {
		String reversed = "";
		
		String value = "A";
		
		for (String keys: morse.keySet()) {
			System.out.println("hi");
		      if (morse.get(keys).equals(value)) {
		        reversed += morse.get(keys);
		        System.out.println(reversed);
		      }
		 }
		
		for (int x = 0; x < str.length(); x++) {
			value = str.substring(x, x+1);
			
			
		}
		System.out.println(reversed);
		return reversed;
	}*/
}