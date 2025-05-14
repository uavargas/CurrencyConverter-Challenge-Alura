# CurrencyConverter-Challenge-Alura

## Descripción
Aplicación Java de consola para conversión de monedas que:
- Obtiene tasas de cambio actualizadas desde una API
- Permite realizar conversiones entre múltiples monedas
- Mantiene un historial de todas las conversiones realizadas
- Muestra información detallada de cada operación

## Características principales
- Interfaz intuitiva con menú interactivo
- Tasas actualizadas en tiempo real desde ExchangeRate-API
- Historial completo con fecha/hora de cada conversión
- Monedas soportadas: USD, EUR, GBP, JPY, MXN, COP, ARS, CLP, BRL, CNY

## Requisitos del sistema
- Java JDK 11 o superior
- Conexión a Internet (para obtener tasas de cambio)
- Dependencias:
  - Gson (para manejo de JSON)

## Instalación
1. Clonar el repositorio o descargar los archivos fuente
2. Compilar con:
   ```bash
   javac -cp .:gson-2.8.6.jar *.java
3. Ejecutar con:   
Java -cp .:gson-2.8.6.jar Main

## Uso
Al iniciar, la aplicación obtendrá automáticamente las tasas de cambio más recientes

Menú principal:

1. Ver monedas disponibles: Muestra lista de monedas con sus códigos

2. Realizar conversión: Permite convertir entre dos monedas

3. Ver historial: Muestra todas las conversiones realizadas

4. Salir: Termina la aplicación

Ejemplo de uso

## === CONVERSOR DE MONEDAS ===
1. Ver monedas disponibles
2. Realizar conversión
3. Ver historial de conversiones
4. Salir
Seleccione una opción: 2

## === REALIZAR CONVERSIÓN ===
Ingrese código de moneda origen (ej. USD): USD
Ingrese código de moneda destino (ej. COP): COP
Ingrese cantidad a convertir: 100

100.00 USD = 391200.00 COP
Conversión guardada en el historial.

## Estructura del código
Main.java: Punto de entrada de la aplicación

Menu.java: Maneja la interfaz de usuario y el historial

Conversor.java: Lógica de conversión de monedas

Moneda.java: Modelo de datos para monedas

ApiClient.java: Cliente para la API de tasas de cambio

ApiResponse.java: Modelo para respuesta de la API

## Historial de conversiones
Cada conversión se guarda con:

Fecha y hora exacta

Moneda origen y destino

Cantidad convertida

Resultado de la conversión

## Ejemplo de entrada de historial:
[2023-04-15 14:30:45] 100.00 USD → 391200.00 COP

Limitaciones
Requiere conexión a Internet para la primera carga de tasas

Las tasas no se actualizan automáticamente durante la sesión

Historial se pierde al cerrar la aplicación

Mejoras futuras
Persistencia del historial en archivo

Actualización periódica de tasas

Gráficos de conversión histórica
 
