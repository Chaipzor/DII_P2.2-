# DII_P2.2
Práctica 2 de desarrollo de interfaces

# Enunciado
Desarrolla un Servicio Web con Java (Jersey) para el manejo de los datos de la Agenda
de contactos (Práctica 1.2).

La API deberá permitir realizar las operaciones CRUD sobre los datos almacenados en
una estructura en memoria.

Tomando como referencia la URL base indicada, las operaciones permitidas estarán
mapeadas de la siguiente manera:

Listar los contactos (JSON): GET

/webapi/contact

Obtener el número de contactos: GET

/webapi/contact/size

Insertar un contacto: POST

/webapi/contact

Actualizar un contacto: PUT

/webapi/contact

Eliminar un contacto: DELETE

/webapi/contact

A la hora de almacenar los contactos en la agenda se recomienda utilizar el email como
clave única o incluir un id numérico a cada registro para poder buscar un contacto
concreto en la estructura en memoria.

Realiza las comprobaciones de datos correspondientes, como puede ser la
comprobación de que el email del contacto a insertar no exista ya en el listado de
contactos, etc.

# Desarrollo
- Se han implementado todas las notas del enunciado.
- Se han añadido los controles pertinentes en diversas opciones para controlar y guiar al usuario si algo no es correcto
- Se ha utilizado postman para realizar las pruebas pertinentes
- Se ha utilizado el patrón DAO aunque no era requisito
- Los datos se almacenan en memoria

