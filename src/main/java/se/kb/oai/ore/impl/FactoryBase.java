package se.kb.oai.ore.impl;

import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import se.kb.oai.OAIException;
import se.kb.oai.ore.ResourceMap;
import se.kb.oai.ore.ResourceMapFactory;

public abstract class FactoryBase implements ResourceMapFactory {

	public ResourceMap newResourceMap(String uri) throws URISyntaxException {
		return new ResourceMap(uri);
	}
	
	public ResourceMap newResourceMap(URI uri) {
		return new ResourceMap(uri);
	}	
	
	public ResourceMap getResourceMap(URL url) throws OAIException {
		try {
			SAXReader reader = new SAXReader();
			Document document = reader.read(url);
			return getResourceMap(document.getRootElement());
		} catch (Exception e) {
			throw new OAIException(e);
		}		
	}

	public ResourceMap getResourceMap(String url) throws OAIException {
		try {
			return getResourceMap(new URL(url));
		} catch (Exception e) {
			throw new OAIException(e);
		}
	}

	public abstract ResourceMap getResourceMap(Element root) throws OAIException;
}