package E13_productor_consum_Sin;

class Monitor {
	private int colaNumeros[] = new int[6];
	private int sigNum = 0;
	
	private boolean colaLlena = false;
	private boolean colaVacia = true;

	public synchronized int coger() {
		//Si la cola se encuentra vac�a env�a el hilo a la cola de espera
		while( colaVacia ) //sale cuando colaVacia es falso
		{
			try {
				wait();
			} catch( InterruptedException e ) {
				
			}
		}
		
		//Disminuye sigNum porque coge un n�mero y habr� un n�mero menos
		sigNum--;
		// Si no quedan n�meros
		if( sigNum == 0 )
			colaVacia = true;
		colaLlena = false;
		notify();
		//Devuelve el n�mero al hilo consumidor
		return( colaNumeros[sigNum] );
	}
	
	public synchronized void dejar( int num ) {
		//Si la cola est� llena, no entran m�s n�meros,
       // enviamos el hilo a la cola de espera
             //Si colaLlena es false, podr� continuar produciendo
		while( colaLlena )		{
			try {
				wait();
			} catch( InterruptedException e ) {
				
			}
		}
		//a�adimos el nuevo n�mero al primer lugar disponible
		colaNumeros[sigNum] = num;
		// aumentamos los n�meros de la cola
		sigNum++;
		// Miramos si la cola est� llena
		if( sigNum == 6 )
			colaLlena = true;
		colaVacia = false; //porque acabamos de producir un n�mero
		notify();
	}

}

