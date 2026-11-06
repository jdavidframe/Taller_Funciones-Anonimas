object Operaciones {
  def main(args: Array[String]): Unit = {
    val productos = Productos.productos

    // Ordena por precio de menor a mayor.
    val ordenados = productos.sortBy(p => p.precio)
    println("1. sortBy: " + ordenados.map(p => p.nombre).mkString(", "))

    // Agrupa productos por categoria.
    val grupos = productos.groupBy(p => p.categoria)
    val resumen = grupos.toList.sortBy(par => par._1)
      .map(par => par._1 + "=" + par._2.size)
    println("2. groupBy: " + resumen.mkString(", "))

    // Separa los productos disponibles de los agotados.
    val (disponibles, agotados) = productos.partition(p => p.stock > 0)
    println("3. partition: disponibles=" + disponibles.size + ", agotados=" + agotados.size)

    // Busca el primer producto con precio menor a 20.
    val economico = productos.find(p => p.precio < 20)
    println("4. find: " + economico.map(p => p.nombre).getOrElse("Ninguno"))

    // Agrupa, selecciona y ordena las categorias segun su stock total.
    val categorias = productos.groupBy(p => p.categoria)
      .toList
      .filter(par => par._2.map(p => p.stock).sum > 20)
      .sortBy(par => -par._2.map(p => p.stock).sum)
      .map(par => par._1 + "=" + par._2.map(p => p.stock).sum)
    println("5. Combinacion: " + categorias.mkString(", "))
  }
}
