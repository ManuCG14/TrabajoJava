package interfaz;

import com.mycompany.javaevents.MetodosAdministrador;
import com.mycompany.javaevents.Reserva;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.*;
import java.util.stream.Collectors;

public class ConsultaReservas extends javax.swing.JFrame {
    private final List<Reserva> listaReservas;
    private List<Reserva> reservas;
    private final DateTimeFormatter dtfFechaHora = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
    private final DateTimeFormatter dtfFecha = DateTimeFormatter.ofPattern("dd/MM/yyyy");


    public ConsultaReservas() {
        this.listaReservas = MetodosAdministrador.mostrarReservas();
        initComponents();
        mostrarTodasReservas();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaReservas = new javax.swing.JTable();
        btnFiltrar = new javax.swing.JButton();
        btnMostrarTodas = new javax.swing.JButton();
        txtFecha = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tablaReservas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Cliente", "Evento", "Fecha Reserva", "Fecha Evento", "Cantidad", "Total(euros)"
            }
        ));
        jScrollPane1.setViewportView(tablaReservas);

        btnFiltrar.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        btnFiltrar.setText("Filtrar");
        btnFiltrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFiltrarActionPerformed(evt);
            }
        });

        btnMostrarTodas.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        btnMostrarTodas.setText("Mostrar Todas");
        btnMostrarTodas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMostrarTodasActionPerformed(evt);
            }
        });

        txtFecha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFechaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnFiltrar)
                    .addComponent(btnMostrarTodas))
                .addGap(34, 34, 34)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 477, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(146, 146, 146)
                        .addComponent(btnFiltrar)
                        .addGap(18, 18, 18)
                        .addComponent(txtFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(51, 51, 51)
                        .addComponent(btnMostrarTodas))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(98, 98, 98)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 344, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(46, Short.MAX_VALUE))
        );

        jLabel1.setIcon(new javax.swing.ImageIcon("C:\\Users\\ismae\\OneDrive\\Documentos\\Universidad\\Java\\imagenTrabajo .png")); // NOI18N
        jLabel1.setText("jLabel1");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnFiltrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFiltrarActionPerformed
        String fechaTexto = txtFecha.getText().trim();
        try {
            // Parsear solo la fecha sin hora
            LocalDate fechaFiltro = LocalDate.parse(fechaTexto, dtfFecha);

            List<Reserva> filtradas = listaReservas.stream()
                    // Compara fechaEvento (LocalDateTime) con la fechaFiltro (LocalDate)
                    .filter(r -> !r.getFechaEvento().toLocalDate().isBefore(fechaFiltro))
                    .sorted(Comparator.comparing(Reserva::getFechaReserva).reversed())
                    .collect(Collectors.toList());

            cargarReservasEnTabla(filtradas);

        } catch (DateTimeParseException e) {
            JOptionPane.showMessageDialog(this,
                    "Formato de fecha inválido. Usa dd/MM/yyyy.",
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnFiltrarActionPerformed

    private void txtFechaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFechaActionPerformed
        
    }//GEN-LAST:event_txtFechaActionPerformed

    private void btnMostrarTodasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMostrarTodasActionPerformed
        mostrarTodasReservas();
    }//GEN-LAST:event_btnMostrarTodasActionPerformed
    
    private void mostrarTodasReservas() {
        List<Reserva> ordenadas = new ArrayList<>(listaReservas);
        ordenadas.sort(Comparator.comparing(Reserva::getFechaReserva).reversed());
        cargarReservasEnTabla(ordenadas);
    }
    
    private void cargarReservasEnTabla(List<Reserva> reservas) {
        DefaultTableModel model = (DefaultTableModel) tablaReservas.getModel();
        model.setRowCount(0);

        for (Reserva r : reservas) {
            model.addRow(new Object[]{
                    r.getCliente().getNombre(),            // Nombre Cliente
                    r.getEvento().getTitulo(),             // Título Evento
                    r.getFechaReserva().format(dtfFechaHora), // Fecha Reserva con hora
                    r.getFechaEvento().format(dtfFechaHora),  // Fecha Evento con hora
                    r.getCantidadEntradas(),                // Cantidad entradas
                    String.format("%.2f", r.getTotal())    // Total en euros con 2 decimales
            });
        }
    }
    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnFiltrar;
    private javax.swing.JButton btnMostrarTodas;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tablaReservas;
    private javax.swing.JTextField txtFecha;
    // End of variables declaration//GEN-END:variables
}
