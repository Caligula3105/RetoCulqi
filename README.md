RetoKulki

1: Descripción
Proyecto automatizado de pruebas funcionales para la tienda online, utilizando Serenity BDD, Cucumber y Selenium WebDriver con Java y Maven.
Se estructura en carpetas para definiciones, páginas, pasos y utilidades, y utiliza archivos CSV para manejar datos de prueba.

2: Tecnologías usadas
Java 17
Maven
Serenity BDD (v4.2.34)
Cucumber (v7.14.0)
Selenium WebDriver (integrado con Serenity)
JUnit 4.13.2
CSV para datos de prueba

* Uso de CSV en los casos de prueba
Los archivos CSV se usan para parametrizar los casos, facilitando la ejecución con diferentes datos de usuario.
Por ejemplo, Usuarios.csv contiene usuarios válidos y UsuariosTemporales.csv usuarios temporales para escenarios específicos.

* Justificación del uso de Selenium WebDriver
Selenium está integrado mediante Serenity para permitir la automatización real de interacciones con el navegador (clics, ingreso de texto, navegación). Esto garantiza pruebas funcionales precisas y replicables de la tienda online.

3: Estructura del proyecto
src/test/java/com/tiendaonline/pe/definitions - Clases con definiciones de pasos (step definitions)
src/test/java/com/tiendaonline/pe/pages - Clases que modelan páginas web (Page Objects)
src/test/java/com/tiendaonline/pe/step - Implementación de pasos para Cucumber
src/test/java/com/tiendaonline/pe/util - Utilidades generales
src/test/resources/data - Archivos CSV con datos de usuarios y otros datos de prueba
src/test/resources/features - Archivos .feature con escenarios escritos en Gherkin

4: Instrucciones de instalación y ejecución
  4.1 Tener instalado Java 17
  4.2 Tener Maven instalado
  4.3 Navegador Chrome (u otro compatible)
  4.4 Clonar el repositorio
      git clone <url-del-repositorio>
      cd RetoKulki
  4.5 Ejecutar pruebas
      Ejecuta las pruebas con Maven:
      mvn clean verify
  4.6 Reportes
      Al finalizar la ejecución, los reportes de Serenity estarán disponibles en:
      target/serenity-reports/index.html
