package at.teamhasi.hotel.dto;

import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RoomAvailabilityDto {
    private Integer roomId;
    private Boolean available;
    private LocalDate checkIn;
    private LocalDate checkOut;
    private List<LocalDate> unavailableDates;
}
