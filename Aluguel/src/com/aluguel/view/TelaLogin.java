package com.aluguel.view;

import javax.swing.*;
import java.awt.*;
import java.util.regex.*;

public class TelaLogin {

    public static void main(String[] args) {

        JFrame frame = new JFrame("Login");
        frame.setSize(500, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());
        frame.getContentPane().setBackground(new Color(220,220,220));

        JLabel titulo = new JLabel(
            "<html><center><h2>LOGIN:</h2></center></html>",
            SwingConstants.CENTER
        );
        titulo.setPreferredSize(new Dimension(510, 180));

        JPanel formPanel = new JPanel();
        formPanel.setLayout(new BoxLayout(formPanel, BoxLayout.Y_AXIS));
        formPanel.setBackground(new Color(220,220,220));

        JLabel usuarioLabel = new JLabel("Usuário:");
        JTextField usuarioField = new JTextField();
        usuarioField.setHorizontalAlignment(SwingConstants.CENTER);
        usuarioField.setMaximumSize(new Dimension(230, 30));

        JLabel senhaLabel = new JLabel("Senha:");
        JPasswordField senhaField = new JPasswordField();
        senhaField.setHorizontalAlignment(SwingConstants.CENTER);
        senhaField.setMaximumSize(new Dimension(230, 30));

        formPanel.add(usuarioLabel);
        formPanel.add(usuarioField);
        formPanel.add(Box.createVerticalStrut(15));
        formPanel.add(senhaLabel);
        formPanel.add(senhaField);

        usuarioLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        usuarioField.setAlignmentX(Component.CENTER_ALIGNMENT);
        senhaLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        senhaField.setAlignmentX(Component.CENTER_ALIGNMENT);

        JButton loginButton = new JButton("Entrar");
        loginButton.setPreferredSize(new Dimension(230, 50));
        loginButton.addActionListener(e -> {
            String usuario = usuarioField.getText();
            String senha = new String(senhaField.getPassword());
            
            String senhaRegex = "^(?=.*[A-Za-z]).{8,}$";
            Pattern senhaPattern = Pattern.compile(senhaRegex);

            if (usuario.isEmpty() || senha.isEmpty()) {
                JOptionPane.showMessageDialog(frame, "Por favor, preencha todos os campos.", null, JOptionPane.ERROR_MESSAGE);
                return;
            }

            if (usuario.length() < 10) {
                JOptionPane.showMessageDialog(frame, 
                    "O nome de usuário deve ter pelo menos 10 caracteres.", 
                    null, 
                    JOptionPane.ERROR_MESSAGE);
                return;
            }

            if (!senhaPattern.matcher(senha).matches()) {
                JOptionPane.showMessageDialog(frame, 
                    "Senha inválida! A senha deve ter pelo menos 8 caracteres.", 
                    null, 
                    JOptionPane.ERROR_MESSAGE
                );
                return;
            }
            
            JOptionPane.showMessageDialog(frame, "Login realizado com sucesso!", null, JOptionPane.INFORMATION_MESSAGE);
            frame.dispose();
            TelaAgendamento.main(null);
            
        });
        
        JButton cadastroButton = new JButton("Cadastrar");
        cadastroButton.setPreferredSize(new Dimension(230, 50));
        cadastroButton.addActionListener(e -> {
                frame.dispose();
                TelaCadastro.main(null);
        });
        
        frame.add(titulo, BorderLayout.NORTH);
        frame.add(formPanel, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setBackground(new Color(220,220,220));
        buttonPanel.add(cadastroButton);
        buttonPanel.add(loginButton);
        frame.add(buttonPanel, BorderLayout.SOUTH);

        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

    }
}