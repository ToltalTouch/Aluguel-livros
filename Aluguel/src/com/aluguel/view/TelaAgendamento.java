package com.aluguel.view;

import javax.swing.*;
import java.awt.*;
import java.util.regex.*;

public class TelaAgendamento {

    public static void main(String[] args) {

        JFrame frame = new JFrame("Agendamento");
        frame.setSize(500, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());
        frame.getContentPane().setBackground(new Color(220,220,220));

        JLabel titulo = new JLabel(
            "<html><center><h2>Realize a sua Locação de Livros:</h2></center></html>",
            SwingConstants.CENTER
        );
        titulo.setPreferredSize(new Dimension(510, 180));

        JPanel formPanel = new JPanel();
        formPanel.setLayout(new BoxLayout(formPanel, BoxLayout.Y_AXIS));
        formPanel.setBackground(new Color(220,220,220));

        JLabel dataLabel = new JLabel("Data: (Ex.: 10/10/2010)");
        JTextField dataField = new JTextField();
        dataField.setHorizontalAlignment(SwingConstants.CENTER);
        dataField.setMaximumSize(new Dimension(230, 50));

        JLabel horarioLabel = new JLabel("Horário: (Ex.: 10:10)");
        JTextField horarioField = new JTextField();
        horarioField.setHorizontalAlignment(SwingConstants.CENTER);
        horarioField.setMaximumSize(new Dimension(230, 50));

        JLabel visitantesLabel = new JLabel("Biblioteca para Retirada: ");
        JTextField visitantesField = new JTextField();
        visitantesField.setHorizontalAlignment(SwingConstants.CENTER);
        visitantesField.setMaximumSize(new Dimension(230, 50));

        formPanel.add(dataLabel);
        formPanel.add(dataField);
        formPanel.add(Box.createVerticalStrut(15));
        formPanel.add(horarioLabel);
        formPanel.add(horarioField);
        formPanel.add(Box.createVerticalStrut(15));
        formPanel.add(visitantesLabel);
        formPanel.add(visitantesField);

        dataLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        dataField.setAlignmentX(Component.CENTER_ALIGNMENT);
        horarioLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        horarioField.setAlignmentX(Component.CENTER_ALIGNMENT);
        visitantesLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        visitantesField.setAlignmentX(Component.CENTER_ALIGNMENT);

        JButton avisoButton = new JButton("Aviso");
        avisoButton.setPreferredSize(new Dimension(160, 50));
        avisoButton.setBackground(Color.RED);
        avisoButton.setForeground(Color.WHITE);
        avisoButton.addActionListener(e -> {
            JOptionPane.showMessageDialog(frame,
                    "Dados incorretos podem comprometer seu agendamento.",
                    "Aviso",
                    JOptionPane.WARNING_MESSAGE);
        });

        JButton realizarButton = new JButton("Locação");
        realizarButton.setPreferredSize(new Dimension(1160, 50));
        realizarButton.addActionListener(e -> {
            String data = dataField.getText();
            String horario = horarioField.getText();
            String visitantes = visitantesField.getText();

            String dataRegex = "^([0-2][0-9]|3[0-1])/(0[1-9]|1[0-2])/\\d{4}$";
            Pattern dataPattern = Pattern.compile(dataRegex);

            String horarioRegex = "^([0-1][0-9]|2[0-3]):([0-5][0-9])$";
            Pattern horarioPattern = Pattern.compile(horarioRegex);

            if (data.isEmpty() || horario.isEmpty() || visitantes.isEmpty()) {
                JOptionPane.showMessageDialog(frame, "Preencha todos os campos corretamente.", null, JOptionPane.ERROR_MESSAGE);
                return;
            }
            
            if (!dataPattern.matcher(data).matches()) {
                JOptionPane.showMessageDialog(frame, "Data incorreto! Use o formato DD/MM/AAAA.", null, JOptionPane.ERROR_MESSAGE);
                return;
            }

            if (!horarioPattern.matcher(horario).matches()) {
                JOptionPane.showMessageDialog(frame, "Horário incorreto! Use o formato HH:mm.", null, JOptionPane.ERROR_MESSAGE);
                return;
            }


            
            JOptionPane.showMessageDialog(frame, "Agendamento realizado!", null, JOptionPane.INFORMATION_MESSAGE);
            frame.dispose();
            TelaConfirmacao.main(null);
            
        });

        JButton voltarButton = new JButton("Re-faça o Login");
        voltarButton.setPreferredSize(new Dimension(160, 50));
        voltarButton.addActionListener(e -> {
            frame.dispose();
            TelaLogin.main(null);
        });

        frame.add(titulo, BorderLayout.NORTH);
        frame.add(formPanel, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setBackground(new Color(220,220,220));
        buttonPanel.add(avisoButton);
        buttonPanel.add(realizarButton);
        buttonPanel.add(voltarButton);
        frame.add(buttonPanel, BorderLayout.SOUTH);

        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}