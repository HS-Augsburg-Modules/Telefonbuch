package telefonbuch;

import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;

public class UserInputArea {
    private final FlowPane flowPane = new FlowPane();

    public UserInputArea() {

    	TextField first = new TextField();    	
    	TextField last = new TextField();
    	TextField number = new TextField();
    	flowPane.getChildren().addAll(first, last, number);
    	
    	
//    	<FlowPane maxHeight="-Infinity" maxWidth="-Infinity" minHeight="-Infinity" minWidth="-Infinity" prefHeight="400.0" prefWidth="600.0" xmlns="http://javafx.com/javafx/16" xmlns:fx="http://javafx.com/fxml/1">
//    	   <children>
//    	      <TextField />
//    	      <TextField />
//    	      <TextField />
//    	      <Button mnemonicParsing="false" text="Button" />
//    	   </children>
//    	</FlowPane>
    	
//        AnchorPane.setLeftAnchor(tableView, 10.0);
//        AnchorPane.setRightAnchor(tableView, 10.0);
//        AnchorPane.setTopAnchor(tableView, 0.0);
//        AnchorPane.setBottomAnchor(tableView, 0.0);
//        anchorPane.getChildren().addAll(tableView);

    }
    
    public FlowPane getFlowPane() {
		return flowPane;
	}

}