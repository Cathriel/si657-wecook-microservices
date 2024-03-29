package pe.edu.upc.client;


import pe.edu.upc.model.Profile;
import pe.edu.upc.model.Recipe;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "recipe-service", fallback = RecipeHystrixFallbackFactory.class)
public interface RecipeClient {

    @GetMapping(value = "/recipes/{id}")
    public ResponseEntity<Recipe> getRecipe(@PathVariable("id") long id);

}
