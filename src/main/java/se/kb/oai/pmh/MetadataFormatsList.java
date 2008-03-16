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

import org.dom4j.Document;
import org.dom4j.Node;

/**
 * This class represents the response from a <code>ListMetadataFormats</code> request 
 * to the OAI-PMH server. Can be used to get a list of <code>MetadataFormats</code>.
 * 
 * @author Oskar Grenholm, National Library of Sweden
 */
public class MetadataFormatsList extends ListBase<MetadataFormat> {

    private static final String METADATAFORMAT_XPATH = "oai:ListMetadataFormats/oai:metadataFormat";
    
    /**
     * Creates a <code>MetadataFormatsList</code> from the returned response.
     * 
     * @param document the response
     * @throws ErrorResponseException
     */
    public MetadataFormatsList(Document document) throws ErrorResponseException {
        super(document);
        
        super.list = new LinkedList<MetadataFormat>();
        for(Node metadataFormat : xpath.selectNodes(METADATAFORMAT_XPATH)) {
            list.add(new MetadataFormat(metadataFormat));
        }
    }
    
    /**
     * The response from a <code>ListMetadataFormats</code> request will never 
     * have a resumption token, so this method will throw a <code>NoSuchMethodError</code>
     * to prevent it from being used in that way.
     */
    @Override
    public ResumptionToken getResumptionToken() {
        throw new NoSuchMethodError("The response from the verb 'ListMetadataFormats' " +
                                    "can't have a ResumptionToken!");
    }
}
