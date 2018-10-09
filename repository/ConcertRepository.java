package concert.demo.repository;

import concert.demo.entity.Concert;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public
interface ConcertRepository extends JpaRepository<Concert, Long> {
    Concert findByConcertName(String concertName);
}