/*
 * Created on 17 Aug 2007
 *
 * Copyright (C) 2007 Royal Library of Sweden.
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public License
 * as published by the Free Software Foundation; either version 2
 * of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place - Suite 330, Boston, MA  02111-1307, USA.
 */
package se.kb.oai.pmh;

import static se.kb.oai.pmh.ResponseBase.*;

import org.dom4j.Node;

import se.kb.xml.XPathWrapper;

public class MetadataFormat {

    private static final String PREFIX_XPATH = "oai:metadataPrefix";
    private static final String SCHEMA_XPATH = "oai:schema";
    private static final String NAMESPACE_XPATH = "oai:metadataNamespace";
    
    private String prefix;
    private String schema;
    private String namespace;
    
    public MetadataFormat(Node node) {
        XPathWrapper xpath = new XPathWrapper(node);
        xpath.addNamespace(OAI_NS_PREFIX, OAI_NS_URI);
        
        this.prefix = xpath.valueOf(PREFIX_XPATH);
        this.schema = xpath.valueOf(SCHEMA_XPATH);
        this.namespace = xpath.valueOf(NAMESPACE_XPATH);
    }   

    public String getPrefix() {
        return prefix;
    }

    public String getSchema() {
        return schema;
    }
    
    public String getNamespace() {
        return namespace;
    }   
}
