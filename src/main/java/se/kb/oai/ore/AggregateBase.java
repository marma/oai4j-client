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
