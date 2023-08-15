/* Miron Smierzewski
   5/3/2022
The purpose of this program is to recieve user input, add the input
to a 2D array of a fixed size, and display whether or not that arrau is a Lo Shu Magic Square */

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.geometry.Pos;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.event.EventHandler;
import javafx.event.ActionEvent;

public class LoShuMagicSquareDisplay extends Application
{
   //declaring variables
   int size = 0;
   int numberArray[][];
   MagicSquareInput obj = new MagicSquareInput();
   Label displayOutputLabel;
   Label instructionLabel;
   
   public static void main(String []args)
   {
      //Launch the application
      launch(args);
   }
   
   @Override
   public void start(Stage primaryStage)
   { 
      //Creating labels to give user instructions
      displayOutputLabel = new Label("This label will show the result from clicking a button");
      instructionLabel = new Label("Please look at the console to enter values after you press the create array button.");
      Label sizeLabel = new Label("Choose from the options below to select how large you want your 2D array");
      
      //creating radio buttons that determine the size of 2D array
      RadioButton size2 = new RadioButton("2");
      RadioButton size3 = new RadioButton("3");
      RadioButton size4 = new RadioButton("4");
      RadioButton size5 = new RadioButton("5");
      RadioButton size6 = new RadioButton("6");
      
      //setting size 2 to be selected by default
      size2.setSelected(true);
      
      //creating a toggle group
      ToggleGroup radioGroup = new ToggleGroup();
      
      //setting radio buttons to toggle group
      size2.setToggleGroup(radioGroup);
      size3.setToggleGroup(radioGroup);
      size4.setToggleGroup(radioGroup);
      size5.setToggleGroup(radioGroup);
      size6.setToggleGroup(radioGroup);
      
      //Create a button to confirm the user's choice for size
      Button sizeButton = new Button("Press to confirm the size of the 2D array you want to create.");
      
      //Create a button to create a 2D array 
      Button arrayButton = new Button("Press to create the 2D array and determine if it is a Lo Shu Magic Square.");
      
      
      //Lambda Expression to register an event handler for sizeButton
      sizeButton.setOnMouseClicked(event ->
      {
         if(size2.isSelected())
         {   
            size = 2;
            displayOutputLabel.setText("You have selected a 2x2 array.");
         }
         if(size3.isSelected())
         {   
            size = 3;
            displayOutputLabel.setText("You have selected a 3x3 array.");
         }   
         if(size4.isSelected())
         {   
            size = 4;
            displayOutputLabel.setText("You have selected a 4x4 array.");
         }   
         if(size5.isSelected())
         {   
            size = 5;
            displayOutputLabel.setText("You have selected a 5x5 array.");
         }   
         if(size6.isSelected())
         {   
            size = 6;
            displayOutputLabel.setText("You have selected a 6x6 array.");
         }   
      });
   
      
      //Lambda Expression to register an event handler for the arrayButton
      arrayButton.setOnMouseClicked(event ->
      {   
        
         if(size == 0)
         {
           displayOutputLabel.setText("Please press the confirm size button");
         }
         else if(size > 0)
         {

            //declaring variables
            int numberArray[][] = obj.getInput(size);
            boolean magicSquare;
            boolean loShuMagicSquare;
         
            //assigning values to booleans
            magicSquare = obj.determineMagicSquare(numberArray);
            loShuMagicSquare = obj.determineLoShu(numberArray, magicSquare, size);
                  
            //changing the output label depending on whether or not the 2D array fits the criteria
            if(magicSquare && loShuMagicSquare)
               displayOutputLabel.setText("The 2D array is a Lo Shu Magic Square.");
            else if(magicSquare)
               displayOutputLabel.setText("The 2D array is just a Magic Square.");
            else
               displayOutputLabel.setText("The 2D array is neither a Magic Square nor a Lo Shu Magic Square.");
         }          
                    
      });
      
      
      //creating a hbox layout container and adding the radiobuttons to it
      HBox radioBox = new HBox(10, size2, size3, size4, size5, size6);
      radioBox.setAlignment(Pos.CENTER);
      
      //Creating a vbox layout container and adding nodes  to it
      VBox vbox1 = new VBox(10 ,sizeLabel, radioBox, sizeButton, arrayButton, displayOutputLabel, instructionLabel);
      
      //setting the vbox to the center of the window
      vbox1.setAlignment(Pos.CENTER);
      
      //creating the scene
      Scene scene = new Scene(vbox1, 500, 250);
      
      //setting the scene to the stage
      primaryStage.setScene(scene);
      
      //showing the stage
      primaryStage.show();     
   } 
}