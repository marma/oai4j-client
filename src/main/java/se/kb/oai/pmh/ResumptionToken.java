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

public class ResumptionToken {

    private String id;
    private String expirationDate;
    
    public ResumptionToken(Element element) {
        this.id = element.getTextTrim();
        this.expirationDate = element.attributeValue("expirationDate");
    }    

    public String getId() {
        return id;
    }
    
    public String getExpirationDate() {
        return expirationDate;
    }
}
