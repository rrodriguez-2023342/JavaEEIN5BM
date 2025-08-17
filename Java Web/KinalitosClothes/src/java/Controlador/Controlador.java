package Controlador;

import com.kinalitosclothes.modelo.Clientes;
import com.kinalitosclothes.modelo.ClientesDAO;
import com.kinalitosclothes.modelo.Empleados;
import com.kinalitosclothes.modelo.EmpleadosDAO;
import com.kinalitosclothes.modelo.Pedidos;
import com.kinalitosclothes.modelo.PedidosDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Controlador extends HttpServlet {

    EmpleadosDAO empleadoDAO = new EmpleadosDAO();
    Empleados empleado = new Empleados();

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, ParseException {
        String menu = request.getParameter("menu");
        String accion = request.getParameter("accion");
        if (menu.equals("Principal")) {
            request.getRequestDispatcher("Index/Principal.jsp").forward(request, response);
        } else if (menu.equals("VistaEmpleado")) {
            /*
            switch (accion) {
                case "Listar":
                    List listaempleados = empleadoDAO.listar();
                    request.setAttribute("empleados", listaempleados);
                    break;
                case "Agregar":
                    int Codigousuario = 0;
                    String Nombre = request.getParameter("txtNombreEmpleado");
                    String Apellido = request.getParameter("txtApellidoEmpleado");
                    String Correo = request.getParameter("txtCorreoEmpleado");
                    String Telefono = request.getParameter("txtTelefonoEmpleado");
                    String Direccion = request.getParameter("txtDireccionEmpleado");
                    String CodigousuarioStr = request.getParameter("txtCodigoUsuario");
                    try {
                        Codigousuario = Integer.parseInt(CodigousuarioStr);
                    } catch (NumberFormatException e) {
                        // Manejo de error si no es un número válido
                        System.out.println("El código de usuario no es un número válido.");
                    }
                    empleado.setNombreEmpleado(Nombre);
                    empleado.setApellidoEmpleado(Apellido);
                    empleado.setCorreoEmpleado(Correo);
                    empleado.setTelefonoEmpleado(Telefono);
                    empleado.setDireccionEmpleado(Direccion);
                    empleado.setCodigoUsuario(Codigousuario);
                    empleadoDAO.agregar(empleado);
                    request.getRequestDispatcher("Controlador?menu=VistaEmpleado&accion=Listar").forward(request, response);
                    break;
                case "Editar":
                    break;
                case "Actualizar":
                    break;
                case "Eliminar":
                    break;
                default:
                    System.out.println("No se encontro");
            }
            request.getRequestDispatcher("Index/vistaempleadoadmin.jsp").forward(request, response);
             */
        } else if (menu.equals("VistaCliente")) {
            request.getRequestDispatcher("Index/vistaclientesadmin.jsp").forward(request, response);
        } else if (menu.equals("VistaProducto")) {
            request.getRequestDispatcher("Index/vistaproductoadmin.jsp").forward(request, response);
        } else if (menu.equals("VistaUsuario")) {
            request.getRequestDispatcher("Index/VistaUsuarioAdmin.jsp").forward(request, response);
        } else if (menu.equals("VistaPedido")) {
            PedidosDAO pedidoDAO = new PedidosDAO();
            Pedidos pedido = new Pedidos();
            switch (accion) {
                case "Listar":
                    List listapedidos = pedidoDAO.listar();
                    request.setAttribute("pedidos", listapedidos);
                    break;
                case "Agregar":
                    int codigoUsuario = 0;
                    int codigoMetodoP = 0;
                    String horaStr = request.getParameter("txtHoraPedido"); 
                    Time Hora = Time.valueOf(horaStr + ":00"); 
                    String fechaStr = request.getParameter("txtFechaPedido");
                    Date Fecha = new SimpleDateFormat("yyyy-MM-dd").parse(fechaStr);
                    String Estado = request.getParameter("txtEstadoPedido");
                    Double Total = Double.valueOf(request.getParameter("txtTotal"));
                    String codUsuarioStr = request.getParameter("txtCodigoUsuario");
                    String codMetodoStr = request.getParameter("txtCodigoMetodoPago"); // corregido
                    try {
                        codigoUsuario = Integer.parseInt(codUsuarioStr);
                        codigoMetodoP = Integer.parseInt(codMetodoStr);
                    } catch (NumberFormatException e) {
                        System.out.println("El código de usuario o método de pago no es un número válido.");
                        return;
                    }
                    pedido.setHoraPedido(Hora);
                    pedido.setFechaPedido(Fecha);
                    pedido.setEstadoPedido(Pedidos.Estado.Pendiente);
                    pedido.setTotal(Total);
                    pedido.setCodigoUsuario(codigoUsuario);
                    pedido.setCodigoMetodoPago(codigoMetodoP);
                    pedidoDAO.agregar(pedido);
                    request.getRequestDispatcher("Controlador?menu=VistaPedido&accion=Listar").forward(request, response);
                    break;
                case "Editar":
                    break;
                case "Actualizar":
                    break;
                case "Buscar":
                    String codigoPed = request.getParameter("txtBuscarId");
                    List<Pedidos> listaPedidosB = new ArrayList<>();
                    if (codigoPed != null && !codigoPed.trim().isEmpty()) {
                        try {
                            int codigoP = Integer.parseInt(codigoPed);
                            Pedidos pedidoEncontrado = pedidoDAO.buscar(codigoP);

                            if (pedidoEncontrado != null) {
                                listaPedidosB.add(pedidoEncontrado);
                            } else {
                                request.setAttribute("error", "Factura no encontrada");
                            }
                        } catch (NumberFormatException e) {
                            request.setAttribute("error", "ID de Factura inválido");
                        }
                    } else {
                        listaPedidosB = pedidoDAO.listar();
                    }

                    request.setAttribute("pedidos", listaPedidosB);
                    request.getRequestDispatcher("/Index/vistapedidoadmin.jsp").forward(request, response);

                    break;
                case "Eliminar":
                    String idEliminar = request.getParameter("id");
                    if (idEliminar != null && !idEliminar.trim().isEmpty()) {
                        try {
                            int codigo = Integer.parseInt(idEliminar);

                            int resultado = pedidoDAO.eliminar(codigo);

                            if (resultado > 0) {
                                request.setAttribute("mensaje", "Pedido eliminado exitosamente");
                            } else {
                                request.setAttribute("error", "Error al eliminar el pedido");
                            }

                        } catch (NumberFormatException e) {
                            request.setAttribute("error", "ID de pedido inválido");
                        }

                        response.sendRedirect("Controlador?menu=VistaPedido&accion=Listar");
                        return;
                    }
                    break;
                default:
                    System.out.println("No se encontro");
            }
            request.getRequestDispatcher("Index/vistapedidoadmin.jsp").forward(request, response);
        } else if (menu.equals("VistaFactura")) {
            request.getRequestDispatcher("Index/VistaFacturaAdmin.jsp").forward(request, response);
        } else if (menu.equals("VistaCategoria")) {
            request.getRequestDispatcher("Index/vistacategoria.jsp").forward(request, response);
        } else if (menu.equals("VistaProveedor")) {
            request.getRequestDispatcher("Index/vistaproveedoradmin.jsp").forward(request, response);
        } else if (menu.equals("VistaDetallePedido")) {
            request.getRequestDispatcher("Index/vistadetallepedidoadmin.jsp").forward(request, response);
        } else if (menu.equals("VistaMetodoPago")) {
            request.getRequestDispatcher("Index/metodopagoadmin.jsp").forward(request, response);
        } else if (menu.equals("Tienda")) {
            request.getRequestDispatcher("Index/vistaproducto.jsp").forward(request, response);
        } else if (menu.equals("Nosotros")) {
            request.getRequestDispatcher("Index/conocenos.jsp").forward(request, response);
        } else if (menu.equals("VistaAdmin")) {
            request.getRequestDispatcher("Index/vistaadmin.jsp").forward(request, response);
        } else if (menu.equals("Mispedidos")) {
            request.getRequestDispatcher("Index/mispedidos.jsp").forward(request, response);
        } else if (menu.equals("DetalePedido")) {
            request.getRequestDispatcher("Index/vistadetallepedido.jsp").forward(request, response);
        } else if (menu.equals("FacturaCliente")) {
            request.getRequestDispatcher("Index/VistaFacturaCliente.jsp").forward(request, response);
        } else if (menu.equals("MetodoPago")) {
            request.getRequestDispatcher("Index/MetodoPago.jsp").forward(request, response);
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (ParseException ex) {
            Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (ParseException ex) {
            Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
