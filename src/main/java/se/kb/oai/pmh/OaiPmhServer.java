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

import java.net.URL;

import se.kb.oai.OAIException;

import ORG.oclc.oai.harvester2.verb.GetRecord;
import ORG.oclc.oai.harvester2.verb.Identify;
import ORG.oclc.oai.harvester2.verb.ListIdentifiers;
import ORG.oclc.oai.harvester2.verb.ListMetadataFormats;
import ORG.oclc.oai.harvester2.verb.ListRecords;
import ORG.oclc.oai.harvester2.verb.ListSets;

/**
 * Class that acts as a facade for an OAI-PMH server. 
 * 
 * Has methods that corresponds to the different verbs in the OAI-PMH 
 * specification and that will return appropriate objects based on 
 * the response.
 * 
 * @author oskar
 */
public class OaiPmhServer {
    
    private String baseurl;
    
    /**
     * Creates an <code>OaiPmhServer</code> with the given base URL.
     * 
     * @param url Base URL that points to an OAI-PMH server.
     */
    public OaiPmhServer(String url) {
        this.baseurl = url;
    }

    /**
     * Creates an <code>OaiPmhServer</code> with the given base URL.
     * 
     * @param url Base URL that points to an OAI-PMH server.
     */
    public OaiPmhServer(URL url) {
        this(url.toString());
    }
    
    public String getBaseUrl() {
        return baseurl;
    }
    
    public Record getRecord(String identifier, String metadataPrefix) throws OAIException {
        try {
            GetRecord getRecord = new GetRecord(baseurl, identifier, metadataPrefix);
            return new Record(getRecord.getDocument());
        } catch (ErrorResponseException e) {
        	throw e;
        } catch (Exception e) {
            throw new OAIException(e);
        }
    }
    
    public Identification identify() throws OAIException {
        try {
            Identify identify = new Identify(baseurl);
            return new Identification(identify.getDocument());
        } catch (ErrorResponseException e) {
        	throw e;
        } catch (Exception e) {
            throw new OAIException(e);
        }   
    }
    
    public IdentifiersList listIdentifiers(String metadataPrefix) throws OAIException {
        return listIdentifiers(null, null, null, metadataPrefix);
    }
           
    public IdentifiersList listIdentifiers(String from, String until, String set, String metadataPrefix) throws OAIException {
        try {
            ListIdentifiers list = new ListIdentifiers(baseurl, from, until, set, metadataPrefix);
            return new IdentifiersList(list.getDocument());
        } catch (ErrorResponseException e) {
        	throw e;
        } catch (Exception e) {
            throw new OAIException(e);
        }   
    }
    
    public IdentifiersList listIdentifiers(ResumptionToken resumptionToken) throws OAIException {
        try {
            ListIdentifiers list = new ListIdentifiers(baseurl, resumptionToken.getId());
            return new IdentifiersList(list.getDocument());
        } catch (ErrorResponseException e) {
        	throw e;
        } catch (Exception e) {
            throw new OAIException(e);
        }   
    }
    
    public RecordsList listRecords(String metadataPrefix) throws OAIException {
        return listRecords(null, null, null, metadataPrefix);
    }
    
    public RecordsList listRecords(String from, String until, String set, String metadataPrefix) throws OAIException {
        try {
            ListRecords list = new ListRecords(baseurl, from, until, set, metadataPrefix);
            return new RecordsList(list.getDocument());
        } catch (ErrorResponseException e) {
        	throw e;
        } catch (Exception e) {
            throw new OAIException(e);
        }
    }
    
    public RecordsList listRecords(ResumptionToken resumptionToken) throws OAIException {
        try {
            ListRecords list = new ListRecords(baseurl, resumptionToken.getId());
            return new RecordsList(list.getDocument());
        } catch (ErrorResponseException e) {
        	throw e;
        } catch (Exception e) {
            throw new OAIException(e);
        }
    }
    
    public MetadataFormatsList listMetadataFormats() throws OAIException {
        return listMetadataFormats(null);
    }
    
    public MetadataFormatsList listMetadataFormats(String identifier) throws OAIException {
        try {
            ListMetadataFormats list = new ListMetadataFormats(baseurl, identifier);
            return new MetadataFormatsList(list.getDocument());
        } catch (ErrorResponseException e) {
        	throw e;
        } catch (Exception e) {
            throw new OAIException(e);
        }   
    }
    
    public SetsList listSets() throws OAIException {
        try {
            ListSets list = new ListSets(baseurl);
            return new SetsList(list.getDocument());
        } catch (ErrorResponseException e) {
        	throw e;
        } catch (Exception e) {
            throw new OAIException(e);
        }   
    }    
}
