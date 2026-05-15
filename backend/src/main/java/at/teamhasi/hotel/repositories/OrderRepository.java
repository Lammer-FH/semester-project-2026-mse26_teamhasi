package at.teamhasi.hotel.repositories;

import at.teamhasi.hotel.entities.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;

@Repository
public interface OrderRepository extends JpaRepository<OrderEntity, Integer> {

    @Query("SELECT COUNT(o) > 0 FROM OrderEntity o WHERE o.room.id = :roomId AND o.bookingStart < :bookingEnd AND o.bookingEnd > :bookingStart")
    boolean existsOverlappingBooking(@Param("roomId") Integer roomId,
                                     @Param("bookingStart") LocalDate bookingStart,
                                     @Param("bookingEnd") LocalDate bookingEnd);
}
