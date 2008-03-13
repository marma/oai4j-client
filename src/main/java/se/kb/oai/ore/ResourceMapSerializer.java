package se.kb.oai.ore;

import java.io.File;
import java.io.IOException;

import org.dom4j.Element;

public interface ResourceMapSerializer {

	public void serializeToFile(File file, ResourceMap map) throws IOException;
	
	public String serializeToString(ResourceMap map) throws IOException;	

	public Element serializeToXml(ResourceMap map);
}
