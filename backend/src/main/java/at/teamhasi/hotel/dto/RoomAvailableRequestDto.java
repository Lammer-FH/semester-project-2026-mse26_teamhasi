package at.teamhasi.hotel.dto;

import at.teamhasi.hotel.controller.validation.BookingDates;
import at.teamhasi.hotel.controller.validation.ValidBookingDates;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ValidBookingDates
public class RoomAvailableRequestDto implements BookingDates {
    @NotNull
    private LocalDate bookingStart;
    @NotNull
    private LocalDate bookingEnd;
}