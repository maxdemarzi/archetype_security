# Security Rule for Archetype API

To Create jar:

    mvn package

To Install:

    cp target/security-1.0.jar neo4j/plugins


In neo4j-server.properties:

    org.neo4j.server.rest.security_rules=pe.archety.ArchetypeSecurityRule
