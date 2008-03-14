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

public class Aggregation extends AggregateBase {

	private List<AggregatedResource> resources;
	
	public Aggregation(String id) throws URISyntaxException {
		this(new URI(id));
	}
	
	public Aggregation(URI id) {
		super(id);
		this.resources = new LinkedList<AggregatedResource>();
	}
		
	public int numberOfResources() {
		return resources.size();
	}
	
	public List<AggregatedResource> getResources() {
		return resources;
	}
		
	public AggregatedResource getResource(int index) {
		return resources.get(index);
	}
	
	public AggregatedResource getResource(String id) throws URISyntaxException {
		return getResource(new URI(id));
	}
	
	public AggregatedResource getResource(URI id) {
		for (AggregatedResource resource : resources) {
			if (resource.getId().equals(id)) {
				return resource;
			}
		}
		return null;
	}
	
	public void setResources(List<AggregatedResource> resources) {
		this.resources = resources;
	}
	
	public void addResource(AggregatedResource resource) {
		resources.add(resource);
	}
}
