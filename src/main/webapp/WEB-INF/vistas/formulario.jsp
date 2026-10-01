<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Registrar objeto encontrado</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/estilos.css">
</head>
<body>
<main>
    <h1>Registrar objeto encontrado</h1>

    <c:if test="${not empty error}">
        <p class="error"><c:out value="${error}"/></p>
    </c:if>

    <form class="formulario" method="post" action="${pageContext.request.contextPath}/objetos">
        <label for="descripcion">Descripción</label>
        <input type="text" id="descripcion" name="descripcion" maxlength="150" required
               value="<c:out value='${param.descripcion}'/>">

        <label for="categoria">Categoría</label>
        <select id="categoria" name="categoria" required>
            <c:forEach var="categoria" items="${categorias}">
                <option value="<c:out value='${categoria}'/>"
                        <c:if test="${categoria == param.categoria}">selected</c:if>>
                    <c:out value="${categoria}"/>
                </option>
            </c:forEach>
        </select>

        <label for="lugar">Lugar donde se encontró</label>
        <input type="text" id="lugar" name="lugar" maxlength="100" required
               value="<c:out value='${param.lugar}'/>">

        <label for="fecha">Fecha</label>
        <input type="date" id="fecha" name="fecha" max="${hoy}" required
               value="<c:out value='${empty param.fecha ? hoy : param.fecha}'/>">

        <div class="acciones">
            <button type="submit" class="boton">Guardar</button>
            <a href="${pageContext.request.contextPath}/objetos">Cancelar</a>
        </div>
    </form>
</main>
</body>
</html>
