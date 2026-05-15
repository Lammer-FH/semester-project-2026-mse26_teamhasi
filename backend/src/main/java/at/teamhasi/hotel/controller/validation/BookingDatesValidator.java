package at.teamhasi.hotel.controller.validation;

import at.teamhasi.hotel.dto.OrderDto;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class BookingDatesValidator implements ConstraintValidator<ValidBookingDates, OrderDto> {

    @Override
    public boolean isValid(OrderDto orderDto, ConstraintValidatorContext context) {
        boolean hasStart = orderDto.getBookingStart() != null;
        boolean hasEnd = orderDto.getBookingEnd() != null;

        if (hasStart != hasEnd) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate("Both check-in and check-out dates must be provided")
                    .addConstraintViolation();
            return false;
        }

        if (!hasStart) return true;

        return orderDto.getBookingEnd().isAfter(orderDto.getBookingStart());
    }
}
