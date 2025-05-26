package interfaz;

import com.mycompany.javaevents.Datos;
import com.mycompany.javaevents.Direccion;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import com.mycompany.javaevents.Eventos;
import com.mycompany.javaevents.TipoEvento;

public class GestionEventos extends javax.swing.JFrame {
    private DefaultTableModel modeloTabla;


    public GestionEventos() {
        initComponents();
        configurarTabla();
        cargarTabla();
}
    private void configurarTabla() {
        modeloTabla = new DefaultTableModel(new Object[][] {}, new String[] {
            "Título", "Tipo", "Ciudad", "Precio"
        });
        tablaEvento.setModel(modeloTabla);
}

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnAgregar = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        btnSalir = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaEvento = new javax.swing.JTable();

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

        btnSalir.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        btnSalir.setText("Salir");
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });

        tablaEvento.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Título", "Tipo", "Ciudad", "Precio"
            }
        ));
        jScrollPane1.setViewportView(tablaEvento);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 263, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 255, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(198, 198, 198))
            .addGroup(layout.createSequentialGroup()
                .addGap(65, 65, 65)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnEliminar)
                    .addComponent(btnEditar)
                    .addComponent(btnAgregar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 417, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(jLabel1)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(61, 61, 61)
                        .addComponent(btnAgregar)
                        .addGap(52, 52, 52)
                        .addComponent(btnEditar)
                        .addGap(46, 46, 46)
                        .addComponent(btnEliminar)
                        .addGap(41, 41, 41)
                        .addComponent(btnSalir)
                        .addContainerGap(131, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addContainerGap())))
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
                Eventos nuevo = new Eventos(
                    titulo,
                    Enum.valueOf(TipoEvento.class, tipo.toUpperCase()),
                    new Direccion("Calle Ejemplo", "1", ciudad, "00000"),  // Aquí corregido
                    precio,
                    "portada.png"
            );
            Datos.eventos.add(nuevo);
            cargarTabla();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Datos inválidos: " + e.getMessage());
        }
    }
    }//GEN-LAST:event_btnAgregarActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        int fila = tablaEvento.getSelectedRow();
    if (fila >= 0) {
        Eventos evento = Datos.eventos.get(fila);

        String nuevoTitulo = JOptionPane.showInputDialog(this, "Nuevo título:", evento.getTitulo());
        String nuevaCiudad = JOptionPane.showInputDialog(this, "Nueva ciudad:", evento.getDireccion().getCiudad());
        String nuevoTipo = JOptionPane.showInputDialog(this, "Nuevo tipo:", evento.getTipo().toString());
        String nuevoPrecio = JOptionPane.showInputDialog(this, "Nuevo precio:", String.valueOf(evento.getPrecio()));

        try {
            Eventos nuevoEvento = new Eventos(
                    nuevoTitulo,
                    TipoEvento.valueOf(nuevoTipo.toUpperCase()),
                    new Direccion("Calle Ejemplo", "1", nuevaCiudad, "00000"),  // Aquí corregido también
                    Double.parseDouble(nuevoPrecio),
                    evento.getPortada()
            );
            Datos.eventos.set(fila, nuevoEvento);
            cargarTabla();
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Datos inválidos.");
        }
    } else {
        JOptionPane.showMessageDialog(this, "Seleccione un evento para editar.");
    }
    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        int fila = tablaEvento.getSelectedRow();
        if (fila >= 0) {
            int confirm = JOptionPane.showConfirmDialog(this, "¿Eliminar este evento?", "Confirmar", JOptionPane.YES_NO_OPTION);
            if (confirm == JOptionPane.YES_OPTION) {
                Datos.eventos.remove(fila);
                cargarTabla();
            }
        } else {
            JOptionPane.showMessageDialog(this, "Seleccione un evento para eliminar.");
        }
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        VentanaAdministrador ventA = new VentanaAdministrador();
        ventA.setVisible(true);
        ventA.setLocationRelativeTo(null);
        this.dispose();
    }//GEN-LAST:event_btnSalirActionPerformed
    
    private void cargarTabla() {
        modeloTabla.setRowCount(0);
        for (Eventos evento : Datos.eventos) {
            modeloTabla.addRow(new Object[]{
                evento.getTitulo(),
                evento.getTipo().toString(),
                evento.getDireccion().getCiudad(),
                evento.getPrecio()
            });
        }
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnSalir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tablaEvento;
    // End of variables declaration//GEN-END:variables

 
}
