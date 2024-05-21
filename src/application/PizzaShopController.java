package application;

import javafx.fxml.FXML;
import java.util.ArrayList;
import java.util.List;
import Model.CrustType;
import Model.Order;
import Model.PizzaSize;
import Model.Toppings;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.CheckBox;
import javafx.scene.image.ImageView;

public class PizzaShopController {

	@FXML
	private ImageView ivPizza;
	
	@FXML
    private Label lbPizzaShop;
    
    @FXML
    private Label lbName;
    
    @FXML
    private TextField tfName;
    
    @FXML
    private Label lbContact;
    
    @FXML
    private TextField tfContact;
    
    @FXML
    private Label lbSize;
    
    @FXML
    private ChoiceBox<PizzaSize> cbSize;
    
    @FXML
    private Label lbType;
    
    @FXML
    private ChoiceBox<CrustType> cbType;
    
    @FXML
    private Label lbQuantity;
    
    @FXML
    private TextField tfQuantity;
    
    @FXML
    private Label lbToppings;
    
    @FXML
    private CheckBox cbCheese;
    
    @FXML
    private CheckBox cbTomatoes;
    
    @FXML
    private CheckBox cbJalapeno;
    
    @FXML
    private CheckBox cbPepper;
    
    @FXML
    private CheckBox cbGarlic;
    
    @FXML
    private Button btnOrder;
    
    @FXML
    private Button btnClear;
    
    @FXML
    private TextArea taSummary;
    
    private List<Toppings> selectedToppings;
	
    public PizzaShopController() {
    	setSelectedToppings(new ArrayList<>());
    }
	@FXML
	private void initialize() {
	     // Initialize the ChoiceBoxes with options
	     cbSize.getItems().addAll(PizzaSize.values());
	     cbType.getItems().addAll(CrustType.values());
	}
	    
	@FXML
	private void handleOrderButtonAction() {
        // Extract data from UI components
        PizzaSize pizzaSize = cbSize.getValue();
        CrustType crustType = cbType.getValue();
        int quantity = Integer.parseInt(tfQuantity.getText());
        selectedToppings.clear();
        
        if(cbCheese.isSelected()) {
        	selectedToppings.add(Toppings.EXTRA_CHEESE);
        }
        
        if(cbTomatoes.isSelected()) {
        	selectedToppings.add(Toppings.TOMATOES);
        }
        
        if(cbJalapeno.isSelected()) {
        	selectedToppings.add(Toppings.JALAPENO);
        }
        
        if(cbPepper.isSelected()) {
        	selectedToppings.add(Toppings.GREEN_PAPER);
        }
        
        if(cbGarlic.isSelected()) {
        	selectedToppings.add(Toppings.ROASTED_GARLIC);
        }
        
        Order order = new Order( pizzaSize, crustType, selectedToppings, quantity);
        displayOrderSummary(order);
	}
	
    private void displayOrderSummary(Order order) {  
    	
    	String customerName = tfName.getText().toUpperCase();
        int customerPhone = Integer.parseInt(tfContact.getText());
    	
        // Calculate total cost including tax
    	double totalBeforeTax = order.getPizzaSize().getPrice() * order.getQuantity();
  
    	for(Toppings toppings : order.getToppings()) {
    		totalBeforeTax += toppings.getPrice() * order.getQuantity();
    	}
    	
        double totalToBePaid = totalBeforeTax + (totalBeforeTax * 0.13);

        // Prepare order summary
        StringBuilder summaryBuilder = new StringBuilder();
        summaryBuilder.append("Customer Name: ").append(customerName).append("\n");
        summaryBuilder.append("Customer Phone: ").append(customerPhone).append("\n");
        summaryBuilder.append("Pizza Size: ").append(order.getPizzaSize()).append("\n");
        summaryBuilder.append("Crust Type: ").append(order.getCrustType()).append("\n");
        summaryBuilder.append("Quantity: ").append(order.getQuantity()).append("\n");
        summaryBuilder.append("Before Tax: $").append(String.format("%.2f", totalBeforeTax)).append("\n");
        summaryBuilder.append("Total: $").append(String.format("%.2f", totalToBePaid)).append("\n");

        // Display order summary
        taSummary.setText(summaryBuilder.toString());
    }
	    
	@FXML
	private void handleClearButtonAction() {
		cbSize.setValue(null);
        cbType.setValue(null);
        cbCheese.setSelected(false);
        cbTomatoes.setSelected(false);
        cbJalapeno.setSelected(false);
        cbPepper.setSelected(false);
        cbGarlic.setSelected(false);
        tfQuantity.clear();
        tfContact.clear();
        tfName.clear();
        taSummary.clear();
        
	}
	public List<Toppings> getSelectedToppings() {
		return selectedToppings;
	}
	public void setSelectedToppings(List<Toppings> selectedToppings) {
		this.selectedToppings = selectedToppings;
	}

	
}
