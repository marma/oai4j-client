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

import org.dom4j.Node;
import org.w3c.dom.Document;

public class MetadataFormatsList extends ResponseBase {

    private static final String METADATAFORMAT_XPATH = "oai:ListMetadataFormats/oai:metadataFormat";
    
    private List<MetadataFormat> metadataFormats;
    
    public MetadataFormatsList(Document document) throws ErrorResponseException {
        super(document);
        
        this.metadataFormats = new LinkedList<MetadataFormat>();
        for(Node metadataFormat : xpath.selectNodes(METADATAFORMAT_XPATH)) {
            metadataFormats.add(new MetadataFormat(metadataFormat));
        }
    }
    
    public int size() {
        return metadataFormats.size();
    }
    
    public List<MetadataFormat> asList() {
        return metadataFormats;
    } 
}
