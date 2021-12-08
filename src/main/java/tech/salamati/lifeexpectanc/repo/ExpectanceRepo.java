package tech.salamati.lifeexpectanc.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import tech.salamati.lifeexpectanc.model.Expectance;

import java.util.Optional;

@Repository
public interface ExpectanceRepo extends CrudRepository<Expectance,Long> {

    Optional<Expectance> findByAgeAndSex(int age,String sex);

}
