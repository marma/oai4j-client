package se.kb.oai.pmh;

import java.util.LinkedList;
import java.util.List;

import org.dom4j.Node;
import org.w3c.dom.Document;

public class IdentifiersList extends ResponseBase {

    private static final String HEADER_XPATH = "oai:ListIdentifiers/oai:header";
      
    private List<Header> headers;
    
    public IdentifiersList(Document document) throws PMHErrorResponseException {
        super(document);

        this.headers = new LinkedList<Header>();
        for(Node node : xpath.selectNodes(HEADER_XPATH)) {
            headers.add(new Header(node));
        } 
    }
    
    public int size() {
        return headers.size();
    }
    
    public List<Header> asList() {
        return headers;
    }
    
    public ResumptionToken getResumptionToken() {
        if (super.resumptionToken == null 
                || super.resumptionToken.getId() == null  
                || super.resumptionToken.getId().length() == 0)
            return null;
        
        return super.resumptionToken;
    }
}
