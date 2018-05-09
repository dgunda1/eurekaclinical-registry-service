package org.eurekaclinical.registry.service.authentication;


import org.eurekaclinical.registry.service.entity.AuthorizedUserEntity;
import org.eurekaclinical.registry.service.dao.AuthorizedUserDao;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.core.Response.Status;
import org.eurekaclinical.standardapis.exception.HttpStatusException;
import org.jasig.cas.client.authentication.AttributePrincipal;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author Andrew Post
 */
public class AuthorizedUserSupport extends AbstractUserSupport {
	private static final Logger LOGGER = LoggerFactory.getLogger(AuthorizedUserSupport.class);
	
	private final AuthorizedUserDao userDao;
	
	public AuthorizedUserSupport(AuthorizedUserDao inUserDao) {
		this.userDao = inUserDao;
	}

	public boolean isSameUser(HttpServletRequest servletRequest, AuthorizedUserEntity user) {
		return isSameUser(servletRequest, user.getUsername());
	}
	
	/**
	 * Returns the user object, or if there isn't one, throws an exception.
	 * 
	 * @param servletRequest the HTTP servlet request.
	 * @return the user object.
	 * 
	 * @throws HttpStatusException if the logged-in user isn't in the user
	 * table, which means the user is not authorized to use 
	 * eureka-protempa-etl.
	 */
	public AuthorizedUserEntity getUser(HttpServletRequest servletRequest) {
		AttributePrincipal principal = getUserPrincipal(servletRequest);
		AuthorizedUserEntity result = this.userDao.getByPrincipal(principal);
		if (result == null) {
			throw new HttpStatusException(Status.FORBIDDEN, "User " + principal.getName() + " is unauthorized to use this resource");
		}
		return result;
	}
}
