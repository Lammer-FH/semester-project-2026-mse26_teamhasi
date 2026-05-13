package at.teamhasi.hotel.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "room_extra")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RoomExtraEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "room_extra_id")
    private Long id;

    @NotBlank
    @Column(nullable = false, length = 255)
    private String name;

    @Column(length = 255)
    private String description;

    @Column(name = "icon_key", length = 255)
    private String iconKey;
}
