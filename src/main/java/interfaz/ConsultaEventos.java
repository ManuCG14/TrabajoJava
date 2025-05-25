package interfaz;

import com.mycompany.javaevents.Eventos;
import com.mycompany.javaevents.MetodosAdministrador;
import java.util.List;
import javax.swing.table.DefaultTableModel;


public class ConsultaEventos extends javax.swing.JFrame {
    private final List<Eventos> listaEventos;
    private List<Eventos> eventos;

    public ConsultaEventos() {
        this.listaEventos = MetodosAdministrador.listarEventos();  // <--- cargar los eventos
        initComponents();
        cargarEventosEnTabla(listaEventos);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        btnMostrarTodos = new javax.swing.JButton();
        btnBuscar = new javax.swing.JButton();
        txtCiudad = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaEventos = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("jLabel1");

        btnMostrarTodos.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        btnMostrarTodos.setText("Mostrar Todos");
        btnMostrarTodos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMostrarTodosActionPerformed(evt);
            }
        });

        btnBuscar.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        tablaEventos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Titulo", "Tipo", "Dirección"
            }
        ));
        jScrollPane1.setViewportView(tablaEventos);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(156, 156, 156)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnBuscar)
                            .addComponent(txtCiudad, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(94, 94, 94))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnMostrarTodos)
                        .addGap(73, 73, 73)))
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 266, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(137, 137, 137)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(150, 150, 150)
                        .addComponent(btnBuscar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtCiudad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(59, 59, 59)
                        .addComponent(btnMostrarTodos))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(91, 91, 91)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 322, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(30, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        String ciudad = txtCiudad.getText().trim();
        if (!ciudad.isEmpty()) {
            List<Eventos> filtrados = MetodosAdministrador.buscarEventosPorCiudad(listaEventos, ciudad);
            cargarEventosEnTabla(filtrados);
        }
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void btnMostrarTodosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMostrarTodosActionPerformed
        cargarEventosEnTabla(listaEventos);    }//GEN-LAST:event_btnMostrarTodosActionPerformed

    private void cargarEventosEnTabla(List<Eventos> eventos) {
        DefaultTableModel model = (DefaultTableModel) tablaEventos.getModel();
        model.setRowCount(0);
        for (Eventos e : eventos) {
            model.addRow(new Object[]{
                e.getTitulo(),
                e.getTipo(),
                e.getDireccion().getCiudad()
            });
        }
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnMostrarTodos;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tablaEventos;
    private javax.swing.JTextField txtCiudad;
    // End of variables declaration//GEN-END:variables
}
