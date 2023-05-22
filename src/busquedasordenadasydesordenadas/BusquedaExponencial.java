package busquedasordenadasydesordenadas;

import javax.swing.JOptionPane;

import ToolsPanel.Tools;

public class BusquedaExponencial {
	int a [] = new int [ 10 ], n , x , l , h ,mid,bound,indx ;
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
	
	int busq_binaria(int a[],int l,int h,int x){
	if(l>h)
	return -1;
	
	mid=(l+h)/2;
	
	if (x==a[mid])
	return mid;

	else if(x<a[mid])
	return busq_binaria(a,l,mid-1,x);
	else
	return busq_binaria(a,mid+1,h,x);
	}

	public void busquedaExponencial()
	{
	x=Tools.leerInt("\nIngresa el elemento a buscar: ");
	bound=1;
	
	while(bound<n&&a[bound]<x)
	bound*=2;
	
	indx=busq_binaria(a,bound/2,Math.min(bound,n),x);
	if(indx!=-1)
		Tools.imprime("El elemento "+x+" se encuentra en el índice "+indx);
	else
		Tools.imprimeErrorMsje("Elemento no encontrado");
	}
	public static void menu3(String menu){  
		String sel="";
		BusquedaExponencial exp = new BusquedaExponencial();
		do {
			sel=boton(menu);
			switch(sel){
			case "Agregar":
				exp.agregar();
				break;
			case "Busqueda Exponencial":
				exp.busquedaExponencial();
				break;
			case"Salir": Tools.imprime("Fin del programa");
				break;
			}
	}while(!sel.equalsIgnoreCase("Salir"));
	}
		
	
	public static void main(String []args) {
		String menu2="Agregar,Busqueda Exponencial,Salir";
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
