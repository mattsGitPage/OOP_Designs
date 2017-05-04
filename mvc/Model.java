package mvc;

/**
 * 
 * @author matthew dunning
 *in this application we are using the interceptor patteren
 *this is the "target" of the application which means we will
 *apply all of the users selected filters and then send it to the "target"
 *this will check and validate that all the password requirements are met
 */
public class Model {

		//holds the string value of the password at first
		//no filters set so it must pass no matter what
		private static String password = "password passed";
		
		//gets the boolean results from all the filters and checks if the password is valid
		public void passwordPassedFilter(Boolean[] check){
			for(int i = 0; i < check.length && check[i] != null; i++)
			{
				if(check[i] == false)
				{
					password = "password failed";
					return;
				}
				else{
					password = "password passed";
				}
			}
		}
		
		//returns the password whether it be set or not
		public String getPassword(){
			return password;
		}

}
