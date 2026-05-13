package at.teamhasi.hotel.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "media")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MediaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "media_id")
    private Long id;

    @Column(length = 500)
    private String path;

    @Column(length = 500)
    private String title;

    @Column(length = 500)
    private String description;

    @Column(name = "alt_text", length = 500)
    private String altText;

    @Column(name = "sort_helper")
    private Integer sortHelper;

    @ManyToMany(mappedBy = "media")
    private List<RoomTypeEntity> roomTypes;
}
