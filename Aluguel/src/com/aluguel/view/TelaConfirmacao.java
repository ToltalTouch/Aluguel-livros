package com.aluguel.view;

import javax.swing.*;
import java.awt.*;

public class TelaConfirmacao {

    public static void main(String[] args) {

        JFrame frame = new JFrame("Confirmação Aluguel");
        frame.setSize(500, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());
        frame.getContentPane().setBackground(new Color(220,220,220));

        JLabel titulo = new JLabel(
                "<html><center><h2>Aluguel bem sucedido!</h2></center></html>",
                SwingConstants.CENTER
        );
        titulo.setPreferredSize(new Dimension(500, 70));

        JLabel mensagem = new JLabel(
                "<html><center><p>PARABENS, VOCE CONSEGUIU ALUGAR O LIVRO</p></center></html>",
                SwingConstants.CENTER);
        mensagem.setPreferredSize(new Dimension(500, 70));

        
        JLabel eventos = new JLabel(
                "<html><center><p>RETIRE O LIVRO NA BIBLIOTECA ESCOLHIDA</p>"
              ,
                SwingConstants.CENTER
        );
        mensagem.setPreferredSize(new Dimension(500, 70));

        
        JButton saidaButton = new JButton("Sair");
        saidaButton.setPreferredSize(new Dimension(160, 50));
        saidaButton.addActionListener(e -> {
            frame.dispose();
        });

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBackground(new Color(220,220,220));

        panel.add(Box.createVerticalStrut(15));
        panel.add(titulo);
        panel.add(mensagem);
        panel.add(Box.createVerticalStrut(40));
        panel.add(Box.createVerticalStrut(20));
        panel.add(eventos);
        panel.add(Box.createVerticalStrut(90));
        panel.add(Box.createVerticalStrut(20));
        
        titulo.setAlignmentX(Component.CENTER_ALIGNMENT);
        mensagem.setAlignmentX(Component.CENTER_ALIGNMENT);
        eventos.setAlignmentX(Component.CENTER_ALIGNMENT);
        saidaButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.setAlignmentX(Component.CENTER_ALIGNMENT);

        frame.add(panel, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setBackground(new Color(220,220,220));
        buttonPanel.add(saidaButton);
        frame.add(buttonPanel, BorderLayout.SOUTH);
        
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}