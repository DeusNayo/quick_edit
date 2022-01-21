import java.io.File;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class App extends Application {
    public static void main(String[] args) {
        launch(args);
    }
    
    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Quick Edit");

        //Sets Grid container
        GridPane root = new GridPane();
        root.setPadding(new Insets(10,10,10,10));
        root.setVgap(5);
        root.setHgap(5);

        //Sets textfield to add filepath of video file
        TextField file = new TextField();
        file.setPromptText("Add file to process...");
        file.setPrefColumnCount(10);
        GridPane.setConstraints(file, 0, 0);
        root.getChildren().add(file);

        //Sets process button to start
        Button processButton = new Button("Process");
        GridPane.setConstraints(processButton, 1, 0);
        root.getChildren().add(processButton);

        //Function to get filepath and 
        processButton.setOnAction(e -> {
            String filePath = file.getText();

            //Checks if string is a valid filepath
            if (filePath.matches("([a-zA-Z]:)?(\\\\[a-zA-Z0-9_.-]+)+\\\\?")) {
                File videoFile = new File(filePath);

                //Checks if video Exist
                if (videoFile.exists() && !videoFile.isDirectory()) {
                    //1. Analize audio
                    //2. Cut video on audio spikes
                    //3. Output video edited
                }
            }
        });
        
        
        primaryStage.setScene(new Scene(root, 300, 250));
        primaryStage.show();
    }
}
