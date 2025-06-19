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

*(Agrega aquí una imagen de las pruebas en verde desde tu IDE o GitHub Actions)*

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
