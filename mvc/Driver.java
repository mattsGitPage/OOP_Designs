package mvc;

/**
 * 
 * @author matthew dunning
 * this is the main driver to test the interceptor filter pattern
 */
public class Driver {

	   public static void main(String[] args) {
	    
		   View theView = new View();
	        
	    	Model theModel = new Model();
	        
	        Controller theController = new Controller(theView,theModel);
	        
	        theView.setVisible(true);
	        
	    }
}
