package at.teamhasi.hotel.dto;

import at.teamhasi.hotel.entities.MediaEntity;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MediaDto {
    private String path;
    private String title;
    private String description;
    private String altText;
    private Integer sortHelper;

    public static MediaDto fromEntity(MediaEntity mediaEntity) {
        return MediaDto.builder()
                .path(mediaEntity.getPath())
                .title(mediaEntity.getTitle())
                .description(mediaEntity.getDescription())
                .altText(mediaEntity.getAltText())
                .sortHelper(mediaEntity.getSortHelper())
                .build();
    }
}
