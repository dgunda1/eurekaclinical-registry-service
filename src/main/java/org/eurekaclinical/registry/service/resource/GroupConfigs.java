package org.eurekaclinical.registry.service.resource;

import org.eurekaclinical.registry.client.comm.GroupConfig;
import org.eurekaclinical.registry.service.entity.AuthorizedUserEntity;
import org.eurekaclinical.registry.service.entity.ConfigEntity; 
import org.eurekaclinical.registry.service.dao.GroupDao;
import org.eurekaclinical.registry.service.dao.GroupConfigDao;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.core.Response;
import org.eurekaclinical.standardapis.exception.HttpStatusException;
/**
*
* @author Dileep Gunda
*/
public class GroupConfigs {

	
	private final GroupDao groupDao; 
	private final AuthorizedUserEntity groupUser;
	private final GroupConfigDao configDao;
	private final ConfigsDTOExtractor extractor;

	//GroupConfigs(EtlProperties inEtlProperties, AuthorizedUserEntity inEtlUser, SourceConfigDao inSourceConfigDao, GroupDao inGroupDao) {
	GroupConfigs( AuthorizedUserEntity inGroupUser,  GroupConfigDao inGroupConfigDao, GroupDao inGroupDao) {
		try {
			 
			this.groupDao = inGroupDao;
			this.groupUser = inGroupUser;
			this.configDao = inGroupConfigDao;
			this.extractor = new ConfigsDTOExtractor(this.groupUser);
		} catch (IOException ex) {
			throw new HttpStatusException(Response.Status.INTERNAL_SERVER_ERROR,
					"Could not create source config directory", ex);
		}
	}

	/**
	 * Gets the specified source extractDTO. If it does not exist or the current
	 * user lacks read permissions for it, this method returns
	 * <code>null</code>.
	 *
	 * @return a extractDTO.
	 */
	public final GroupConfig getOne(String configId) {
		if (configId == null) {
			throw new IllegalArgumentException("configId cannot be null");
		}

		return (GroupConfig) extractor.extractDTO(this.configDao.getByName(configId));
	}

	/**
	 * Gets all configs for which the current user has read permissions.
	 *
	 * @return a {@link List} of configs.
	 */
	public final List<GroupConfig> getAll() {
		List<GroupConfig> result = new ArrayList<>();
		for (ConfigEntity configEntity : this.configDao.getAll()) {
			GroupConfig dto = (GroupConfig) extractor.extractDTO(configEntity);
			if (dto != null) {
				result.add(dto);
			}
		}
		return result;
	}

}
