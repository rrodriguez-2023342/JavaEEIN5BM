package com.kinalitosclothes.modelo;

import com.kinalitosclothes.config.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ClientesDAO {
    
    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    int resp;
    
    //Listar
    public List listar() {
        String sql = "call sp_ListarClientes();";
        List<Clientes> listaClientes = new ArrayList<>();
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Clientes cli = new Clientes();
                cli.setCodigoCliente(rs.getInt(1));
                cli.setNombreCliente(rs.getString(2));
                cli.setApellidoCliente(rs.getString(3));
                cli.setCorreoCliente(rs.getString(4));
                cli.setTelefonoCliente(rs.getString(5));
                cli.setDireccionCliente(rs.getString(6));
                cli.setCodigoUsuario(rs.getInt(7));
                listaClientes.add(cli);
            }
        } catch (Exception e) {
        }
        return listaClientes;
    }
}
