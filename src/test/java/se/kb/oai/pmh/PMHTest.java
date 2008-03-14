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

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class PMHTest {

	private QueryBuilder builder;
	private String baseurl = "http://lauren.kb.se:8080/oaiprovider";
	
	@Before
	public void clearCalculator() {
		this.builder = new QueryBuilder(baseurl);
	}
	
	@Test
	public void testBuildIdentifyQuery()
    {
		assertEquals(baseurl + "?verb=Identify", builder.buildIdentifyQuery());
    }
	
	@Test
	public void testBuildGetRecordyQuery()
    {
		assertEquals(baseurl + "?verb=GetRecord&identifier=kb:1&metadataPrefix=mods", builder.buildGetRecordQuery("kb:1", "mods"));
    }

	@Test
	public void testBuildListIdentifiersQuery() {
		assertEquals(baseurl + "?verb=ListIdentifiers&metadataPrefix=mods&from=2001-01-01&until=2002-02-02", builder.buildListIdentifiersQuery("mods", "2001-01-01", "2002-02-02", null));
	}
	
	@Test
	public void testBuildListMetadataFormatsQuery() {
		assertEquals(baseurl + "?verb=ListMetadataFormats&identifier=kb:1", builder.buildListMetadataFormatsQuery("kb:1"));
	}
	
	@Test
	public void testBuildListRecordsQuery() {
		assertEquals(baseurl + "?verb=ListRecords&metadataPrefix=mods&from=2001-01-01&until=2002-02-02&set=sot", builder.buildListRecordsQuery("mods", "2001-01-01", "2002-02-02", "sot"));
	}
}
