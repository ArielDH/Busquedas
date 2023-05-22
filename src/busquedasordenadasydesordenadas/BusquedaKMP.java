package busquedasordenadasydesordenadas;

import java.util.ArrayList;
import java.util.List;

import ToolsPanel.Tools;

public class BusquedaKMP {
	public static int[] calcularLPS(String patron) {
		int m = patron.length();
		int[] lps = new int[m];
		int longitud = 0;
		int i = 1;
		while (i < m) {
		if (patron.charAt(i) == patron.charAt(longitud)) {
		longitud++;
		lps[i] = longitud;
		i++;
		} else {
		if (longitud != 0) {
		longitud = lps[longitud - 1];
		} else {
		lps[i] = 0;
		i++;
		}
		}
		}
		return lps;
		}
		public static List<Integer> buscarPatron(String texto, String patron) {
		int n = texto.length();
		int m = patron.length();
		int[] lps = calcularLPS(patron);
		List<Integer> resultados = new ArrayList<>();
		int i = 0;
		int j = 0;
		while (i < n) {
		if (texto.charAt(i) == patron.charAt(j)) {
		i++;
		j++;
		if (j == m) {
		resultados.add(i - j);
		j = lps[j - 1];
		}
		} else {
		if (j != 0) {
		j = lps[j - 1];
		} else {
		i++;
		}
		}
		}
		return resultados;
		}
		public static void main(String[] args) {
		String texto =Tools.leerString("Ingresa un texto");
		String patron =Tools.leerString("Ingresa un patron");
		List<Integer> resultados = buscarPatron(texto, patron);
		if (!resultados.isEmpty()) {
		Tools.imprime("El patrón se encontró en las siguientes posiciones:" +resultados);
		} else {
		Tools.imprimeErrorMsje("El patrón no se encontró en el texto.");
		}
		}
}
