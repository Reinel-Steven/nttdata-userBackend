package com.nttdata.demo.user.dto;

import lombok.Data;

import java.io.Serial;
import java.io.Serializable;

@Data
public class UserDto  implements Serializable {

    @Serial
    private static final long serialVersionUID = -7939503531445783842L;

    private String primerNombre;
    private String segundoNombre;
    private String primerApellido;
    private String segundoApellido;
    private String telefono;
    private String direccion;
    private String ciudad;

    public UserDto() {
        super();
    }

    public UserDto(String name, String middleName, String lastName, String secondSurname, String phone, String address, String city) {
        this.primerNombre = name;
        this.segundoNombre = middleName;
        this.primerApellido = lastName;
        this.segundoApellido = secondSurname;
        this.telefono = phone;
        this.direccion = address;
        this.ciudad = city;
    }
}
