package org.eurekaclinical.registry.service.authentication;


import org.eurekaclinical.registry.service.entity.UserEntity;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.eurekaclinical.common.comm.User;
import org.jasig.cas.client.authentication.AttributePrincipal;

/**
 *
 * @author Dileep Gunda
 */
public abstract class AbstractUserSupport implements UserSupport {
	
	protected AbstractUserSupport() {
	}
	
	@Override
	public AttributePrincipal getUserPrincipal(HttpServletRequest request) {
		return (AttributePrincipal) request.getUserPrincipal();
	}
	
	@Override
	public Map<String, Object> getUserPrincipalAttributes(HttpServletRequest request) {
		AttributePrincipal principal = getUserPrincipal(request);
		return principal.getAttributes();
	}
		
	@Override
	public boolean isSameUser(HttpServletRequest servletRequest, User user) {
		return isSameUser(servletRequest, user.getUsername());
	}
	
	@Override
	public boolean isSameUser(HttpServletRequest servletRequest, UserEntity user) {
		return isSameUser(servletRequest, user.getUsername());
	}
	
	@Override
	public boolean isSameUser(HttpServletRequest servletRequest, String username) {
		AttributePrincipal principal = getUserPrincipal(servletRequest);
		if (!principal.getName().equals(username)) {
			return false;
		}
		return true;
	}
	
}
