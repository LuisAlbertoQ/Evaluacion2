/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.evaluacion.dao;

import com.mycompany.evaluacion.coon.ConnS;
import com.mycompany.evaluacion.modelo.ResultadoTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author quill
 */
public class ResultadoDao implements ResultadoDaoI {

    ConnS instance = ConnS.getInstance();
    Connection conexion = instance.getConnection();
    PreparedStatement ps;
    ResultSet rs;

    @Override
    public List listartabla() {
        List<ResultadoTO> lista = new ArrayList();
        String sql = "selec * from resultado";
        try {
            ps = conexion.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                ResultadoTO to = new ResultadoTO();
                to.setId_resultado(rs.getInt("id_resultado"));
                to.setPunto(rs.getInt("punto"));
                to.setNombre_partida(rs.getString("nombre_partida"));
                to.setNombre_jugador1(rs.getString("nombre_jugador1"));
                to.setNombre_jugador2(rs.getString("nombre_jugador2"));
            }

        } catch (Exception e) {
        }

        return lista;
    }

    @Override
    public int crearResultados(ResultadoTO re) {
        int exec = 0;
        int i = 0;

        String sql = "insert into resultado(nombre_partida, nombre_jugador1, nombre_jugador2) values(?,?,?)";
        try {
            ps = conexion.prepareStatement(sql);
            ps.setString(++i, re.getNombre_partida());
            ps.setString(++i, re.getNombre_jugador1());
            ps.setString(++i, re.getNombre_jugador2());
            exec = ps.executeUpdate();
            try ( ResultSet rs = ps.getGeneratedKeys()) {
                if (rs.next()) {
                    exec = rs.getInt(1);
                }
                rs.close();
            }
        } catch (SQLException ex) {

        }
        return exec;
    }

}
