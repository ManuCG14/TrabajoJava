package interfaz;


import JavaEventsApp.JavaEventsApp;
import com.mycompany.javaevents.Eventos;
import com.mycompany.javaevents.Clientes;
import com.mycompany.javaevents.MetodosClientes;
import com.mycompany.javaevents.Reserva;
import java.time.LocalDateTime;
import javax.swing.table.DefaultTableModel;
import java.util.List;
import javax.swing.JOptionPane;

public class BuscarEventos extends javax.swing.JFrame {
    private Clientes clienteActual;  // Cliente que está usando la app
    private LocalDateTime fechaEvento;

    public BuscarEventos(Clientes cliente) {
        this.clienteActual = cliente;
        initComponents();
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        btnBuscar = new javax.swing.JButton();
        txtBuscarEvento = new javax.swing.JTextField();
        btnMostrarTodos = new javax.swing.JButton();
        btnReservarEventos = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableBuscarEventos = new javax.swing.JTable();
        btnSalir = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btnBuscar.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        btnBuscar.setText("Buscar por titulo");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        btnMostrarTodos.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        btnMostrarTodos.setText("Mostar Todos");
        btnMostrarTodos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMostrarTodosActionPerformed(evt);
            }
        });

        btnReservarEventos.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        btnReservarEventos.setText("Reservar Evento");
        btnReservarEventos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReservarEventosActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(79, 79, 79)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnBuscar)
                    .addComponent(txtBuscarEvento, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnMostrarTodos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnReservarEventos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(31, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(153, 153, 153)
                .addComponent(btnBuscar)
                .addGap(18, 18, 18)
                .addComponent(txtBuscarEvento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnMostrarTodos)
                .addGap(18, 18, 18)
                .addComponent(btnReservarEventos)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

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
                .addGap(60, 60, 60)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 318, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                .addComponent(btnSalir)
                .addGap(27, 27, 27))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    // Método para actualizar la tabla
    private void actualizarTabla(List<Eventos> lista) {
        DefaultTableModel modelo = (DefaultTableModel) tableBuscarEventos.getModel();
        modelo.setRowCount(0); // Limpiar tabla

        for (Eventos e : lista) {
            modelo.addRow(new Object[]{e.getTitulo(), e.getTipo(), e.getDireccion().getCiudad()});
        }
    }

    private void btnMostrarTodosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMostrarTodosActionPerformed
        List<Eventos> eventos = JavaEventsApp.getEventos();
        actualizarTabla(eventos);
    }//GEN-LAST:event_btnMostrarTodosActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        String texto = txtBuscarEvento.getText().trim().toLowerCase();

        if (texto.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Introduce un texto para buscar.");
            return;
        }

        // Buscar en título (puedes usar buscarPorCiudad si quieres)
        List<Eventos> eventosFiltrados = JavaEventsApp.getEventos().stream()
            .filter(e -> e.getTitulo().toLowerCase().contains(texto))
            .toList();

        actualizarTabla(eventosFiltrados);
    }//GEN-LAST:event_btnBuscarActionPerformed
    
    
    private void btnReservarEventosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReservarEventosActionPerformed
        int filaSeleccionada = tableBuscarEventos.getSelectedRow();

    if (filaSeleccionada == -1) {
        JOptionPane.showMessageDialog(this, "Selecciona un evento para reservar.");
        return;
    }

    String tituloEvento = (String) tableBuscarEventos.getValueAt(filaSeleccionada, 0);

    Eventos eventoSeleccionado = JavaEventsApp.getEventos().stream()
        .filter(e -> e.getTitulo().equals(tituloEvento))
        .findFirst()
        .orElse(null);

    if (eventoSeleccionado == null) {
        JOptionPane.showMessageDialog(this, "Evento no encontrado.");
        return;
    }

    // Preguntar al usuario cuántas entradas desea
    String input = JOptionPane.showInputDialog(this, "¿Cuántas entradas deseas reservar?");
    if (input == null || input.isEmpty()) return;

    int cantidadEntradas;
    try {
        cantidadEntradas = Integer.parseInt(input);
        if (cantidadEntradas <= 0) throw new NumberFormatException();
    } catch (NumberFormatException e) {
        JOptionPane.showMessageDialog(this, "Por favor, introduce una cantidad válida.");
        return;
    }

    // Crear la reserva con los datos correctos
    Reserva reserva = new Reserva(clienteActual, eventoSeleccionado, fechaEvento, cantidadEntradas);
    MetodosClientes.añadirReserva(reserva);
    
    JOptionPane.showMessageDialog(this, "¡Evento reservado correctamente!");

    }//GEN-LAST:event_btnReservarEventosActionPerformed

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        VentanaClientes ventC = new VentanaClientes(clienteActual);
        ventC.setVisible(true);
        ventC.setLocationRelativeTo(null);
        this.dispose();
    }//GEN-LAST:event_btnSalirActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnMostrarTodos;
    private javax.swing.JButton btnReservarEventos;
    private javax.swing.JButton btnSalir;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tableBuscarEventos;
    private javax.swing.JTextField txtBuscarEvento;
    // End of variables declaration//GEN-END:variables
}
