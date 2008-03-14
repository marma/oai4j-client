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

public class QueryBuilder {

	private enum Verb { Identify, GetRecord, ListIdentifiers, ListMetadataFormats, ListRecords, ListSets }
	
	private static final String VERB = "verb";
	private static final String QUESTION_MARK = "?";
	private static final String AMPERSAND = "&";
	private static final String EQUAL_SIGN = "=";
	
	private static final String IDENTIFIER = "identifier";
	private static final String METADATA_PREFIX = "metadataPrefix";
	private static final String FROM = "from";
	private static final String UNTIL = "until";
	private static final String SET = "set";
	private static final String RESUMPTION_TOKEN = "resumptionToken";
	
	private String basesurl;
	
	public QueryBuilder(String baseurl) {
		this.basesurl = baseurl + QUESTION_MARK + VERB + EQUAL_SIGN;
	}
	
	public String getBasesurl() {
		return basesurl;
	}

	public String buildGetRecordQuery(String identifier, String metadataPrefix) {
		StringBuffer buffer = new StringBuffer(basesurl);
		buffer.append(Verb.GetRecord);
		buffer.append(AMPERSAND).append(IDENTIFIER).append(EQUAL_SIGN).append(identifier);
		buffer.append(AMPERSAND).append(METADATA_PREFIX).append(EQUAL_SIGN).append(metadataPrefix);
		return buffer.toString();
	}
	
	public String buildIdentifyQuery() {
		StringBuffer buffer = new StringBuffer(basesurl);
		buffer.append(Verb.Identify);
		return buffer.toString();
	}
	
	public String buildListIdentifiersQuery(String metadataPrefix, String from, String until, String set) {
		StringBuffer buffer = new StringBuffer(basesurl);
		buffer.append(Verb.ListIdentifiers);
		buffer.append(AMPERSAND).append(METADATA_PREFIX).append(EQUAL_SIGN).append(metadataPrefix);
		if (from != null)
			buffer.append(AMPERSAND).append(FROM).append(EQUAL_SIGN).append(from);
		if (until != null)
			buffer.append(AMPERSAND).append(UNTIL).append(EQUAL_SIGN).append(until);
		if (set != null)
			buffer.append(AMPERSAND).append(SET).append(EQUAL_SIGN).append(set);
		return buffer.toString();
	}
	
	public String buildListIdentifiersQuery(ResumptionToken token) {
		StringBuffer buffer = new StringBuffer(basesurl);
		buffer.append(Verb.ListIdentifiers);
		buffer.append(AMPERSAND).append(RESUMPTION_TOKEN).append(EQUAL_SIGN).append(token.getId());
		return buffer.toString();
	}
	
	public String buildListMetadataFormatsQuery(String identifier) {
		StringBuffer buffer = new StringBuffer(basesurl);
		buffer.append(Verb.ListMetadataFormats);
		if (identifier != null)
			buffer.append(AMPERSAND).append(IDENTIFIER).append(EQUAL_SIGN).append(identifier);
		return buffer.toString();
	}
	
	public String buildListRecordsQuery(String metadataPrefix, String from, String until, String set) {
		StringBuffer buffer = new StringBuffer(basesurl);
		buffer.append(Verb.ListRecords);
		buffer.append(AMPERSAND).append(METADATA_PREFIX).append(EQUAL_SIGN).append(metadataPrefix);
		if (from != null)
			buffer.append(AMPERSAND).append(FROM).append(EQUAL_SIGN).append(from);
		if (until != null)
			buffer.append(AMPERSAND).append(UNTIL).append(EQUAL_SIGN).append(until);
		if (set != null)
			buffer.append(AMPERSAND).append(SET).append(EQUAL_SIGN).append(set);
		return buffer.toString();
	}
	
	public String buildListRecordsQuery(ResumptionToken token) {
		StringBuffer buffer = new StringBuffer(basesurl);
		buffer.append(Verb.ListRecords);
		buffer.append(AMPERSAND).append(RESUMPTION_TOKEN).append(EQUAL_SIGN).append(token.getId());
		return buffer.toString();
	}
	
	public String buildListSetsQuery() {
		StringBuffer buffer = new StringBuffer(basesurl);
		buffer.append(Verb.ListSets);
		return buffer.toString();
	}
	
	public String buildListSetsQuery(ResumptionToken token) {
		StringBuffer buffer = new StringBuffer(basesurl);
		buffer.append(Verb.ListSets);
		buffer.append(AMPERSAND).append(RESUMPTION_TOKEN).append(EQUAL_SIGN).append(token.getId());
		return buffer.toString();
	}
}
