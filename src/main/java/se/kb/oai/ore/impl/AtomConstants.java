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

import java.text.SimpleDateFormat;

import org.dom4j.QName;

import se.kb.oai.ore.OREConstants;

public class AtomConstants extends OREConstants {

	public static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");
		
	public static final String COLON = ":";
	public static final String SLASH = "/";
	
	public static final QName FEED = new QName("feed", ATOM_NS);
	public static final QName ID = new QName("id", ATOM_NS);
	public static final QName LINK = new QName("link", ATOM_NS);
	public static final QName TITLE = new QName("title", ATOM_NS);
	public static final QName AUTHOR = new QName("author", ATOM_NS);
	public static final QName NAME = new QName("name", ATOM_NS);
	public static final QName RIGHTS = new QName("rights", ATOM_NS);
	public static final QName PUBLISHED = new QName("published", ATOM_NS);
	public static final QName UPDATED = new QName("updated", ATOM_NS);
	public static final QName CATEGORY = new QName("category", ATOM_NS);
	public static final QName ICON = new QName("icon", ATOM_NS);
	public static final QName ENTRY = new QName("entry", ATOM_NS);
	public static final QName TYPE = new QName("type", RDF_NS);
	
	public static final String SCHEME = "scheme";
	public static final String TERM = "term";
	public static final String LABEL = "label";
	public static final String REL = "rel";
	public static final String HREF = "href";
	
	public static final String ORE_TERMS_URL = "http://www.openarchives.org/ore/terms/";
	public static final String ORE_TERMS_REM_URL = "http://www.openarchives.org/ore/terms/ResourceMap";
	public static final String ICON_URL = "http://www.openarchives.org/ore/logos/ore_icon.png";
	
	public static final String ID_XPATH = ATOM_NS_PREFIX + COLON + LINK.getName() + "[@rel='self']/@href";
	public static final String CREATOR_XPATH = ATOM_NS_PREFIX + COLON + AUTHOR.getName() + SLASH + ATOM_NS_PREFIX + COLON + NAME.getName();
	public static final String MODIFIED_XPATH = ATOM_NS_PREFIX + COLON + UPDATED.getName();
	public static final String CREATED_XPATH = ATOM_NS_PREFIX + COLON + PUBLISHED.getName();
	public static final String RIGHTS_XPATH = ATOM_NS_PREFIX + COLON + RIGHTS.getName();
	public static final String ENTRY_XPATH = ATOM_NS_PREFIX + COLON + ENTRY.getName();
	public static final String ENTRY_ID_XPATH = ATOM_NS_PREFIX + COLON + LINK.getName() + "[@rel='alternate']/@href";
}
