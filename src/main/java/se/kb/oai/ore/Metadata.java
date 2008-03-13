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
