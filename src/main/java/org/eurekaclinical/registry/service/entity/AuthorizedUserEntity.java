package org.eurekaclinical.registry.service.entity;

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

import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.eurekaclinical.standardapis.entity.UserGroupEntity;

/**
 *
 * @author Dileep Gunda
 */
public class AuthorizedUserEntity implements UserGroupEntity<AuthorizedGroupEntity> {

	/**
	 * The user's unique identifier.
	 */
	@Id
	@SequenceGenerator(name = "USER_SEQ_GENERATOR", sequenceName = "USER_SEQ", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "USER_SEQ_GENERATOR")
	private Long id;
	/**
	 * The user's email address.
	 */
	@Column(unique = true, nullable = false)
	private String username;
	@ManyToMany(cascade = { CascadeType.REFRESH, CascadeType.MERGE })
//	@JoinTable(joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "component_id"))
	@JoinTable(name = "user_group",
    joinColumns = {
        @JoinColumn(name = "user_id")},
    inverseJoinColumns = {
        @JoinColumn(name = "group_id")})
private List<RoleEntity> roles = new ArrayList<>();
	private List<AuthorizedGroupEntity> groups;

	/**
	 * Create an empty User object.
	 */
	public AuthorizedUserEntity() {
		this.groups = new ArrayList<>();

	}

	/**
	 * Get the user's unique identifier.
	 *
	 * @return A {@link Long} representing the user's unique identifier.
	 */
	@Override
	public Long getId() {
		return this.id;
	}

	/**
	 * Set the user's unique identifier.
	 *
	 * @param inId
	 *            A {@link Long} representing the user's unique identifier.
	 */
	@Override
	public void setId(final Long inId) {
		this.id = inId;
	}

	/**
	 * Get the user's email address.
	 *
	 * @return A String containing the user's email address.
	 */
	@Override
	public String getUsername() {
		return this.username;
	}

	/**
	 * Set the user's email address.
	 *
	 * @param inUsername
	 *            A String containing the user's email address.
	 */
	@Override
	public void setUsername(final String inUsername) {
		this.username = inUsername;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}

	public List<AuthorizedGroupEntity> getGroups() {
		return this.groups;
	}

	public void setGroups(List<AuthorizedGroupEntity> inGroups) {
		if (inGroups == null) {
			this.groups = new ArrayList<>();
		} else {
			this.groups = inGroups;
		}
	}

	public void addGroup(AuthorizedGroupEntity groups) {
		this.groups.add(groups);
	}

	public void removeGroup(AuthorizedGroupEntity group) {
		this.groups.remove(group);
	}

}
