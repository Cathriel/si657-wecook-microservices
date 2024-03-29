package pe.edu.upc.client;

import pe.edu.upc.model.Profile;
import pe.edu.upc.model.Recipe;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class RecipeHystrixFallbackFactory implements RecipeClient{

    @Override
    public ResponseEntity<Recipe> getRecipe(long id){
        Recipe recipe= Recipe.builder()
                .name("none")
                .views(0)
                .exclusive(false)
                .preparation("none")
                .recommendation("none")
                .build();

        return ResponseEntity.ok(recipe);
    }

}
