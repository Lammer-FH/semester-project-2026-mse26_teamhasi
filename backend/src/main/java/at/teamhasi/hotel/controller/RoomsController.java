package at.teamhasi.hotel.controller;

import at.teamhasi.hotel.dto.RoomAvailableRequestDto;
import at.teamhasi.hotel.dto.RoomAvailableResponseDto;
import at.teamhasi.hotel.dto.RoomsResponseDto;
import at.teamhasi.hotel.services.RoomService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@RequestMapping("/rooms")
@RequiredArgsConstructor
public class RoomsController {

    private final RoomService roomService;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<RoomsResponseDto> getRooms(
            @RequestParam(defaultValue = "20") int limit,
            @RequestParam(defaultValue = "0") int offset,
            @RequestParam(required = false) LocalDate bookingStart,
            @RequestParam(required = false) LocalDate bookingEnd) {
        return ResponseEntity.ok(roomService.getRooms(limit, offset, bookingStart, bookingEnd));
    }

    @PostMapping(value = "/{id}/available", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<RoomAvailableResponseDto> getRoomAvailable(
            @PathVariable Integer id, @RequestBody @Validated RoomAvailableRequestDto request) {

        boolean roomAvailable = roomService.isRoomAvailable(id, request.getBookingStart(), request.getBookingEnd());
        return ResponseEntity.ok(RoomAvailableResponseDto.builder().available(roomAvailable).build());

    }
}
