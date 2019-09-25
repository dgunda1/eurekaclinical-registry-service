package org.eurekaclinical.registry.service.dao;

/*-
 * #%L
 * Eureka! Clinical Registry Service
 * %%
 * Copyright (C) 2017 Emory University
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

import org.eurekaclinical.registry.service.entity.AuthorizedRoleEntity;
import org.eurekaclinical.standardapis.dao.AbstractJpaRoleDao;

import javax.inject.Inject;
import javax.inject.Provider;
import javax.persistence.EntityManager;

/**
 * Created by akalsan on 10/4/16.
 */


public class JpaRoleDao extends AbstractJpaRoleDao<AuthorizedRoleEntity> implements RegistryServiceRoleDao{

    /**
     * Create an object with the give entity manager.
     *
     * @param inEMProvider The entity manager to be used for communication with
     * the data store.
     */
    @Inject
    public JpaRoleDao(final Provider<EntityManager> inEMProvider) {
        super(AuthorizedRoleEntity.class, inEMProvider);
    }
}
