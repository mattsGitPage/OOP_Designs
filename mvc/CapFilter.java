package mvc;

/**
 * 
 * @author matthew dunning
 * if selected by the user it checks for any capital letters in the password
 * the user provides. 
 */
public class CapFilter implements IFilter {

	@Override
	public Boolean Execute(String pass) {
		System.out.println("implementing caps filter");
		boolean hasUppercase = pass.equals(pass.toLowerCase());
		return hasUppercase;
	}

}
