package pe.edu.upc.aaw.demo1_202302_si63.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.edu.upc.aaw.demo1_202302_si63.entities.Ingredient;

import java.util.List;

@Repository
public interface IIngredientRepository extends JpaRepository<Ingredient,Integer> {


}
