package busquedasordenadasydesordenadas;

import javax.swing.JOptionPane;

import ToolsPanel.Tools;

public class BusquedaLinealDesordenada {
	private Integer datos[];
    private byte p;
    public BusquedaLinealDesordenada(byte tam)
    {
        datos = new Integer[tam];
        p=-1;
    }

    public boolean validaVacio()
    {
        return(p==-1);
    }

    public void almacenarDatos()
    {
        if(p< datos.length)
        {
            datos[p+1] = Tools.leerInt("Escribe un numero");
            p++;
        }
        else
            Tools.imprimeErrorMsje("Arreglo Lleno.");
    }

    public String imprimeDatos()
    {
        String cad="";

        for (int i = 0; i<=p; i++)
        {
            cad+= "[" + datos[i] + "]" + "\n";
        }
        return "\n" + cad;
    }

    public byte busquedaSecuencialLineal(Object val)
    {
        byte i=0;
        while(i<=p && !val.equals(datos[i]))
            i++;
        return(i<=p)? i:-1;
    }
    public static void menu3(String menu){  
		String sel="";
		BusquedaLinealDesordenada obj = new BusquedaLinealDesordenada((byte)10);
		byte pos=0;
		do {
				sel=boton(menu);
				switch(sel){
				case "AgregarDesordenado":
					obj.almacenarDatos();
					break;
				case "Busqueda Secuencial Lineal Desordenado":
					if(obj.validaVacio()) {
						Tools.imprimeErrorMsje("Array vacio");
					}
					else {
					pos = obj.busquedaSecuencialLineal(Tools.leerInt("Inserta un numero a buscar"));
					if(pos>=0) {
						Tools.imprime("Se encuentra en la posicion: " +pos);
					}else {
						Tools.imprimeErrorMsje("Dato no encontrado");
					}
				}
					break;
				case "Imprimir":
					if(obj.validaVacio()) Tools.imprimeErrorMsje("Array vacio");
					else Tools.imprime("Datos del arreglo\n"+obj.imprimeDatos());
					
					break;
				case "Salir": 
					break;
				}//switch
		}while(!sel.equalsIgnoreCase("Salir"));
		
	}
	public static String boton(String menu) {
		String valores[]=menu.split(",");
		int n;
		n = JOptionPane.showOptionDialog(null,"SELECCIONA  DANDO CLICK ", " M E N U", JOptionPane.NO_OPTION, JOptionPane.QUESTION_MESSAGE,null,valores,valores[0]);
		return ( valores[n]);
	}
public static void main(String[] args) {
		
		menu3("AgregarDesordenado,Busqueda Secuencial Lineal Desordenado,Imprimir,Salir");

	}


}
