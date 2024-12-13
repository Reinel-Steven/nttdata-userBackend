package com.nttdata.demo.user.exception;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

public class ValidateResponseEntity {

        @Autowired
        private static Validator validator; // Inyectar el validador

        public static BindingResult validateObject(Object object) {
            BindingResult bindingResult = new org.springframework.validation.BeanPropertyBindingResult(object, object.getClass().getSimpleName());
            validator.validate(object, bindingResult);
            return bindingResult;
        }

    public static void validateAndThrowWithMessage(Object object) {
            if(object==null){
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Error Al validar los datos");
            }
        BindingResult bindingResult = validateObject(object);

        String message="";
        List<String> erros = bindingResult.getFieldErrors()
                .stream()
                .map(err ->	{return "El Campo ->" + err.getField() + " " + err.getDefaultMessage();}
                ).toList();

        message += erros;

        if (bindingResult.hasErrors()) {
            String errorMessage = bindingResult.getAllErrors().stream()
                    .map(error -> error.getDefaultMessage())
                    .reduce((msg1, msg2) -> msg1 + ", " + msg2).orElse(message);

            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, errorMessage);
        }
    }
        public static void validateAndThrow(Object object) {
            BindingResult bindingResult = validateObject(object);

            if (bindingResult.hasErrors()) {
                String errorMessage = bindingResult.getAllErrors().stream()
                        .map(error -> error.getDefaultMessage())
                        .reduce((msg1, msg2) -> msg1 + ", " + msg2).orElse("Error en los parámetros");

                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, errorMessage);
            }
        }
    public static void validateAndThrow(Object object, String message) {
        BindingResult bindingResult = validateObject(object);

        if (bindingResult.hasErrors()) {
            String errorMessage = bindingResult.getAllErrors().stream()
                    .map(error -> error.getDefaultMessage())
                    .reduce((msg1, msg2) -> msg1 + ", " + msg2).orElse(message);

            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, errorMessage);
        }
    }
    }

