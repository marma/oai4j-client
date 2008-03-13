package se.kb.oai.ore;

import org.dom4j.Namespace;

public class OREConstants {

	public static final String ATOM_NS_PREFIX = "atom";
	public static final String ATOM_NS_URI = "http://www.w3.org/2005/Atom";
	public static final Namespace ATOM_NS = new Namespace(ATOM_NS_PREFIX, ATOM_NS_URI);
		
	public static final String DC_NS_PREFIX = "dc";
	public static final String DC_NS_URI = "http://purl.org/dc/";
	public static final Namespace DC_NS = new Namespace(DC_NS_PREFIX, DC_NS_URI);
	
	public static final String DCTERMS_NS_PREFIX = "dcterms";
	public static final String DCTERMS_NS_URI = "http://purl.org/dc/terms/";
	public static final Namespace DCTERMS_NS = new Namespace(DCTERMS_NS_PREFIX, DCTERMS_NS_URI);
	
	public static final String RDF_NS_PREFIX = "rdf";
	public static final String RDF_NS_URI = "http://www.w3.org/1999/02/22-rdf-syntax-ns#";
	public static final Namespace RDF_NS = new Namespace(RDF_NS_PREFIX, RDF_NS_URI);
}
