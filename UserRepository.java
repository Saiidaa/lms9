import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    List<User> findAllByNameContainsAndAge(String name, Integer age);

    List<User> findAll();

    Map<Object, Object> findById(Long id);

    User saveAndFlush(User user);

    User findByUsername(String username);
}

