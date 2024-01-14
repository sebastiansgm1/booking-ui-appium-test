
# Proyecto de automatizacion de pruebas de UI YAPE
Este es el reto de automatización de pruebas de API de YAPE

## Autor: Sebastian Galeano Molina / Senior QA Automation
La prueba esta orientada a la app Booking.com

## Especificaciones de pruebas

* Se planteo un flujo E2E desde un feature BDD parametrizable con tablas entre los steps para cambiar facilmente la data de prueba y evaluar diferentes escenarios

## Plan de pruebas
Se plantean varias pruebas con el fin de lograr una buena cobertura, las pruebas planteadas son:
Escenario E2E de validación de reserva exitosa, para fines de la prueba se completa el flujo y se evalua mediante una soft assertion los datos
de informacion personal y monto total

## Stack tecnologico

* Version de Java: 8
* Gestor de paquetes: Gradle
* Serenity framework + Cucumber + Appium
* Arnes de pruebas: Junit
* Patrón de automatizacion: Action class
* 

## Instalación y preparación de ambiente

* Use el comando `git clone https://github.com/sebastiansgm1/restful-booker-test` para clonar el proyecto
* Se recomienda usar IntelliJ para abrir el proyecto, tambien puede utulizar un IDE similar como eclipse o vs code
* Si desea compilar el proyecto manualmente use el comando gradle compileJava
* Para correr las pruebas en el proyecto use el comando Gradle clean test

## Documentación de apoyo
- **Serenity**: https://serenity-bdd.github.io/docs/tutorials/first_test
- **Gradle**: https://docs.gradle.org/current/userguide/userguide.html
- **Selenium**: https://www.selenium.dev/documentation/webdriver/
- **Xpath**: https://www.w3schools.com/xml/xpath_syntax.asp
- **Cucumber**: https://cucumber.io/docs/cucumber/
- **Appium**: https://appium.io/docs/en/about-appium/api/

## Parametrización de ambiente

En el archivo serenity.conf en la carpeta test/resources se encuentra el parametro
Environment mediante el cual puede parametrizarse la ejecución local o cloud (saucelabs)
para la ejecución local utilice un emulador con android 13 con nombre emulator-5554,
puede tener la app preinstalada o reemplace el capability appium.app en el archivo 
serenity.properties por la ruta del archivo donde esta el apk

## Ejecución de pruebas en Github Action (CI)

Este proyecto esta parametrizado para ejecutarse en github actions, el disparador del
actions es cuando se hace push a la rama principal o se realiza un pull request,
puede ver las ejecuciones en la pestaña actions en el repositorio github

https://github.com/sebastiansgm1/booking-ui-appium-test/actions/

Este proyeto esta parametrizado para ejecutarse desde github actions y conectarse con 
saucelabs para soportar la ejecución en un dispositivo movil cloud,
para ver los resultados puede ir a la pagina de saucelabs y loguearse con el correo
sebastiansgm1@gmail.com y la contraseña Yape2024*
La cuenta saucelabs es un trial y los minutos de ejecución son limitados, todo esto se 
configuro para efectos de la prueba

## Reportes
Puede consultar los reportes en la ruta target/site/serenity/index.html
Cuando se ejecuta en github actions el reporte queda descargable en un zip



