
package edu.saintjoe.cs.brianc.examtwo;

//Import Directives that show what components you are using
import com.google.devtools.simple.runtime.components.Component;
import com.google.devtools.simple.runtime.components.HandlesEventDispatching;
import com.google.devtools.simple.runtime.components.android.Form;

import com.google.devtools.simple.runtime.components.android.Button;
import com.google.devtools.simple.runtime.components.android.Label;
import com.google.devtools.simple.runtime.components.android.HorizontalArrangement;
import com.google.devtools.simple.runtime.components.android.TextBox;
import com.google.devtools.simple.runtime.components.android.AccelerometerSensor;

import com.google.devtools.simple.runtime.events.EventDispatcher;

public class ExamActivity extends Form implements HandlesEventDispatching {

	private HorizontalArrangement line1, line2, line3, line4, line5;
	private Button incButton;
	private Label resultLabel;
	private Label promptLabel;
	private TextBox inputBox;
	private Label outputLabel;
	int temp;
	

 void $define() {
 	//sets background color to white
     this.BackgroundColor(COLOR_WHITE);
    // Creates 4 new horizontal arrangements
     line1 = new HorizontalArrangement(this);
     line2 = new HorizontalArrangement(this);
     line3 = new HorizontalArrangement(this);
     line4 = new HorizontalArrangement(this);

     //Creates a label that says "enter number"
     //adds a textbox so you can put in numbers
     //Only allows numbers in the text box
     promptLabel = new Label(line1, "Enter a number:");
     inputBox = new TextBox(line1);
     inputBox.NumbersOnly(true);
   //Button that when pressed doubles the value in the text box
     incButton = new Button(line2,"Double it:"); 
     //Shows results of that label
     resultLabel = new Label(line3,"");
     //this label does nothing and is redundant
     outputLabel = new Label(line4, "");
 
     EventDispatcher.registerEventForDelegation(this, "ButtonClick", "Click");
    
 } 
 @Override
 public boolean dispatchEvent(Component component, String id, String eventName,
         Object[] args) {
 	//This is where the actual math of the app takes place
	    if (component.equals(incButton) && eventName.equals("Click")){
	    	temp = Integer.parseInt(inputBox.Text());
	    	//multiplies the integer in the text box by 2
	    	temp *= 2;
	    	//sends the result to the result label
	    	resultLabel.Text(String.valueOf(temp));
	        return true;
	    
	    }
 return true;
 }
	    
}
	    
	   
    
 

