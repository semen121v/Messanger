package org.example.model.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import org.example.model.enums.Gender;

import java.time.LocalDate;

@Data
public class UserCreateDtoRequest {
    @Schema(description = "Имя")
    private String firstName;

    @Schema(description = "Фамилия")
    private String lastName;

    @Schema(description = "Отчество")
    private String patronymic;

    @Schema(description = "Дата рождения")
    private LocalDate birthDate;

    @Schema(description = "Пол")
    private Gender gender;

    @Schema(description = "Почта")
    private String email;

    @Schema(description = "Телефон")
    private String phoneNumber;
}
