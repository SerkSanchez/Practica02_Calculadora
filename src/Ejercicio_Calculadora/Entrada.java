package Ejercicio_Calculadora;

import javax.swing.*;

public class Entrada
{
    public static void main(String[] args) {

        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                VentanaCalculadora ventanaCalculadora = new VentanaCalculadora();
                ventanaCalculadora.initGUI();
            }
        });
    }
}
