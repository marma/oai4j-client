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

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.Node;

/**
 * Class that represents the information returned from an <code>Identify</code> request.
 *  
 * @author Oskar Grenholm, National Library of Sweden
 */
public class Identification extends ResponseBase {

    private static final String REPOSITORYNAME_XPATH = "oai:Identify/oai:repositoryName";
    private static final String BASEURL_XPATH = "oai:Identify/oai:baseURL";
    private static final String PROTOCOLVERSION_XPATH = "oai:Identify/oai:protocolVersion";
    private static final String EARLIESTDATESTAMP_XPATH = "oai:Identify/oai:earliestDatestamp";
    private static final String DELETEDRECORD_XPATH = "oai:Identify/oai:deletedRecord";
    private static final String GRANULARITY_XPATH = "oai:Identify/oai:granularity";
    private static final String COMPRESSION_XPATH = "oai:Identify/oai:compression";
    private static final String DESCRIPTION_XPATH = "oai:Identify/oai:description/*";
    private static final String ADMINEMAIL_XPATH = "oai:Identify/oai:adminEmail";
    
    private String repositoryName;
    private String baseUrl;
    private String protocolVersion;
    private String earliestDatestamp;
    private String deletedRecord;
    private String granularity;
    private String compression;
    private List<Element> descriptions;
    private List<String> adminEmails;
    
    /**
     * Creates an <code>Identification</code> from the returned response.
     * 
     * @param document the response
     * 
     * @throws ErrorResponseException
     */
    public Identification(Document document) throws ErrorResponseException {
        super(document);
        
        this.repositoryName = xpath.valueOf(REPOSITORYNAME_XPATH);
        this.baseUrl = xpath.valueOf(BASEURL_XPATH);
        this.protocolVersion = xpath.valueOf(PROTOCOLVERSION_XPATH);
        this.earliestDatestamp = xpath.valueOf(EARLIESTDATESTAMP_XPATH);
        this.deletedRecord = xpath.valueOf(DELETEDRECORD_XPATH);
        this.granularity = xpath.valueOf(GRANULARITY_XPATH);
        this.compression = xpath.valueOf(COMPRESSION_XPATH);
        
        this.descriptions = new LinkedList<Element>();
        for (Node description: xpath.selectNodes(DESCRIPTION_XPATH)) {
            descriptions.add((Element) description);
        }
        
        this.adminEmails = new LinkedList<String>();
        for(Node adminEmail : xpath.selectNodes(ADMINEMAIL_XPATH)) {
            adminEmails.add(adminEmail.getText());
        }
    }

    /**
     * Get a list of e-mails to the administrators of this repository.
     * 
     * @return a list of e-mails
     */
    public List<String> getAdminEmails() {
        return adminEmails;
    }

    /**
     * Get the base URL of the repository.
     * 
     * @return the base URL
     */
    public String getBaseUrl() {
        return baseUrl;
    }

    /**
     * Get the compression type supported by this repository.
     * 
     * @return the compression
     */
    public String getCompression() {
        return compression;
    }

    /**
     * Get the support for deletes this repository has.
     * Legitimate values are: 
     * <ul>
     * 	<li>no 
     * 	<li>transient
     * 	<li>persistent
     * </ul>
     * 
     * @return the deleted record support
     */
    public String getDeletedRecord() {
        return deletedRecord;
    }

    /**
     * Get a list of descriptions of this repositories. Can be in any xml-format.
     * 
     * @return a list of descriptions
     */
    public List<Element> getDescriptions() {
        return descriptions;
    }

    /**
     * Get the earliest datestamp that exists in the repository.
     * 
     * @return the earliest datestamp
     */
    public String getEarliestDatestamp() {
        return earliestDatestamp;
    }

    /**
     * Get the granularity for datestamps in the repository. Two possible values:
     * <ul>
     * 	<li> <code>YYYY-MM-DD</code>, meaning day granularity 
     * 	<li> <code>YYYY-MM-DDThh:mm:ssZ</code>, meaning second granularity
     * </ul>
     * 
     * @return the granularity
     */
    public String getGranularity() {
        return granularity;
    }

    /**
     * Get the protocol version of OAI-PMH this repository supports.
     * 
     * @return the version
     */
    public String getProtocolVersion() {
        return protocolVersion;
    }

    /**
     * Get the name of this repository.
     * 
     * @return the name
     */
    public String getRepositoryName() {
        return repositoryName;
    }    
}
