package pe.archety;

import org.neo4j.server.rest.security.SecurityFilter;
import org.neo4j.server.rest.security.SecurityRule;

import javax.servlet.http.HttpServletRequest;

public class ArchetypeSecurityRule implements SecurityRule {

    public static final String REALM = "WallyWorld"; // as per RFC2617 :-);

    @Override
    public boolean isAuthorized(HttpServletRequest request)
    {
        if(request.getRequestURI().startsWith("/v1")) return true;
        return false;
    }

    @Override
    public String forUriPath()
    {
        return "/";
    }

    @Override
    public String wwwAuthenticateHeader()
    {
        return SecurityFilter.basicAuthenticationResponse(REALM);
    }
}
