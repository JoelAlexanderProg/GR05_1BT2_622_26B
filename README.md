# GR05_1BT2_622_26B: Registro de objetos encontrados

Ejemplo de aplicación web con Java para la Tarea 2 de Metodologías Ágiles (ISWD622, EPN, 2026-B), Grupo 5.

Permite registrar los objetos encontrados en el campus, verlos en una lista y eliminarlos.

## Tecnologías

| Capa | Tecnología |
|---|---|
| Vista | JSP con JSTL |
| Controlador | Servlet (Jakarta Servlet 6) |
| Persistencia (ORM) | JPA con Hibernate |
| Base de datos | H2 embebida (archivo en `~/gr05_1bt2/`) |
| Servidor | Apache Tomcat 10.1 |
| Construcción | Maven |

## Estructura

```
src/main/java/ec/edu/epn/objetos/
├── modelo/ObjetoEncontrado.java            entidad JPA
├── dao/JPAUtil.java                        fábrica de EntityManager
├── dao/ObjetoEncontradoDAO.java            guardar, listar y eliminar
└── controlador/
    ├── ObjetoEncontradoServlet.java        atiende /objetos
    └── CierreJPAListener.java              cierra la base de datos al detener la aplicación
src/main/resources/META-INF/persistence.xml configuración de JPA
src/main/webapp/
├── index.jsp                               redirige a /objetos
├── css/estilos.css
└── WEB-INF/vistas/lista.jsp, formulario.jsp
```

## Cómo ejecutar

Solo se necesita Java 17 o superior. Maven y Tomcat se descargan automáticamente la primera vez.

```bash
# Windows (PowerShell o símbolo del sistema)
.\mvnw.cmd package cargo:run

# Linux o macOS
./mvnw package cargo:run
```

Luego abrir <http://localhost:8080/GR05_1BT2_622_26B/>. Para detener el servidor, presionar `Ctrl + C`.

También se puede generar el archivo `target/GR05_1BT2_622_26B.war` con `mvnw package` y desplegarlo en un Tomcat 10.1 o configurarlo como artefacto en el IDE.

## Integrantes

- Lenin Alejandro Jerez Chimbo
- Dylan Isaí Maldonado Morales
- Joel Alexander Places Lucero
- Jeimy Jhair Sánchez Tixe
- Francisco Gabriel Villalba Portilla
