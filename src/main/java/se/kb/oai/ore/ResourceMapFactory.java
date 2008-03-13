package se.kb.oai.ore;

import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

import org.dom4j.Element;

import se.kb.oai.OAIException;

public interface ResourceMapFactory {

	public ResourceMap newResourceMap(String uri) throws URISyntaxException;
	
	public ResourceMap newResourceMap(URI uri);
	
	public ResourceMap getResourceMap(URL url) throws OAIException;
	
	public ResourceMap getResourceMap(String url) throws OAIException;
	
	public ResourceMap getResourceMap(Element root) throws OAIException;
}
