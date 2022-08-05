# CRUD
Nombre: Eduardo Garcia

CI: 30.167.871

Correo: eduardo.30167871@uru.edu

# Informacion del proyecto

Este proyecto es una aplicacion en java NetBeans sobre una interfaz grafica capaz de realizar las operaciones basicas de una base de datos

La base de datos se llama CRUD, el usuario postgres y la contraseña poki2320

Para hacer el crud se creo la siguiente tabla:

```sql
create table empleado (
  id serial not null primary key,
  nombre text not null,
  apellido text not null,
  puesto text not null,
  correo text not null
);
```
