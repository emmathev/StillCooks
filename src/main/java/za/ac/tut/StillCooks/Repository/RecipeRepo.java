package za.ac.tut.StillCooks.Repository;


import za.ac.tut.StillCooks.Model.StillCooksRecipes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface RecipeRepo extends JpaRepository<StillCooksRecipes, Long> {
}

