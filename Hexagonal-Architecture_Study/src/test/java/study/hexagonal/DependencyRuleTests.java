package study.hexagonal;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.noClasses;
import static study.hexagonal.archunit.HexagonalArchitecture.boundedContext;

import com.tngtech.archunit.core.importer.ClassFileImporter;
import org.junit.jupiter.api.Test;

class DependencyRuleTests {

    @Test
    void validateRegistrationContextArchitecture() {
        boundedContext("io.reflectoring.buckpal.account")

                .withDomainLayer("domain")

                .withAdaptersLayer("adapter")
                .incoming("in.web")
                .outgoing("out.persistence")
                .and()

                .withApplicationLayer("application")
                .services("service")
                .incomingPorts("port.in")
                .outgoingPorts("port.out")
                .and()

                .withConfiguration("configuration")
                .check(new ClassFileImporter()
                        .importPackages("io.reflectoring.buckpal.."));
    }

    @Test
    void testPackageDependencies() {
        noClasses()
                .that()
                .resideInAPackage("io.reflectoring.reviewapp.domain..")
                .should()
                .dependOnClassesThat()
                .resideInAnyPackage("io.reflectoring.reviewapp.application..")
                .check(new ClassFileImporter()
                        .importPackages("io.reflectoring.reviewapp.."));
    }

}
