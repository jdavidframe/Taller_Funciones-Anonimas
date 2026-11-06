case class Producto(nombre: String, categoria: String, precio: Double, stock: Int)

object Productos {
  val productos = List(
    Producto("Teclado", "Perifericos", 35, 12),
    Producto("Mouse", "Perifericos", 18, 25),
    Producto("Monitor", "Pantallas", 180, 6),
    Producto("SSD", "Almacenamiento", 65, 15),
    Producto("Memoria RAM", "Componentes", 80, 9),
    Producto("Webcam", "Perifericos", 45, 0),
    Producto("Disco HDD", "Almacenamiento", 55, 4),
    Producto("Audifonos", "Audio", 40, 20),
    Producto("Parlantes", "Audio", 70, 7),
    Producto("Laptop", "Computadoras", 750, 3)
  )

  def main(args: Array[String]): Unit = {
    // Selecciona productos que superan los 50 dolares.
    val seleccion = productos.filter(p => p.precio > 50).map(p => p.nombre)
    println("1. Seleccion: " + seleccion.mkString(", "))

    // Calcula el precio con un descuento del 10 %.
    val descuentos = productos.map(p => f"${p.nombre}: ${p.precio * 0.9}%.2f")
    println("2. Transformacion: " + descuentos.mkString(" | "))

    val agotados = productos.exists(p => p.stock == 0)
    println("3. Validacion: " + agotados)

    val stockBajo = productos.count(p => p.stock < 10)
    println("4. Conteo: " + stockBajo)

    val masCaro = productos.maxBy(p => p.precio)
    println("5. Extremos: " + masCaro.nombre + " ($" + masCaro.precio.toInt + ")")
  }
}
