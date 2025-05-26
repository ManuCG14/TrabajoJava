/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package interfaz;

/**
 *
 * @author ismae
 */
import JavaEventsApp.JavaEventsApp;
import com.mycompany.javaevents.Eventos;
import javax.swing.table.DefaultTableModel;
import java.util.List;
import javax.swing.JOptionPane;

public class BuscarEventos extends javax.swing.JFrame {

    /**
     * Creates new form BuscarEventos
     */
    public BuscarEventos() {
        initComponents();
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        txtBuscar = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();
        txtMostrarTodos = new javax.swing.JButton();
        txtReservarEventos = new javax.swing.JButton();
        btnReseñas = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableBuscarEventos = new javax.swing.JTable();
        btnSalir = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        txtBuscar.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        txtBuscar.setText("Buscar");
        txtBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBuscarActionPerformed(evt);
            }
        });

        txtMostrarTodos.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        txtMostrarTodos.setText("Mostar Todos");
        txtMostrarTodos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMostrarTodosActionPerformed(evt);
            }
        });

        txtReservarEventos.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        txtReservarEventos.setText("Reservar Evento");
        txtReservarEventos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtReservarEventosActionPerformed(evt);
            }
        });

        btnReseñas.setText("Reseñas");
        btnReseñas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReseñasActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(79, 79, 79)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtBuscar)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtMostrarTodos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtReservarEventos, javax.swing.GroupLayout.DEFAULT_SIZE, 139, Short.MAX_VALUE)
                    .addComponent(btnReseñas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(33, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(101, 101, 101)
                .addComponent(txtBuscar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(txtMostrarTodos)
                .addGap(18, 18, 18)
                .addComponent(txtReservarEventos)
                .addGap(18, 18, 18)
                .addComponent(btnReseñas)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel1.setText("jLabel1");

        tableBuscarEventos.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        tableBuscarEventos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Titulo", "Tipo", "Direccion"
            }
        ));
        jScrollPane1.setViewportView(tableBuscarEventos);

        btnSalir.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        btnSalir.setText("Salir");
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(72, 72, 72)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 268, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(341, 341, 341)
                        .addComponent(btnSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(17, 17, 17))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(44, 44, 44)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 318, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                .addComponent(btnSalir)
                .addGap(27, 27, 27))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
        private void actualizarTabla(List<Eventos> lista) {
            
            DefaultTableModel modelo = (DefaultTableModel) tableBuscarEventos.getModel();
    modelo.setRowCount(0); // Limpia la tabla

        for (Eventos e : lista) {
            modelo.addRow(new Object[]{e.getTitulo(), e.getTipo(), e.getDireccion()});
    }

}

    private void txtMostrarTodosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMostrarTodosActionPerformed
        List<Eventos> eventos = JavaEventsApp.getEventos();
        actualizarTabla(eventos);
    }//GEN-LAST:event_txtMostrarTodosActionPerformed

    private void txtBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBuscarActionPerformed
        String texto = txtBuscar.getText().trim().toLowerCase();

    if (texto.isEmpty()) {
        JOptionPane.showMessageDialog(this, "Introduce un texto para buscar.");
        return;
    }

    List<Eventos> eventosFiltrados = JavaEventsApp.getEventos().stream()
            .filter(e -> e.getTitulo().toLowerCase().contains(texto))
            .toList();

    actualizarTabla(eventosFiltrados);

    }//GEN-LAST:event_txtBuscarActionPerformed

    private void txtReservarEventosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtReservarEventosActionPerformed
        int filaSeleccionada = tableBuscarEventos.getSelectedRow();

    if (filaSeleccionada == -1) {
        JOptionPane.showMessageDialog(this, "Selecciona un evento para reservar.");
        return;
    }

    String tituloEvento = (String) tableBuscarEventos.getValueAt(filaSeleccionada, 0);

    // Buscar el evento por título (puede haber mejor forma si usas IDs únicos)
    Eventos eventoSeleccionado = JavaEventsApp.getEventos().stream()
            .filter(e -> e.getTitulo().equals(tituloEvento))
            .findFirst()
            .orElse(null);

    if (eventoSeleccionado == null) {
        JOptionPane.showMessageDialog(this, "Evento no encontrado.");
        return;
    }

    // Lógica de reserva (puedes mejorarla después)
    JOptionPane.showMessageDialog(this, "¡Evento reservado: " + eventoSeleccionado.getTitulo() + "!");

    }//GEN-LAST:event_txtReservarEventosActionPerformed

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        VentanaClientes ventC = new VentanaClientes();
        ventC.setVisible(true);
        ventC.setLocationRelativeTo(null);
        this.dispose();
    }//GEN-LAST:event_btnSalirActionPerformed

    private void btnReseñasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReseñasActionPerformed
        Reseñas reseñas = new Reseñas();
        reseñas.setVisible(true);
        reseñas.setLocationRelativeTo(null);
        this.dispose();
    }//GEN-LAST:event_btnReseñasActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnReseñas;
    private javax.swing.JButton btnSalir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTable tableBuscarEventos;
    private javax.swing.JButton txtBuscar;
    private javax.swing.JButton txtMostrarTodos;
    private javax.swing.JButton txtReservarEventos;
    // End of variables declaration//GEN-END:variables
}
