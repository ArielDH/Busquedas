package busquedasordenadasydesordenadas;

import javax.swing.JOptionPane;

import ToolsPanel.Tools;

public class BusquedaFibonacci {
	int ar[]=new int[10],n,x,a,b,c,offset;
	public void agregar()
	{
	int i;
	String cad="";
	n=Tools.leerInt("\nIngresa el numero de elementos para el array: ");
	
	for(i=0;i<n;i++) {
	ar[i]=Tools.leerInt("\nIngresa los elementos del arreglo: ");
		cad+= i + "[" + ar [ i ]+ "]" + "\n" ;
	}
	Tools.imprime("Datos del arreglo\n "+cad);
	
	}
	public void busquedaFibonacci(){
	int i;
	x=Tools.leerInt("\nIngresa el elemento a buscar: ");
	a=0;
	b=1;
	c=a+b;
	while (c<n){
	a = b;
	b = c;
	c = a+b;
	}
	offset = -1;
	while(c > 1){
	i=Math.min(offset+a, n-1);
	if (ar[i] < x){
	c = b;
	b = a;
	a = c - b;
	offset = i;
	}
	else if (ar[i] > x){
	c= a;
	b = b -a;
	a= c - b;
	}
	else{
		Tools.imprime("El elemento "+x+" se encuentra en el índice "+i);
	return;
	}
	}
	if(b!=0 && ar[offset+1]==x){
		Tools.imprime("El elemento "+x+" se encuentra en el índice "+offset);
		return;
	}
	Tools.imprimeErrorMsje("Elemento no encontrado");
	}
	public static void menu3(String menu){  
		String sel="";
		BusquedaFibonacci fib = new BusquedaFibonacci();
		do {
			sel=boton(menu);
			switch(sel){
			case "Agregar":
				fib.agregar();
				break;
			case "Busqueda Fibonacci":
				fib.busquedaFibonacci();
				break;
			case"Salir": Tools.imprime("Fin del programa");
				break;
			}
	}while(!sel.equalsIgnoreCase("Salir"));
	}
		
	
	public static void main(String []args) {
		String menu2="Agregar,Busqueda Fibonacci,Salir";
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