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
import java.util.Date;

/**
 * A resource map is a description of an {@link Aggregation} according to the OAI-ORE data model. 
 * <code>ResourceMaps</code> can be serialized to a machine readable format, see {@link ResourceMapSerializer}. 
 * This class will consist of the <code>Aggregation</code> it describes and some metadata concerning the 
 * resource map itself. 
 * 
 * @author Oskar Grenholm, National Library of Sweden
 */
public class ResourceMap {

	private URI id;
	private String creator;
	private String rights;
	private Date created;
	private Date modified;
	private Aggregation aggregation;
	
	public ResourceMap(String id) throws URISyntaxException {
		this(new URI(id));
	}
	
	public ResourceMap(URI id) {
		this.id = id;
		this.aggregation = new Aggregation(id.resolve("#aggregation"));
	}
	
	public URI getId() {
		return id;
	}
	
	public void setId(URI id) {
		this.id = id;
	}
	
	public String getCreator() {
		return creator;
	}
	
	public void setCreator(String creator) {
		this.creator = creator;
	}
	
	public String getRights() {
		return rights;
	}
	
	public void setRights(String rights) {
		this.rights = rights;
	}
	
	public Date getCreated() {
		return created;
	}
	
	public void setCreated(Date created) {
		this.created = created;
	}
	
	public Date getModified() {
		return modified;
	}
	
	public void setModified(Date modified) {
		this.modified = modified;
	}

	public Aggregation getAggregation() {
		return aggregation;
	}

	public void setAggregation(Aggregation aggregation) {
		this.aggregation = aggregation;
	}		
}
