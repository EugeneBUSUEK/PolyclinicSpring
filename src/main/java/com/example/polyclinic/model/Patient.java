package com.example.polyclinic.model;

import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Builder
@Getter
@Setter
@RequiredArgsConstructor
@AllArgsConstructor
public class Patient {
    @NotBlank(message = "This field should not be empty")
    private String firstName;
    @NotBlank(message = "This field should not be empty")
    private String lastName;
    //    @NotBlank(message = "This field should not be empty")
    private Long birthDate;
    private String phoneNumber;
    private String address;

    // остальные поля...

    // геттеры и сеттеры
}
