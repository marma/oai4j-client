package se.kb.oai.pmh;

import java.util.List;

import org.dom4j.Document;

/**
 * Abstract base class that holds common functionality for the responses that
 * return lists. Can be used to get the size of the list and the actual list
 * of objects. For respones that don't return all of their results in one response,
 * the <code>ResumptionToken</code> to get the next set of data can also be 
 * retrieved.
 * 
 * @author Oskar Grenholm, National Library of Sweden
 */
public abstract class ListBase<T> extends ResponseBase {

    protected List<T> list;
    
    /**
     * Constructor.
     * 
     * @param the response
     * 
     * @throws ErrorResponseException
     */
    public ListBase(Document document) throws ErrorResponseException {
        super(document);
    }
        
    /**
     * Get the size of the list.
     * 
     * @return the size
     */
    public int size() {
        return list.size();
    }
    
    /**
     * Get the content of the response as a list with objects of type <code>T</code>.
     * 
     * @return the list
     */
    public List<T> asList() {
        return list;
    }
    
    /**
     * Get the <code>ResumptionToken</code>, if any, for this response.
     * 
     * @return the <code>ResumptionToken</code>, or <code>null</code>
     * if none available
     */
    public ResumptionToken getResumptionToken() {
        if (super.resumptionToken == null 
                || super.resumptionToken.getId() == null  
                || super.resumptionToken.getId().length() == 0)
            return null;
        
        return super.resumptionToken;
    }    
}
