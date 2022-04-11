import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
//CLASE JPANEL QUE SE MUESTRA DESPUES DE INICIAR SESIÓN

public class Datos2022 extends JPanel implements ActionListener{        //Un JPanel es lo que está dentro de un JFrame
   private JButton btnGuardar, btnMostrar, btnOpciones,
           btnModificar, btnBuscar, btnEliminar;
   private JTextField txtNombre, txtTel, txtCorreo, txtCump, txtPos;
   //private JRadioButton tec, trabajo;
  
   ManPersona mpa = new ManPersona();     //?????????????????????????????????
  
   Datos2022()
   {
      setLayout(new GridLayout(10,3));
      JLabel lblNombre = new JLabel("Nombre: ", JLabel.RIGHT);
      txtNombre = new JTextField(30);
      add(lblNombre);
      add(txtNombre);
    
      JLabel lblTel = new JLabel("Numero de Celular: ", JLabel.RIGHT);
      txtTel = new JTextField(15);
      add(lblTel);
      add(txtTel);
   
      JLabel lblCorreo = new JLabel("Correo electrónico: ", JLabel.RIGHT);
      txtCorreo = new JTextField(20);
      add(lblCorreo);
      add(txtCorreo);
      
      JLabel lblCump = new JLabel("Fecha de Cumpleaños: ", JLabel.RIGHT);
      txtCump = new JTextField(20);
      add(lblCump);
      add(txtCump);
      
      JLabel lblPos = new JLabel("Núm. de Posición: ", JLabel.RIGHT);
      txtPos = new JTextField(5);
      add(lblPos);
      add(txtPos);
      
      //- - - - - - - - - - - - - - - - - - - - - - - - -
      
      btnGuardar = new JButton("Guardar/Dar de Alta");
      btnGuardar.addActionListener(this);
      btnBuscar = new JButton("Buscar");
      btnBuscar.addActionListener(this);
      btnEliminar = new JButton("Eliminar");
      btnEliminar.addActionListener(this);
      btnModificar = new JButton("Modificar");
      btnModificar.addActionListener(this);
      btnMostrar = new JButton("Mostrar");
      btnMostrar.addActionListener(this);
      
      add(btnGuardar);
      add(btnBuscar);
      add(btnEliminar);
      add(btnModificar);
      add(btnMostrar);
   }
  
