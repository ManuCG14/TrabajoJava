/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package interfaz;


public class VentanaClientes extends javax.swing.JFrame {


    public VentanaClientes() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        btnBuscarEvento = new javax.swing.JButton();
        btnConsultarReservas = new javax.swing.JButton();
        btnModificarDatos = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();
        btnReseñas = new javax.swing.JButton();
        btnVerReseña = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI Black", 0, 24)); // NOI18N
        jLabel1.setText("Cliente");

        btnBuscarEvento.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        btnBuscarEvento.setText("Buscar Eventos");
        btnBuscarEvento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarEventoActionPerformed(evt);
            }
        });

        btnConsultarReservas.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        btnConsultarReservas.setText("Consultar Reservas");
        btnConsultarReservas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConsultarReservasActionPerformed(evt);
            }
        });

        btnModificarDatos.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        btnModificarDatos.setText("Modificar Datos Personales");
        btnModificarDatos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarDatosActionPerformed(evt);
            }
        });

        btnSalir.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        btnSalir.setText("Salir");
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });

        btnReseñas.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        btnReseñas.setText("Hacer Reseña");
        btnReseñas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReseñasActionPerformed(evt);
            }
        });

        btnVerReseña.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        btnVerReseña.setText("Hacer Reseña");
        btnVerReseña.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVerReseñaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(375, 375, 375))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(btnSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(71, 71, 71)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnBuscarEvento)
                            .addComponent(btnReseñas))
                        .addGap(211, 211, 211)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnConsultarReservas)
                            .addComponent(btnVerReseña)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(214, 214, 214)
                        .addComponent(btnModificarDatos)))
                .addContainerGap(139, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(37, 37, 37)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnBuscarEvento)
                    .addComponent(btnConsultarReservas))
                .addGap(72, 72, 72)
                .addComponent(btnModificarDatos)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 78, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnReseñas)
                    .addComponent(btnVerReseña))
                .addGap(72, 72, 72)
                .addComponent(btnSalir)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnBuscarEventoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarEventoActionPerformed
        BuscarEventos buscar = new BuscarEventos();
        buscar.setVisible(true);
        buscar.setLocationRelativeTo(null);
        this.dispose();
    }//GEN-LAST:event_btnBuscarEventoActionPerformed

    private void btnConsultarReservasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConsultarReservasActionPerformed
        ConsultaReservasClientes consultaReservasClientes = new ConsultaReservasClientes();
        consultaReservasClientes.setVisible(true);
        consultaReservasClientes.setLocationRelativeTo(null);
        this.dispose();
    }//GEN-LAST:event_btnConsultarReservasActionPerformed

    private void btnModificarDatosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarDatosActionPerformed
        ModificarDatosPersonales datospersonales = new ModificarDatosPersonales();
        datospersonales.setVisible(true);
        datospersonales.setLocationRelativeTo(null);
        this.dispose();
    }//GEN-LAST:event_btnModificarDatosActionPerformed

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        Principal princ = new Principal();
        princ.setVisible(true);
        princ.setLocationRelativeTo(null);
        this.dispose();
    }//GEN-LAST:event_btnSalirActionPerformed

    private void btnReseñasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReseñasActionPerformed
        Reseñas reseña = new Reseñas();
        reseña.setVisible(true);
        reseña.setLocationRelativeTo(null);
        this.dispose();
    }//GEN-LAST:event_btnReseñasActionPerformed

    private void btnVerReseñaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVerReseñaActionPerformed
        VerReseñas reseñas = new VerReseñas();
        reseñas.setVisible(true);
        reseñas.setLocationRelativeTo(null);
        this.dispose();
    }//GEN-LAST:event_btnVerReseñaActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscarEvento;
    private javax.swing.JButton btnConsultarReservas;
    private javax.swing.JButton btnModificarDatos;
    private javax.swing.JButton btnReseñas;
    private javax.swing.JButton btnSalir;
    private javax.swing.JButton btnVerReseña;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
