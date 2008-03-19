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

import static se.kb.oai.ore.OREConstants.*;

import org.dom4j.QName;

/**
 * Class that represents a metadata element that can be set for an <code>Aggregation</code>
 * or an <code>AggreagatedResource</code>. Only metadata from the Dublin Core elements
 * (DC) namespace or the Dublin Core terms (DCTERMS) namespace can be created.
 * 
 * @author Oskar Grenholm, National Library of Sweden
 */
public class Metadata {

	public enum Namespace { DC, DCTERMS }
	
	private QName qname;
	private String value;
	
	/**
	 * Create a <code>Metadata</code>.
	 * 
	 * @param ns a namespace, can only be DC or DCTERMS
	 * @param name the name of the metadata element
	 * @param value the value of the metadata
	 */
	public Metadata(Namespace ns, String name, String value) {
		this.qname = getName(ns, name);
		this.value = value;
	}
	
	/**
	 * Get the qualified name of this metadata.
	 * 
	 * @return the name
	 */
	public QName getName() {
		return qname;
	}
	
	/**
	 * Get the value of this metadata.
	 * 
	 * @return the value
	 */
	public String getValue() {
		return value;
	}
	
	/**
	 * Set the value.
	 * 
	 * @param value the value
	 */
	public void setValue(String value) {
		this.value = value;
	}
	
	/**
	 * Helper method that creates a qualified name with the given
	 * namespace and name.
	 * 
	 * @param ns a namespace, can only be DC or DCTERMS
	 * @param name the name
	 * 
	 * @return a qualified name
	 */
	public static QName getName(Namespace ns, String name) {
		switch (ns) {
			case DC: 		
				return new QName(name, DC_NS);
			case DCTERMS:	
				return new QName(name, DCTERMS_NS);
		}
		return null;
	}
}