   public void actionPerformed(ActionEvent e)
   {
      //String tipo = "Tecnologico";
      //if(trabajo.isSelected())
         //tipo = "Trabajo";
      if(e.getSource() == btnGuardar){
         if(txtNombre.getText() == null || txtNombre.getText().isEmpty())
         {
            JOptionPane.showMessageDialog(null, "Coloque el nombre de la persona a agregar, por favor.",
               "Aviso", JOptionPane.INFORMATION_MESSAGE);
            txtNombre.requestFocus();
         }
         else
            if(txtTel.getText() == null || txtTel.getText().isEmpty())
            {
               JOptionPane.showMessageDialog(null, "Coloque un número de teléfono a agregar, por favor.",
                  "Aviso", JOptionPane.INFORMATION_MESSAGE);
               txtTel.requestFocus();
            }
            else if(txtCorreo.getText() == null || txtTel.getText().isEmpty()){
                JOptionPane.showMessageDialog(null, "Coloque el correo electrónico de la persona a agregar, por favor.",
                  "Aviso", JOptionPane.INFORMATION_MESSAGE);
               txtCorreo.requestFocus();
            }
            else if(txtCump.getText() == null || txtCump.getText().isEmpty()){
                JOptionPane.showMessageDialog(null, "Coloque la fecha de cumpleaños de la persona a agregar, por favor.",
                  "Aviso", JOptionPane.INFORMATION_MESSAGE);
               txtCump.requestFocus();
            }
                
            else    
            {
               mpa.Agregar(txtNombre.getText(), txtTel.getText(),
                  txtCorreo.getText(), txtCump.getText());
               JOptionPane.showMessageDialog(null, "¡Se guardaron los datos con éxito!",
                  "¡Persona Agregada!", JOptionPane.INFORMATION_MESSAGE);
               txtNombre.setText(null);
               txtTel.setText(null);
               txtCorreo.setText(null);
               txtCump.setText(null);
               txtNombre.requestFocus();          
            }
      }
    
        if(e.getSource()==btnBuscar){//BUSQUEDA----------------------------------
          if(txtPos.getText() == null || txtPos.getText().isEmpty())
            {
                JOptionPane.showMessageDialog(null, "Coloque el # de posición (en base a la lista  del botón Mostrar) de la persona a buscar, por favor.",
                    "Aviso", JOptionPane.INFORMATION_MESSAGE);
                txtPos.requestFocus();
            }
          
          else{
              Persona p = new Persona();
              int pos = Integer.parseInt(txtPos.getText());
              p = mpa.Buscar(pos);
              txtNombre.setText(p.getNombre());
              txtTel.setText(p.getTelefono());
              txtCorreo.setText(p.getCorreoe());
              txtCump.setText(p.getCump());
              
              
          }
            
        }
        /*
        NOTA SOBRE MODIFICAR, y similar, ELIMINAR:
            Para el uso correcto de Modificar, primero hay que hacer uso del botón
            Buscar (teniendo en cuenta que buscamos el # de posición de la persona)
            para que carguen los datos en las casillas txt. Una vez estén
            cargadas, escribiremos ahora en ellas la información que querramos
            cambiar. Ya escrito presionamos, ahora sí, "Modificar" y listo.
            
            Esto aplica prácticamente igual al momento de ELIMINAR.
            Al momento de querer Modificar o Eliminar, primero buscamos para
            nosotros ver sus datos. Y luego presionar uno de los dos botones
            dependiendo de lo que querrámos hacer.
        */
        
        if(e.getSource()==btnModificar){//MODIFICAR------------------------------
            if(txtNombre.getText() == null || txtNombre.getText().isEmpty()){
                JOptionPane.showMessageDialog(null, "Debe haber buscado a alguien, por favor.",
                    "Aviso", JOptionPane.INFORMATION_MESSAGE);
                txtNombre.requestFocus();
            }else if(txtPos.getText() == null || txtPos.getText().isEmpty())
            {
                JOptionPane.showMessageDialog(null, "Coloque el # de posición (en base a la lista  del botón Mostrar) de la persona a modificar, por favor.",
                    "Aviso", JOptionPane.INFORMATION_MESSAGE);
                txtPos.requestFocus();
            }
          else if(txtTel.getText() == null || txtTel.getText().isEmpty())
            {
                JOptionPane.showMessageDialog(null, "Debe haber buscado a alguien, por favor.",
                    "Aviso", JOptionPane.INFORMATION_MESSAGE);
                txtTel.requestFocus();
            }else if(txtCorreo.getText() == null || txtCorreo.getText().isEmpty())
            {
                JOptionPane.showMessageDialog(null, "Debe haber buscado a alguien, por favor.",
                    "Aviso", JOptionPane.INFORMATION_MESSAGE);
                txtCorreo.requestFocus();
            }else if(txtCump.getText() == null || txtCump.getText().isEmpty())
            {
                JOptionPane.showMessageDialog(null, "Debe haber buscado a alguien, por favor. ",
                    "Aviso", JOptionPane.INFORMATION_MESSAGE);
                txtCump.requestFocus();
            }
            
            else{
                Persona p = new Persona();
                int pos = Integer.parseInt(txtPos.getText());
                p.setNombre(txtNombre.getText());
                p.setTelefono(txtTel.getText());
                p.setCorreoe(txtCorreo.getText());
                p.setCump(txtCump.getText());
                
                mpa.Modificar(p, pos);
                JOptionPane.showMessageDialog(null, "¡Se modificó la información de la persona con éxito!"
                    + "\nNota: La posición de esta persona ya no es la misma.\nSe actualizó a la última de la cola hasta el momento.",
                    "¡Modificación Exitosa!", JOptionPane.INFORMATION_MESSAGE);
                
                txtNombre.setText(null);
                txtTel.setText(null);
                txtCorreo.setText(null);
                txtCump.setText(null);
                txtPos.setText(null);
                txtPos.requestFocus();
                
            }
        }
      
        if(e.getSource()==btnEliminar){//ELIMINAR--------------------------------
            if(txtPos.getText() == null || txtPos.getText().isEmpty()){
                JOptionPane.showMessageDialog(null, "Coloque el # de posición (en base a la lista del botón Mostrar) de la persona a eliminar, por favor.",
                    "Aviso", JOptionPane.INFORMATION_MESSAGE);
                txtPos.requestFocus();
            }
            
            
            else{
                int pos = Integer.parseInt(txtPos.getText());
                mpa.Eliminar(pos);
                JOptionPane.showMessageDialog(null, "La persona que estaba asociada a la posición ingresada ha sido eliminada con éxito!",
                    "¡Eliminación Exitosa!", JOptionPane.INFORMATION_MESSAGE);
                txtNombre.setText(null);
                txtTel.setText(null);
                txtCorreo.setText(null);
                txtCump.setText(null);
                txtPos.setText(null);
                txtNombre.requestFocus();
            }  
        }
      
      if(e.getSource()==btnMostrar){
         JFrameTablaDatos jft = new JFrameTablaDatos();
      //mpa.mostrar();
      //System.exit(0);
      }    
   }
}