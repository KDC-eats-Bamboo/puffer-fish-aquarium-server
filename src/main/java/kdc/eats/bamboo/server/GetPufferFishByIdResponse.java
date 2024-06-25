package kdc.eats.bamboo.server;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@Builder
@AllArgsConstructor
public class GetPufferFishByIdResponse {

    private Long id; // PK

    private String name; // 이름

    private String description; // 설명

    private Float length; // 몸 길이 (cm)

    private Integer expansionRate; // 팽창 정도 (%)

    private Float poisonAmount; // 독의 양

    private Float thronLength; // 가시 길이 (cm)

    private ContinentEnum capturePlace; // 포획 장소

    private Float liveTemperature; // 견딜 수 있는 물 온도 (섭씨)

    private LocalDateTime deadline; // 사망 예정일

    private GenderEnum gender; // 성별

    public static GetPufferFishByIdResponse of(BogeoEntity bogeo){
        return GetPufferFishByIdResponse.builder()
                .id(bogeo.getId())
                .name(bogeo.getName())
                .description(bogeo.getDescription())
                .length(bogeo.getLength())
                .expansionRate(bogeo.getExpansionRate())
                .poisonAmount(bogeo.getPoisonAmount())
                .thronLength(bogeo.getThronLength())
                .capturePlace(bogeo.getCapturePlace())
                .liveTemperature(bogeo.getLiveTemperature())
                .deadline(bogeo.getDeadline())
                .gender(bogeo.getGender())
                .build();
    }
}
