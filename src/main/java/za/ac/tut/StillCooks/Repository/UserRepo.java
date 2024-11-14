package za.ac.tut.StillCooks.Repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.tut.StillCooks.Model.StillCooksUser;

@Repository
public interface UserRepo extends JpaRepository<StillCooksUser,Long> {

    Optional<StillCooksUser> findByUsername(String username);
}
