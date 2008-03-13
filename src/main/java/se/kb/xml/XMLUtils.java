package se.kb.xml;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.XMLWriter;

public class XMLUtils {

	public static final String ENCODING = "UTF-8"; 
	
	public static void writeXmlTo(Element element, OutputStream stream) throws IOException {
		OutputStreamWriter writer = new OutputStreamWriter(stream, ENCODING);
        OutputFormat format = OutputFormat.createPrettyPrint();
        format.setEncoding(ENCODING);
        
        XMLWriter xmlwriter = new XMLWriter(writer, format);
        xmlwriter.write(element);
        xmlwriter.flush();
        writer.flush();
	}
	
	public static String xmlToString(Element xml) throws IOException {
		ByteArrayOutputStream stream = new ByteArrayOutputStream();
        writeXmlTo(xml, stream);        
        return stream.toString(ENCODING);
	}
}
