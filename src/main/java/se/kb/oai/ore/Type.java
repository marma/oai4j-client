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

/**
 * Class that are used for typing <code>Aggregations</code> and
 * <code>AggreagatedResources</code>.
 * 
 * @author Oskar Grenholm, National Library of Sweden
 */
public class Type {

	private String value;
	
	/**
	 * Create a typing with this value.
	 * 
	 * @param value a value
	 */
	public Type(String value) {
		this.value = value;
	}

	/**
	 * Get the value.
	 * 
	 * @return the value
	 */
	public String getValue() {
		return value;
	}
}
