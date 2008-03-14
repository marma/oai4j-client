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

import java.util.LinkedList;
import java.util.List;

import org.dom4j.Element;
import org.dom4j.Node;

import se.kb.xml.XPathWrapper;

public class Set {

    private static final String SPEC_XPATH = "oai:setSpec";
    private static final String NAME_XPATH = "oai:setName";
    private static final String DESCRIPTION_XPATH = "oai:setDescription/*";
    
    private String spec;
    private String name;
    private List<Element> descriptions;
    
    public Set(Node node) {
        XPathWrapper xpath = new XPathWrapper(node);
        xpath.addNamespace(OAI_NS_PREFIX, OAI_NS_URI);
    
        this.spec = xpath.valueOf(SPEC_XPATH);
        this.name = xpath.valueOf(NAME_XPATH);
        this.descriptions = new LinkedList<Element>();
        for (Node description : xpath.selectNodes(DESCRIPTION_XPATH)) {
            descriptions.add((Element) description);
        }
    }

    public String getSpec() {
        return spec;
    }

    public String getName() {
        return name;
    }
    
    public List<Element> getDescriptions() {
        return descriptions;
    }
}
