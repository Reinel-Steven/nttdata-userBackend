package com.nttdata.demo.user.dto;

import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import org.springframework.validation.annotation.Validated;

@Getter
@Validated
public class FindUserDto {
    @Pattern(regexp = "^\\d+$", message = "El documento debe ser numérico.")
    private String doc;

    @Pattern(regexp = "^[CP]$", message = "El tipo solo puede ser 'C' o 'P'.")
    private String type;

    public FindUserDto(String doc, String type) {
        this.doc = doc;
        this.type = type;
    }
}
