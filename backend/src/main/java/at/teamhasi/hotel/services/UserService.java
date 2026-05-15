package at.teamhasi.hotel.services;

import at.teamhasi.hotel.dto.UserDto;
import at.teamhasi.hotel.entities.UserEntity;
import at.teamhasi.hotel.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public UserEntity findOrCreate(UserDto userDto) {
        List<UserEntity> users = userRepository.findUserEntityByUsername(userDto.getUsername());
        if (!users.isEmpty()) return users.getFirst();

        return userRepository.save(UserEntity.builder()
                .username(userDto.getUsername())
                .firstName(userDto.getFirstName())
                .lastName(userDto.getLastName())
                .email(userDto.getEmail())
                .build());
    }
}