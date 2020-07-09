/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.Editorial;

/**
 *
 * @author RaNmA
 */
public class EditorialDao {
     public static boolean registrar(Editorial e){
        try {
            String SQL="INSERT INTO editoriales(nit,nombre,telefono,direccion,email,sitioweb)" +
"values(?,?,?,?,?,?);";
            Connection con=Conexion.conectar();
            PreparedStatement st=con.prepareStatement(SQL);
            st.setString(1, e.getNit());
            st.setString(1, e.getNombre());
            st.setString(1, e.getTelefono());
            st.setString(1, e.getDireccion());
            st.setString(1, e.getEmail());
            st.setString(1, e.getSitioweb());
            if(st.executeUpdate()>0){
                return true;
            }else{
                return false;
            }
        } catch (SQLException ex) {
            return false;
        }
    }
    
    public static ArrayList<Editorial> listar(){
        try {
            String SQL="select * from editoriales";
            Connection con=Conexion.conectar();
            PreparedStatement st=con.prepareStatement(SQL);
           // st.setString(1, cat.getNombre());
            ResultSet resultado=st.executeQuery();
            ArrayList<Editorial> lista=null;
            Editorial edi;
            while(resultado.next()){
                edi=new Editorial();
                edi.setNit(resultado.getString("nit"));
                edi.setNombre(resultado.getString("nombre"));
                edi.setDireccion(resultado.getString("direccion"));
                edi.setEmail(resultado.getString("email"));
                edi.setSitioweb(resultado.getString("sitioweb"));
                edi.setTelefono(resultado.getString("telefono"));
                lista.add(edi);
            }
            return lista;
        } catch (SQLException ex) {
            return null;
        }
    }
}
