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

package se.kb.oai.ore;

import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

import org.dom4j.Element;

import se.kb.oai.OAIException;

/**
 * A <code>ResourceMapFactory</code> will be used to create a {@link ResourceMap}. 
 * It can either be a totally new <code>ResourceMap</code> or one that is parsed
 * from an existing serialization of a <code>ResourceMap</code>. Different
 * implementations of this interface will handle different serialization formats.
 * <p>
 * At the moment the Open Archive Initiative describes two possible formats:
 * <ul>
 * 	<li> Atom - <a href="http://www.openarchives.org/ore/0.2/atom-implementation">http://www.openarchives.org/ore/0.2/atom-implementation</a>
 * 	<li> RDF/XML - <a href="http://www.openarchives.org/ore/0.2/rdfsyntax">http://www.openarchives.org/ore/0.2/rdfsyntax</a>
 * </ul>
 * 
 * @author Oskar Grenholm, National Library of Sweden
 */
public interface ResourceMapFactory {

	/**
	 * Create a new <code>ResourceMap</code> with this id.
	 * 
	 * @param uri the id
	 * 
	 * @return a new resource map
	 * @throws URISyntaxException
	 */
	public ResourceMap newResourceMap(String uri) throws URISyntaxException;
	
	/**
	 * Create a new <code>ResourceMap</code> with this id.
	 * 
	 * @param uri the id
	 * 
	 * @return a new resource map
	 */
	public ResourceMap newResourceMap(URI uri);
	
	/**
	 * Parse the content of the URL and create a <code>ResourceMap</code>
	 * from it.
	 * 
	 * @param url a URL
	 * 
	 * @return a resource map representing the content of the URL
	 * @throws OAIException
	 */
	public ResourceMap getResourceMap(URL url) throws OAIException;
	

	/**
	 * Parse the content of the URL and create a <code>ResourceMap</code>
	 * from it.
	 * 
	 * @param url a URL
	 * 
	 * @return a resource map representing the content of the URL
	 * @throws OAIException
	 */
	public ResourceMap getResourceMap(String url) throws OAIException;
	

	/**
	 * Parse the XML and create a <code>ResourceMap</code> from it.
	 * 
	 * @param root a XML element
	 * 
	 * @return a resource map representing the content of the XML
	 * @throws OAIException
	 */
	public ResourceMap getResourceMap(Element root) throws OAIException;
}
