package se.kb.oai.pmh;

import se.kb.oai.OAIException;

public class PMHErrorResponseException extends OAIException {
	
	private static final long serialVersionUID = -2010182612617642664L;
	
	public static final String BAD_ARGUMENT = "badArgument";
	public static final String BAD_RESUMPTION_TOKEN = "badResumptionToken";
	public static final String BAD_VERB = "badVerb";
	public static final String CANNOT_DISSEMINATE_FORMAT = "cannotDisseminateFormat";
	public static final String ID_DOES_NOT_EXIST = "idDoesNotExist";
	public static final String NO_RECORDS_MATCH = "noRecordsMatch";
	public static final String NO_METADATA_FORMATS = "noMetadataFormats";
	public static final String NO_SET_HIERARCHY = "noSetHierarchy";

	private String code;
	private String message;
	
	public PMHErrorResponseException(String code, String message) {
		super();
		this.code = code;
		this.message = message;
	}

	public String getCode() {
		return code;
	}

	public String getMessage() {
		return message;
	}	
}
