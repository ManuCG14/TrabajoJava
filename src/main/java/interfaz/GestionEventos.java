package interfaz;

import com.mycompany.javaevents.Direccion;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.*;
import java.util.List;
import java.util.ArrayList;
import com.mycompany.javaevents.Eventos;
import com.mycompany.javaevents.TipoEvento;

public class GestionEventos extends javax.swing.JFrame {
    private JTable tablaEventos;
    private DefaultTableModel modeloTabla;
    private List<Eventos> listaEventos = new ArrayList<>();


    public GestionEventos() {
        initComponents();
        JScrollPane scrollPane = new JScrollPane();
    tablaEventos = new JTable();
    modeloTabla = new DefaultTableModel(new Object[][] {}, new String[] {
        "Título", "Tipo", "Ciudad", "Precio"
    });
    tablaEventos.setModel(modeloTabla);
    scrollPane.setViewportView(tablaEventos);

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnAgregar = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btnAgregar.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        btnAgregar.setText("Agregar");
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });

        btnEditar.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        btnEditar.setText("Editar");
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });

        btnEliminar.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI Black", 3, 24)); // NOI18N
        jLabel1.setText("Gestión de Eventos");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 263, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 255, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(198, 198, 198))
            .addGroup(layout.createSequentialGroup()
                .addGap(150, 150, 150)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnEliminar)
                    .addComponent(btnEditar)
                    .addComponent(btnAgregar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(jLabel1)
                .addGap(68, 68, 68)
                .addComponent(btnAgregar)
                .addGap(49, 49, 49)
                .addComponent(btnEditar)
                .addGap(45, 45, 45)
                .addComponent(btnEliminar)
                .addContainerGap(110, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        String titulo = JOptionPane.showInputDialog(this, "Título del evento:");
        String tipo = JOptionPane.showInputDialog(this, "Tipo de evento:");
        String ciudad = JOptionPane.showInputDialog(this, "Ciudad:");
        String precioStr = JOptionPane.showInputDialog(this, "Precio:");

        if (titulo != null && tipo != null && ciudad != null && precioStr != null) {
            try {
                double precio = Double.parseDouble(precioStr);
                Eventos nuevo = new Eventos(titulo, Enum.valueOf(TipoEvento.class, tipo.toUpperCase()),
                    new Direccion("Calle Ejemplo", ciudad, "00000"), precio, "portada.png");
                listaEventos.add(nuevo);
                modeloTabla.addRow(new Object[] {titulo, tipo, ciudad, precio});
        }   catch (Exception e) {
                JOptionPane.showMessageDialog(this, "Datos inválidos: " + e.getMessage());
        }
    }

    }//GEN-LAST:event_btnAgregarActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        int fila = tablaEventos.getSelectedRow();
        if (fila >= 0) {
            Eventos evento = listaEventos.get(fila);

            String nuevoTitulo = JOptionPane.showInputDialog(this, "Nuevo título:", evento.getTitulo());
            String nuevaCiudad = JOptionPane.showInputDialog(this, "Nueva ciudad:", evento.getDireccion().getCiudad());
            String nuevoTipo = JOptionPane.showInputDialog(this, "Nuevo tipo:", evento.getTipo().toString());
            String nuevoPrecio = JOptionPane.showInputDialog(this, "Nuevo precio:", String.valueOf(evento.getPrecio()));

            try {
                evento = new Eventos(
                    nuevoTitulo,
                    TipoEvento.valueOf(nuevoTipo.toUpperCase()),
                    new Direccion(nuevaCiudad),
                    Double.parseDouble(nuevoPrecio),
                    evento.getPortada()
                );
                listaEventos.set(fila, evento);
                cargarTabla();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "Datos inválidos.");
            }
        } else {
            JOptionPane.showMessageDialog(this, "Seleccione un evento para editar.");
        }
    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        int fila = tablaEventos.getSelectedRow();
        if (fila >= 0) {
            int confirm = JOptionPane.showConfirmDialog(this, "¿Eliminar este evento?", "Confirmar", JOptionPane.YES_NO_OPTION);
            if (confirm == JOptionPane.YES_OPTION) {
                listaEventos.remove(fila);
                cargarTabla();
            }
        } else {
            JOptionPane.showMessageDialog(this, "Seleccione un evento para eliminar.");
        }
    }//GEN-LAST:event_btnEliminarActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables

    private void cargarTabla() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
