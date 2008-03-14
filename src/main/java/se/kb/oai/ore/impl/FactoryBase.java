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

import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import se.kb.oai.OAIException;
import se.kb.oai.ore.ResourceMap;
import se.kb.oai.ore.ResourceMapFactory;

public abstract class FactoryBase implements ResourceMapFactory {

	public ResourceMap newResourceMap(String uri) throws URISyntaxException {
		return new ResourceMap(uri);
	}
	
	public ResourceMap newResourceMap(URI uri) {
		return new ResourceMap(uri);
	}	
	
	public ResourceMap getResourceMap(URL url) throws OAIException {
		try {
			SAXReader reader = new SAXReader();
			Document document = reader.read(url);
			return getResourceMap(document.getRootElement());
		} catch (Exception e) {
			throw new OAIException(e);
		}		
	}

	public ResourceMap getResourceMap(String url) throws OAIException {
		try {
			return getResourceMap(new URL(url));
		} catch (Exception e) {
			throw new OAIException(e);
		}
	}

	public abstract ResourceMap getResourceMap(Element root) throws OAIException;
}