package org.eurekaclinical.registry.service.dao;


import org.eurekaclinical.registry.service.entity.AuthorizedUserEntity;
import org.eurekaclinical.standardapis.dao.UserDao;

/**
 * A data access object interface for working with {@link UserEntity} objects in the
 * data store.
 *
 * @author Dileep
 *
 */
public interface AuthorizedUserDao extends UserDao<AuthorizedUserEntity> {
	
}
