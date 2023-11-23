package com.example.polyclinic.model;

import lombok.*;

import javax.validation.constraints.NotBlank;

@Builder
@Getter
@Setter
@RequiredArgsConstructor
@AllArgsConstructor
public class Patient {
    @NotBlank(message = "This field should not be empty")
    private String username;
    @NotBlank(message = "This field should not be empty")
    private String password;
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
