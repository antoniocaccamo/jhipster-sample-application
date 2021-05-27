package me.antoniocaccamo.jhipster.sampleapp.repository;

import me.antoniocaccamo.jhipster.sampleapp.domain.Authority;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Spring Data JPA repository for the {@link Authority} entity.
 */
public interface AuthorityRepository extends JpaRepository<Authority, String> {}
