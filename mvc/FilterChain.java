package mvc;


import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author matthew dunning
 * chains all the filters that are passed from the filter manager.
 */
public class FilterChain {

	 private List<IFilter> filters = new ArrayList<IFilter>();


     private Model model;
     
     public void addFilter(IFilter f)
     {
         filters.add(f);
     }

     public void Execute(String request , int countFilters)
     {
    	 Boolean[] fer = new Boolean[countFilters];
    	 //initialize results 
    	 for(int i = 0; i < countFilters; i++){
    		 fer[i] = true;
    	 }
    	 int i =0;
         for (IFilter f : filters)
         {
            fer[i] = f.Execute(request);
            i++;
         }
      
         //execute target area here
         model.passwordPassedFilter(fer);
     }

  
     public void setModelTarget(Model t)
     {
    	 this.model = t;
     }
}
