package com.mycompany.adtarea07.vista;

import com.mycompany.adtarea07.controller.MatriculasController;
import com.mycompany.adtarea07.model.GestorMatriculas;
import com.mycompany.adtarea07.util.ConnectionBD;
import com.mycompany.adtarea07.componente.ComponenteMatriculas;
import com.mycompany.adtarea07.dao.GestorMatriculasDAO;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.ldap.ManageReferralControl;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;

public class VistaMatriculasFrame extends javax.swing.JFrame {

    private JButton guardarButton;
    private JButton cancelarButton;

    // JTable tabla = new JTable();
    private final MatriculasController controller;
    private MatriculasTableModel model;
    private GestorMatriculasDAO gestorMatriculas;
    private GestorMatriculas matricula;
    private Object com;

    public VistaMatriculasFrame(MatriculasController controller) throws SQLException {
        // Crear instancia de DetalleAlumnoPanel y asignarlo al panel detalle
        this.controller = controller;
        DetalleAlumnoPanel detalleAlumnoPanel = new DetalleAlumnoPanel(this, this.controller);
        setDetalleAlumnoPanel(detalleAlumnoPanel);
        initComponents();

        // Asignación de ActionListeners después de inicializar los componentes
        guardar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    guardarActionPerformed(e);
                } catch (SQLException ex) {
                    Logger.getLogger(VistaMatriculasFrame.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });

