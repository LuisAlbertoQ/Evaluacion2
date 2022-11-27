/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.evaluacion.dao;

import com.mycompany.evaluacion.modelo.ResultadoTO;
import java.util.List;


public interface ResultadoDaoI {
    public List listartabla();
    public int crearResultados(ResultadoTO re);
}
