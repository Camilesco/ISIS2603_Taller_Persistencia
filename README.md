# Taller Persistencia


## Enlaces de interés

- [BookstoreBack](https://github.com/Uniandes-isis2603/bookstore-back) -> Repositorio de referencia para el Back

## Respuestas Taller

1. Diseño de Relaciones: La columna de la llave foránea `project_id` queda en la tabla de `Tarea` (es decir, en `TareaEntity`). Esto es necesario porque la relación es `@ManyToOne` desde `Tarea` hacia `Proyecto`: muchas tareas pertenecen a un proyecto, así que la FK vive en el lado "muchos" para indicar a qué proyecto pertenece cada tarea.

2. Integridad de Datos: En el código actual se usó `orphanRemoval = true` en `ProyectoEntity` para que cuando una `Tarea` se elimine de la lista `tareas`, esa fila se borre de la base de datos. Además, el `cascade` configurado es `CascadeType.PERSIST`, que solo propaga la persistencia, no el borrado. Para que al borrar un `Proyecto` desaparezcan automáticamente sus `Tareas`, habría que usar `CascadeType.REMOVE` (o `CascadeType.ALL`) en la relación. Diferencia conceptual: borrar una tarea de la lista es eliminar solo esa tarea (y el proyecto sigue existiendo); borrar el proyecto entero implica eliminar el agregado completo y todas sus tareas asociadas.

3. Consultas: El método `findByEstado(...)` es un Query Method de Spring Data JPA. Spring analiza el nombre del método y genera un `SELECT` con `WHERE estado = ?`. En SQL, sería aproximadamente:

```sql
SELECT *
FROM tarea
WHERE estado = 'Terminado';