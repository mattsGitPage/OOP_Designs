package mvc;


/**
 * 
 * @author matthew dunning
 * this is the filter manager interacts with the client
 * depending on what the client wants then sends info to the chain
 */
public class FilterManager {

	 FilterChain filterChain;

     public FilterManager(Model t)
     {
         filterChain = new FilterChain();
         filterChain.setModelTarget(t);
     }

     public void setFilter(IFilter f)
     {
         filterChain.addFilter(f);
     }

     public void filterRequest(String request, int countFilters)
     {
         filterChain.Execute(request , countFilters);
     }
}
