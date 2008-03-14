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

/**
 * The <code>Record</code> class represents the data returned for a 
 * <code>GetRecord</code> or <code>ListRecords</code> request. It 
 * holds the actual metadata content.
 * 
 * @author Oskar Grenholm, National Library of Sweden
 */
public class Record extends ResponseBase {

    private static final String RECORD_XPATH = "oai:GetRecord/oai:record";
    private static final String HEADER_XPATH = "oai:header";
    private static final String METADATA_XPATH = "oai:metadata/*";
    private static final String ABOUT_XPATH = "oai:about/*";
        
    private Header header;
    private Element metadata;
    private Element about;
    
    /**
     * Creates a <code>Record</code> from the response from a 
     * <code>GetRecord</code> request.
     * 
     * @param document the response
     * @throws ErrorResponseException
     */
    public Record(Document document) throws ErrorResponseException {               
        this(document, null); 
    }  
    
    /**
     * Creates a <code>Record</code> from  from a <code>ListRecords</code> 
     * response and a specific <code>&lt;record&gt;</code> element in that
     * response. 
     * 
     * @param document the response
     * @param record a <code>&lt;record&gt;</code> element
     * @throws ErrorResponseException
     */
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
    
    /**
     * Get the <code>Header</code> with the information 
     * about this <code>Record</code>.
     * 
     * @return a <code>Header</code> 
     */
    public Header getHeader() {
        return header;
    }

    /**
     * Get the metadata contained in the <code>metadata</code> element
     * of this <code>Record</code>.
     * 
     * @return the metadata as xml
     */
    public Element getMetadata() {
        return metadata;
    }
    
    /**
    * Get the xml representation of the metadata as a <code>String</code>.
    * 
    * @return the metadata as a <code>String</code>
    */
    public String getMetadataAsString() throws IOException {
    	return XMLUtils.xmlToString(getMetadata());
    }

    /**
     * Get the information about this <code>Record</code>.
     * 
     * @return the about information
     */
    public Element getAbout() {
        return about;
    }    
}
