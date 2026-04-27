<div align="center">

# 📦 Calculadora de Pedidos

### Pruebas unitarias con JUnit 5 + Mockito · CI/CD con GitHub Actions

![Java](https://img.shields.io/badge/Java_17-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white)
![Spring](https://img.shields.io/badge/Maven-C71A36?style=for-the-badge&logo=apachemaven&logoColor=white)
![JUnit](https://img.shields.io/badge/JUnit_5-25A162?style=for-the-badge&logo=junit5&logoColor=white)
![Mockito](https://img.shields.io/badge/Mockito-78C257?style=for-the-badge&logoColor=white)
![GitHub Actions](https://img.shields.io/badge/GitHub_Actions-2088FF?style=for-the-badge&logo=githubactions&logoColor=white)

[![Tests](https://github.com/LujoMontero/calculadora-pedidos/actions/workflows/test.yml/badge.svg)](https://github.com/LujoMontero/calculadora-pedidos/actions)

</div>

---

## 📌 ¿Qué hace este proyecto?

Simulador de cálculo de pedidos con lógica de descuentos y costos de envío. El foco está en demostrar buenas prácticas de **testing en Java**: pruebas unitarias aisladas con mocks, cobertura de múltiples escenarios y automatización CI/CD.

```
Subtotal → aplicar descuento (opcional) → agregar costo envío → Total final
```

---

## 🏗️ Arquitectura

```
calculadora-pedidos/
├── src/
│   ├── main/java/
│   │   ├── PedidoService.java        # Lógica principal de negocio
│   │   └── DescuentoRepository.java  # Repositorio de descuentos
│   └── test/java/
│       └── PedidoServiceTest.java    # Suite de pruebas unitarias
├── .github/workflows/
│   └── test.yml                      # Pipeline CI/CD
└── pom.xml
```

---

## ⚙️ Requisitos

- Java 17+
- Maven 3.8+

---

## 🚀 Instalación y ejecución

```bash
# 1. Clonar el repositorio
git clone https://github.com/LujoMontero/calculadora-pedidos.git
cd calculadora-pedidos

# 2. Ejecutar pruebas
mvn test

# 3. Compilar el proyecto
mvn clean install
```

---

## 🧪 Pruebas implementadas

Las pruebas cubren los escenarios principales de negocio usando **JUnit 5** y **Mockito** para aislar dependencias:

| Escenario | Tipo | Estado |
|---|---|---|
| Pedido sin descuento + envío normal | Unitaria | ✅ |
| Pedido con descuento + envío express | Unitaria | ✅ |
| Descuento simulado con Mock | Unitaria con Mock | ✅ |
| Código de descuento inválido | Caso borde | ✅ |

**Ejemplo de prueba con Mock:**

```java
@Test
void testConMockDeDescuento() {
    DescuentoRepository mockRepo = mock(DescuentoRepository.class);
    when(mockRepo.obtenerPorcentaje("PROMO10")).thenReturn(0.10);

    PedidoService service = new PedidoService(mockRepo);
    double total = service.calcularTotal(100, "PROMO10", true);

    assertEquals(110.0, total); // 100 - 10% descuento + $20 envío express
}
```

---

## 🔁 Pipeline CI/CD

Cada `push` o `pull request` a `main` ejecuta automáticamente las pruebas:

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

👉 [Ver resultados en Actions](https://github.com/LujoMontero/calculadora-pedidos/actions)

---

## 💡 Conceptos aplicados

- **Pruebas unitarias**: Validación de lógica de negocio de forma aislada
- **Mockito**: Simulación de dependencias externas (repositorio de descuentos) sin necesidad de base de datos real
- **Integración continua**: Pipeline automatizado que detecta regresiones antes del merge
- **Maven**: Gestión de dependencias y ciclo de vida del proyecto

---

## 👨‍💻 Autor

**Luis Montero** · [GitHub](https://github.com/LujoMontero) · [LinkedIn](https://www.linkedin.com/in/luis-montero-if/)
