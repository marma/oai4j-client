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

import java.io.File;
import java.io.IOException;

import org.dom4j.Element;

/**
 * A <code>ResourceMapSerializer</code> is used to serialize the content of a 
 * {@link ResourceMap} to a machine readable format (for example XML). Different
 * implementations of this interface will handle serialization to different formats.
 * <p>
 * At the moment the Open Archive Initiative describes two possible serialization formats:
 * <ul>
 * 	<li> Atom - <a href="http://www.openarchives.org/ore/0.2/atom-implementation">http://www.openarchives.org/ore/0.2/atom-implementation</a>
 * 	<li> RDF/XML - <a href="http://www.openarchives.org/ore/0.2/rdfsyntax">http://www.openarchives.org/ore/0.2/rdfsyntax</a>
 * </ul>
 * 
 * @author Oskar Grenholm, National Library of Sweden
 */
public interface ResourceMapSerializer {

	/**
	 * Serialize the resource map to the given file.
	 * 
	 * @param file a file
	 * @param map a resource map
	 * 
	 * @throws IOException
	 */
	public void serializeToFile(File file, ResourceMap map) throws IOException;
	
	/**
	 * Serialize the resource map and return it as a <code>String</code>.
	 * 
	 * @param map a resource map
	 * 
	 * @return a <code>String</code> with the serialized resource map
	 * @throws IOException
	 */
	public String serializeToString(ResourceMap map) throws IOException;	

	/**
	 * Serialize the resource map into XML.
	 * 
	 * @param map a resource map
	 * 
	 * @return an <code>Element</code> containing the result of the serialization
	 */
	public Element serializeToXml(ResourceMap map);
}
