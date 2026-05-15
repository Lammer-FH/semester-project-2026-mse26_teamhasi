package at.teamhasi.hotel.dto;


import at.teamhasi.hotel.entities.UserEntity;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserDto {
    private String username;
    private String firstName;
    private String lastName;
    private String email;

    public static UserDto fromEntity(UserEntity user) {
        return UserDto.builder()
                .username(user.getUsername())
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .email(user.getEmail())
                .build();
    }
}
