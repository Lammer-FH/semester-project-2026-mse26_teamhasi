package at.teamhasi.hotel.repositories;

import at.teamhasi.hotel.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Integer> {
    List<UserEntity> findUserEntityByUsername(String username);
}
