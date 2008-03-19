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
import java.util.LinkedList;
import java.util.List;

import org.dom4j.QName;

/**
 * Abstract base class for those classes that make up an aggregation, i.e.
 * <code>Aggregation</code> and <code>AggregatedResource</code>. It can be used to
 * get and set <code>Types</code> and <code>Metadata</code>.
 * 
 * @author Oskar Grenholm, National Library of Sweden
 */
public abstract class AggregateBase {

	protected URI id;
	protected List<Type> types; 
	protected List<Metadata> metadata;
	
	/**
	 * Creates an <code>AggregateBase</code> with the specified id.
	 * 
	 * @param id the id
 	 */
	public AggregateBase(URI id) {
		this.id = id;
		this.types = new LinkedList<Type>();
		this.metadata = new LinkedList<Metadata>();
	}
	
	/**
	 * Get the id.
	 * 
	 * @return the id
	 */
	public URI getId() {
		return id;
	}
	
	/**
	 * Set the id.
	 * 
	 * @param id the id
	 */
	public void setId(URI id) {
		this.id = id;
	}
		
	/**
	 * Get all types associated with this object. 
	 * 
	 * @return a list of types
	 */
	public List<Type> getTypes() {
		return types;
	}

	/**
	 * Set the types associated with this object.
	 * 
	 * @param types a list of types
	 */
	public void setTypes(List<Type> types) {
		this.types = types;
	}

	/**
	 * Add a <code>Type</code> to this object.
	 * 
	 * @param type a type
	 */
	public void addType(Type type) {
		types.add(type);
	}
	
	/**
	 * Get a list of all the <code>Metadata</code> for this object.
	 * 
	 * @return a list with metadata
	 */
	public List<Metadata> getMetadata() {
		return metadata;
	}
	
	/**
	 * Get a list of only the <code>Metadata</code> that matches 
	 * the qualified name for this object.
	 * 
	 * @param name a qualified name
	 * 
	 * @return a list with metadata
	 */
	public List<Metadata> getMetadata(QName name) {
		List<Metadata> list = new LinkedList<Metadata>();
		for (Metadata meta : metadata) {
			if (meta.getName().equals(name)) {
				list.add(meta);
			}
		}
		return list;
	}

	/**
	 * Set the metadata for this object.
	 * 
	 * @param metadata a list with metadata
	 */
	public void setMetadata(List<Metadata> metadata) {
		this.metadata = metadata;
	}
	
	/**
	 * Add a <code>Metadata</code> to the list of metadata.
	 * 
	 * @param meta a metadata
	 */
	public void addMetadata(Metadata meta) {
		metadata.add(meta);
	}	
}
