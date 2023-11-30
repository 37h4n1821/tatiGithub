/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mysql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.table.DefaultTableModel;
import Clases.Cliente;


class NoEditableTableModel extends DefaultTableModel {
    @Override
    public boolean isCellEditable(int row, int column) {
        return false;
    }
}

public class CrudCliente {
    public boolean agregar(Cliente cli) {
        Conexion con= new Conexion();
        Connection conn=con.conectarBD("MyPet");
        PreparedStatement stmt;
        String query = "insert into cliente (rut,dv,nombre,apepat,apemat) values (?,?,?,?,?)";
        try {
            stmt = conn.prepareStatement(query);
            stmt.setString(1,cli.getRut());
            stmt.setString(2,String.valueOf(cli.getDv()));
            stmt.setString(3,cli.getNombre());
            stmt.setString(4, cli.getApe1());
            stmt.setString(5, cli.getApe2());
            stmt.executeUpdate();
            return true;
        } catch (SQLException ex) {
            return false;
        }         
    }

    public DefaultTableModel listarClientes(String opc) {   /* AGREGUÉ */
        Statement stmt;
        ResultSet rs;
        Conexion con= new Conexion();
        Connection conn=con.conectarBD("MyPet");
        try {
            stmt = conn.createStatement(); 
            if (opc.equals("")){
                rs = stmt.executeQuery("select * from cliente");
            }else{
                rs = stmt.executeQuery("select * from cliente where rut = "+opc);
            }
            DefaultTableModel DT=new NoEditableTableModel();
            DT.addColumn("Rut");
            DT.addColumn("Nombre");
            DT.addColumn("Apellido paterno");
            DT.addColumn("Apellido Materno");
            Object[] fila=new Object[4];
            while (rs.next()) { 
                fila[0]=rs.getString(1)+"-"+rs.getString(2);
                fila[1]=rs.getString(3);
                fila[2]=rs.getString(4);
                fila[3]=rs.getString(5);
                DT.addRow(fila);
            }
            rs.close(); 
            stmt.close(); 
            return(DT);
        } catch (SQLException ex) {
            return null;
        }
    }    

    public boolean modificar(Cliente cli) {
        Conexion con= new Conexion();
        Connection conn=con.conectarBD("MyPet");
        PreparedStatement stmt;
        String query = "update cliente set dv=?,nombre=?,apemat=?,apepat=? where rut=?";
        try {            
            stmt = conn.prepareStatement(query);
            stmt.setString(1,cli.getNombre());
            stmt.setString(2, cli.getApe1());
            stmt.setString(3, cli.getApe2());
            stmt.setString(4, cli.getRut());
            stmt.setString(5,String.valueOf(cli.getDv()));
            stmt.executeUpdate();
            return true;
        } catch (SQLException ex) {
            return false;
        }     
    }   
    
    public String buscar(Cliente cli) {
        Statement stmt;
        ResultSet rs;
        Conexion con= new Conexion();
        Connection conn=con.conectarBD("MyPet");
        String codigo="-1";
        try {
            stmt = conn.createStatement(); 
            rs = stmt.executeQuery("select rut,dv,nombre,apepat,apemat from cliente where rut='"+cli.getRut()+"'");
            while (rs.next()) { 
                cli.setNombre(rs.getString(3));
                cli.setApe1(rs.getString(4));
                cli.setApe2(rs.getString(5));
				cli.setRut(rs.getString(1));
                codigo=cli.getRut(); 
            }
            rs.close(); 
            stmt.close(); 
            return codigo;
        } catch (SQLException ex) {
           return codigo; 
        }
    }    

    public boolean eliminar(Cliente cli) {
        Conexion con= new Conexion();
        Connection conn=con.conectarBD("Mypet");
        PreparedStatement stmt;
        String query = "delete from cliente where rut=?";
        try {
            stmt = conn.prepareStatement(query);
            stmt.setString(1,cli.getRut());
            stmt.executeUpdate();
            return true;
        } catch (SQLException ex) {
            
        }     
        return false;
    }     


}
