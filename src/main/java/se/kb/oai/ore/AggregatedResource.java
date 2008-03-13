package se.kb.oai.ore;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.URISyntaxException;

public class AggregatedResource extends AggregateBase {
	
	public AggregatedResource(String id) throws URISyntaxException {
		this(new URI(id));
	}
	
	public AggregatedResource(URI id) {
		super(id);
	}
		
	public InputStream getContent() throws IOException {
		return id.toURL().openStream();
	}
	public String getContentAsString() throws IOException {
		InputStream in = getContent();
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		byte[] bytes = new byte[4 * 1024];
		int read = in.read(bytes);
		while (read != -1) {
			out.write(bytes, 0, read);
			read = in.read(bytes);
		}
		in.close();
		return new String(out.toByteArray());
	}	
}
