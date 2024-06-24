package kdc.eats.bamboo.server;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
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
        bogeo.length = 10 + random.nextFloat() * 90; // 10cm에서 100cm 사이
        bogeo.expansionRate = random.nextInt(101); // 0%에서 100% 사이
        bogeo.poisonAmount = random.nextFloat() * 10; // 0에서 10 사이
        bogeo.thronLength = random.nextFloat() * 5; // 0cm에서 5cm 사이
        bogeo.capturePlace = getRandomContinentEnum();
        bogeo.liveTemperature = -10 + random.nextFloat() * 50; // -10°C에서 40°C 사이
        bogeo.deadline = LocalDateTime.now().plusDays(random.nextInt(365)); // 현재부터 1년 이내
        bogeo.gender = getRandomGenderEnum();

        repository.save(bogeo);

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

}
