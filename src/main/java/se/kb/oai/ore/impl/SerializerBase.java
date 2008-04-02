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

package se.kb.oai.ore.impl;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import org.dom4j.Element;

import se.kb.oai.ore.ResourceMap;
import se.kb.oai.ore.ResourceMapSerializer;
import se.kb.xml.XMLUtils;

/**
 * Abstract base class for the different <code>ResourceMapSerializer</code> implementations.
 * 
 * @author Oskar Grenholm, National Library of Sweden
 */
public abstract class SerializerBase implements ResourceMapSerializer {

	public void serializeToStream(ResourceMap map, OutputStream stream) throws IOException {
		XMLUtils.writeXmlTo(serializeToXml(map), stream);		
	}
	
	public void serializeToFile(ResourceMap map, File file) throws IOException {
		FileOutputStream stream = new FileOutputStream(file);
		serializeToStream(map, stream);
		stream.close();
	}

	public String serializeToString(ResourceMap map) throws IOException {
		return XMLUtils.xmlToString(serializeToXml(map));
	}

	public abstract Element serializeToXml(ResourceMap map);	
}
