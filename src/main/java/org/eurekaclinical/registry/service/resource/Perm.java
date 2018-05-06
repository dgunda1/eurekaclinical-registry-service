package org.eurekaclinical.registry.service.resource;

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

import org.eurekaclinical.registry.service.entity.AuthorizedUserEntity;


/**
 *
 * @author Dileep Gunda
 */
class Perm {
	AuthorizedUserEntity owner;
	boolean read;
	boolean write;
	boolean execute;

	Perm(AuthorizedUserEntity owner, boolean read, boolean write, boolean execute) {
		this.owner = owner;
		this.read = read;
		this.write = write;
		this.execute = execute;
	}
    
}
