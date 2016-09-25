import java.util.*;
import java.io.*;


public class Arreglos {

  public static char[] barra;
  
  public Arreglos()
  {
    barra = new char[] {'#','#','#','#','#','#','#','#','#','#'};
  }

  public static char cont(int posicion) {
    return(barra[posicion]);
  }

  /* Devuelve la nueva posicion del asterisco */
  public static int ImprimeBarra(Arreglos a, int posicion, int numero)
  {
    int nuevaPos = posicion;
    
    a.barra[posicion] = '#';  /* "Borra" el astericos */
    if (numero != 0)
    {
      nuevaPos = posicion+numero;
      try {
        a.barra[nuevaPos] = '*';
      }
      catch (ArrayIndexOutOfBoundsException exception) {
        System.out.print("\007");
        if (nuevaPos > 9)
          nuevaPos = 9;
        else if (nuevaPos < 0)
          nuevaPos = 0;
        /* Coloca el asterisco al limite */
        a.barra[nuevaPos] = '*';
      }
    }
    for (int i=0; i<10; i++)
      System.out.printf("%c", a.barra[i]);
    System.out.print("\n");
    return(nuevaPos);
  }


  public static void main(String[] args)
  {
    Scanner scan = new Scanner(System.in);
    BufferedReader pausa;
    int numero = -1;
    int pos = 0;
    int i = 0;
    boolean ciclo = true;
    Arreglos a = new Arreglos();

    ImprimeBarra(a, pos, numero);
    do
    {
      System.out.println("Introduce un numero positivo o negativo. 0 para terminar <-- (-)    (+) -->");
      System.out.print("numero: ");
      do
      {
        try {
          numero = scan.nextInt();
          if (numero!=0)
            pos = ImprimeBarra(a, pos, numero);
          ciclo = false;
        }
        catch (InputMismatchException e) {
          System.out.println("ERROR: valor invalido, intenta de nuevo...");
          scan.next(); /* Descarta el token generado por la excepcion */
        }
      }
      while (ciclo);

    }
    while (numero != 0);

    System.out.println("\n\nPresiona < Enter > para continuar...");
    try {
        System.in.read();
    } catch (IOException e) {
        e.printStackTrace();
    }
  }
}
