package kdc.eats.bamboo.server;

import jakarta.persistence.EntityNotFoundException;
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
        bogeo.length = 5 + random.nextFloat() * 70; // 5cm에서 75cm 사이
        bogeo.expansionRate = random.nextInt(101); // 0%에서 100% 사이
        bogeo.poisonAmount = 1 + random.nextFloat() * 4; // 1mg에서 5mg 사이
        bogeo.thronLength = random.nextFloat() * 7; // 0cm에서 7cm 사이
        bogeo.capturePlace = getRandomContinentEnum();
        bogeo.liveTemperature = -20 + random.nextFloat() * 60; // -20°C에서 40°C 사이
        bogeo.deadline = LocalDateTime.now().plusDays(365 + random.nextInt(1460)); // 현재부터 1년에서 5년 이내
        bogeo.gender = getRandomGenderEnum();

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

}
