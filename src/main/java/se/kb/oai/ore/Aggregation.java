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
