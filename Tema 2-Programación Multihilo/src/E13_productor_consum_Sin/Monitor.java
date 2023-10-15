package E13_productor_consum_Sin;

class Monitor {
	private int colaNumeros[] = new int[6];
	private int sigNum = 0;
	
	private boolean colaLlena = false;
	private boolean colaVacia = true;

	public synchronized int coger() {
		//Si la cola se encuentra vacía envía el hilo a la cola de espera
		while( colaVacia ) //sale cuando colaVacia es falso
		{
			try {
				wait();
			} catch( InterruptedException e ) {
				
			}
		}
		
		//Disminuye sigNum porque coge un número y habrá un número menos
		sigNum--;
		// Si no quedan números
		if( sigNum == 0 )
			colaVacia = true;
		colaLlena = false;
		notify();
		//Devuelve el número al hilo consumidor
		return( colaNumeros[sigNum] );
	}
	
	public synchronized void dejar( int num ) {
		//Si la cola está llena, no entran más números,
       // enviamos el hilo a la cola de espera
             //Si colaLlena es false, podrá continuar produciendo
		while( colaLlena )		{
			try {
				wait();
			} catch( InterruptedException e ) {
				
			}
		}
		//añadimos el nuevo número al primer lugar disponible
		colaNumeros[sigNum] = num;
		// aumentamos los números de la cola
		sigNum++;
		// Miramos si la cola está llena
		if( sigNum == 6 )
			colaLlena = true;
		colaVacia = false; //porque acabamos de producir un número
		notify();
	}

}

