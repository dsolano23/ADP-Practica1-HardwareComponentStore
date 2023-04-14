Pregunta 1:

Para garantizar bajo acoplamiento, se debe implementar el metodo getPrice en las clases hijas de shoppingCart. 
Ademas al hacerlo asi podemos crear distintos tipos de carritos (BlackFridayCart) que puedan calcular el precio especial para ese evento.

Para el calculo de descuento: Al carrito se le tiene que indicar quien es el cliente para calcular el precio.
Cada cliente tiene asociado un tipo de descuento, de forma que se pueden crear mas clientes con un descuento determinado.

Los carritos nunca saben de tipos de cliente, solo del metodo "getDiscount", hay bajo acoplamiento y alta cohesion ya que el metodo que da el descuento del usuario
es siempre el del padre (Client).

En este modelo, el tipo de carrito puede hacer uso del padre para el calculo del precio o sobreescribir si fuera necesario (como comente antes el BlackFridayCart)