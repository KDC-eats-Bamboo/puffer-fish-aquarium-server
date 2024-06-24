package kdc.eats.bamboo.server;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class BogeoController {

    private final BogeoService service;

    @PostMapping("/pufferfish")
    public BogeoEntity addNewBogeo(@RequestBody NewBogeoRequest dto) {
        return service.addNewBogeo(dto);
    }

}
