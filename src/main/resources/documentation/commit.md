# ESTANDAR DEL MENSAJE COMMIT

Este será el estandar que se seguirá en nuestro proyecto para añadir un nuevo commit.

```
Resumir los cambios en aproximadamente 50 caracteres o menos (EN IMPERATIVO y MAYUSCULA)
 
Mas texto descriptivo, si es necesario.  Límita aproximadamente a 72 caracteres o menos. En algunos contextos, la primera línea se establece como el asunto del commit y el resto es el cuerpo. La línea en blanco que separa el asunto del cuerpo es fundamental (a menos que se omita el cuerpo por completo); diversas herramientas como `log`,` y `shortlog` y `rebase` pueden confundirse si ejecuta los dos juntos.

Explique el problema que el commit está resolviendo. Concéntrese en por qué usted está haciendo este cambio en comparación de cómo  (pues el código explica esa parte).
¿Hay efectos secundarios u otros consecuencias poco intuitivas en este cambio? Este es el lugar para explicarlos.

Otros párrafos vienen después de líneas en blanco.

 - Las viñetas o listas son aceptables también 
 - Normalmente, un guión o asterisco se utiliza para la viñeta, precedido por un solo espacio, con líneas en blanco en el medio, pero hay diferentes convenciones 

Si utiliza un administrador de "issues", coloque referencias a ellos en la parte inferior, así: 

Resuelve: # 123 
Consulte también: # 456, # 789
```