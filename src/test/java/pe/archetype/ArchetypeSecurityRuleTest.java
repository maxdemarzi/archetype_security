package pe.archetype;

import org.junit.Test;
import org.neo4j.harness.ServerControls;
import org.neo4j.harness.TestServerBuilders;
import org.neo4j.test.server.HTTP;
import pe.archety.ArchetypeSecurityRule;

import static org.junit.Assert.assertEquals;

public class ArchetypeSecurityRuleTest {

    @Test
    public void should401WhenRootIsRequested() throws Exception
    {
        // Given
        try ( ServerControls server = TestServerBuilders.newInProcessBuilder()
                .withConfig("org.neo4j.server.rest.security_rules", ArchetypeSecurityRule.class.getCanonicalName())
                .newServer() )
        {
            // When
            HTTP.Response response = HTTP.GET( server.httpURI().resolve( "/" ).toString() );

            // Then
            assertEquals( 401, response.status() );
        }
    }

    @Test
    public void should401WhenDataIsRequested() throws Exception
    {
        // Given
        try ( ServerControls server = TestServerBuilders.newInProcessBuilder()
                .withConfig("org.neo4j.server.rest.security_rules", ArchetypeSecurityRule.class.getCanonicalName())
                .newServer() )
        {
            // When
            HTTP.Response response = HTTP.GET( server.httpURI().resolve( "/db/data" ).toString() );

            // Then
            assertEquals( 401, response.status() );
        }
    }

    @Test
    public void should404WhenHelloWorldIsRequested() throws Exception
    {
        // Given
        try ( ServerControls server = TestServerBuilders.newInProcessBuilder()
                .withConfig("org.neo4j.server.rest.security_rules", ArchetypeSecurityRule.class.getCanonicalName())
                .newServer() )
        {
            // When
            HTTP.Response response = HTTP.GET( server.httpURI().resolve( "/v1/service/helloworld" ).toString() );

            // Then
            assertEquals( 404, response.status() );
        }
    }
}
