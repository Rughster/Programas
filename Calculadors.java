import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
public class Calculadors extends JFrame{
   JLabel Letrero, Resultado; //VARIABLES TIPO OBJ
   JButton btnSuma, btnResta, btnMultiplica, btnDivide, btnIgual;
   JTextField txtCampo1, txtCampo2, txtResultado;
   JPanel panel;
   private Object objTextField;
    
   public Calculadors()
   {
      initComponents();
   }

   private void initComponents() 
   {
      setSize(600,160);
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      txtCampo1 = new JTextField(10);
      txtCampo2 = new JTextField(10);
      txtResultado = new JTextField(10);
      txtResultado.setEditable(false);//el usuario no puede cambiar el valor del texto
        
      Letrero = new JLabel("C A L C U L A D O R A");
      Resultado = new JLabel("El resultado es: ");
    
      btnSuma = new JButton("+");
      btnSuma.setMnemonic('+');
      btnResta = new JButton("-");
      btnResta.setMnemonic('-');
      btnMultiplica = new JButton("x");
      btnMultiplica.setMnemonic('*');
      btnDivide = new JButton("/");
      btnDivide.setMnemonic('/');
      btnIgual = new JButton("=");
    
      panel = new JPanel();
      panel.add(Letrero);
      panel.add(txtCampo1);
      txtCampo1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
      panel.add(txtCampo2);
      txtCampo2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
      panel.add(Resultado);
      panel.add(txtResultado);
      panel.add(btnSuma);
      panel.add(btnResta);
      panel.add(btnMultiplica);
      panel.add(btnDivide);
      panel.add(btnIgual);
        
      setTitle("Calculadora");
      setContentPane(panel);
      setVisible(true);
        
        
        
      btnSuma.addActionListener(
         new ActionListener()  //LISTENER SUMA
         {
            public void actionPerformed(ActionEvent evt)
            {
               btnSumaActionPerformed(evt);
            }
         });
      btnResta.addActionListener(
         new ActionListener()  //LISTENER SUMA
         {
            public void actionPerformed(ActionEvent evt)
            {
               btnRestaActionPerformed(evt);
            }
         });
      btnMultiplica.addActionListener(
         new ActionListener()  //LISTENER SUMA
         {
            public void actionPerformed(ActionEvent evt)
            {
               btnMultiplicaActionPerformed(evt);
            }
         });
      btnDivide.addActionListener(
         new ActionListener()  //LISTENER SUMA
         {
            public void actionPerformed(ActionEvent evt)
            {
               btnDivideActionPerformed(evt);
            }
         });
        
   }
    
    //------------------------------------------------------------------------
   private void btnSumaActionPerformed(ActionEvent evt)    //ACTIONEVENT SUMA
   {
      double num1 = 0.0, num2 = 0.0, res= 0.0;
      int recNum1=0, recNum2=0; //recabar numeros
        
        
      String c1 = txtCampo1.getText(), c2 = txtCampo2.getText();
      recNum1 = Integer.parseInt(c1.trim());
      recNum2 = Integer.parseInt(c2.trim());
      System.out.println(recNum1 + "---" + recNum2 + "\n" + c1 + " " + c2);
      res = recNum1 + recNum2; //Operación SUMA
      String textoRes = String.format("%.2f", res);
      txtResultado.setText(textoRes);
        
        
   }
    
   private void btnRestaActionPerformed(ActionEvent evt)    //ACTIONEVENT RESTA
   {
      double num1 = 0.0, num2 = 0.0, res= 0.0;
      int recNum1, recNum2; //recabar numeros
        
        
      String c1 = txtCampo1.getText(), c2 = txtCampo2.getText();
      recNum1 = Integer.parseInt(c1.trim());
      recNum2 = Integer.parseInt(c2.trim());
      res = recNum1 - recNum2; //Operación RESTA
      String textoRes = String.format("%.2f", res);
      txtResultado.setText(textoRes);
      
            
        
       
        
   }
    
   private void btnMultiplicaActionPerformed(ActionEvent evt)    //ACTIONEVENT MULTIPLICA
   {
      double num1 = 0.0, num2 = 0.0, res= 0.0;
      int recNum1, recNum2; //recabar numeros
        
   
      String c1 = txtCampo1.getText(), c2 = txtCampo2.getText();
      recNum1 = Integer.parseInt(c1.trim());
      recNum2 = Integer.parseInt(c2.trim());
      res = recNum1 * recNum2; //Operación MULTIPLICA
      String textoRes = String.format("%.2f", res);
      txtResultado.setText(textoRes);
      
            
        
        
        
   }
    
   private void btnDivideActionPerformed(ActionEvent evt)    //ACTIONEVENT DIVIDE
   {
      double num1 = 0.0, num2 = 0.0, res= 0.0;
      int recNum1, recNum2; //recabar numeros
      String cero = "0";  
      
   try{
      String c1 = txtCampo1.getText(), c2 = txtCampo2.getText();
      recNum1 = Integer.parseInt(c1.trim());
      recNum2 = Integer.parseInt(c2.trim());
      res = recNum1 / recNum2; //Operación DIVIDE
      String textoRes = String.format("%.2f", res);
      txtResultado.setText(textoRes);
   }
   catch(ArithmeticException e){
      txtResultado.setText(cero);
   }   
            
        
   }
    //----------------------------------------------------------
    
    
    
    
    
    
    
   private class MyListener extends MouseAdapter
   {
      public void mouseClicked(MouseEvent event)
      {
         System.exit(0);
      }
   }
   
   
}
