package at.teamhasi.hotel.services;

import at.teamhasi.hotel.dto.OrderDto;
import at.teamhasi.hotel.dto.OrderResponseDto;
import at.teamhasi.hotel.dto.RoomDto;
import at.teamhasi.hotel.dto.UserDto;
import at.teamhasi.hotel.entities.OrderEntity;
import at.teamhasi.hotel.entities.RoomEntity;
import at.teamhasi.hotel.entities.UserEntity;
import at.teamhasi.hotel.enums.EOrderStatus;
import at.teamhasi.hotel.repositories.OrderRepository;
import at.teamhasi.hotel.repositories.RoomRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.temporal.ChronoUnit;

@Service
@RequiredArgsConstructor
public class OrderService {
    private final OrderRepository orderRepository;
    private final RoomRepository roomRepository;
    private final UserService userService;

    public OrderResponseDto createOrder(OrderDto orderDto) {
        UserEntity user = userService.findOrCreate(orderDto.getUser());
        OrderEntity order = saveOrder(orderDto, user);

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

    private OrderEntity saveOrder(OrderDto orderDto, UserEntity user) {
        RoomEntity room = roomRepository.findById(orderDto.getRoomId()).orElseThrow();
        return orderRepository.save(OrderEntity.builder()
                .bookingStart(orderDto.getBookingStart())
                .bookingEnd(orderDto.getBookingEnd())
                .status(EOrderStatus.CONFIRMED)
                .hasBreakfast(orderDto.getHasBreakfast())
                .user(user)
                .room(room)
                .build());
    }
}