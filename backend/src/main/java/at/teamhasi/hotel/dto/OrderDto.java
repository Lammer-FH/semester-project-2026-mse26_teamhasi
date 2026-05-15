package at.teamhasi.hotel.dto;


import at.teamhasi.hotel.entities.OrderEntity;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OrderDto {
    private Integer roomId;
    private LocalDate bookingStart;
    private LocalDate bookingEnd;
    private Boolean hasBreakfast;
    private UserDto user;

    public static OrderDto fromEntity(OrderEntity order) {
        return OrderDto.builder()
                .roomId(order.getRoom().getId())
                .bookingStart(order.getBookingStart())
                .bookingEnd(order.getBookingEnd())
                .hasBreakfast(order.getHasBreakfast())
                .user(UserDto.fromEntity(order.getUser()))
                .build();
    }
}
