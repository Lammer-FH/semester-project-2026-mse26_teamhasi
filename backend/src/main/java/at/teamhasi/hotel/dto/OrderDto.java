package at.teamhasi.hotel.dto;

import at.teamhasi.hotel.controller.validation.ValidBookingDates;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ValidBookingDates
public class OrderDto {
    private Integer roomId;
    private LocalDate bookingStart;
    private LocalDate bookingEnd;
    private Boolean hasBreakfast;
    private UserDto user;
}
