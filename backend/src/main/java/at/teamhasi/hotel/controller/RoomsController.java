package at.teamhasi.hotel.controller;

import at.teamhasi.hotel.dto.ApiErrorResponse;
import at.teamhasi.hotel.dto.RoomAvailabilityDto;
import at.teamhasi.hotel.dto.RoomsResponseDto;
import at.teamhasi.hotel.enums.ApiErrorCode;
import at.teamhasi.hotel.services.RoomService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@RequestMapping("/rooms")
@RequiredArgsConstructor
public class RoomsController {

    private final RoomService roomService;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getAllRooms(
            @RequestParam(defaultValue = "5") int limit,
            @RequestParam(defaultValue = "0") int offset,
            @RequestParam(value = "check_in", required = false) LocalDate checkIn,
            @RequestParam(value = "check_out", required = false) LocalDate checkOut) {

        if ((checkIn == null) != (checkOut == null)) {
            return ResponseEntity.badRequest()
                    .body(ApiErrorResponse.of(ApiErrorCode.VALIDATION_ERROR,
                            "check_in and check_out must be provided together"));
        }

        return ResponseEntity.ok(roomService.getRooms(limit, offset, checkIn, checkOut));
    }

    @GetMapping(value = "/{id}/available", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> checkAvailability(
            @PathVariable Integer id,
            @RequestParam(value = "check_in", required = false) LocalDate checkIn,
            @RequestParam(value = "check_out", required = false) LocalDate checkOut) {

        if ((checkIn == null) != (checkOut == null)) {
            return ResponseEntity.badRequest()
                    .body(ApiErrorResponse.of(ApiErrorCode.VALIDATION_ERROR,
                            "check_in and check_out must be provided together"));
        }

        return ResponseEntity.ok(roomService.checkAvailability(id, checkIn, checkOut));
    }
}