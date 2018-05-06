package org.eurekaclinical.registry.service.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.eurekaclinical.standardapis.entity.GroupEntity;

/**
*
* @author Dileep Gunda
*/
@Entity
@Table(name = "groups")
public class AuthorizedGroupEntity implements GroupEntity {


	/**
	 * The group's unique identifier.
	 */
	@Id
	@SequenceGenerator(name = "GROUP_SEQ_GENERATOR1", sequenceName = "GROUP_SEQ",
			allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE,
			generator = "GROUP_SEQ_GENERATOR1")
	private Long id;
	/**
	 * The group's name.
	 */
	@Column(unique = true, nullable = false)
	private String name;
	/**
	 * Is this group a default group? Default groups are assigned to all new users.
	 */
	private boolean defaultgroup;

	/**
	 * Create an empty group.
	 */
	public AuthorizedGroupEntity() {
		super();
	}

	/**
	 * Get the group's identification number.
	 *
	 * @return A {@link Long} representing the group's id.
	 */
	@Override
	public Long getId() {
		return this.id;
	}

	/**
	 * Set the group's identification number.
	 *
	 * @param inId The number representing the group's id.
	 */
	@Override
	public void setId(Long inId) {
		this.id = inId;
	}

	/**
	 * Get the group's name.
	 *
	 * @return A String containing the group's name.
	 */
	@Override
	public String getName() {
		return this.name;
	}

	/**
	 * Set the group's name.
	 *
	 * @param inName A string containing the group's name.
	 */
	@Override
	public void setName(String inName) {
		this.name = inName;
	}

	/**
	 * Is this group a default group?
	 *
	 * @return True if the group is a default group, false otherwise.
	 */

	public boolean isDefaultGroup() {
		return this.defaultgroup;
	}

	/**
	 * Set the group's default flag.
	 *
	 * @param inDefaultgroup True or False, True indicating a default group, False
	 *            indicating a non-default group.
	 */

	public void setDefaultGroup(boolean inDefaultgroup) {
		this.defaultgroup = inDefaultgroup;
	}


	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}


	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof AuthorizedGroupEntity)) return false;

		AuthorizedGroupEntity group = (AuthorizedGroupEntity) o;

		if (defaultgroup != group.defaultgroup) return false;
		if (!id.equals(group.id)) return false;
		if (!name.equals(group.name)) return false;

		return true;
	}

	@Override
	public int hashCode() {
		int result = id.hashCode();
		result = 31 * result + name.hashCode();
		result = 31 * result + (defaultgroup ? 1 : 0);
		return result;
	}	

}
