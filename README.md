## README: Servicio REST para Consulta de Información de Clientes

### Descripción General
Este servicio REST proporciona una API para consultar la información básica de un cliente a partir de su tipo y número de documento. Ha sido desarrollado utilizando Spring y Maven, cumpliendo con los siguientes requisitos:

* **Manejo de códigos HTTP:** Se implementan códigos HTTP para indicar el estado de las solicitudes (200 - Éxito, 400 - Solicitud Inválida, 404 - No Encontrado, 500 - Error Interno del Servidor).
* **Validación de datos de entrada:** Se valida que los campos de tipo y número de documento sean obligatorios y que el tipo de documento sea válido (C o P).
* **Datos de salida:** Se retorna información básica del cliente (nombres, apellidos, teléfono, dirección, ciudad) para un cliente específico (cédula 23445322).
* **Puerto:** La aplicación se inicia en el puerto 8090.

### Tecnologías Utilizadas
* **Spring:** Framework para desarrollo de aplicaciones Java.
* **Maven:** Herramienta de gestión de proyectos y dependencias.
* **Dependencias**
* spring-boot
* Lombok
* Swagger openapi

### Estructura del Proyecto
* **[Descripción de la estructura de directorios y paquetes]**

### Cómo Ejecutar
1. **Clonar el repositorio:**
   git clone https://github.com/Reinel-Steven/nttdata-userBackend.git)
   
2. **Construir el proyecto:**
   mvn clean install
   
3. **Ejecutar la aplicación:**
   
   java -jar target/demo-users-0.0.1-SNAPSHOT.jar
   

### Endpoints
* **GET /user?doc={Documento}&type={typo de documento}:** Consulta la información de un cliente por tipo y número de documento.

### Ejemplos
* **Consulta exitosa:**
  ```
  GET http://localhost:8091/user?doc=23445322&type=C
  ```
  Respuesta:
  ```json
  {
    "primerNombre": "Jose",
    "segundoNombre": "Maria",
    "primerApellido": "Mendez",
    "segundoApellido": "Morales",
    "telefono": "3103101122",
    "direccion": "Calle 123 22 33",
    "ciudad": "Bogota"
}
  ```
* **Cliente no encontrado:**
  ```
  GET http://localhost:8090/user?doc=111111&type=C
  ```
  Respuesta:
  ```
  HTTP 204 Not Content
  ```
* **parametros incorrectos:**
  ```
  GET http://localhost:8090/user?doc=234ABC322&type=H
  ```
  Respuesta:
  ```
  HTTP 400 Not Found
  ```

### Consideraciones Adicionales
* **Datos de respuesta:** Los datos de respuesta son mockeados para fines demostrativos.
* **Log:** Se crean log a nivel de consla de info, waning, error
* **Pruebas unitarias:** se crean pruebas unitarias on un porcentage del 90%
* **Calidad de código:** se validan pruebas con sonar


**Documentacion Swagger:**
http://localhost:8090/doc/swagger-ui/index.html
https://users-nttdata-back-d2chgndrc0dmeba6.canadacentral-01.azurewebsites.net/doc/swagger-ui/index.html#/user-controller/userDetail

Evidencias paso a paso de despliegue Azure
https://udistritaleduco-my.sharepoint.com/:w:/g/personal/rsbolanosm_udistrital_edu_co/Ebl04svJ2y5Bj-2ajNFvYfYBnF82cxgEC_-0CZB1UZqP6w?e=WE6rFh
