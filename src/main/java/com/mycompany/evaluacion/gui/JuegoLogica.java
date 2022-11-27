/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.evaluacion.gui;

import java.awt.Color;
import javax.swing.JOptionPane;

/**
 *
 * @author quill
 */
public class JuegoLogica {

    int Turno;
    int pJugador1;
    int pJugador2;

    public JuegoLogica(int Turno, int pJugador1, int pJugador2) {
        this.Turno = Turno;
        this.pJugador1 = pJugador1;
        this.pJugador2 = pJugador2;
    }

    public int getTurno() {
        return Turno;
    }

    public void setTurno(int Turno) {
        this.Turno = Turno;
    }

    public int getpJugador1() {
        return pJugador1;
    }

    public void setpJugador1(int pJugador1) {
        this.pJugador1 = pJugador1;
    }

    public int getpJugador2() {
        return pJugador2;
    }

    public void setpJugador2(int pJugador2) {
        this.pJugador2 = pJugador2;
    }

    public void intercambiar() {
        if (getTurno() == 0) {
            setTurno(1);
        } else {
            setTurno(0);
        }
    }

    public int juego(int matriz[][]) {
        ///posibilidades en horizontal
        if (matriz[0][0] == matriz[0][1] && matriz[0][0] == matriz[0][2]) {
            return 1;
        }
        if (matriz[1][0] == matriz[1][1] && matriz[1][0] == matriz[1][2]) {
            return 2;
        }
        if (matriz[2][0] == matriz[2][1] && matriz[2][0] == matriz[2][2]) {
            return 3;
        }
        ///posibilidades en vertical
        if (matriz[0][0] == matriz[1][0] && matriz[0][0] == matriz[2][0]) {
            return 4;
        }
        if (matriz[0][1] == matriz[1][1] && matriz[0][1] == matriz[2][1]) {
            return 5;
        }
        if (matriz[0][2] == matriz[1][2] && matriz[0][2] == matriz[2][2]) {
            return 6;
        }
        ///posibilidades en diagonal
        if (matriz[0][0] == matriz[1][1] && matriz[0][0] == matriz[2][2]) {
            return 7;
        }
        if (matriz[2][0] == matriz[1][1] && matriz[2][0] == matriz[0][2]) {
            return 8;
        }
        return 0;
    }

    public int ejecutar(javax.swing.JButton bt, int i, int j, int matriz[][], javax.swing.JLabel jx, javax.swing.JLabel jo) {
        matriz[i][j] = getTurno();
        String n = new String();
        if (getTurno() == 0) {
            n = "X";
            bt.setForeground(Color.red);

        } else {
            n = "O";
            bt.setForeground(Color.blue);
        }

        intercambiar();
        bt.setText(n);
        bt.setEnabled(false);

        if (juego(matriz) != 0) {
            JOptionPane.showMessageDialog(null, "Ganaste!" + n);
            if (getTurno() == 1) {
                setpJugador1(getpJugador1() + 1);
                jx.setText(String.valueOf(getpJugador1()));
            }
            if (getTurno() == 0) {
                setpJugador2(getpJugador2() + 1);
                jo.setText(String.valueOf(getpJugador2()));
            }
            return 1;

        }
        return 0;
    }

    public void rayar(int matriz[][], javax.swing.JPanel p, int n, int i, int j) {
        matriz[i][j] = getTurno();
        if (juego(matriz) == n) {
            p.setVisible(true);
        }
    }

    public void rayar(int matriz[][], javax.swing.JLabel p, int n, int i, int j) {
        matriz[i][j] = getTurno();
        if (juego(matriz) == n) {
            p.setVisible(true);
        }
    }
}
