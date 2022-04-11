import javax.swing.*;
import java.awt.*;
import java.util.*;
public class TablaDatos extends JPanel{
  JTable tabla;
  JScrollPane scroll = new JScrollPane();
  JButton salir;
  ManPersona mp = new ManPersona();
  ArrayList<Persona> datosPer = new ArrayList<Persona>();
  
  public TablaDatos()
  {
     datosPer = mp.Datos();
     String titulos [] = {"Nombre", "Teléfono", "Correo", "Fecha de Cumpleaños", "Posición (#)"};
     String info [][] = obtenerDatos();
     setLayout (new GridLayout(2,1));
     salir = new JButton("Salir");
     tabla = new JTable(info, titulos);
     tabla.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
     scroll.setViewportView(tabla);
     add(scroll);
     add(salir);
  }
  
  private String[][] obtenerDatos()
  {
    int x=0, y=0;
    String informacion[][] = new String[datosPer.size()][5];
    Iterator<Persona> itrPersona = datosPer.iterator();
    while(itrPersona.hasNext()){
        
            Persona persona = itrPersona.next();
            informacion[x][0] = persona.getNombre();
            informacion[x][1] = persona.getTelefono();
            informacion[x][2] = persona.getCorreoe();
            informacion[x][3] = persona.getCump();
            informacion[x][4] = x+"";
            System.out.println(informacion[x]);
            x++;
     }
   return informacion;
  }

}
