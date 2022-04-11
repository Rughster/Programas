import java.util.*;

public class ManPersona {
  static ArrayList<Persona> ArrPersona = new ArrayList<Persona>();
  private Persona objPersona;
  
  public ManPersona()
  {}
  
  public void Agregar(String nom, String tel, String correo, String cump)
  {
    objPersona = new Persona(); //Iniciamos Persona
    objPersona.setNombre(nom);
    objPersona.setTelefono(tel);
    objPersona.setCorreoe(correo);
    objPersona.setCump(cump);
    
    ArrPersona.add(objPersona); //Agregando el objeto al arraylist
  }
  
  
  public Persona Buscar(int pos){
      Persona persona = new Persona();
      
      persona = ArrPersona.get(pos);
      
      return persona;
  }
  
  public void Modificar(Persona p, int pos){
      //Persona personaMod = new Persona();
      
      ArrPersona.remove(pos);
      ArrPersona.add(p);    
      //personaMod = ArrPersona.get(ArrPersona.size()-1);
      //ArrPersona.size()
      
      //return personaMod;
  }
  
  public void Eliminar(int pos){
      ArrPersona.remove(pos);
  }
  
  
  public void mostrar()
  {
    System.out.println("...PERSONAS EN LA AGENDA...");
    Iterator<Persona> itrPersona = ArrPersona.iterator();
    while(itrPersona.hasNext()){
     Persona persona = itrPersona.next();
     System.out.println(persona.getNombre() + "  " + persona.getTelefono());
    }
  }
  
  public ArrayList Datos()
  {
     return ArrPersona;
  }

}