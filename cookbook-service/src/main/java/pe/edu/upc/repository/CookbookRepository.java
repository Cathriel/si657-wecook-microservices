package pe.edu.upc.repository;

import pe.edu.upc.entity.Cookbook;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CookbookRepository extends JpaRepository<Cookbook,Long> {

    Optional<Cookbook> findCookbookByName(String name);
    public Optional<List<Cookbook>> findCookbookByProfileId(long profileId);

}
