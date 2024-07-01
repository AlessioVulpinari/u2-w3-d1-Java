package alessiovulpinari.u2_w3_d1_Java.repositories;


import alessiovulpinari.u2_w3_d1_Java.entities.Device;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface DeviceRepository extends JpaRepository<Device, UUID> {

}
