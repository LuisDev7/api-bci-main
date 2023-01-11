
# Evaluación Java
Aplicación que expone un API RESTful para la creación de usuarios


### Tecnología

- Banco de datos en memoria H2.
- Proceso de build vía Maven.
- Persistencia con Hibernate.
- Framework Spring.
- Servidor Tomcat Embedded.
- Java 8
- Json Web Token
- Swagger


### Ejecución

#### Clonar el repositorio

`$ git clone ` <https://github.com/LuisDev7/api-bci-main>
#### Generar el JAR del proyecto
##### Ejecutar el comando en el directorio raíz del proyecto api-bci-main

`$ mvn clean install `
#### Ejecutar el proyecto
##### Ejecutar el comando dentro del directorio api-bci-mail/target/
`$ java -jar api-bci-main-0.0.1-SNAPSHOT.jar`


### Api
####Endpoint para obtener un token
<abbr title="Hyper Text Markup Language">Método HTTP GET</abbr>
Url : http://localhost:8080/api-bci/token

####Endpoint para agregar usuarios
<abbr title="Hyper Text Markup Language">Método HTTP POST</abbr>

Authorization : Bearer Token

Url :  http://localhost:8080/api-bci/user/addUser

Token Administador : eyJhbGciOiJIUzUxMiJ9.eyJqdGkiOiJuaXN1bUpXVCIsInN1YiI6ImFkbWluQG5pc3VtLmVjIiwiYXV0aG9yaXRpZXMiOlsiUk9MRV9VU0VSIl0sImlhdCI6MTYzNjM1NDE1Mn0.d8G7m26rUPe1zhrkhGTVSgi6Jfu-zovZp2eDLR9wx2S_h3YLnhVnBMom7wYlVMoFYsi0mFXLqgoU2Sx8LfDMJA

Json Request :
```json
{
  "id": "4",
  "name": "Juan Rodriguez10",
  "email": "juan@rodriguez.org",
  "password": "Hunter2,",
  "phones": [
    {
      "number": "1234567001",
      "citycode": "1",
      "contrycode": "57"
    },
    {
      "number": "1234567002",
      "citycode": "2",
      "contrycode": "59"
    }
  ]
}
  ```
HEADER:ALGORITHM & TOKEN TYPE



    {
      "alg": "HS512"
    }



PAYLOAD:DATA


```json
{
  "jti": "nisumJWT",
  "sub": "admin@nisum.ec",
  "authorities": [
    "ROLE_USER"
  ],
  "iat": 1636354152
}
```

VERIFY SIGNATURE
```json
HMACSHA512(
  base64UrlEncode(header) + "." +
  base64UrlEncode(payload),
  
) secret base64 encoded
```
####Endpoint para listar los usuarios

<abbr title="Hyper Text Markup Language">Método HTTP GET</abbr>

Authorization : Bearer Token

Url: http://localhost:8080/api-bci/user/usuarios

Token Administador : eyJhbGciOiJIUzUxMiJ9.eyJqdGkiOiJuaXN1bUpXVCIsInN1YiI6ImFkbWluQG5pc3VtLmVjIiwiYXV0aG9yaXRpZXMiOlsiUk9MRV9VU0VSIl0sImlhdCI6MTYzNjM1NDE1Mn0.d8G7m26rUPe1zhrkhGTVSgi6Jfu-zovZp2eDLR9wx2S_h3YLnhVnBMom7wYlVMoFYsi0mFXLqgoU2Sx8LfDMJA



####CARACTERÍSTICA DE CONTRASEÑA POR DEFECTO
La contraseña debe tener:
- Entre 8 y 30 caracteres.
- Al menos un dígito.
- Al menos una minúscula.
- Al menos una mayúscula.
- Al menos un caracter especial.
- No permite secuencial alfabético.
- No permite secuencial numérico.
- No permite espacios en blanco.
- Contraseña válida: Marco0021,
- Contraseña no válida: M@rco2,


### H2
Una vez ejecutado el proyecto podemos acceder a la base de datos desde el navegador.

##### Url :  http://localhost:8080/api-bci/h2-console/
##### Saved Settings: Generic H2 (Embedded)
##### Setting Name: Generic H2 (Embedded)
##### Driver Class:  org.h2.Driver
##### JDBC URL:  jdbc:h2:mem:bcidb
##### User Name:  admin
##### Password:  admin123

### Pruebas con Swagger-ui
##### 1.- Ingresar a swagger
http://localhost:8080/api-bci/swagger-ui/index.html
##### 2.- Generar un token con el endpoint token
##### 3.-  Ir al botón Authorize ingresar el token en value y dar clic en Authorize.
##### 4.- Ingresar usuarios nuevos con el endpoint addUser
##### 5.- Ver los usuario ingresados con el endpoint usuarios
##### 6.- Probar los token de los usuarios

##### Nota: Para cambiar de token, dar clic en logout dentro del botón Authorize.

### End
