package busquedasordenadasydesordenadas;


import javax.swing.JOptionPane;

import ToolsPanel.Tools;

public class SaltoBusqueda {
	int a[]=new int[10],n,x,strt,end,f=0, l , h , pos ;

	
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
	
	
	public void busquedaSalto()
	{
	x=Tools.leerInt("\nIngresa el elemento a buscar: ");
	int i;
	
	strt = 0;
	end = (int) Math.sqrt(n);
	while(a[end] <= x && end < n) {
	strt = end;
	end += Math.sqrt(n);
	if(end > n - 1)
	end = n;
	}
	for(i = strt; i<end; i++) {
	if(a[i] == x)
	{
	Tools.imprime("El elemento "+x+" si se encuentra en la posicion "+i);
	f=1;
	}
	
	}
	if(f==0)
		Tools.imprimeErrorMsje("Elemento no encontrado");
	
	}
	
	public static void menu3(String menu){  
		String sel="";
		SaltoBusqueda salto = new SaltoBusqueda();
		do {
			sel=boton(menu);
			switch(sel){
			case "Agregar":
				salto.agregar();
				break;
			case "Busqueda Salto":
				salto.busquedaSalto();
				break;
			case"Salir": Tools.imprime("Fin del programa");
				break;
			}
	}while(!sel.equalsIgnoreCase("Salir"));
	}
		
	
	public static void main(String []args) {
		String menu2="Agregar,Busqueda Salto,Salir";
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
