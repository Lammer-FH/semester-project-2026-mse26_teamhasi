package at.teamhasi.hotel.controller.validation;

import java.time.LocalDate;

public interface BookingDates {
    LocalDate getBookingStart();
    LocalDate getBookingEnd();
}