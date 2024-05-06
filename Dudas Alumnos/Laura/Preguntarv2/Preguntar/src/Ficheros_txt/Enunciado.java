package Ficheros_txt;

//------------------------------------------------------------------------------------------------------------------------------------
//Se desea crear un programa que procese ficheros aprovechando el paralelismo de la máquina. 
//Se tienen cinco ficheros con los siguientes nombres:

//informatica.txt

//gerencia.txt

//contabilidad.txt

//comercio.txt

//rrhh.txt



//Crear 5 procesos
//En cada fichero hay una lista de cantidades (buscar cantidades) enteras que representa las contabilidades de distintos departamentos

//Se creará un proceso diferente (clase SumarCantidades) para sumar la cantidad total que suma todas las cantidades de los cinco 
//ficheros haciendo uso del paralelismo

//Una vez hayan finalizado todos los procesos que suman las cantidades, 
//desde el Lanzador se creará otro proceso (clase ContarCifras) que realizará el conteo de las cifras del número a cada cantidad 
//y la almacenará en un fichero llamado "sumarcantidades.txt" que se ubicará en una carpeta llamada 
//archivos ubicada en la raíz del proyecto


//**********
//Lanzador --> 1º clase --> SumarCantidades --> numProceso y nombre del fichero
         //--> 2º clase --> ContarCifras --> ruta de la carpeta y ruta del archivo

//------------------------------------------------------------------------------------------------------------------------------------


//---------------------------------------EJERCICIO PARECIDO AL ANTERIOR---------------------------------------------------------------------------------------------
//Crear 5 procesos
//Se creará un proceso diferente (clase contarVocales) para contar las vocales que hay en un fichero
//El programa padre debe lanzar cinco procesos hijo, donde cada uno de ellos se ocupará 
//de contar una vocal concreta (que puede ser minúscula o mayúscula).


//Una vez hayan finalizado todos los procesos que suman las cantidades, 
//desde el Lanzador se creará otro proceso (clase ContarCifras) que realizará el conteo de las cifras del número a cada cantidad 
//y la almacenará en un fichero llamado "sumarcantidades.txt" que se ubicará en una carpeta llamada 
//archivos ubicada en la raíz del proyecto


//Cada subproceso que cuenta vocales deberá dejar el resultado en un fichero. 
//El programa padre se ocupará de recuperar los resultados de los ficheros, 
//sumar todos los subtotales y mostrar el resultado final en pantalla.

//Clases:
//Lanzador --> 
//ContarVocales --> vocal y nombre del fichero
//ContarCifras --> ruta de la carpeta



//Este ejercicio es bastante parecido al anterior, con la salvedad de que ahora necesitaremos sumar 
//cantidades en lugar de buscar elementos. Por lo demás, también generaremos un fichero de resultados por 
//cada fichero de datos y los llamaremos igual pero añadiendo la extensión «.res». Es decir, 
//la suma de las cantidades de informatica.txt se dejará en informatica.txt.res.
//------------------------------------------------------------------------------------------------------------------------------------
