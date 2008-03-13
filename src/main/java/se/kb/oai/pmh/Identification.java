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
    
    public Identification(Document document) throws PMHErrorResponseException {
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
