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

import java.io.IOException;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.Node;

import se.kb.xml.XMLUtils;
import se.kb.xml.XPathWrapper;

public class Record extends ResponseBase {

    private static final String RECORD_XPATH = "oai:GetRecord/oai:record";
    private static final String HEADER_XPATH = "oai:header";
    private static final String METADATA_XPATH = "oai:metadata/*";
    private static final String ABOUT_XPATH = "oai:about/*";
        
    private Header header;
    private Element metadata;
    private Element about;
    
    public Record(Document document) throws ErrorResponseException {               
        this(document, null); 
    }  
    
    public Record(Document document, Node record) throws ErrorResponseException {
        super(document);
        
        if (record == null) 
            this.xpath = new XPathWrapper(xpath.selectSingleNode(RECORD_XPATH));
        else    
            this.xpath = new XPathWrapper(record);
        xpath.addNamespace(OAI_NS_PREFIX, OAI_NS_URI);
        
        Node headerNode = xpath.selectSingleNode(HEADER_XPATH);
        this.header = new Header(headerNode);
        this.metadata = xpath.selectSingleElement(METADATA_XPATH);
        this.about = xpath.selectSingleElement(ABOUT_XPATH);  
    }    
    
    public Header getHeader() {
        return header;
    }

    public Element getMetadata() {
        return metadata;
    }
    
    public String getMetadataAsString() throws IOException {
    	return XMLUtils.xmlToString(getMetadata());
    }

    public Element getAbout() {
        return about;
    }    
}
