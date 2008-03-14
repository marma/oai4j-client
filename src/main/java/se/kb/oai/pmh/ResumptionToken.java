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

import org.dom4j.Element;

/**
 * This class represents the <code>resumption token</code> returned from a 
 * list request when not all of the content of the query fits in one response. 
 * You can use it to get another response that has the next set of content 
 * returned from the query. (Which in turn may have a new resumption token.)
 * <p>
 * The verbs that has responses that can contain a resumption token are:
 * <ul>
 * 	<li> <code>ListIdentifiers</code>
 * 	<li> <code>ListRecords</code>
 * 	<li> <code>ListSets</code>
 * </ul>
 * 
 * @author Oskar Grenholm, National Library of Sweden
 *
 */
public class ResumptionToken {

    private String id;
    private String expirationDate;
    
    /**
     * Create a <code>ResumptionToken</code> from the <code>&lt;resumptionToken&gt;</code>
     * element of a response.
     * 
     * @param element
     */
    public ResumptionToken(Element element) {
        this.id = element.getTextTrim();
        this.expirationDate = element.attributeValue("expirationDate");
    }    

    /**
     * Get the id of this resumption token.
     * 
     * @return the id
     */
    public String getId() {
        return id;
    }
    
    /**
     * Get the date when this resumption token expires.
     * 
     * @return the date
     */
    public String getExpirationDate() {
        return expirationDate;
    }
}
