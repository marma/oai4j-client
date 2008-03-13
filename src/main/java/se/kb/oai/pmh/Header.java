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

import java.util.List;
import java.util.LinkedList;

import org.dom4j.Node;

import se.kb.xml.XPathWrapper;

public class Header {
    
    private static final String IDENTIFIER_XPATH = "oai:identifier";
    private static final String DATESTAMP_XPATH = "oai:datestamp";
    private static final String SETSPEC_XPATH = "oai:setSpec";

    private String identifier;
    private String datestamp;
    private List<String> setSpecs;
    
    public Header(Node node) {
        XPathWrapper xpath = new XPathWrapper(node);
        xpath.addNamespace(OAI_NS_PREFIX, OAI_NS_URI);
        
        this.identifier = xpath.valueOf(IDENTIFIER_XPATH);
        this.datestamp = xpath.valueOf(DATESTAMP_XPATH);
        this.setSpecs = new LinkedList<String>();
        for(Node spec : xpath.selectNodes(SETSPEC_XPATH)) {
            setSpecs.add(spec.getText());
        }
    }

    public String getIdentifier() {
        return identifier;
    }
    
    public String getDatestamp() {
        return datestamp;
    }    

    public List<String> getSetSpecs() {
        return setSpecs;
    }
}
