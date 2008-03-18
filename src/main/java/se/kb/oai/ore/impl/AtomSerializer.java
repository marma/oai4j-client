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
import java.util.UUID;

import org.dom4j.DocumentHelper;
import org.dom4j.Element;

import se.kb.oai.ore.AggregatedResource;
import se.kb.oai.ore.Metadata;
import se.kb.oai.ore.ResourceMap;
import se.kb.oai.ore.Type;

import static se.kb.oai.ore.impl.AtomConstants.*;

/**
 * The <code>AtomSerializer</code> class implements the {@link se.kb.oai.ore.ResourceMapSerializer} 
 * interface to provide the functionality of serializing <code>ResourceMap</code> objects into
 * Atom feeds.
 * 
 * @author Oskar Grenholm, National Library of Sweden
 */
public class AtomSerializer extends SerializerBase {
			
	@Override
	public Element serializeToXml(ResourceMap map) {
		Element feed = DocumentHelper.createElement(FEED);
		feed.addNamespace(ATOM_NS_PREFIX, ATOM_NS_URI);
		feed.addNamespace(RDF_NS_PREFIX, RDF_NS_URI);
		feed.addNamespace(DC_NS_PREFIX, DC_NS_URI);
		feed.addNamespace(DCTERMS_NS_PREFIX, DCTERMS_NS_URI);
		
		Element id = DocumentHelper.createElement(ID);
		id.setText(createAtomId());
		feed.add(id);
		
		Element link = DocumentHelper.createElement(LINK);
		link.addAttribute(REL, "self");
		link.addAttribute("type", "application/atom+xml");
		link.addAttribute(HREF, map.getId().toString());
		feed.add(link);
		
		Element title = DocumentHelper.createElement(TITLE);
		title.setText("Resource Map " + map.getId().toString());
		feed.add(title);
		
		Element author = DocumentHelper.createElement(AUTHOR);
		Element name = DocumentHelper.createElement(NAME);
		name.setText(map.getCreator());
		author.add(name);
		feed.add(author);
		
		if (map.getRights() != null) {
			Element rights = DocumentHelper.createElement(RIGHTS);
			rights.setText(map.getRights());
			feed.add(rights);
		}
		
		if (map.getCreated() != null) {
			Element published = DocumentHelper.createElement(PUBLISHED);
			published.setText(DATE_FORMAT.format(map.getCreated()));
			feed.add(published);
		}
		
		Element updated = DocumentHelper.createElement(UPDATED);
		updated.setText(DATE_FORMAT.format(map.getModified()));
		feed.add(updated);
				
		Element category = DocumentHelper.createElement(CATEGORY);
		category.addAttribute(SCHEME, ORE_TERMS_URL);
		category.addAttribute(TERM, ORE_TERMS_REM_URL);
		category.addAttribute(LABEL, "Resource Map");
		feed.add(category);
		
		Element icon = DocumentHelper.createElement(ICON);
		icon.setText(ICON_URL);
		feed.add(icon);
		
		link = DocumentHelper.createElement(LINK);
		link.addAttribute(REL, "describes");
		link.addAttribute(HREF, map.getAggregation().getId().toString());
		feed.add(link);
		
		addTypes(feed, map.getAggregation().getTypes()); 
		addMetadata(feed, map.getAggregation().getMetadata());
	
		for (AggregatedResource resource : map.getAggregation().getResources()) {
			Element entry = DocumentHelper.createElement(ENTRY);
			
			id = DocumentHelper.createElement(ID);
			id.setText(createAtomId());
			entry.add(id);
			
			title = DocumentHelper.createElement(TITLE);
			title.setText("Aggregated Resource " + resource.getId().toString());
			entry.add(title);
			
			updated = DocumentHelper.createElement(UPDATED);
			updated.setText(DATE_FORMAT.format(map.getModified()));
			entry.add(updated);

			link = DocumentHelper.createElement(LINK);
			link.addAttribute(REL, "alternate");
			link.addAttribute(HREF, resource.getId().toString());
			entry.add(link);
			
			addTypes(entry, resource.getTypes()); 
			addMetadata(entry, resource.getMetadata());
			
			feed.add(entry);
		}
		
		return feed;
	}
	
	private void addTypes(Element target, List<Type> list) {
		for (Type type : list) {
			Element element = DocumentHelper.createElement(TYPE);
			element.setText(type.getValue());
			target.add(element);
		}	
	}
	
	private void addMetadata(Element target, List<Metadata> list) {
		for (Metadata metadata : list) {
			Element element = DocumentHelper.createElement(metadata.getName());
			element.setText(metadata.getValue());
			target.add(element);
		}
	}	
	
	protected String createAtomId() {
		return "urn:uuid:" + UUID.randomUUID().toString();
	}
}
