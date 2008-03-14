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
import org.dom4j.Node;

/**
 * Class that represents the response from a <code>ListRecords</code> request.
 * 
 * @author Oskar Grenholm, National Library of Sweden
 */
public class RecordsList extends ResponseBase {

    private static final String RECORD_XPATH = "oai:ListRecords/oai:record";
    
    private List<Record> records;

    /**
     * Creates a <code>RecordsList</code> from the returned response.
     * 
     * @param document the response
     * @throws ErrorResponseException
     */    
    public RecordsList(Document document) throws ErrorResponseException {
        super(document);
        
        this.records = new LinkedList<Record>();
        for (Node record : xpath.selectNodes(RECORD_XPATH)) {
            records.add(new Record(document, record));
        }      
    }
    
    /**
     * Get the size of the list.
     * 
     * @return the size
     */
    public int size() {
        return records.size();
    }
    
    /**
     * Get the records as a list of <code>Records</code>.
     * 
     * @return a list of records
     */
    public List<Record> asList() {
        return records;
    }
    
    /**
     * Get the <code>ResumptionToken</code>, if any, for this response.
     * 
     * @return the <code>ResumptionToken</code>, or <code>null</code>
     * if none available
     */
    public ResumptionToken getResumptionToken() {
        if (super.resumptionToken == null 
                || super.resumptionToken.getId() == null  
                || super.resumptionToken.getId().length() == 0)
            return null;
        
        return super.resumptionToken;
    }
}
