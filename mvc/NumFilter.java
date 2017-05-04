package mvc;

/**
 * 
 * @author matthew dunning
 * if this filter is selected it checks if there are any numbers in
 * the user passed password
 */
public class NumFilter implements IFilter{

	@Override
	public Boolean Execute(String pass) {
		System.out.println("implementing num filter");
		if(pass.matches(".*\\d+.*"))
		return false;
		
		return true;
		
	}
}
