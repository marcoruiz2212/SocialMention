## REFACTOR SOCIAL MEDIA APP

Malas prácticas

1. No se hace uso de los principios SOLID, lo cual hace que sea mas dificil entender el codigo
2. El controlador tiene lógica de negocio que no le corresponde
3. El controlador no debería tener conexión a la base de datos
4. Url de la base de datos expuesta, esto debería estar en un secret, ya que alguien que pueda acceder al código, podría acceder a la base de datos
5. Por buena práctica la url de los endpoints debe empezar en minúscula
6. No tener una base de datos segregada por cuenta
7. Codigo duplicado

Refactor

1. Lo primero es crear clases especificas para separar la logica y tengan su funcion correspondiente.

    Ejemplo:
    
    El controlador no deberia tener logica de negocio, el service se debe encargar de esto y lo mismo para el repository en el acceso a datos

2. Se hace uso del patron strategy para separar la logica de las cuentas de facebook como la de twitter, y pensando que podriamos agregar otras redes sociales como Instagram, tiktok...
3. Al usar esta separacion por medio de modulos, usando diferentes patrones es mas sencillo entender el codigo y hacer mantenibilidad de este mismo.

