package kdc.eats.bamboo.server;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.lang.reflect.Array;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.List;
import java.util.Random;

@Service
@RequiredArgsConstructor
public class BogeoService {
    private final BogeoRepository repository;
    private static final Random random = new Random();
    public BogeoEntity addNewBogeo(NewBogeoRequest dto) {
        BogeoEntity bogeo = new BogeoEntity();

        bogeo.name = dto.getName();
        bogeo.description = dto.getDescription();
        bogeo.length = 5 + random.nextFloat() * 70; // 5cm에서 75cm 사이
        bogeo.expansionRate = random.nextInt(101); // 0%에서 100% 사이
        bogeo.poisonAmount = 1 + random.nextFloat() * 4; // 1mg에서 5mg 사이
        bogeo.thronLength = random.nextFloat() * 7; // 0cm에서 7cm 사이
        bogeo.capturePlace = getRandomContinentEnum();
        bogeo.liveTemperature = -20 + random.nextFloat() * 60; // -20°C에서 40°C 사이
        bogeo.deadline = LocalDateTime.now().plusDays(365 + random.nextInt(1460)); // 현재부터 1년에서 5년 이내
        bogeo.gender = getRandomGenderEnum();
        bogeo.createdAt = LocalDateTime.now();
        bogeo.editedAt = LocalDateTime.now();

        repository.save(bogeo);

        return bogeo;
    }

    public BogeoEntity updateBogeo(Long id, NewBogeoRequest dto) {
        BogeoEntity bogeo = repository.findById(id).orElseThrow(() -> new EntityNotFoundException("BogeoEntity with id " + id + " not found"));
        bogeo.update(dto);
        return bogeo;
    }
    private static ContinentEnum getRandomContinentEnum() {
        ContinentEnum[] values = ContinentEnum.values();
        return values[random.nextInt(values.length)];
    }

    private static GenderEnum getRandomGenderEnum() {
        GenderEnum[] values = GenderEnum.values();
        return values[random.nextInt(values.length)];
    }

    public List<BogeoEntity> getBogeoRank() {
        List<BogeoEntity> bogeoEntities = repository.findAll();
        bogeoEntities.sort((o1, o2) -> {
            Float o1Score = getScore(o1);
            Float o2Score = getScore(o2);
            System.out.println("result");
            System.out.println("o1: " + o1Score);
            System.out.println("o2: " + o2Score);
            return (int) -(o1Score - o2Score);
        });
        return bogeoEntities;
    }

    private static Float getScore(BogeoEntity bogeo) {
        Integer normalizedLength = normalize(bogeo.length, 5f, 75f);
        Integer expasionRate = normalize(bogeo.expansionRate.floatValue(), 0f, 100f);
        Integer poisonAmount = normalize(bogeo.poisonAmount, 1f, 5f);
        Integer thronLength = normalize(bogeo.thronLength, 0f, 7f);
        System.out.println("score: ");
        System.out.println(normalizedLength);
        System.out.println(expasionRate);
        System.out.println(poisonAmount);
        System.out.println(thronLength);
        return normalizedLength + expasionRate * 1.2f + poisonAmount * 1.2f + thronLength;
    }

    public static Integer normalize(Float value, Float minInput, Float maxInput) {
        return (int) ((value - minInput) * 100 / (maxInput - minInput));
    }

    // 복어 전체 조회
    public List<GetPufferFishByIdResponse> getAllBogeos() {
        List<BogeoEntity> PufferFish = repository.findAll();
        return PufferFish.stream().map(
                GetPufferFishByIdResponse::of
        ).toList();
    }

    // 복어 단일 조회
    public GetPufferFishByIdResponse getOneBogeo(Long id) {
        BogeoEntity bogeo = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("복어를 찾을 수 없습니다."));
        return GetPufferFishByIdResponse.of(bogeo);
    }

    public String deleteBogeo(Long id) {
        BogeoEntity bogeo = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("복어를 찾을 수 없습니다."));
        repository.deleteById(id);
        return "복어를 방생했습니다.";
    }

}
