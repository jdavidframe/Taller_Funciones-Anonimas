from dataclasses import dataclass


@dataclass(frozen=True)
class Producto:
    nombre: str
    categoria: str
    precio: float
    stock: int


productos = [
    Producto("Teclado", "Perifericos", 35, 12),
    Producto("Mouse", "Perifericos", 18, 25),
    Producto("Monitor", "Pantallas", 180, 6),
    Producto("SSD", "Almacenamiento", 65, 15),
    Producto("Memoria RAM", "Componentes", 80, 9),
    Producto("Webcam", "Perifericos", 45, 0),
    Producto("Disco HDD", "Almacenamiento", 55, 4),
    Producto("Audifonos", "Audio", 40, 20),
    Producto("Parlantes", "Audio", 70, 7),
    Producto("Laptop", "Computadoras", 750, 3),
]


def main():
    # Se conservan los productos que cuestan mas de 50.
    seleccion = list(filter(lambda p: p.precio > 50, productos))
    print("1. Seleccion: " + ", ".join(p.nombre for p in seleccion))

    descuentos = list(map(lambda p: f"{p.nombre}: {p.precio * 0.9:.2f}", productos))
    print("2. Transformacion: " + " | ".join(descuentos))

    agotados = any(map(lambda p: p.stock == 0, productos))
    print("3. Validacion: " + str(agotados).lower())

    stock_bajo = sum(map(lambda p: int(p.stock < 10), productos))
    print("4. Conteo: " + str(stock_bajo))

    mas_caro = max(productos, key=lambda p: p.precio)
    print(f"5. Extremos: {mas_caro.nombre} (${mas_caro.precio:.0f})")


if __name__ == "__main__":
    main()
