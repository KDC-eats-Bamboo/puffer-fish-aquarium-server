package kdc.eats.bamboo.server;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class NewBogeoRequest {

    private String name; // 이름
    private String description; // 설명

}
