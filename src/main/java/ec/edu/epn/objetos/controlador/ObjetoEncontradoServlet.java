package ec.edu.epn.objetos.controlador;

import ec.edu.epn.objetos.dao.ObjetoEncontradoDAO;
import ec.edu.epn.objetos.modelo.ObjetoEncontrado;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.List;

/**
 * Controlador de la aplicación: recibe las peticiones, usa el DAO
 * y reenvía la respuesta a la JSP correspondiente.
 */
@WebServlet("/objetos")
public class ObjetoEncontradoServlet extends HttpServlet {

    private static final List<String> CATEGORIAS =
            List.of("Documentos", "Electrónicos", "Llaves", "Ropa y accesorios", "Útiles", "Otros");

    private final ObjetoEncontradoDAO dao = new ObjetoEncontradoDAO();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        if ("nuevo".equals(request.getParameter("accion"))) {
            mostrarFormulario(request, response);
        } else {
            request.setAttribute("objetos", dao.listar());
            request.getRequestDispatcher("/WEB-INF/vistas/lista.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        if ("eliminar".equals(request.getParameter("accion"))) {
            dao.eliminar(Long.valueOf(request.getParameter("id")));
            response.sendRedirect(request.getContextPath() + "/objetos");
            return;
        }

        String descripcion = limpiar(request.getParameter("descripcion"));
        String categoria = limpiar(request.getParameter("categoria"));
        String lugar = limpiar(request.getParameter("lugar"));
        LocalDate fecha = leerFecha(request.getParameter("fecha"));

        if (descripcion.isEmpty() || lugar.isEmpty() || !CATEGORIAS.contains(categoria)
                || fecha == null || fecha.isAfter(LocalDate.now())) {
            request.setAttribute("error",
                    "Complete todos los campos. La fecha no puede ser posterior a hoy.");
            mostrarFormulario(request, response);
            return;
        }

        dao.guardar(new ObjetoEncontrado(descripcion, categoria, lugar, fecha));
        // Redirigir después de guardar evita registrar dos veces al recargar la página
        response.sendRedirect(request.getContextPath() + "/objetos");
    }

    private void mostrarFormulario(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setAttribute("categorias", CATEGORIAS);
        request.setAttribute("hoy", LocalDate.now());
        request.getRequestDispatcher("/WEB-INF/vistas/formulario.jsp").forward(request, response);
    }

    private String limpiar(String valor) {
        return valor == null ? "" : valor.trim();
    }

    private LocalDate leerFecha(String valor) {
        try {
            return LocalDate.parse(valor);
        } catch (DateTimeParseException | NullPointerException e) {
            return null;
        }
    }
}
