# Prueba AppGate

API para realizar operaciones Matematicas Basicas: sumar, resta, multiplicación, división y potenciación .

# Requerimientos

- JDK 11 o superior.
- IDE Eclipse con plugin para AWS.
- Una cuenta en la consola de AWS para desplegar y probar las Lambdas.
- SoapUI para probar los servicios REST

# Arquitectura de la Aplicación

La aplicación es desarrollada para que funcione en la arquitectura Serverless  o  relacionada  formalmente con el término FaaS (Function as a Service), para esto me apoye en servicios propios de AWS Como lambdas, Api Gateway, RDS(Maria DB) y S3, a continuación una imagen donde se describe mejor lo anteriormente expuesto: 

![Arquitectura Meli](https://github.com/JorgeTamara22/challengeFuegoQuasar/blob/master/post2.png)

El API REST cuenta con tres servicios los cuales se describen a continuación:
## Login
Este metodo tiene como funcionalidad crear una session y da como respuesta un token que debe ser utilizado para realizar las otras funcionalidades, el token se actualiza cada vez que realice loguin.
- Metodo: POST
- endpoint: https://54varwzxy8.execute-api.us-east-1.amazonaws.com/dev/login
- Request: 
{
  "userName": "+++++",
  "password": "++++"
}
- Para efectos de prueba se crearon dos usuarios en la base de datos cuyos datos se muestran a continuacion:
{
  "userName": "PRUEBA",
  "password": "PRUEBA"
}
y
{
  "userName": "appgate",
  "password": "123456
}
- Response: La respuesta del metodo tiene la siguiente estructura:
{
   "position":    {
      "x": -100.00688339798238,
      "y": 75.51770663789418
   },
   "message": "este es un mensaje secreto"
}

## topsecret (Nivel 3)
[https://u5fhoiwlve.execute-api.us-east-2.amazonaws.com/prod/topsecret-split?satellite_name=XXXX](https://u5fhoiwlve.execute-api.us-east-2.amazonaws.com/prod/topsecret-split?satellite_name=XXXX)
- Metodo: POST
- Request: Este metodo tiene como entrada un objeto satelites y recibe un parametro llamado satellite_name con la siguiente estructura en JSON:
 
{ "distance": 600.5, "message": ["este", "", "un", "", ""] }

- Response: La respuesta del metodo tiene la siguiente estructura:
{
   "position":    {
      "x": -100.00688339798238,
      "y": 75.51770663789418
   },
   "message": "este es un mensaje secreto"
}

## topsecret (Nivel 3)
[https://u5fhoiwlve.execute-api.us-east-2.amazonaws.com/prod/topsecret-split](https://u5fhoiwlve.execute-api.us-east-2.amazonaws.com/prod/topsecret-split)
- Metodo: GET
- Request: No tiene entrada
- Response: La respuesta del metodo tiene la siguiente estructura:
{
   "position":    {
      "x": -100.00688339798238,
      "y": 75.51770663789418
   },
   "message": "este es un mensaje secreto"
}

# Test

Para ejecutar los tests correr el programa con JUnit Test
