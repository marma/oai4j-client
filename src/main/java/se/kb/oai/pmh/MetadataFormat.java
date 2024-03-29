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

import org.dom4j.Node;

import se.kb.xml.XPathWrapper;

/**
 * This class has the information for a specific metadata format that 
 * exists in the repository.
 * 
 * @author Oskar Grenholm, National Library of Sweden
 */
public class MetadataFormat {

    private static final String PREFIX_XPATH = "oai:metadataPrefix";
    private static final String SCHEMA_XPATH = "oai:schema";
    private static final String NAMESPACE_XPATH = "oai:metadataNamespace";
    
    private String prefix;
    private String schema;
    private String namespace;
   
    /**
     * Create a <code>MetadataFormat</code> from a <code>&lt;metadataFormat&gt;</code> 
     * node from the response.
     * 
     * @param node a <code>metadataFormat</code> node
     */
    public MetadataFormat(Node node) {
        XPathWrapper xpath = new XPathWrapper(node);
        xpath.addNamespace(OAI_NS_PREFIX, OAI_NS_URI);
        
        this.prefix = xpath.valueOf(PREFIX_XPATH);
        this.schema = xpath.valueOf(SCHEMA_XPATH);
        this.namespace = xpath.valueOf(NAMESPACE_XPATH);
    }   

    /**
     * Get the prefix for the metadata format in the repository.
     * 
     * @return the prefix
     */
    public String getPrefix() {
        return prefix;
    }

    /**
     * Get the schema for the metadata format.
     * 
     * @return the schema
     */
    public String getSchema() {
        return schema;
    }
    
    /**
     * Get the namespace for the metadata format.
     * 
     * @return the namespace
     */
    public String getNamespace() {
        return namespace;
    }   
}
