package kdc.eats.bamboo.server;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class BogeoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id; // PK

    @Column(nullable = false)
    String name; // 이름

    @Column(nullable = false)
    String description; // 설명

    @Column(nullable = false)
    Float length; // 몸 길이 (cm)

    @Column(nullable = false)
    Integer expansionRate; // 팽창 정도 (%)

    @Column(nullable = false)
    Float poisonAmount; // 독의 양

    @Column(nullable = false)
    Float thronLength; // 가시 길이 (cm)

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    ContinentEnum capturePlace; // 포획 장소

    @Column(nullable = false)
    Float liveTemperature; // 견딜 수 있는 물 온도 (섭씨)

    @Column(nullable = false)
    LocalDateTime deadline; // 사망 예정일

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    GenderEnum gender; // 성별

}
