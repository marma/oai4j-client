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

import java.util.List;

import org.dom4j.Element;
import org.dom4j.Node;

import se.kb.oai.OAIException;
import se.kb.oai.ore.AggregateBase;
import se.kb.oai.ore.AggregatedResource;
import se.kb.oai.ore.Metadata;
import se.kb.oai.ore.Metadata.Namespace;
import se.kb.oai.ore.ResourceMap;
import se.kb.oai.ore.Type;
import se.kb.xml.XPathWrapper;

import static se.kb.oai.ore.OREConstants.ATOM_NS_PREFIX;
import static se.kb.oai.ore.OREConstants.ATOM_NS_URI;
import static se.kb.oai.ore.OREConstants.DCTERMS_NS_PREFIX;
import static se.kb.oai.ore.OREConstants.DCTERMS_NS_URI;
import static se.kb.oai.ore.OREConstants.DC_NS_PREFIX;
import static se.kb.oai.ore.OREConstants.DC_NS_URI;
import static se.kb.oai.ore.OREConstants.RDF_NS_PREFIX;
import static se.kb.oai.ore.OREConstants.RDF_NS_URI;
import static se.kb.oai.ore.impl.AtomConstants.*;

public class AtomFactory extends FactoryBase {
	
	@Override
	public ResourceMap getResourceMap(Element feed) throws OAIException {
		try {
			XPathWrapper xpath = createXPath(feed);
			
			ResourceMap map = new ResourceMap(xpath.valueOf(ID_XPATH));
			map.setCreator(xpath.valueOf(CREATOR_XPATH));
			map.setModified(DATE_FORMAT.parse(xpath.valueOf(MODIFIED_XPATH)));
						
			String rights = xpath.valueOf(RIGHTS_XPATH);
			if (notEmpty(rights))
				map.setRights(rights);
			
			String created = xpath.valueOf(CREATED_XPATH);
			if (notEmpty(created))
				map.setCreated(DATE_FORMAT.parse(created));
						
			addTypesAndMetadata(map.getAggregation(), xpath.selectNodes("*"));	
			
			for (Node node : xpath.selectNodes(ENTRY_XPATH)) {
				xpath = createXPath(node);
				AggregatedResource resource = new AggregatedResource(xpath.valueOf(ENTRY_ID_XPATH));
				addTypesAndMetadata(resource, xpath.selectNodes("*"));	
				map.getAggregation().addResource(resource);				
			}	
			
			return map;
		} catch (Exception e) {
			throw new OAIException(e);
		}
	}
	
	private void addTypesAndMetadata(AggregateBase aggregate, List<Node> nodes) {
		for (Node node : nodes) {
			Element element = (Element) node;
			if (element.getNamespace().equals(DC_NS)) {
				aggregate.addMetadata((new Metadata(Namespace.DC, element.getName(), element.getText())));
			}
			else if (element.getNamespace().equals(DCTERMS_NS)) {
				aggregate.addMetadata((new Metadata(Namespace.DCTERMS, element.getName(), element.getText())));
			}
			else if (element.getNamespace().equals(RDF_NS) && element.getName().equals("type")) {
				aggregate.addType(new Type(element.getText()));
			}
		}
	}
	
	private XPathWrapper createXPath(Node node) {
		XPathWrapper xpath = new XPathWrapper(node);	
		xpath.addNamespace(ATOM_NS_PREFIX, ATOM_NS_URI);
		xpath.addNamespace(RDF_NS_PREFIX, RDF_NS_URI);
		xpath.addNamespace(DC_NS_PREFIX, DC_NS_URI);
		xpath.addNamespace(DCTERMS_NS_PREFIX, DCTERMS_NS_URI);
		return xpath;
	}
	
	private boolean notEmpty(String string) {
		return (string != null && string.trim().length() > 0);
	}
}
