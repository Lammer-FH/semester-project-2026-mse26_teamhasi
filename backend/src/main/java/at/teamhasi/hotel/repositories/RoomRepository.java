package at.teamhasi.hotel.repositories;

import at.teamhasi.hotel.entities.RoomEntity;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface RoomRepository extends JpaRepository<RoomEntity, Integer> {

    @Query("SELECT r FROM RoomEntity r")
    List<RoomEntity> findAllWithPagination(Pageable pageable);

    @Query("SELECT r FROM RoomEntity r WHERE NOT EXISTS (" +
            "SELECT o FROM OrderEntity o WHERE o.room = r AND o.bookingStart < :endDate AND o.bookingEnd > :startDate)")
    List<RoomEntity> findAvailableWithPagination(
            @Param("startDate") LocalDate startDate,
            @Param("endDate") LocalDate endDate,
            Pageable pageable);

    @Query("SELECT COUNT(r) FROM RoomEntity r WHERE NOT EXISTS (" +
            "SELECT o FROM OrderEntity o WHERE o.room = r AND o.bookingStart < :endDate AND o.bookingEnd > :startDate)")
    long countAvailable(
            @Param("startDate") LocalDate startDate,
            @Param("endDate") LocalDate endDate);

    @Query("SELECT COUNT(r) FROM RoomEntity r WHERE r.id = :roomId AND NOT EXISTS (" +
            "SELECT o FROM OrderEntity o WHERE o.room = r AND o.bookingStart < :endDate AND o.bookingEnd > :startDate)")
    long countAvailableById(
            @Param("roomId") Integer roomId,
            @Param("startDate") LocalDate startDate,
            @Param("endDate") LocalDate endDate);
}
