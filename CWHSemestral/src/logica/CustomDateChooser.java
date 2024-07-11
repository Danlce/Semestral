package logica;

import java.awt.event.KeyEvent;
import java.util.Date;
import com.toedter.calendar.JDateChooser;
import com.toedter.calendar.JTextFieldDateEditor;

public class CustomDateChooser extends JDateChooser {
    private static final long serialVersionUID = 1L;

    public CustomDateChooser() {
        super();
        JTextFieldDateEditor editor = (JTextFieldDateEditor) this.getDateEditor();
        editor.setEditable(false); // Bloquea la edición manual
    }

    @Override
    protected void processKeyEvent(KeyEvent e) {
        // Bloquea la edición manual con teclado
        // No hace nada al recibir eventos de teclado
    }

    @Override
    public void setDate(Date date) {
        // Validación para asegurarse de que la fecha no sea anterior a la fecha actual
        if (date != null && date.before(new Date())) {
            date = new Date(); // Establece la fecha actual si se ingresa una fecha anterior
        }
        super.setDate(date);
    }
}