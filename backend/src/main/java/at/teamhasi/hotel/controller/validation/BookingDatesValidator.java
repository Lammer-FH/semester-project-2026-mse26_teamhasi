package at.teamhasi.hotel.controller.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class BookingDatesValidator implements ConstraintValidator<ValidBookingDates, BookingDates> {

    @Override
    public boolean isValid(BookingDates dto, ConstraintValidatorContext context) {
        boolean hasStart = dto.getBookingStart() != null;
        boolean hasEnd = dto.getBookingEnd() != null;

        if (hasStart != hasEnd) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate("Both check-in and check-out dates must be provided")
                    .addConstraintViolation();
            return false;
        }

        if (!hasStart) return true;

        return dto.getBookingEnd().isAfter(dto.getBookingStart());
    }
}
