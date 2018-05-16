package org.eurekaclinical.registry.service.dao;


import com.google.inject.Inject;
import com.google.inject.Provider;
import org.eurekaclinical.registry.service.entity.GroupConfigEntity;
import org.eurekaclinical.registry.service.entity.GroupConfigEntity_;
import javax.persistence.EntityManager;
import org.eurekaclinical.standardapis.dao.GenericDao;

/**
 *
 * @author Andrew Post
 */
public class JpaGroupConfigDao  extends GenericDao<GroupConfigEntity, Long> implements GroupConfigDao {

	@Inject
	public JpaGroupConfigDao(Provider<EntityManager> inManagerProvider) {
		super(GroupConfigEntity.class, inManagerProvider);
	}

	@Override
	public GroupConfigEntity getByName(String name) {
		return getDatabaseSupport().getUniqueByAttribute(GroupConfigEntity.class, GroupConfigEntity_.name, name);
	}
	
}
