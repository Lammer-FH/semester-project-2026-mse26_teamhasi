package at.teamhasi.hotel.controller;

import at.teamhasi.hotel.dto.OrderDto;
import at.teamhasi.hotel.dto.OrderResponseDto;
import at.teamhasi.hotel.services.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/orders")
@RequiredArgsConstructor
public class OrderController {
    private final OrderService orderService;

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<OrderResponseDto> getAllRooms(@RequestBody @Validated OrderDto orderDto) {
        return ResponseEntity.ok(orderService.createOrder(orderDto));
    }
}
