package org.eurekaclinical.registry.service.entity;

import javax.persistence.Column;
/*-
 * #%L
 * Eureka! Clinical Registry Service
 * %%
 * Copyright (C) 2017 - 2018 Emory University
 * %%
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * #L%
 */
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import org.eurekaclinical.standardapis.entity.ComponentEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;

/**
*
* @author Dileep Gunda
*/
@Entity
@Table(name = "components")
public class AuthorizedComponentEntity implements ComponentEntity {
	

	/**
	 * The component's unique identifier.
	 */
	@Id
	@SequenceGenerator(name = "component_SEQ_GENERATOR", sequenceName = "component_SEQ",
			allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE,
			generator = "component_SEQ_GENERATOR")
	private Long id;
	/**
	 * The component's name.
	 */
	@Column(unique = true, nullable = false)
	private String name;
	/**
	 * Is this component a default component? Default components are assigned to all new users.
	 */
	private boolean defaultcomponent;

	/**
	 * Create an empty component.
	 */
	public AuthorizedComponentEntity() {
		super();
	}

	/**
	 * Get the component's identification number.
	 *
	 * @return A {@link Long} representing the component's id.
	 */
	@Override
	public Long getId() {
		return this.id;
	}

	/**
	 * Set the component's identification number.
	 *
	 * @param inId The number representing the component's id.
	 */
	@Override
	public void setId(Long inId) {
		this.id = inId;
	}

	/**
	 * Get the component's name.
	 *
	 * @return A String containing the component's name.
	 */
	@Override
	public String getName() {
		return this.name;
	}

	/**
	 * Set the component's name.
	 *
	 * @param inName A string containing the component's name.
	 */
	@Override
	public void setName(String inName) {
		this.name = inName;
	}

	/**
	 * Is this component a default component?
	 *
	 * @return True if the component is a default component, false otherwise.
	 */

	public boolean isDefaultComponent() {
		return this.defaultcomponent;
	}

	/**
	 * Set the component's default flag.
	 *
	 * @param inDefaultcomponent True or False, True indicating a default component, False
	 *            indicating a non-default component.
	 */

	public void setDefaultComponent(boolean inDefaultcomponent) {
		this.defaultcomponent = inDefaultcomponent;
	}


	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}


	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof AuthorizedComponentEntity)) return false;

		AuthorizedComponentEntity component = (AuthorizedComponentEntity) o;

		if (defaultcomponent != component.defaultcomponent) return false;
		if (!id.equals(component.id)) return false;
		if (!name.equals(component.name)) return false;

		return true;
	}

	@Override
	public int hashCode() {
		int result = id.hashCode();
		result = 31 * result + name.hashCode();
		result = 31 * result + (defaultcomponent ? 1 : 0);
		return result;
	}	

}
