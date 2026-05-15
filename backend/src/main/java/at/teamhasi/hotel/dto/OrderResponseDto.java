package at.teamhasi.hotel.dto;

import at.teamhasi.hotel.enums.EOrderStatus;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OrderResponseDto {
    private Integer id;
    private EOrderStatus status;
    private LocalDate bookingStart;
    private LocalDate bookingEnd;
    private int nights;
    private Boolean hasBreakfast;
    private UserDto user;
    private RoomDto room;
}
