package at.teamhasi.hotel.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import jakarta.persistence.OrderBy;

import java.util.List;

@Entity
@Table(name = "room_type")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RoomTypeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "room_type_id")
    private Integer id;

    @NotBlank
    @Column(nullable = false, length = 255)
    private String name;

    @Column(length = 500)
    private String description;

    @NotNull
    @Column(nullable = false)
    private Integer capacity;

    @NotNull
    @Column(name = "price_per_night", nullable = false)
    private Float pricePerNight;

    @ManyToMany
    @JoinTable(
            name = "room_type_has_media",
            joinColumns = @JoinColumn(name = "room_type_id"),
            inverseJoinColumns = @JoinColumn(name = "media_id")
    )
    @OrderBy("sortHelper ASC")
    private List<MediaEntity> media;

    @OneToMany(mappedBy = "roomType", fetch = FetchType.LAZY)
    private List<RoomEntity> rooms;
}