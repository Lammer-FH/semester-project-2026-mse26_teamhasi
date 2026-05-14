package at.teamhasi.hotel.repositories;

import at.teamhasi.hotel.entities.RoomTypeEntity;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoomTypeRepository extends JpaRepository<RoomTypeEntity, Integer> {
    @Query("SELECT r FROM RoomTypeEntity r")
    List<RoomTypeEntity> findAllWithPagination(Pageable pageable);
}
