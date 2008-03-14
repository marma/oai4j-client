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

import org.dom4j.Document;
import org.dom4j.Element;

import se.kb.xml.XPathWrapper;

public abstract class ResponseBase {

    public static final String OAI_NS_PREFIX = "oai";
    public static final String OAI_NS_URI = "http://www.openarchives.org/OAI/2.0/";
    
    private static final String RESPONSEDATE_XPATH = "oai:responseDate";
    private static final String RESUMPTIONTOKEN_XPATH = "*/oai:resumptionToken";
    private static final String ERROR_XPATH = "oai:error";
    
    
    protected Document response;
    protected XPathWrapper xpath;
    protected String responseDate;
    protected ResumptionToken resumptionToken;
    
    public ResponseBase(Document document) throws ErrorResponseException {
        Element root = document.getRootElement();
        
        this.xpath = new XPathWrapper(root);
        xpath.addNamespace(OAI_NS_PREFIX, OAI_NS_URI);
        this.response = document;        
        this.responseDate = xpath.valueOf(RESPONSEDATE_XPATH);
                
        Element token = xpath.selectSingleElement(RESUMPTIONTOKEN_XPATH);
        this.resumptionToken = token != null ? new ResumptionToken(token) : null; 
        
        Element error = xpath.selectSingleElement(ERROR_XPATH);
        if (error != null) {
        	throw new ErrorResponseException(error.attributeValue("code"), error.getTextTrim());
        }
    }    
    
    public Document getResponse() {
        return response;
    }
    
    public String getResponseDate() {
        return responseDate;
    }
}
