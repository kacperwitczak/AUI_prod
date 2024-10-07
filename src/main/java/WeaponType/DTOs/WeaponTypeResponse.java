package WeaponType.DTOs;

import Weapon.DTOs.WeaponResponse;
import Weapon.Entity.Weapon;
import lombok.*;

import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@ToString
@EqualsAndHashCode
public class WeaponTypeResponse {
    private String category;
    private String description;
    private List<WeaponResponse> weapons;
}
