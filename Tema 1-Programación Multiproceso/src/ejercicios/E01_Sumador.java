package ejercicios;

public class E01_Sumador {

    public int sumar(int n1, int n2) {
        int resultado = 0;
        for (int i = n1; i <= n2; i++) {
            resultado = resultado + i;
        }
        return resultado;
    }

    public static void main(String[] args) {
        E01_Sumador s = new E01_Sumador();
        int n1 = Integer.parseInt(args[0]);
        int n2 = Integer.parseInt(args[1]);
        int resultado = s.sumar(n1, n2);
        // Lo muestra por la salida
        System.out.println(resultado);
        System.out.flush();// vacía el buffer de salida
    }

}
