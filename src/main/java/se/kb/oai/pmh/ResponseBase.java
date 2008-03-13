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

import org.dom4j.Element;
import org.dom4j.io.DOMReader;
import org.w3c.dom.Document;

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
    
    public ResponseBase(Document document) throws PMHErrorResponseException {
        DOMReader reader = new DOMReader();
        Element root = reader.read(document).getRootElement();
        
        this.xpath = new XPathWrapper(root);
        xpath.addNamespace(OAI_NS_PREFIX, OAI_NS_URI);
        this.response = document;        
        this.responseDate = xpath.valueOf(RESPONSEDATE_XPATH);
                
        Element token = xpath.selectSingleElement(RESUMPTIONTOKEN_XPATH);
        this.resumptionToken = token != null ? new ResumptionToken(token) : null; 
        
        Element error = xpath.selectSingleElement(ERROR_XPATH);
        if (error != null) {
        	throw new PMHErrorResponseException(error.attributeValue("code"), error.getTextTrim());
        }
    }    
    
    public Document getResponse() {
        return response;
    }
    
    public String getResponseDate() {
        return responseDate;
    }
}
