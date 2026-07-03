Integrante 1: Eugenio Román Cortés Egaña / RUT: 22.405.687-7 7 / CARRERA: Ingeniería Civil en Computación e Informatica / Usuario: QuenoLL - Integrante 2: Matías Nicolás Núñez González / RUT: 22.256.666.5 / CARRERA: Ingeniería Civil en Computación e Informatica / Usuario: Manugooo

Descripción: TallerPOO4 programa un menu interactivo en el universo de las cartas TCG Pokemon, de una manera distinta, a travéz de de una GUI la cual cuenta con dos pestañas principales, la primera siendo
de Administracion, en la cual podremos agregar, eliminar y modificar cartas desde la misma ventana de la GUI; La segunda pestaña siendo de coleccion, nos muestra todas las cartas con distintos filtros
de una manera grafica, con sus imagenes png, todo esto respetando la arquitectura en software, donde contaremos con una app y un sistema implementado, ademas de multiples clases y subclases gracias
a la programación orientada a objetos.

Estructura: Dentro del programa contamos con un source folder llamado "Taller4", en él se realizara todo lo dicho en la descripción, de manera que contaremos con distintos paquetes
respetando el modelo de negocio, el primero siendo de Logica, alberga todo lo relacionado al funcionamiento del programa, el segundo, Dominio, contiene nuestros distintos objetos, donde resaltan
algunos, pero el principal, siendo Carta, una clase abstracta que extiende a distintos subtipos del universo TCG, estas teniendo ademas de sus atributos una ruta de imagen, correspondiente a un folder llamado Images, donde contamos con imagenes de formato
png, las cuales grafican las cartas de manera que se veran mostradas en la pestaña de colección; Es necesario tambien decir que en el programa se ven implementados distintos patrones de diseño, los cuales son 4, a continuacion se nombraran
y el como se implementaron en el programa: 1.Singleton, este patron se implementa en el sistema implementado, de manera que solo habra una instancia de este, evitando conflictos, etc. 
2.Factory, se instancia una clase factory de cartas, de manera que la creacion de estas no es tarea del sistema implementado pero que este debe instanciar y llamar al metodo.
3.Visitor, las cartas de por si tienen un sistema de puntuaciones, donde los atrbutos de estas dictaminan la misma, el patron visitor lo que hace es visitar los distintos tipos de cartas de manera que al recorrerlas se entregue la puntuacion corrrespondiente.
4.Estrategy, este patrón sale a la luz en la pestaña de coleccion, donde podemos poner distintos filtros para el printeo, o muestra mejor dicho de las cartas, y ¿como nos ayuda estrategy en esto? como los filtros es un cambio en tiempo de ejecucion
con estrategy podemos llevar a cabo un sistema que ordene las cartas segun un dato en especifico.

Metodo de uso: Al correr el programa, aparecerá un venteana emergente JFrame, la cual tendra en ella dos pestañas, Administracion y Coleccion, si apretamos el primer boton respectivamente, 
se abrira una ventana emergente donde deberemos seleccionar la accion administrativa a realizar, puede ser agregar, eliminar o modificar una carta, de manera que podemos cambiar los datos segun un panel, JDialog.
Si apretamos el segundo podremos printear las imagenes segun un ordenamiento, apareciendo en pantalla las distintas cartas.
