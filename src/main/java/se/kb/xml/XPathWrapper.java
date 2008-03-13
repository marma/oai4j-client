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
package se.kb.xml;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.Node;
import org.dom4j.XPath;

public class XPathWrapper {

    private Node node;
    private Map<String, String> namespaces;
    
    public XPathWrapper(Node node) {
        this(node, new HashMap<String, String>());
    }
    
    public XPathWrapper(Node node, Map<String, String> namespaces) {
        this.node = node;
        this.namespaces = namespaces;
    }
    
    public void addNamespace(String prefix, String uri) {
        namespaces.put(prefix, uri);
    }
    
    public Node selectSingleNode(String xpathExpression) {
        XPath xpath = createXPath(xpathExpression);
        return xpath.selectSingleNode(node);
    }
    
    @SuppressWarnings("unchecked")
    public List<Node> selectNodes(String xpathExpression) {
        XPath xpath = createXPath(xpathExpression);
        return xpath.selectNodes(node);
    }
    
    public Element selectSingleElement(String xpathExpression) {
        return (Element) selectSingleNode(xpathExpression);
    }
    
    public String valueOf(String xpathExpression) {
        XPath xpath =createXPath(xpathExpression);
        return xpath.valueOf(node);
    }
    
    private XPath createXPath(String xpathExpression) {
        XPath xpath = DocumentHelper.createXPath(xpathExpression);
        xpath.setNamespaceURIs(namespaces);
        return xpath;
    }
}
