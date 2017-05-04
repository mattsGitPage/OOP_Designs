package mvc;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Controller {

	private View theView;
	private Model theModel;
	
	public Controller(View theView, Model theModel) {
		this.theView = theView;
		this.theModel = theModel;
		
		//interacting with the view
		this.theView.addCalculateListener(new CalculateListener());
		
	}
	
	class CalculateListener implements ActionListener{

		public void actionPerformed(ActionEvent e) {
			
			boolean _noSpaces , _noDuplicates , _noCaps, _noNum = false;
			String[] orderHolder = new String[4];
			int[] order =new int[4];
			String password = "";
			
			try{
				
				//gets all the user specifications for the password filters 
				password = theView.getPassword();
				_noSpaces = theView.getNoSpace();
				_noDuplicates = theView.getNoDuplicates();
				_noCaps = theView.getNoCaps();
				_noNum = theView.getNoNum();
				orderHolder = theView.getOrder();
				
				//convert from string to int 
				for(int i = 0; i< orderHolder.length; i++)
					order[i] = Integer.parseInt(orderHolder[i]);
				
				//set the filter manager and the desired target aka model
				FilterManager filterManager = new FilterManager(new Model());
				
				//execute in preferred order and keep count of number of filters
				//count filters is to set the size of array for the pass fail rate in filter manager
				int countFilters = 0;
					for (int j = 1 ; j<=order.length; j++){
						if(_noSpaces && order[0] == j){
							filterManager.setFilter(new SpaceFilter());
							countFilters++;
						}
						if(_noDuplicates && order[1] == j){
							filterManager.setFilter(new DuplicateFilter());
							countFilters++;
						}
						if(_noCaps && order[2] == j){
							filterManager.setFilter(new CapFilter());
							countFilters++;
						}
						if(_noNum && order[3] == j){
							filterManager.setFilter(new NumFilter());
							countFilters++;
						}
				
				}
				
				
				//this intercepts the password between the controller and the model
				filterManager.filterRequest(password , countFilters);
	
				//set the views password pass or fail for actual result
				theView.setPasswordPassOrFail(theModel.getPassword());
			
			}

			catch(NumberFormatException ex){
				
				theView.displayErrorMessage("come on now try entering a password");
				
			}
			
		}
		
	}
}
