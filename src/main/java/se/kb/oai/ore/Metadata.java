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

import static se.kb.oai.ore.OREConstants.*;

import org.dom4j.QName;

public class Metadata {

	public enum Namespace { DC, DCTERMS }
	
	private QName qname;
	private String value;
	
	public Metadata(Namespace ns, String name, String value) {
		this.qname = getName(ns, name);
		this.value = value;
	}
	
	public QName getName() {
		return qname;
	}
	
	public String getValue() {
		return value;
	}
	
	public void setValue(String value) {
		this.value = value;
	}
	
	public static QName getName(Namespace ns, String name) {
		switch (ns) {
			case DC: 		
				return new QName(name, DC_NS);
			case DCTERMS:	
				return new QName(name, DCTERMS_NS);
		}
		return null;
	}
}
