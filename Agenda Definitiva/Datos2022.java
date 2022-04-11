import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
//CLASE JPANEL QUE SE MUESTRA DESPUES DE INICIAR SESI�N

public class Datos2022 extends JPanel implements ActionListener{        //Un JPanel es lo que est� dentro de un JFrame
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
   
      JLabel lblCorreo = new JLabel("Correo electr�nico: ", JLabel.RIGHT);
      txtCorreo = new JTextField(20);
      add(lblCorreo);
      add(txtCorreo);
      
      JLabel lblCump = new JLabel("Fecha de Cumplea�os: ", JLabel.RIGHT);
      txtCump = new JTextField(20);
      add(lblCump);
      add(txtCump);
      
      JLabel lblPos = new JLabel("N�m. de Posici�n: ", JLabel.RIGHT);
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
               JOptionPane.showMessageDialog(null, "Coloque un n�mero de tel�fono a agregar, por favor.",
                  "Aviso", JOptionPane.INFORMATION_MESSAGE);
               txtTel.requestFocus();
            }
            else if(txtCorreo.getText() == null || txtTel.getText().isEmpty()){
                JOptionPane.showMessageDialog(null, "Coloque el correo electr�nico de la persona a agregar, por favor.",
                  "Aviso", JOptionPane.INFORMATION_MESSAGE);
               txtCorreo.requestFocus();
            }
            else if(txtCump.getText() == null || txtCump.getText().isEmpty()){
                JOptionPane.showMessageDialog(null, "Coloque la fecha de cumplea�os de la persona a agregar, por favor.",
                  "Aviso", JOptionPane.INFORMATION_MESSAGE);
               txtCump.requestFocus();
            }
                
            else    
            {
               mpa.Agregar(txtNombre.getText(), txtTel.getText(),
                  txtCorreo.getText(), txtCump.getText());
               JOptionPane.showMessageDialog(null, "�Se guardaron los datos con �xito!",
                  "�Persona Agregada!", JOptionPane.INFORMATION_MESSAGE);
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
                JOptionPane.showMessageDialog(null, "Coloque el # de posici�n (en base a la lista  del bot�n Mostrar) de la persona a buscar, por favor.",
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
            Para el uso correcto de Modificar, primero hay que hacer uso del bot�n
            Buscar (teniendo en cuenta que buscamos el # de posici�n de la persona)
            para que carguen los datos en las casillas txt. Una vez est�n
            cargadas, escribiremos ahora en ellas la informaci�n que querramos
            cambiar. Ya escrito presionamos, ahora s�, "Modificar" y listo.
            
            Esto aplica pr�cticamente igual al momento de ELIMINAR.
            Al momento de querer Modificar o Eliminar, primero buscamos para
            nosotros ver sus datos. Y luego presionar uno de los dos botones
            dependiendo de lo que querr�mos hacer.
        */
        
        if(e.getSource()==btnModificar){//MODIFICAR------------------------------
            if(txtNombre.getText() == null || txtNombre.getText().isEmpty()){
                JOptionPane.showMessageDialog(null, "Debe haber buscado a alguien, por favor.",
                    "Aviso", JOptionPane.INFORMATION_MESSAGE);
                txtNombre.requestFocus();
            }else if(txtPos.getText() == null || txtPos.getText().isEmpty())
            {
                JOptionPane.showMessageDialog(null, "Coloque el # de posici�n (en base a la lista  del bot�n Mostrar) de la persona a modificar, por favor.",
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
                JOptionPane.showMessageDialog(null, "�Se modific� la informaci�n de la persona con �xito!"
                    + "\nNota: La posici�n de esta persona ya no es la misma.\nSe actualiz� a la �ltima de la cola hasta el momento.",
                    "�Modificaci�n Exitosa!", JOptionPane.INFORMATION_MESSAGE);
                
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
                JOptionPane.showMessageDialog(null, "Coloque el # de posici�n (en base a la lista del bot�n Mostrar) de la persona a eliminar, por favor.",
                    "Aviso", JOptionPane.INFORMATION_MESSAGE);
                txtPos.requestFocus();
            }
            
            
            else{
                int pos = Integer.parseInt(txtPos.getText());
                mpa.Eliminar(pos);
                JOptionPane.showMessageDialog(null, "La persona que estaba asociada a la posici�n ingresada ha sido eliminada con �xito!",
                    "�Eliminaci�n Exitosa!", JOptionPane.INFORMATION_MESSAGE);
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