package com.nttdata.demo.user.controller;

import com.nttdata.demo.user.dto.FindUserDto;
import com.nttdata.demo.user.dto.UserDto;
import com.nttdata.demo.user.exception.ValidateResponseEntity;
import com.nttdata.demo.user.services.IUserService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Pattern;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/user")
public class UserController {

   private static final Logger logger = LoggerFactory.getLogger(UserController.class);
    @Autowired
    private IUserService service;

    @GetMapping
    @Validated
    public ResponseEntity<UserDto> userDetail(@Pattern(regexp = "^\\d+$", message = "El documento debe ser numérico.") @RequestParam("doc") String doc,
                                              @Pattern(regexp = "^[CP]$", message = "El tipo solo puede ser 'C' o 'P'.") @RequestParam("type") String type){
        try {
            UserDto user = service.findByCc(doc);
            if(user != null){
                logger.info("Usuario consultado " + user.getPrimerNombre() + " " + user.getPrimerApellido());
                return ResponseEntity.ok(user);
            }
            logger.warn("El usuario consultado no existe");
            throw new ResponseStatusException(HttpStatus.NO_CONTENT, "El usuario no existe");
        }catch (NullPointerException e){ // para bases de datos DataAccessException
            logger.error("error al consultar la informaciono", e);
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "error al consultar la informacion", e);
        }
    }
}
