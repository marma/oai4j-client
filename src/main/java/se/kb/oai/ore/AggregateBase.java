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

public abstract class AggregateBase {

	protected URI id;
	protected List<Type> types; 
	protected List<Metadata> metadata;
	
	public AggregateBase(URI id) {
		this.id = id;
		this.types = new LinkedList<Type>();
		this.metadata = new LinkedList<Metadata>();
	}
	
	public URI getId() {
		return id;
	}
	
	public void setId(URI id) {
		this.id = id;
	}
		
	public List<Type> getTypes() {
		return types;
	}

	public void setTypes(List<Type> types) {
		this.types = types;
	}

	public void addType(Type type) {
		types.add(type);
	}
	
	public List<Metadata> getMetadata() {
		return metadata;
	}
	
	public List<Metadata> getMetadata(QName name) {
		List<Metadata> list = new LinkedList<Metadata>();
		for (Metadata meta : metadata) {
			if (meta.getName().equals(name)) {
				list.add(meta);
			}
		}
		return list;
	}

	public void setMetadata(List<Metadata> metadata) {
		this.metadata = metadata;
	}
	
	public void addMetadata(Metadata meta) {
		metadata.add(meta);
	}	
}
