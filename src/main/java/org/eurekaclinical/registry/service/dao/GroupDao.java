package org.eurekaclinical.registry.service.dao;



import org.eurekaclinical.registry.service.entity.GroupEntity;
import org.eurekaclinical.standardapis.dao.Dao;

/**
 *
 * @author Dileep Gunda
 */
public interface GroupDao extends Dao<GroupEntity, Long> {
	GroupEntity getByName(String name);
	

	
}
