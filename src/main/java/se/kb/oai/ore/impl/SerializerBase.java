package se.kb.oai.ore.impl;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import org.dom4j.Element;

import se.kb.oai.ore.ResourceMap;
import se.kb.oai.ore.ResourceMapSerializer;
import se.kb.xml.XMLUtils;

public abstract class SerializerBase implements ResourceMapSerializer {

	public void serializeToFile(File file, ResourceMap map) throws IOException {
		FileOutputStream out = new FileOutputStream(file);
		XMLUtils.writeXmlTo(serializeToXml(map), out);
		out.close();
	}

	public String serializeToString(ResourceMap map) throws IOException {
		return XMLUtils.xmlToString(serializeToXml(map));
	}

	public abstract Element serializeToXml(ResourceMap map);	
}
