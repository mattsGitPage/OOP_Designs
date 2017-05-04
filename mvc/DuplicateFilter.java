package mvc;

/**
 * 
 * @author matthew dunning
 * if this filter is selected it checks if there are any duplicate 
 * characters in the password does not take into account numbers or special char
 */
public class DuplicateFilter implements IFilter {

	@Override
	public Boolean Execute(String pass) {
		System.out.println("implementing duplicate filter");
		//get rid of everything that is not a character
	
		String temp = pass.replaceAll("[^A-Za-z]", "");
		//if over all is greater than 26 it must have duplicate
		if (temp.length() > 26) { 
	        return false;
	    }
	    int checker = 0;
	    for (int i = 0; i < temp.length(); i++) {
	        int val = temp.charAt(i) - 'a';
	        if ((checker & (1 << val)) > 0) return false;
	        checker |= (1 << val);
	    }
	    return true;
	}

}
