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

import java.util.LinkedList;
import java.util.List;

import org.dom4j.Node;
import org.w3c.dom.Document;

public class MetadataFormatsList extends ResponseBase {

    private static final String METADATAFORMAT_XPATH = "oai:ListMetadataFormats/oai:metadataFormat";
    
    private List<MetadataFormat> metadataFormats;
    
    public MetadataFormatsList(Document document) throws PMHErrorResponseException {
        super(document);
        
        this.metadataFormats = new LinkedList<MetadataFormat>();
        for(Node metadataFormat : xpath.selectNodes(METADATAFORMAT_XPATH)) {
            metadataFormats.add(new MetadataFormat(metadataFormat));
        }
    }
    
    public int size() {
        return metadataFormats.size();
    }
    
    public List<MetadataFormat> asList() {
        return metadataFormats;
    } 
}
