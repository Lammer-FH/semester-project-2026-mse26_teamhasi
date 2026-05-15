package at.teamhasi.hotel.entities;

import at.teamhasi.hotel.enums.EOrderStatus;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.LocalDate;

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
    private Integer id;

    @NotNull
    @Column(name = "booking_start", nullable = false)
    private LocalDate bookingStart;

    @NotNull
    @Column(name = "booking_end", nullable = false)
    private LocalDate bookingEnd;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 45)
    private EOrderStatus status;

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
