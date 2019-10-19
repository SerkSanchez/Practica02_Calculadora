package Ejercicio_Calculadora;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VentanaCalculadora extends JFrame implements ActionListener {
    JButton botonCero, botonUno, botonDos, botonTres, botonCuatro, botonCinco, botonSeis, botonSiete, botonOcho, botonNueve;
    JButton botonDiv, botonMulti, botonResta, botonSuma, botonIgual, botonPunto, botonClear, botonDel, botonResto, botonMasMenos;
    JButton botonSin, botonCos, botonTan, botonLn, botonRaiz;
    JButton botonBasico, botonCientifico;

    JTextField pantalla;

    JPanel panelInferior, panelSuperior, panelDerecha, panelCentro, panelIzquierda;

    Container container;

    double oper1, oper2;
    int tipoOperacion;
    boolean operando = false;

    public void initGUI()
    {
        instancias();
        configurarContainer();

        this.setBounds(25, 25, 500, 700);
        this.setTitle("CALCULADORA");
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        acciones();
    }

    private void acciones() //Añadir los botones que tendrán escuchadores
    {
        Component[] componentesNumeros =panelCentro.getComponents(); //Forma abreviada para agrupar todos los botonX.addActionListener(this) a la vez;
        for(Component item : componentesNumeros)
        {
            ((JButton)item).addActionListener(this);
        }

        Component[] componentesOper = panelDerecha.getComponents(); //Forma abreviada para agrupar todos los botonX.addActionListener(this) a la vez;
        for(Component item : componentesOper)
        {
            ((JButton)item).addActionListener(this);
        }

        Component[] componentesOperIzq = panelIzquierda.getComponents(); //Forma abreviada para agrupar todos los botonX.addActionListener(this) a la vez;
        for(Component item : componentesOperIzq)
        {
            ((JButton)item).addActionListener(this);
        }

        botonBasico.addActionListener(this); //Forma simple
        botonCientifico.addActionListener(this);
    }

    private void instancias()
    {
        Font fuente = new Font("Calibri", Font.BOLD, 36);
        container = getContentPane();

        botonCero = new JButton("0");
        botonCero.setFont(fuente);
        botonCero.setPreferredSize(new Dimension(200,100));
        botonUno = new JButton("1");
        botonUno.setFont(fuente);
        botonDos = new JButton("2");
        botonDos.setFont(fuente);
        botonTres = new JButton("3");
        botonTres.setFont(fuente);
        botonCuatro = new JButton("4");
        botonCuatro.setFont(fuente);
        botonCinco = new JButton("5");
        botonCinco.setFont(fuente);
        botonSeis = new JButton("6");
        botonSeis.setFont(fuente);
        botonSiete = new JButton("7");
        botonSiete.setFont(fuente);
        botonOcho = new JButton("8");
        botonOcho.setFont(fuente);
        botonNueve = new JButton("9");
        botonNueve.setFont(fuente);


        botonDiv = new JButton("/");
        botonDiv.setFont(fuente);
        botonMulti = new JButton("*");
        botonMulti.setFont(fuente);
        botonResta = new JButton("-");
        botonResta.setFont(fuente);
        botonSuma = new JButton("+");
        botonSuma.setFont(fuente);
        botonIgual = new JButton("=");
        botonIgual.setFont(fuente);
        botonPunto = new JButton(".");
        botonPunto.setFont(fuente);
        botonDel = new JButton("Del");
        botonDel.setFont(fuente);
        botonClear = new JButton("AC");
        botonClear.setFont(fuente);
        botonMasMenos = new JButton("+-");
        botonMasMenos.setFont(fuente);
        botonResto = new JButton("%");
        botonResto.setFont(fuente);

        botonSin = new JButton("Sin");
        botonSin.setFont(fuente);
        botonCos = new JButton("Cos");
        botonCos.setFont(fuente);
        botonTan = new JButton("Tan");
        botonTan.setFont(fuente);
        botonLn = new JButton("Ln");
        botonLn.setFont(fuente);
        botonRaiz = new JButton("Rz");
        botonRaiz.setFont(fuente);

        botonBasico = new JButton("Basico");
        botonCientifico = new JButton("Cientifico");

        pantalla = new JTextField();
        pantalla.setHorizontalAlignment(pantalla.RIGHT);
        pantalla.setFont(fuente);
        pantalla.setForeground(Color.RED);
        pantalla.setBackground(Color.lightGray);

        panelInferior = new JPanel();
        panelInferior.setBackground(Color.gray);
        panelSuperior = new JPanel();
        panelDerecha = new JPanel();
        panelDerecha.setBackground(Color.lightGray);
        panelCentro = new JPanel();
        panelCentro.setBackground(Color.lightGray);
        panelIzquierda = new JPanel();
    }

    private void configurarContainer()
    {
        container.setLayout(new BorderLayout());
        container.add(configInferior(), BorderLayout.SOUTH);
        container.add(configSuperior(), BorderLayout.NORTH);
        container.add(configDerecha(), BorderLayout.EAST);
        container.add(configCentro(), BorderLayout.CENTER);
        container.add(configIzquierda(), BorderLayout.WEST);
    }

    private JPanel configInferior()
    {
        panelInferior.add(botonCientifico);
        panelInferior.add(botonBasico);
        return panelInferior;
    }

    private JPanel configSuperior() {
        panelSuperior.setPreferredSize(new Dimension(150,150));
        panelSuperior.setLayout(new BorderLayout());
        panelSuperior.add(pantalla, BorderLayout.CENTER);
        return panelSuperior;
    }

    private JPanel configDerecha()
    {
        panelDerecha.setPreferredSize(new Dimension(100, 200));
        panelDerecha.setLayout(new GridLayout(5, 1, 5, 5));
        panelDerecha.add(botonDiv);
        panelDerecha.add(botonMulti);
        panelDerecha.add(botonResta);
        panelDerecha.add(botonSuma);
        panelDerecha.add(botonIgual);
        return panelDerecha;
    }

    private JPanel configCentro() {
        panelCentro.setPreferredSize(new Dimension(100, 100));
        panelCentro.setLayout(new GridLayout(5, 4, 5, 5));
        panelCentro.add(botonClear);
        panelCentro.add(botonMasMenos);
        panelCentro.add(botonResto);
        panelCentro.add(botonSiete);
        panelCentro.add(botonOcho);
        panelCentro.add(botonNueve);
        panelCentro.add(botonCuatro);
        panelCentro.add(botonCinco);
        panelCentro.add(botonSeis);
        panelCentro.add(botonUno);
        panelCentro.add(botonDos);
        panelCentro.add(botonTres);
        panelCentro.add(botonCero);
        panelCentro.add(botonPunto);
        panelCentro.add(botonDel);
        return panelCentro;
    }

    private JPanel configIzquierda()
    {
        container.add(panelIzquierda, BorderLayout.WEST);
        panelIzquierda.setPreferredSize(new Dimension(100, 200));
        panelIzquierda.setLayout(new GridLayout(5, 1, 5, 5));
        panelIzquierda.add(botonSin);
        panelIzquierda.add(botonCos);
        panelIzquierda.add(botonTan);
        panelIzquierda.add(botonLn);
        panelIzquierda.add(botonRaiz);
        return panelIzquierda;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == botonCero) {
            if (!operando) {
                pantalla.setText(pantalla.getText() + "0");
            } else {
                pantalla.setText("0");
                operando = false;
            }
        }

        if (e.getSource() == botonUno) {
            if (!operando) {
                pantalla.setText(pantalla.getText() + "1");
            } else {
                pantalla.setText("1");
                operando = false;
            }
        }

        if (e.getSource() == botonDos) {
            if (!operando) {
                pantalla.setText(pantalla.getText() + "2");
            } else {
                pantalla.setText("2");
                operando = false;
            }
        }

        if (e.getSource() == botonTres) {
            if (!operando) {
                pantalla.setText(pantalla.getText() + "3");
            } else {
                pantalla.setText("3");
                operando = false;
            }
        }
        if (e.getSource() == botonCuatro) {
            if (!operando) {
                pantalla.setText(pantalla.getText() + "4");
            } else {
                pantalla.setText("4");
                operando = false;
            }
        }

        if (e.getSource() == botonCinco) {
            if (!operando) {
                pantalla.setText(pantalla.getText() + "5");
            } else {
                pantalla.setText("5");
                operando = false;
            }
        }

        if (e.getSource() == botonSeis) {
            if (!operando) {
                pantalla.setText(pantalla.getText() + "6");
            } else {
                pantalla.setText("6");
                operando = false;
            }
        }

        if (e.getSource() == botonSiete) {
            if (!operando) {
                pantalla.setText(pantalla.getText() + "7");
            } else {
                pantalla.setText("7");
                operando = false;
            }
        }

        if (e.getSource() == botonOcho) {
            if (!operando) {
                pantalla.setText(pantalla.getText() + "8");
            } else {
                pantalla.setText("8");
                operando = false;
            }
        }

        if (e.getSource() == botonNueve) {
            if (!operando) {
                pantalla.setText(pantalla.getText() + "9");
            } else {
                pantalla.setText("9");
                operando = false;
            }
        }

        if (e.getSource() == botonPunto) {
            int posicion = pantalla.getText().toString().lastIndexOf(".");
            if(posicion == -1)
            {
                pantalla.setText(pantalla.getText() + ".");
            }
        }

        if (e.getSource() == botonSuma) {
            operando = true;
            oper1 = Double.valueOf(pantalla.getText());
            tipoOperacion = 1;
        }

        if (e.getSource() == botonResta) {
            operando = true;
            oper1 = Double.valueOf(pantalla.getText());
            tipoOperacion = 2;
        }

        if (e.getSource() == botonMulti) {
            operando = true;
            oper1 = Double.valueOf(pantalla.getText());
            tipoOperacion = 3;
        }

        if (e.getSource() == botonDiv) {
            operando = true;
            oper1 = Double.valueOf(pantalla.getText());
            tipoOperacion = 4;
        }

        if (e.getSource() == botonResto) {
            operando = true;
            oper1 = Double.valueOf(pantalla.getText());
            tipoOperacion = 5;
        }

        if (e.getSource() == botonClear)
        {
            pantalla.setText("");
            oper2 = 0;
        }

        if(e.getSource() == botonDel)
        {
            if(pantalla.getText().toString() != "")
            {
                pantalla.setText(pantalla.getText().substring(0, pantalla.getText().length()-1));
            }
        }

        if (e.getSource() == botonMasMenos)
        {
            double masmenos = (Double.parseDouble(pantalla.getText())) * -1;
            pantalla.setText(String.valueOf(masmenos));
        }

        if (e.getSource() == botonSin)
        {
            if(pantalla.getText().toString() != "")
            {
                double radianes = Math.toRadians(Double.parseDouble(pantalla.getText().toString()));
                pantalla.setText(String.valueOf(Math.sin(radianes)));
            }
        }

        if (e.getSource() == botonCos) {
            if (pantalla.getText().toString() != "") {
                double radianes = Math.toRadians(Double.parseDouble(pantalla.getText().toString()));
                pantalla.setText(String.valueOf(Math.cos(radianes)));
            }
        }

        if (e.getSource() == botonTan) {
            if (pantalla.getText().toString() != "") {
                double radianes = Math.toRadians(Double.parseDouble(pantalla.getText().toString()));
                pantalla.setText(String.valueOf(Math.tan(radianes)));
            }
        }

        if (e.getSource() == botonLn) {
            if (pantalla.getText().toString() != "") {
                pantalla.setText(String.valueOf(Math.log(Double.parseDouble(pantalla.getText().toString()))));
            }
        }

        if (e.getSource() == botonRaiz) {
            pantalla.setText(String.valueOf(Math.sqrt(Double.parseDouble(pantalla.getText().toString()))));
        }

        if (e.getSource() == botonIgual)
        {
            oper2 = Double.valueOf(pantalla.getText());
            double resultado = 0;
            switch (tipoOperacion) {
                case 1:
                    resultado = oper1 + oper2;
                    break;
                case 2:
                    resultado = oper1 - oper2;
                    break;
                case 3:
                    resultado = oper1 * oper2;
                    break;
                case 4:
                    resultado = oper1 / oper2;
                    break;
                case 5:
                    resultado = oper1 % oper2;
                    break;
            }
            pantalla.setText(String.valueOf(resultado));
        }

        if (e.getSource() == botonBasico)
        {
            if (panelIzquierda.isShowing())
            {
                container.remove(panelIzquierda);
            }
        }

        if(e.getSource() == botonCientifico)
        {
            if(!panelIzquierda.isShowing())
            {
                container.add(panelIzquierda);
            }
        }
    }
}
