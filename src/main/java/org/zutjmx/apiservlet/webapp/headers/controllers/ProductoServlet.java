package org.zutjmx.apiservlet.webapp.headers.controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.zutjmx.apiservlet.webapp.headers.models.Producto;
import org.zutjmx.apiservlet.webapp.headers.services.LoginService;
import org.zutjmx.apiservlet.webapp.headers.services.LoginServiceImpl;
import org.zutjmx.apiservlet.webapp.headers.services.ProductoService;
import org.zutjmx.apiservlet.webapp.headers.services.ProductoServiceImpl;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@WebServlet({"/productos", "/productos.html"})
public class ProductoServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ProductoService productoService = new ProductoServiceImpl();
        List<Producto> productos = productoService.listar();
        String servletPath = req.getServletPath();

        LoginService loginService = new LoginServiceImpl();
        Optional<String> cookieOptional = loginService.getUsername(req);

        resp.setContentType("text/html;charset=UTF-8");

        try (PrintWriter out = resp.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("    <head>");
            out.println("      <meta charset=\"UTF-8\">");
            out.println("      <title>Listado de Productos</title>");
            out.println("    </head>");
            out.println("  <body>");
            out.println("      <h1>Productos:</h1>");
            if (cookieOptional.isPresent()) {
                out.println("      <div style='color: blue;'>Hola " + cookieOptional.get() + " bienvenido</div>");
            }
            out.println("      <table>");
            out.println("      <tr>");
            out.println("       <th>Id</th>");
            out.println("       <th>Nombre</th>");
            out.println("       <th>Tipo</th>");
            if (cookieOptional.isPresent()) {
                out.println("       <th>Precio</th>");
            }
            out.println("      </tr>");
            productos.forEach(p -> {
                out.println("      <tr>");
                out.println("       <td>".concat(p.getId().toString()).concat("</td>"));
                out.println("       <td>".concat(p.getNombre()).concat("</td>"));
                out.println("       <td>".concat(p.getTipo()).concat("</td>"));
                if (cookieOptional.isPresent()) {
                    out.println("       <td>" + p.getPrecio() + "</td>");
                }
                out.println("      </tr>");
            });
            out.println("      </table>");
            out.println("      <p><a href=\"" + req.getContextPath() + "\">Regresar</a></p>");
            out.println("  </body>");
            out.println("</html>");
        }

    }
}
