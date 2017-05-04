package mvc;

/**
 * 
 * @author matthew dunning
 * if selected this filter checks if there are any spaces in the passed password
 */
public class SpaceFilter implements IFilter {

	@Override
	public Boolean Execute(String pass) {
		System.out.println("implements space filter");
		if(pass.contains(" "))
			return false;
		
		return true;
	}

}
