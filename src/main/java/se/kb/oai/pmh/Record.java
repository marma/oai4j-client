/*
 * Created on 17 Aug 2007
 *
 * Copyright (C) 2007 Royal Library of Sweden.
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public License
 * as published by the Free Software Foundation; either version 2
 * of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place - Suite 330, Boston, MA  02111-1307, USA.
 */
package se.kb.oai.pmh;

import java.io.IOException;

import org.dom4j.Element;
import org.dom4j.Node;
import org.w3c.dom.Document;

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
    
    public Record(Document document) throws PMHErrorResponseException {               
        this(document, null); 
    }  
    
    public Record(Document document, Node record) throws PMHErrorResponseException {
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
