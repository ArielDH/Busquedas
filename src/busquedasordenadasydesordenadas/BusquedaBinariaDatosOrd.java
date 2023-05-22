package busquedasordenadasydesordenadas;

import javax.swing.JOptionPane;

import ToolsPanel.Tools;

public class BusquedaBinariaDatosOrd {
	private int datos[],i,n,x,l,u,mid;;//define un arreglo
	private byte p;//es un subindice,
	
	//constructor que recibe el tamaño para dimensionar (reservar)
	public BusquedaBinariaDatosOrd(byte tam) {
		
		 datos= new int[tam];
		 p=-1;//subindice -1 para validar si esta vacio el array
		
	}
	public boolean validaVacio()
	 {
		return (p==-1); 
	 }
	
	public String imprimeDatosOrd()
	 {
		 String cad="";
		 for (int i = 0; i <=p; i++) {
			 cad+=i+"["+datos[i]+"]"+"\n";
			
		}
		 return "\n"+cad;
	 }
	
	public int busquedaBinaria( int x)
	{
        int l = 0, r = datos.length - 1;
        while (l <= r) {
            int m = l + (r - l) / 2;
 
            
            if (datos[m] == x)
                return m;
 
            
            if (datos[m] < x)
                l = m + 1;
 
            
            else
                r = m - 1;
        }
 
       
        return -1;
    }
        

public void recorrePos(byte pos) {// este metodo recorre de forma ordenada
	for(int j= p+1; j>pos; j--) {
		datos[j]=datos[j-1];
	}
}
	
	public void AgregaOr() {
		if(p< datos.length)
        {
            datos[p+1] = Tools.leerInt("Escribe un numero");
            p++;
        }
		else{
            Tools.imprimeErrorMsje("Arreglo Lleno.");
		}
	}
	public static void menu3(String menu){  
		String sel="";
		BusquedaBinariaDatosOrd obj = new BusquedaBinariaDatosOrd((byte)10);
		byte pos=0;
		do {
				sel=boton(menu);
				switch(sel){
				case "AgregarOr":
					obj.AgregaOr();
					break;
				case "BusquedaBinariaOr":
					if(obj.validaVacio()) {
						Tools.imprimeErrorMsje("Array vacio");
					}
					else {
					pos = (byte) obj.busquedaBinaria(Tools.leerInt("Inserta un numero a buscar"));
					if(pos>=0) {
						Tools.imprime("Se encuentra en la posicion: " +pos);
					}else {
						Tools.imprimeErrorMsje("Dato no encontrado");
					}
				}
					break;
				case "Imprimir":
					if(obj.validaVacio()) Tools.imprimeErrorMsje("Array vacio");
					else Tools.imprime("Datos del arreglo\n"+obj.imprimeDatosOrd());		
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
		
		menu3("AgregarOr,BusquedaBinariaOr,Imprimir,Salir");

	}

	
}
