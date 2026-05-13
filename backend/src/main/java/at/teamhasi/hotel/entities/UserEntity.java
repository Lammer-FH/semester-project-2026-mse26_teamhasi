package at.teamhasi.hotel.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Entity
@Table(name = "user")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long id;

    @NotBlank
    @Column(nullable = false, length = 255)
    private String username;

    @NotBlank
    @Column(name = "first_name", nullable = false, length = 255)
    private String firstName;

    @NotBlank
    @Column(name = "last_name", nullable = false, length = 255)
    private String lastName;

    @NotBlank
    @Email
    @Column(nullable = false, length = 255)
    private String email;
}
