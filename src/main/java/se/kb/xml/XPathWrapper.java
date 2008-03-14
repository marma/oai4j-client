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
