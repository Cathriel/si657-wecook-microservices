package pe.edu.upc.respositories;


import pe.edu.upc.entities.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface RecipeRepository extends JpaRepository<Recipe,Long> {
    public Optional<List<Recipe>> findRecipesByProfileId(long profileId);
    public Optional<List<Recipe>> findRecipesByCookbookId(long cookbookId);
}
