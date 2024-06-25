package kdc.eats.bamboo.server;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class BogeoController {

    private final BogeoService service;

    @PostMapping("/pufferfish")
    public BogeoEntity addNewBogeo(@RequestBody NewBogeoRequest dto) {
        return service.addNewBogeo(dto);
    }

    @PatchMapping("/pufferfish")
    public BogeoEntity updateBogeo(
            @RequestParam Long id, @RequestBody NewBogeoRequest dto
    ) {
        return service.updateBogeo(id, dto);
    }

}
