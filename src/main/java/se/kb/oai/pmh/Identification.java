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

import org.dom4j.Element;
import org.dom4j.Node;
import org.w3c.dom.Document;

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

    public List<String> getAdminEmails() {
        return adminEmails;
    }

    public String getBaseUrl() {
        return baseUrl;
    }

    public String getCompression() {
        return compression;
    }

    public String getDeletedRecord() {
        return deletedRecord;
    }

    public List<Element> getDescriptions() {
        return descriptions;
    }

    public String getEarliestDatestamp() {
        return earliestDatestamp;
    }

    public String getGranularity() {
        return granularity;
    }

    public String getProtocolVersion() {
        return protocolVersion;
    }

    public String getRepositoryName() {
        return repositoryName;
    }    
}
