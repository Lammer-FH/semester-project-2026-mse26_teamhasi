package at.teamhasi.hotel.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "order")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrderEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id")
    private Long id;

    @NotNull
    @Column(name = "booking_start", nullable = false)
    private LocalDateTime bookingStart;

    @NotNull
    @Column(name = "booking_end", nullable = false)
    private LocalDateTime bookingEnd;

    @NotBlank
    @Column(nullable = false, length = 45)
    private String status;

    @NotNull
    @Column(name = "hasBreakfast", nullable = false)
    private Boolean hasBreakfast;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private UserEntity user;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "room_id", nullable = false)
    private RoomEntity room;
}
