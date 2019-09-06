# QA Project

El presente repositorio es la solución al proyecto final del módulo 3 de la Maestría
en Dirección Estratégica en Ingeniería de Software, la misma está escrita en JAVA y fue
realizada haciendo uso de [JUnit](https://junit.org/junit4/) para la implementacion de las
pruebas unitarias, [Cucumber.js](https://github.com/cucumber/cucumber-js) para las pruebas
de integración y de UI, así com también [Selenium](https://www.npmjs.com/package/selenium-webdriver)
para estas últimas. 

### Cómo ejecutar el proyecto

1. Clonar el proyecto desde el repositorio
2. Abrir en el IDE de su preferencia como un proyecto Maven (generalmente
indicando el archivo pom.xml)
3. Actualizar su repositorio Maven localpara que contenga las dependencias del proyecto.
4. Puede ejecutar las pruebas una a una (por métodos) o por grupos de pruebas
(por clase), las pruebas se encuentran en la carpeta [Test](src/test/java/com/mingyaracosta/qa)
6. Para ejecutar el proyecto desde su IDE, debe indicar que la clase [QAProjectApplication](src/main/java/com/mingyaracosta/qa/QAProjectApplication.java)
es la clase principal.
5. Para ejecutar las pruebas de integración y UI debe primero instalar las 
dependencias necesarias haciendo uso de npm. Para ello abra una consola terminal y situese en
la carpeta [bdd](bdd), a continuación ejecute los siguientes comandos:
- npm i cucumber --save
- npm i chai --save
- npm i request --save
- npm i request-promise --save
- npm install selenium-webdriver --save
- npm install chromedriver --global

La ejecución de la pruebas se realiza ejecutando el siguient4e comando:
- ./node_modules/.bin/cucumber-js

### Cómo levantar el servidor

Para levantar el servidor necesita ejecutar el archivo [qa-project-1.0.0.jar](server/qa-project-1.0.0.jar),
para ello puede ejcutar el siguiente comando en la carpeta [server](server):
- java -jar qa-project-1.0.0.jar

La aplicación se levantará en [el puerto 7878 de su localhost](http://localhost:7878)


