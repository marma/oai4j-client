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

import org.dom4j.Document;
import org.dom4j.io.SAXReader;

import se.kb.oai.OAIException;

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
    
    private QueryBuilder builder;
    private SAXReader reader;
    
    /**
     * Creates an <code>OaiPmhServer</code> with the given base URL.
     * 
     * @param url Base URL that points to an OAI-PMH server.
     */
    public OaiPmhServer(String url) {
        this.builder = new QueryBuilder(url);
        this.reader = new SAXReader();
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
        return builder.getBasesurl();
    }
    
    public Record getRecord(String identifier, String metadataPrefix) throws OAIException {
        try {
        	String query = builder.buildGetRecordQuery(identifier, metadataPrefix);
        	Document document = reader.read(query);
            return new Record(document);
        } catch (ErrorResponseException e) {
        	throw e;
        } catch (Exception e) {
            throw new OAIException(e);
        }
    }
    
    public Identification identify() throws OAIException {
        try {
        	String query = builder.buildIdentifyQuery();
        	Document document = reader.read(query);
            return new Identification(document);
        } catch (ErrorResponseException e) {
        	throw e;
        } catch (Exception e) {
            throw new OAIException(e);
        }   
    }
    
    public IdentifiersList listIdentifiers(String metadataPrefix) throws OAIException {
        return listIdentifiers(metadataPrefix, null, null, null);
    }
           
    public IdentifiersList listIdentifiers(String metadataPrefix, String from, String until, String set) throws OAIException {
        try {
        	String query = builder.buildListIdentifiersQuery(metadataPrefix, from, until, set);
        	Document document = reader.read(query);
            return new IdentifiersList(document);
        } catch (ErrorResponseException e) {
        	throw e;
        } catch (Exception e) {
            throw new OAIException(e);
        }   
    }
    
    public IdentifiersList listIdentifiers(ResumptionToken resumptionToken) throws OAIException {
        try {
        	String query = builder.buildListIdentifiersQuery(resumptionToken);
        	Document document = reader.read(query);
            return new IdentifiersList(document);
        } catch (ErrorResponseException e) {
        	throw e;
        } catch (Exception e) {
            throw new OAIException(e);
        }   
    }
    
    public RecordsList listRecords(String metadataPrefix) throws OAIException {
        return listRecords(metadataPrefix, null, null, null);
    }
    
    public RecordsList listRecords(String metadataPrefix, String from, String until, String set) throws OAIException {
        try {
        	String query = builder.buildListRecordsQuery(metadataPrefix, from, until, set);
        	Document document = reader.read(query);
            return new RecordsList(document);
        } catch (ErrorResponseException e) {
        	throw e;
        } catch (Exception e) {
            throw new OAIException(e);
        }
    }
    
    public RecordsList listRecords(ResumptionToken resumptionToken) throws OAIException {
        try {
        	String query = builder.buildListRecordsQuery(resumptionToken);
        	Document document = reader.read(query);
            return new RecordsList(document);
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
        	String query = builder.buildListMetadataFormatsQuery(identifier);
        	Document document = reader.read(query);
            return new MetadataFormatsList(document);
        } catch (ErrorResponseException e) {
        	throw e;
        } catch (Exception e) {
            throw new OAIException(e);
        }   
    }
    
    public SetsList listSets() throws OAIException {
        try {
        	String query = builder.buildListSetsQuery();
        	Document document = reader.read(query);
            return new SetsList(document);
        } catch (ErrorResponseException e) {
        	throw e;
        } catch (Exception e) {
            throw new OAIException(e);
        }   
    }    
    
    public SetsList listSets(ResumptionToken resumptionToken) throws OAIException {
        try {
        	String query = builder.buildListSetsQuery(resumptionToken);
        	Document document = reader.read(query);
            return new SetsList(document);
        } catch (ErrorResponseException e) {
        	throw e;
        } catch (Exception e) {
            throw new OAIException(e);
        }   
    }
}
