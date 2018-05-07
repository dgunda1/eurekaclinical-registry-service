package org.eurekaclinical.registry.service.dao;



import org.eurekaclinical.registry.service.entity.AuthorizedUserEntity;
import org.eurekaclinical.registry.service.entity.GroupConfigEntity;
import org.eurekaclinical.registry.service.entity.GroupEntity;
import org.eurekaclinical.standardapis.dao.Dao;

/**
 *
 * @author Dileep Gunda
 */
public interface GroupDao extends Dao<GroupEntity, Long> {
	GroupEntity getByName(String name);
	
	ResolvedPermissions resolveGroupConfigPermissions(AuthorizedUserEntity etlUser, GroupConfigEntity entity);
	
}
