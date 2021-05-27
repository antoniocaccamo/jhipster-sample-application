package me.antoniocaccamo.jhipster.sampleapp;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.noClasses;

import com.tngtech.archunit.core.domain.JavaClasses;
import com.tngtech.archunit.core.importer.ClassFileImporter;
import com.tngtech.archunit.core.importer.ImportOption;
import org.junit.jupiter.api.Test;

class ArchTest {

    @Test
    void servicesAndRepositoriesShouldNotDependOnWebLayer() {
        JavaClasses importedClasses = new ClassFileImporter()
            .withImportOption(ImportOption.Predefined.DO_NOT_INCLUDE_TESTS)
            .importPackages("me.antoniocaccamo.jhipster.sampleapp");

        noClasses()
            .that()
            .resideInAnyPackage("me.antoniocaccamo.jhipster.sampleapp.service..")
            .or()
            .resideInAnyPackage("me.antoniocaccamo.jhipster.sampleapp.repository..")
            .should()
            .dependOnClassesThat()
            .resideInAnyPackage("..me.antoniocaccamo.jhipster.sampleapp.web..")
            .because("Services and repositories should not depend on web layer")
            .check(importedClasses);
    }
}
