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

import java.util.LinkedList;
import java.util.List;

import org.dom4j.Element;
import org.dom4j.Node;

import se.kb.xml.XPathWrapper;

public class Set {

    private static final String SPEC_XPATH = "oai:setSpec";
    private static final String NAME_XPATH = "oai:setName";
    private static final String DESCRIPTION_XPATH = "oai:setDescription/*";
    
    private String spec;
    private String name;
    private List<Element> descriptions;
    
    public Set(Node node) {
        XPathWrapper xpath = new XPathWrapper(node);
        xpath.addNamespace(OAI_NS_PREFIX, OAI_NS_URI);
    
        this.spec = xpath.valueOf(SPEC_XPATH);
        this.name = xpath.valueOf(NAME_XPATH);
        this.descriptions = new LinkedList<Element>();
        for (Node description : xpath.selectNodes(DESCRIPTION_XPATH)) {
            descriptions.add((Element) description);
        }
    }

    public String getSpec() {
        return spec;
    }

    public String getName() {
        return name;
    }
    
    public List<Element> getDescriptions() {
        return descriptions;
    }
}
