package com.endorodrigo.Sistema.Zona.Fit.gui;

import com.endorodrigo.Sistema.Zona.Fit.service.CustomerService;
import com.endorodrigo.Sistema.Zona.Fit.service.CustomerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

@Component
public class ZonaFitForma extends JFrame {
    private JPanel panelPrincipal;
    private JTable tblClients;
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JButton enviarButton;
    private DefaultTableModel tablaModeloClientes;
    private CustomerServiceImpl customerService;

    @Autowired
    public ZonaFitForma(CustomerServiceImpl customerService) {
        this.customerService = customerService;
        initializeForm();
    }

    private void initializeForm() {
        setContentPane(panelPrincipal);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(900, 700);
        setLocationRelativeTo(null); // Centra la ventana

    }

    private void createUIComponents() {
        this.tablaModeloClientes = new DefaultTableModel(0, 4);
        String[] cabeceros = {"Id", "Nombre", "Apellido", "Membresia"};
        this.tablaModeloClientes.setColumnIdentifiers(cabeceros);
        this.tblClients = new JTable(tablaModeloClientes);
        // Cargar listado de clientes
        loadCustomers();
    }

    private void loadCustomers() {
        tablaModeloClientes.setRowCount(0);
        var clientes = customerService.getCustomers();
        clientes.forEach(cliente -> {
            Object[] row = {
                    cliente.getId(),
                    cliente.getName(),
                    cliente.getLastName(),
                    cliente.getMenber()
            };
            tablaModeloClientes.addRow(row);
        });
    }

    // Aquí puedes agregar funcionalidad al botón enviar
    private void initButtonAction() {
        enviarButton.addActionListener(e -> {
            // Lógica del botón (ej. enviar datos o actualizar la lista)
        });
    }
}
