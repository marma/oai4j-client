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
	
	/**
	 * Create an <code>ResourceMap</code> with the specified id.
	 * 
	 * @param id the id
	 * 
	 * @throws URISyntaxException
	 */
	public ResourceMap(String id) throws URISyntaxException {
		this(new URI(id));
	}
	
	/**
	 * Create an <code>ResourceMap</code> with the specified id.
	 * 
	 * @param id the id
	 */
	public ResourceMap(URI id) {
		this.id = id;
		this.aggregation = new Aggregation(id.resolve("#aggregation"));
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
	 * Get the creator of this resource map. 
	 * (Note: NOT the creator of the aggregation or the resources.)
	 * 
	 * @return the creator
	 */
	public String getCreator() {
		return creator;
	}
	
	/**
	 * Set the creator of this resource map.
	 * (Note: NOT the creator of the aggregation or the resources.)
	 * 
	 * @param creator the creator
	 */
	public void setCreator(String creator) {
		this.creator = creator;
	}
	
	/**
	 * Get the rights of this resource map. 
	 * (Note: NOT the rights of the aggregation or the resources.)
	 * 
	 * @return the rights
	 */
	public String getRights() {
		return rights;
	}
	
	/**
	 * Set the rights of this resource map. 
	 * (Note: NOT the rights of the aggregation or the resources.)
	 * 
	 * @param rights the rights
	 */
	public void setRights(String rights) {
		this.rights = rights;
	}
	
	/**
	 * Get the creation date of this resource map. 
	 * (Note: NOT the creation date of the aggregation or the resources.)
	 * 
	 * @return the creation date
	 */
	public Date getCreated() {
		return created;
	}
	
	/**
	 * Set the creation date of this resource map. 
	 * (Note: NOT the creation date of the aggregation or the resources.)
	 * 
	 * @param created the creation date
	 */
	public void setCreated(Date created) {
		this.created = created;
	}
	

	/**
	 * Get the modification date of this resource map. 
	 * (Note: NOT the modification date of the aggregation or the resources.)
	 * 
	 * @return the modification date
	 */
	public Date getModified() {
		return modified;
	}
	
	/**
	 * Set the modification date of this resource map. 
	 * (Note: NOT the modification date of the aggregation or the resources.)
	 * 
	 * @param modified he modification date
	 */
	public void setModified(Date modified) {
		this.modified = modified;
	}

	/**
	 * Get the aggregation that this resource map describes.
	 * 
	 * @return the aggregation
	 */
	public Aggregation getAggregation() {
		return aggregation;
	}

	/**
	 * Set the aggregation that this resource map describes.
	 * 
	 * @param aggregation the aggregation
	 */
	public void setAggregation(Aggregation aggregation) {
		this.aggregation = aggregation;
	}		
}
