# 📦 calculadora-pedidos

Este proyecto simula una calculadora de pedidos que aplica descuentos y calcula costos de envío. Fue desarrollado como parte de un ejercicio práctico para implementar **pruebas unitarias en Java** utilizando **JUnit 5** y **Mockito**, e integrar las pruebas dentro de un flujo de **CI/CD con GitHub Actions**.

---

## 🧪 Tecnologías utilizadas

- Java 17  
- Maven  
- JUnit 5  
- Mockito  
- GitHub Actions  

---

## 📌 Funcionalidad principal

La clase `PedidoService` calcula el total a pagar por un pedido considerando:

- Subtotal del pedido
- Código de descuento (opcional)
- Tipo de envío (`express` o `normal`)

Se simula un acceso a base de datos de descuentos mediante una clase `DescuentoRepository`.

---

## ✅ Pruebas unitarias

Se implementaron pruebas para cubrir varios escenarios, incluyendo:

- Pedido sin descuento y envío normal
- Pedido con descuento y envío express
- Pedido con y sin mocks para aislar dependencias

Ejemplo de prueba:

```java
@Test
void testConMockDeDescuento() {
    DescuentoRepository mockRepo = mock(DescuentoRepository.class);
    when(mockRepo.obtenerPorcentaje("PROMO10")).thenReturn(0.10);

    PedidoService service = new PedidoService(mockRepo);

    double total = service.calcularTotal(100, "PROMO10", true);
    assertEquals(110.0, total); // 100 - 10% + 20
}
```

---

## ⚙️ CI/CD con GitHub Actions

Este repositorio incluye un archivo de workflow (`.github/workflows/test.yml`) que ejecuta automáticamente los tests cuando haces `push` o abres un `pull request`.

```yaml
on: [push, pull_request]
jobs:
  test:
    runs-on: ubuntu-latest
    steps:
      - uses: actions/checkout@v3
      - uses: actions/setup-java@v3
        with:
          java-version: '17'
      - run: mvn test
```

📍 Puedes ver los resultados aquí:  
👉 [Acciones del proyecto](https://github.com/LujoMontero/calculadora-pedidos/actions)

---

## 🧠 Aprendizajes

> En este proyecto aprendí a aplicar pruebas unitarias efectivas en Java, simular dependencias externas con Mockito, y automatizar el proceso de testing como parte de un flujo CI/CD. Esto refuerza la calidad del código y mejora la seguridad en los despliegues.

---

## 📸 Captura de pruebas exitosas
![Captura de pantalla 2025-06-18 223832](https://github.com/user-attachments/assets/f33831d0-4161-4894-99e1-041ef8f89190)
![Captura de pantalla 2025-06-18 223801](https://github.com/user-attachments/assets/8fc35fd7-00be-444d-b56c-fd43bf0f285e)
![Captura de pantalla 2025-06-18 223727](https://github.com/user-attachments/assets/0b2af9c0-4085-4e29-9855-ce2a926619c3)
![Captura de pantalla 2025-06-18 223707](https://github.com/user-attachments/assets/6bfb7381-02de-429b-b977-90372dc8b22a)

---

## 🙋‍♂️ Preguntas Finales – Respuestas
¿Qué te ayudaron a identificar las pruebas unitarias?
Ayudaron a verificar que la lógica de cálculo funcione correctamente en distintos escenarios (con/sin descuento, envío normal/express).

¿Cuál fue el beneficio de usar un mock para simular una dependencia?
Permitió aislar la lógica del servicio sin depender de una base de datos real, facilitando el control del entorno y pruebas más predecibles.

¿Qué pasaría si se modifica la lógica de descuentos sin actualizar las pruebas?
Las pruebas podrían fallar, lo que serviría como alerta para revisar el impacto del cambio en el comportamiento esperado.

¿Cómo escalamos esta estrategia para un sistema más grande?
Organizando los tests en carpetas por módulo, automatizando su ejecución en CI/CD, usando mocks para dependencias complejas, y aplicando buenas prácticas de mantenimiento de tests.

---

## 🚀 Cómo ejecutar el proyecto

```bash
# Clonar el repositorio
git clone https://github.com/LujoMontero/calculadora-pedidos.git

# Ingresar al proyecto
cd calculadora-pedidos

# Ejecutar pruebas
mvn test
```
