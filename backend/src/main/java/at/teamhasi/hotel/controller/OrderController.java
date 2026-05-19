package at.teamhasi.hotel.controller;

import at.teamhasi.hotel.dto.OrderDto;
import at.teamhasi.hotel.dto.OrderResponseDto;
import at.teamhasi.hotel.dto.RoomDto;
import at.teamhasi.hotel.dto.UserDto;
import at.teamhasi.hotel.entities.OrderEntity;
import at.teamhasi.hotel.services.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.temporal.ChronoUnit;

@RestController
@RequestMapping("/orders")
@RequiredArgsConstructor
public class OrderController {
    private final OrderService orderService;

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<OrderResponseDto> getAllRooms(@RequestBody @Validated OrderDto orderDto) {
        OrderEntity order = orderService.createOrder(orderDto);
        return ResponseEntity.ok(createOrderResponseDto(order));
    }

    private OrderResponseDto createOrderResponseDto(OrderEntity order) {
        int nights = (int) ChronoUnit.DAYS.between(order.getBookingStart(), order.getBookingEnd());
        return OrderResponseDto.builder()
                .id(order.getId())
                .status(order.getStatus())
                .bookingStart(order.getBookingStart())
                .bookingEnd(order.getBookingEnd())
                .nights(nights)
                .hasBreakfast(order.getHasBreakfast())
                .user(UserDto.fromEntity(order.getUser()))
                .room(RoomDto.fromEntity(order.getRoom()))
                .build();
    }
}
