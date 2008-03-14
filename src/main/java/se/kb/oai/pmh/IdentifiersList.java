/*
 * Copyright 2008 National Library of Sweden 
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); 
 * you may not use this file except in compliance with the License. 
 * You may obtain a copy of the License at 
 * 
 * 	http://www.apache.org/licenses/LICENSE-2.0 
 *  
 * Unless required by applicable law or agreed to in writing, software 
 * distributed  under the License is distributed on an "AS IS" BASIS, 
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. 
 * See the License for the specific language governing permissions and 
 * limitations under the License.
 */

package se.kb.oai.pmh;

import java.util.LinkedList;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.Node;

public class IdentifiersList extends ResponseBase {

    private static final String HEADER_XPATH = "oai:ListIdentifiers/oai:header";
      
    private List<Header> headers;
    
    public IdentifiersList(Document document) throws ErrorResponseException {
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
