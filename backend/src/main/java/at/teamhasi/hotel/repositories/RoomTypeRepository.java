package at.teamhasi.hotel.repositories;

import at.teamhasi.hotel.entities.RoomTypeEntity;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface RoomTypeRepository extends JpaRepository<RoomTypeEntity, Integer> {

    @Query("SELECT rt FROM RoomTypeEntity rt")
    List<RoomTypeEntity> findAllWithPagination(Pageable pageable);

    @Query("SELECT rt FROM RoomTypeEntity rt WHERE EXISTS (" +
            "SELECT r FROM RoomEntity r WHERE r.roomType = rt AND NOT EXISTS (" +
            "SELECT o FROM OrderEntity o WHERE o.room = r AND o.bookingStart < :endDate AND o.bookingEnd > :startDate))")
    List<RoomTypeEntity> findAvailableWithPagination(
            @Param("startDate") LocalDate startDate,
            @Param("endDate") LocalDate endDate,
            Pageable pageable);

    @Query("SELECT COUNT(rt) FROM RoomTypeEntity rt WHERE EXISTS (" +
            "SELECT r FROM RoomEntity r WHERE r.roomType = rt AND NOT EXISTS (" +
            "SELECT o FROM OrderEntity o WHERE o.room = r AND o.bookingStart < :endDate AND o.bookingEnd > :startDate))")
    long countAvailable(
            @Param("startDate") LocalDate startDate,
            @Param("endDate") LocalDate endDate);
}