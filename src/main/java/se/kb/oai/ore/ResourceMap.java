package se.kb.oai.ore;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Date;

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
