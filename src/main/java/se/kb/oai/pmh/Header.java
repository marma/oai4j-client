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


import static se.kb.oai.pmh.ResponseBase.*;

import java.util.List;
import java.util.LinkedList;

import org.dom4j.Node;

import se.kb.xml.XPathWrapper;

public class Header {
    
    private static final String IDENTIFIER_XPATH = "oai:identifier";
    private static final String DATESTAMP_XPATH = "oai:datestamp";
    private static final String SETSPEC_XPATH = "oai:setSpec";

    private String identifier;
    private String datestamp;
    private List<String> setSpecs;
    
    public Header(Node node) {
        XPathWrapper xpath = new XPathWrapper(node);
        xpath.addNamespace(OAI_NS_PREFIX, OAI_NS_URI);
        
        this.identifier = xpath.valueOf(IDENTIFIER_XPATH);
        this.datestamp = xpath.valueOf(DATESTAMP_XPATH);
        this.setSpecs = new LinkedList<String>();
        for(Node spec : xpath.selectNodes(SETSPEC_XPATH)) {
            setSpecs.add(spec.getText());
        }
    }

    public String getIdentifier() {
        return identifier;
    }
    
    public String getDatestamp() {
        return datestamp;
    }    

    public List<String> getSetSpecs() {
        return setSpecs;
    }
}
