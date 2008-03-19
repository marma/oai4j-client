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
import java.util.LinkedList;
import java.util.List;

/**
 * An aggregation is a set of related resources (see {@link AggregatedResource}), grouped 
 * together such that the set can be treated as a single resource. This class is used to 
 * manage the individual resources and also holds information for the aggregation as 
 * a whole.
 * 
 * @author Oskar Grenholm, National Library of Sweden
 */
public class Aggregation extends AggregateBase {

	private List<AggregatedResource> resources;
	
	/**
	 * Create an <code>Aggregation</code> with the specified id.
	 * 
	 * @param id the id
	 * 
	 * @throws URISyntaxException
	 */
	public Aggregation(String id) throws URISyntaxException {
		this(new URI(id));
	}
	
	/**
	 * Create an <code>Aggregation</code> with the specified id.
	 * 
	 * @param id the id
	 */
	public Aggregation(URI id) {
		super(id);
		this.resources = new LinkedList<AggregatedResource>();
	}
		
	/**
	 * Get the number of resources that this <code>Aggregation</code> has.
	 * 
	 * @return the number of resources
	 */
	public int numberOfResources() {
		return resources.size();
	}
	
	/**
	 * Get this <code>Aggregations</code> list of <code>AggreagatedResources</code>.
	 * 
	 * @return a list of resources
	 */
	public List<AggregatedResource> getResources() {
		return resources;
	}
		
	/**
	 * Get the <code>AggreagatedResource</code> at the specified index.
	 * (There is no guarantee of the ordering of the resources for different
	 * parsings of the same resource map!)
	 * 
	 * @param index the index
	 *
	 * @return the resource
	 */
	public AggregatedResource getResource(int index) {
		return resources.get(index);
	}
	
	/**
	 * Get the <code>AggreagatedResource</code> with the given id.
	 * 
	 * @param id the id of the resource
	 *
	 * @return the resource
	 */
	public AggregatedResource getResource(String id) throws URISyntaxException {
		return getResource(new URI(id));
	}
	
	/**
	 * Get the <code>AggreagatedResource</code> with the given id.
	 * 
	 * @param id the id of the resource
	 *
	 * @return the resource, or <code>null</code> if no match
	 */
	public AggregatedResource getResource(URI id) {
		for (AggregatedResource resource : resources) {
			if (resource.getId().equals(id)) {
				return resource;
			}
		}
		return null;
	}
	
	/**
	 * Set the list of resources.
	 * 
	 * @param resources the list of resources
	 */
	public void setResources(List<AggregatedResource> resources) {
		this.resources = resources;
	}
	
	/**
	 * Add an <code>AggreagatedResource</code> to this <code>Aggregation</code>.
	 * 
	 * @param resource a resource
	 */
	public void addResource(AggregatedResource resource) {
		resources.add(resource);
	}
}
