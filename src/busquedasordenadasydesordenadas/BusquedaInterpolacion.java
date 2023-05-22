package busquedasordenadasydesordenadas;

import javax.swing.JOptionPane;

import ToolsPanel.Tools;

public class BusquedaInterpolacion {
	int a [] = new int [ 10 ], n , x , l , h , pos ;
	public void agregar()
	{
	int i;
	String cad="";
	n=Tools.leerInt("\nIngresa el numero de elementos para el array: ");
	
	for(i=0;i<n;i++) {
	a[i]=Tools.leerInt("\nIngresa los elementos del arreglo: ");
		cad+= i + "[" + a [ i ]+ "]" + "\n" ;
	}
	Tools.imprime("Datos del arreglo\n "+cad);
	
	}
	public void busquedaInterpolacion() {
		x=Tools.leerInt("\nIngresa el elemento a buscar: ");
		//buscando el elemento en el arreglo
		l = 0 ; h = n - 1 ;
		while ( l <= h && x >= a [ l ] && x <= a [ h ])
		{
			if (l == h ){
				if ( a [ l ] == x ) 
					Tools.imprime( "El elemento " + x + " se encuentra en el índice " + l );
				else
					Tools.imprimeErrorMsje("Elemento no encontrado");
				return;
			}
		pos = (int) ( l + ((( double )( h - l ) / ( a [ h ] - a [ l ])) * ( x - a [l])));
		if ( a [pos] == x )
		{
			Tools.imprime ( "El elemento " + x + " se encuentra en el índice " +pos );
			return;
		}
		if ( a [ pos ] < x )
			l = pos + 1 ;
		else
			h = pos - 1 ;
		}
		Tools.imprimeErrorMsje ( "elemento no encontrado" );
	}
	public static void menu3(String menu){  
		String sel="";
		BusquedaInterpolacion salto = new BusquedaInterpolacion();
		do {
			sel=boton(menu);
			switch(sel){
			case "Agregar":
				salto.agregar();
				break;
			case "Busqueda Interpolacion":
				salto.busquedaInterpolacion();
				break;
			case"Salir": Tools.imprime("Fin del programa");
				break;
			}
	}while(!sel.equalsIgnoreCase("Salir"));
	}
		
	
	public static void main(String []args) {
		String menu2="Agregar,Busqueda Interpolacion,Salir";
		menu3(menu2);
	}
	public static String boton(String menu) {
		String valores[]=menu.split(",");
		int n;
		n = JOptionPane.showOptionDialog(null,"SELECCIONA  DANDO CLICK ", 
				" M E N U", JOptionPane.NO_OPTION, JOptionPane.QUESTION_MESSAGE,null,valores,
				valores[0]);
		return ( valores[n]);
}
}
