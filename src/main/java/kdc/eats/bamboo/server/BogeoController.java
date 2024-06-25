package kdc.eats.bamboo.server;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class BogeoController {

    private final BogeoService service;

    @PostMapping("/pufferfish")
    public BogeoEntity addNewBogeo(@RequestBody NewBogeoRequest dto) {
        return service.addNewBogeo(dto);
    }

    @GetMapping("/pufferfish/{id}") // 복어 단일 조회
    public GetPufferFishByIdResponse getOneBogeo(@RequestParam Long id) {
        return service.getOneBogeo(id);
    }

    @GetMapping("/pufferfish") // 복어 전체 조회
    public List<GetPufferFishByIdResponse> getAllBogeos() {
        return service.getAllBogeos();
    }

    @PatchMapping("/pufferfish")
    public BogeoEntity updateBogeo(
            @RequestParam Long id, @RequestBody NewBogeoRequest dto
    ) {
        return service.updateBogeo(id, dto);
    }

    @DeleteMapping("/pufferfish/{id}")
    public String deleteBogeo(@PathVariable Long id) {
        return service.deleteBogeo(id);
    }


    @GetMapping("/pufferfish/rank")
    public List<BogeoEntity> rank() {
        return service.getBogeoRank();
    }
}