        cancelar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cancelarActionPerformed(e);
            }
        });

        Vector<GestorMatriculas> matriculas = controller.listarMatriculas();
        this.model = new MatriculasTableModel(matriculas, tabla);
        this.tabla.setModel(model);
        guardarButton = guardar; // Asegúrate de que `guardar` es el botón correcto
        cancelarButton = cancelar; // Asegúrate de que `cancelar` es el botón correcto

        // cargarMatriculas();
        // this.tabla.setModel(model);
        this.tabla.getSelectionModel().addListSelectionListener(e -> {
            boolean seleccionValida = tabla.getSelectedRow() != -1;
            editar.setEnabled(seleccionValida);
            borrar.setEnabled(seleccionValida);

            // Obtener la matrícula seleccionada y mostrar los datos en el
            // DetalleAlumnoPanel
            if (seleccionValida) {
                GestorMatriculas matriculaSeleccionada = getMatriculaSeleccionada();
                detalleAlumnoPanel1.setMatricula(matriculaSeleccionada); // Establecer la matrícula en el
                                                                         // DetalleAlumnoPanel
                detalleAlumnoPanel1.loadData(); // Cargar los datos en el DetalleAlumnoPanel
            }
        });

    }

    public void setDetalleAlumnoPanel(DetalleAlumnoPanel detalleAlumnoPanel) {
        this.detalleAlumnoPanel1 = detalleAlumnoPanel;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated
    // Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        ToolBar = new javax.swing.JToolBar();
        agregar = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JToolBar.Separator();
        editar = new javax.swing.JButton();
        borrar = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JToolBar.Separator();
        guardar = new javax.swing.JButton();
        cancelar = new javax.swing.JButton();
        jSeparator3 = new javax.swing.JToolBar.Separator();
        listaMatAlumnLabel = new javax.swing.JLabel();
        cbMatAlumnos = new javax.swing.JComboBox<>();
        jToolBar1 = new javax.swing.JToolBar();
        jPanel3 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla = new javax.swing.JTable();
        detalleAlumnoPanel1 = new com.mycompany.adtarea07.vista.DetalleAlumnoPanel(this, this.controller);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        ToolBar.setRollover(true);

        agregar.setText("Agregar Matrícula");
        agregar.setFocusable(false);
        agregar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        agregar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        ToolBar.add(agregar);
        ToolBar.add(jSeparator1);

        editar.setText("Editar");
        editar.setFocusable(false);
        editar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        editar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        ToolBar.add(editar);

        borrar.setText("Borrar");
        borrar.setFocusable(false);
        borrar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        borrar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        ToolBar.add(borrar);
        ToolBar.add(jSeparator2);

        guardar.setText("Guardar");
        guardar.setFocusable(false);
        guardar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        guardar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        ToolBar.add(guardar);

        cancelar.setText("Cancelar");
        cancelar.setFocusable(false);
        cancelar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        cancelar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        ToolBar.add(cancelar);
        ToolBar.add(jSeparator3);

        listaMatAlumnLabel.setText("Lista matriculas - alumnos");
        ToolBar.add(listaMatAlumnLabel);

        cbMatAlumnos.setModel(
                new javax.swing.DefaultComboBoxModel<>(new String[] { "Todas Matriculas", "Juan", "Pedro", "Maria" }));
        ToolBar.add(cbMatAlumnos);

        getContentPane().add(ToolBar, java.awt.BorderLayout.PAGE_START);

        jToolBar1.setRollover(true);
        getContentPane().add(jToolBar1, java.awt.BorderLayout.PAGE_END);

        jPanel3.setLayout(new java.awt.BorderLayout());

        jPanel2.setLayout(new java.awt.BorderLayout());

        tabla.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][] {
                        { null, null, null, null },
                        { null, null, null, null },
                        { null, null, null, null },
                        { null, null, null, null }
                },
                new String[] {
                        "DNI", "Modulo", "Curso", "Nota"
                }));
        jScrollPane1.setViewportView(tabla);

        jPanel2.add(jScrollPane1, java.awt.BorderLayout.CENTER);
        jPanel2.add(detalleAlumnoPanel1, java.awt.BorderLayout.LINE_END);

        jPanel3.add(jPanel2, java.awt.BorderLayout.CENTER);

        getContentPane().add(jPanel3, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private GestorMatriculas getMatriculaSeleccionada() {

        int filaSeleccionada = tabla.getSelectedRow();
        if (filaSeleccionada != -1) {
            String dni = (String) tabla.getValueAt(filaSeleccionada, 0);
            String modulo = (String) tabla.getValueAt(filaSeleccionada, 1);
            String curso = (String) tabla.getValueAt(filaSeleccionada, 2);
            double nota = (double) tabla.getValueAt(filaSeleccionada, 3);

            GestorMatriculas matricula = new GestorMatriculas();
            matricula.setDni(dni);
            matricula.setNombreModulo(modulo);
            matricula.setCurso(curso);
            matricula.setNota(nota);

            return matricula;
        }
        return null; // Devolver null si no se encuentra la matrícula
    }

    private void agregarMatriculaActionPerformed(java.awt.event.ActionEvent evt) {
        // Aquí podrías abrir un formulario para agregar una nueva matrícula
        limpiarCampos(); // Prepara los campos para una nueva entrada
        gestorMatriculas = null;
    }

    private void editarMatriculaSeleccionadaActionPerformed() throws SQLException {
        // Obtener la matrícula seleccionada en la tabla
        GestorMatriculas matriculaSeleccionada = getMatriculaSeleccionada();

        if (matriculaSeleccionada != null) {
            // Aquí podrías abrir un formulario de edición donde el usuario pueda modificar
            // los datos
            // Después de que el usuario modifique los datos, actualizas la matrícula con
            // los nuevos valores
            // Supongamos que el usuario modificó los datos y los nuevos valores están en
            // las variables: nuevoModulo, nuevoCurso, nuevaNota
            String nuevoModulo = "";
            String nuevoCurso = "";
            double nuevaNota = 0.0;
            // Actualizar los datos de la matrícula seleccionada
            matriculaSeleccionada.setNombreModulo(nuevoModulo);
            matriculaSeleccionada.setCurso(nuevoCurso);
            matriculaSeleccionada.setNota(nuevaNota);

            try {
                // Actualizar la matrícula en la base de datos a través del controlador
                controller.updateMatricula(matriculaSeleccionada);

                // Recargar las matrículas en la tabla para reflejar los cambios
                cargarMatriculas();
            } catch (SQLException e) {
                e.printStackTrace();
                // Manejar el error adecuadamente
            }
        } else {
            // Si no hay matrícula seleccionada, muestra un mensaje o realiza alguna acción
            // adecuada
        }
    }

    public void cargarMatriculas() {
        try {
            Vector<GestorMatriculas> matriculas = controller.listarMatriculas();
            this.model.setMatriculas(matriculas);
        } catch (SQLException e) {
            e.printStackTrace();
            // Manejar el error adecuadamente
        }
    }

    private void guardarActionPerformed(java.awt.event.ActionEvent evt) throws SQLException {
//        System.out.println("El boton funciona");
//        JOptionPane.showMessageDialog(this, "el boton funciona.", "Cancelar",
//                JOptionPane.INFORMATION_MESSAGE);

        try {
            if (detalleAlumnoPanel1.isDataFilled()) {
                detalleAlumnoPanel1.saveData();
                // Actualizar la tabla después de guardar los datos
                cargarMatriculas(); // Refrescar la lista de matrículas
                JOptionPane.showMessageDialog(this, "Datos guardados correctamente.", "Guardar",
                        JOptionPane.INFORMATION_MESSAGE);

            } else {
                // Mostrar un mensaje indicando que se deben completar todos los campos
                JOptionPane.showMessageDialog(this, "Por favor, complete todos los campos antes de guardar.",
                        "Campos incompletos", JOptionPane.WARNING_MESSAGE);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error al guardar: " + e.getMessage(), "Error de Guardado",
                    JOptionPane.ERROR_MESSAGE);
        }

    }

    private void limpiarCampos() {
        detalleAlumnoPanel1.limpiarCampos();
    }

    private void cancelarActionPerformed(java.awt.event.ActionEvent evt) {
        // Simplemente recargar las matrículas en la tabla para restaurar los valores
        // originales
        // cargarMatriculas();
        limpiarCampos();
        JOptionPane.showMessageDialog(this, "Cambios cancelados.", "Cancelar", JOptionPane.INFORMATION_MESSAGE);
    }

    private void borrarActionPerformed(java.awt.event.ActionEvent evt) {
        if (matricula != null) {
            try {
                controller.eliminarMatricula(matricula.getDni());
                cargarMatriculas(); // Actualiza la lista de matrículas mostradas
                limpiarCampos();
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(this, "Error al eliminar la matrícula: " + e.getMessage(),
                        "Error de Base de Datos", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(this, "No hay matrícula seleccionada para borrar.",
                    "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(() -> {
            try {
                Connection conexion = ConnectionBD.conectar(); // Establecer conexión a la base de datos
                MatriculasController controller = new MatriculasController(conexion);
                // Crear una instancia de DetalleAlumnoPanel

                // controller.addMatricula();
                // DetalleAlumnoPanel detalleAlumnoPanel = new DetalleAlumnoPanel(this);
                VistaMatriculasFrame frame = new VistaMatriculasFrame(controller);
                frame.setVisible(true);

                // Cargar las matrículas después de crear la instancia de VistaMatriculasFrame
                // frame.cargarMatriculas();
                new VistaMatriculasFrame(controller).setVisible(true);
            } catch (SQLException e) {
                e.printStackTrace();
                // Manejar el error adecuadamente
                // borrar.setDisabledIcon(disabledIcon);
                // cancelar.setDisabledIcon(disabledIcon);
                // editar.setDisabledIcon(disabledIcon);
                // guardar.setDisabledSelectedIcon(disabledSelectedIcon);
            }
        });
    }

    // Método para devolver el botón guardar
    public JButton getGuardarButton() {
        return guardarButton;
    }

    // Método para devolver el botón cancelar
    public JButton getCancelarButton() {
        return cancelarButton;
    }

    // Método para actualizar la interfaz de manera segura en el EDT
    public void actualizarInterfazSeguro() {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                // Asegúrate que los botones se actualizan correctamente
                JButton guardarButton = getGuardarButton();
                JButton cancelarButton = getCancelarButton();

                // Por ejemplo, activar ambos botones
                guardarButton.setEnabled(false);
                cancelarButton.setEnabled(false);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToolBar ToolBar;
    private javax.swing.JButton agregar;
    private javax.swing.JButton borrar;
    private javax.swing.JButton cancelar;
    private javax.swing.JComboBox<String> cbMatAlumnos;
    private com.mycompany.adtarea07.vista.DetalleAlumnoPanel detalleAlumnoPanel1;
    private javax.swing.JButton editar;
    private javax.swing.JButton guardar;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JToolBar.Separator jSeparator1;
    private javax.swing.JToolBar.Separator jSeparator2;
    private javax.swing.JToolBar.Separator jSeparator3;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JLabel listaMatAlumnLabel;
    private javax.swing.JTable tabla;
    // End of variables declaration//GEN-END:variables
}
