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

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.URISyntaxException;

/**
 * An aggregated resource is a resource, that together with other resources, 
 * create an {@link Aggregation}. This class has the actual content of a 
 * resource and also metadata about it.
 * 
 * @author Oskar Grenholm, National Library of Sweden
 */
public class AggregatedResource extends AggregateBase {
	
	private String mimetype;
	
	/**
	 * Create an <code>AggreagatedResource</code> with the specified id.
	 * 
	 * @param id the id
	 * 
	 * @throws URISyntaxException
	 */
	public AggregatedResource(String id) throws URISyntaxException {
		this(new URI(id));
	}
	

	/**
	 * Create an <code>AggreagatedResource</code> with the specified id.
	 * 
	 * @param id the id
	 */
	public AggregatedResource(URI id) {
		super(id);
	}
	/**
	 * Get the MIME type (if known) for this <code>AggreagatedResource</code>. 
	 * 
	 * @return the MIME type, or <code>null</code> if not known
	 */
	public String getMimeType() {
		return mimetype;
	}
	
	/**
	 * Set the MIME type for this <code>AggreagatedResource</code>. 
	 * 
	 * @param mimetype the MIME type
	 */
	public void setMimeType(String mimetype) {
		this.mimetype = mimetype;
	}
	
	/**
	 * Get an <code>InputStream</code> for the content held in this 
	 * <code>AggreagatedResource</code>. 
	 * 
	 * @return a stream to the content
	 * @throws IOException
	 */
	public InputStream getContent() throws IOException {
		return id.toURL().openStream();
	}
	
	/**
	 * Get a <code>String</code> containing the content for this 
	 * <code>AggreagatedResource</code>. 
	 * 
	 * @return a stream to the content
	 * @throws IOException
	 */
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
