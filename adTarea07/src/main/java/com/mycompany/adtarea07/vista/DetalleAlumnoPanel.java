package com.mycompany.adtarea07.vista;

import com.mycompany.adtarea07.controller.MatriculasController;
import com.mycompany.adtarea07.model.GestorMatriculas;
import java.sql.Connection;
import java.sql.SQLException;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

/**
 *
 * @author Heo
 */
public class DetalleAlumnoPanel extends javax.swing.JPanel {

    // private final Connection conexion;
    private MatriculasController controller; // Quita el "= null" para permitir la inicialización
    private GestorMatriculas matricula;
    private boolean editable;
    private VistaMatriculasFrame vistaMatriculasFrame;

//    public DetalleAlumnoPanel() {
//        initComponents();
//    }

    public DetalleAlumnoPanel(VistaMatriculasFrame vistaMatriculasFrame, MatriculasController controller) {
        this.vistaMatriculasFrame = vistaMatriculasFrame;
        this.controller = controller;
        initComponents();
        addDocumentListenerToFields();
    }

    public GestorMatriculas getMatricula() {
        return matricula;
    }

    public void setMatricula(GestorMatriculas matricula) {
        this.matricula = matricula;
    }

    public boolean isEditable() {
        return editable;
    }

    public void setEditable(boolean editable) {
        this.editable = editable;
        dniTF.setEditable(editable);
        moduloTF.setEditable(editable);
        cursoTF.setEditable(editable);
        notaTF.setEditable(editable);

    }

    // metodo para guardar los datos
    public void loadData() {
        if (matricula != null) {

            dniTF.setText(matricula.getDni());
            moduloTF.setText(matricula.getNombreModulo());
            cursoTF.setText(matricula.getCurso());
            notaTF.setText(String.valueOf(matricula.getNota()));
        } else {
            dniTF.setText("");
            moduloTF.setText("");
            cursoTF.setText("");
            notaTF.setText("");
        }

    }

    public void saveData() throws SQLException {

        // Obtener los datos ingresados por el usuario
        // String nuevoDni = dniTF.getText();
        // String nuevoModulo = moduloTF.getText();
        // String nuevoCurso = cursoTF.getText();
        // double nuevaNota = Double.parseDouble(notaTF.getText());
        String nuevoDni = dniTF.getText();
        if (nuevoDni.length() > 10) {
            nuevoDni = nuevoDni.substring(0, 10); // Truncar si excede el máximo
            JOptionPane.showMessageDialog(null, "El nombre del DNI ha sido truncado a 9 caracteres.");
        }

        String nuevoModulo = moduloTF.getText();
        if (nuevoModulo.length() > 60) {
            nuevoModulo = nuevoModulo.substring(0, 60); // Truncar si excede el máximo
            JOptionPane.showMessageDialog(null, "El nombre del modulo ha sido truncado a 60 caracteres.");
        }

        String nuevoCurso = cursoTF.getText();
        if (nuevoCurso.length() > 10) {
            nuevoCurso = nuevoCurso.substring(0, 10); // Truncar si excede el máximo
            JOptionPane.showMessageDialog(null, "El nombre del curso ha sido truncado a 10 caracteres.");
        }
        double nuevaNota;
        try {
            nuevaNota = Double.parseDouble(notaTF.getText());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "La nota debe ser un número válido.", "Error de Formato",
                    JOptionPane.ERROR_MESSAGE);
            return; // Detener la ejecución si la nota no es válida
        }

        // Crear una instancia de GestorMatriculas con los nuevos datos
        GestorMatriculas nuevaMatricula = new GestorMatriculas();
        nuevaMatricula.setDni(nuevoDni);
        nuevaMatricula.setNombreModulo(nuevoModulo);
        nuevaMatricula.setCurso(nuevoCurso);
        nuevaMatricula.setNota(nuevaNota);

