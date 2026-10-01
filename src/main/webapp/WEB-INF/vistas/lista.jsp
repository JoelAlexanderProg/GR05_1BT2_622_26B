<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Objetos encontrados</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/estilos.css">
</head>
<body>
<main>
    <h1>Objetos encontrados en el campus</h1>
    <a class="boton" href="${pageContext.request.contextPath}/objetos?accion=nuevo">Registrar objeto</a>

    <c:choose>
        <c:when test="${empty objetos}">
            <p class="vacio">Todavía no hay objetos registrados.</p>
        </c:when>
        <c:otherwise>
            <table>
                <thead>
                <tr>
                    <th>N.º</th>
                    <th>Descripción</th>
                    <th>Categoría</th>
                    <th>Lugar</th>
                    <th>Fecha</th>
                    <th></th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="objeto" items="${objetos}">
                    <tr>
                        <td>${objeto.id}</td>
                        <td><c:out value="${objeto.descripcion}"/></td>
                        <td><c:out value="${objeto.categoria}"/></td>
                        <td><c:out value="${objeto.lugar}"/></td>
                        <td>${objeto.fecha}</td>
                        <td>
                            <form method="post" action="${pageContext.request.contextPath}/objetos">
                                <input type="hidden" name="accion" value="eliminar">
                                <input type="hidden" name="id" value="${objeto.id}">
                                <button type="submit" class="eliminar">Eliminar</button>
                            </form>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </c:otherwise>
    </c:choose>
</main>
</body>
</html>
