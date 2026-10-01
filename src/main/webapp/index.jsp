<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%-- Página de inicio: envía al controlador, que muestra la lista de objetos --%>
<% response.sendRedirect(request.getContextPath() + "/objetos"); %>
