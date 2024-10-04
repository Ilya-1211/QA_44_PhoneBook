package dto;

import lombok.*;

@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor

public class ContactDtoLombok {

    private String id;
    private String name;
    private String lastname;
    private String email;
    private String phone;
    private String address;
    private String description;

}
