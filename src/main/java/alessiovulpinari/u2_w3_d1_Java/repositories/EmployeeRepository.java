package alessiovulpinari.u2_w3_d1_Java.repositories;

import alessiovulpinari.u2_w3_d1_Java.entities.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, UUID> {
    Optional<Employee> findByEmail(String email);
    Optional<Employee> findByUsername(String username);
}
