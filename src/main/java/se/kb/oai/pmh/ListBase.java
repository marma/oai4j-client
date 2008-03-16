package se.kb.oai.pmh;

import java.util.List;

import org.dom4j.Document;

public class ListBase<T> extends ResponseBase {

    protected List<T> list;
    
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
     * Get a the content of the response as a list of type <code>T</code>.
     * 
     * @return a list with objects of type <code>T</code> 
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