        System.out.println("Preparando para guardar la matrícula...");
        if (!controller.existeMatricula(nuevaMatricula)) {
            System.out.println("No existe una matrícula similar, procediendo...");
            // if (nuevaMatricula == null) {
            System.out.println("Agregando nueva matrícula...");
            controller.agregarMatricula(nuevaMatricula);
            matricula = nuevaMatricula;
            if (matricula != null) {
                System.out.println("Actualizando matrícula existente...");
                controller.updateMatricula(nuevaMatricula);
            }

        } else {
            System.out.println("Error: Matrícula duplicada detectada.");
            JOptionPane.showMessageDialog(this, "Una matrícula con el mismo DNI, módulo y curso ya existe.",
                    "Error de Duplicidad", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void addDocumentListenerToFields() {
        DocumentListener documentListener = new DocumentListener() {
            public void insertUpdate(DocumentEvent e) {
                activarBotonesGuardarCancelar();
            }

            public void removeUpdate(DocumentEvent e) {
                activarBotonesGuardarCancelar();
            }

            public void changedUpdate(DocumentEvent e) {
                activarBotonesGuardarCancelar();
            }
        };

        dniTF.getDocument().addDocumentListener(documentListener);
        moduloTF.getDocument().addDocumentListener(documentListener);
        cursoTF.getDocument().addDocumentListener(documentListener);
        notaTF.getDocument().addDocumentListener(documentListener);
    }

    private void activarBotonesGuardarCancelar() {
        if (vistaMatriculasFrame != null) {
            JButton guardarButton = vistaMatriculasFrame.getGuardarButton();
            JButton cancelarButton = vistaMatriculasFrame.getCancelarButton();

            if (guardarButton != null && cancelarButton != null) {
                // boolean hayDatos = !dniTF.getText().isEmpty() ||
                // !moduloTF.getText().isEmpty() || !cursoTF.getText().isEmpty() ||
                // !notaTF.getText().isEmpty();
                boolean hayDatos = isDataFilled();
                guardarButton.setEnabled(hayDatos);
                cancelarButton.setEnabled(hayDatos);
            }
        } else {
            System.out.println("vistaMatriculasFrame es null");
        }

    }

    public boolean isDataFilled() {
        return !dniTF.getText().isEmpty() && !moduloTF.getText().isEmpty() && !cursoTF.getText().isEmpty()
                && !notaTF.getText().isEmpty();
    }

    // Método para limpiar todos los campos de texto
    public void limpiarCampos() {
        dniTF.setText("");
        moduloTF.setText("");
        cursoTF.setText("");
        notaTF.setText("");
    }

    // Puedes también añadir métodos para obtener o establecer los valores de los
    // campos si es necesario
    public String getDni() {
        return dniTF.getText();
    }

    public void setDni(String dni) {
        dniTF.setText(dni);
    }

    public String getModulo() {
        return moduloTF.getText();
    }

    public void setModulo(String modulo) {
        moduloTF.setText(modulo);
    }

    public String getCurso() {
        return cursoTF.getText();
    }

    public void setCurso(String curso) {
        cursoTF.setText(curso);
    }

    public String getNota() {
        return notaTF.getText();
    }

    public void setNota(String nota) {
        notaTF.setText(nota);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated
    // Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        dniLabel = new javax.swing.JLabel();
        moduloLabel = new javax.swing.JLabel();
        cursoLabel = new javax.swing.JLabel();
        notaLabel = new javax.swing.JLabel();
        dniTF = new javax.swing.JTextField();
        moduloTF = new javax.swing.JTextField();
        cursoTF = new javax.swing.JTextField();
        notaTF = new javax.swing.JTextField();

        dniLabel.setText("DNI:");

        moduloLabel.setText("Modulo:");

        cursoLabel.setText("Curso:");

        notaLabel.setText("Nota:");

        /**
         * dniTF.addActionListener(new java.awt.event.ActionListener() {
         * public void actionPerformed(java.awt.event.ActionEvent evt) {
         * dniTFActionPerformed(evt);
         * }
         * });
         */

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(notaLabel)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED,
                                                        javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(notaTF, javax.swing.GroupLayout.PREFERRED_SIZE, 130,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(cursoLabel)
                                                .addGap(24, 24, 24)
                                                .addComponent(cursoTF, javax.swing.GroupLayout.PREFERRED_SIZE, 130,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(moduloLabel)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(moduloTF, javax.swing.GroupLayout.PREFERRED_SIZE, 130,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(dniLabel)
                                                .addGap(34, 34, 34)
                                                .addComponent(dniTF, javax.swing.GroupLayout.PREFERRED_SIZE, 130,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap(15, Short.MAX_VALUE)));
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(23, 23, 23)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(dniLabel)
                                        .addComponent(dniTF, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(21, 21, 21)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(moduloLabel)
                                        .addComponent(moduloTF, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(cursoLabel)
                                        .addComponent(cursoTF, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(notaLabel)
                                        .addComponent(notaTF, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(18, Short.MAX_VALUE)));
    }// </editor-fold>//GEN-END:initComponents

    private void dniTF2ActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel cursoLabel;
    private javax.swing.JTextField cursoTF;
    private javax.swing.JLabel dniLabel;
    private javax.swing.JTextField dniTF;
    private javax.swing.JLabel moduloLabel;
    private javax.swing.JTextField moduloTF;
    private javax.swing.JLabel notaLabel;
    private javax.swing.JTextField notaTF;
    // End of variables declaration//GEN-END:variables

    void setHorizontalGroup(GroupLayout.ParallelGroup addGap) {

    }

}
