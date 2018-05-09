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
public interface UserSupport {
	
	AttributePrincipal getUserPrincipal(HttpServletRequest request);

	Map<String, Object> getUserPrincipalAttributes(HttpServletRequest request);

	boolean isSameUser(HttpServletRequest servletRequest, User user);

	boolean isSameUser(HttpServletRequest servletRequest, UserEntity user);

	boolean isSameUser(HttpServletRequest servletRequest, String username);
    
}
