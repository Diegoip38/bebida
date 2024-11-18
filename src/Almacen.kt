class Almacen {
    private val estanteria = Array(5) { arrayOfNulls<Bebidas>(5) }


    fun agregarBebida(bebida: Bebidas): Boolean {
        for (i in estanteria.indices) {
            for (j in estanteria[i].indices) {
                if (estanteria[i][j]?.id == bebida.id) {
                    println("La bebida con ID ${bebida.id} ya existe.")
                    return false
                }
                if (estanteria[i][j] == null) {
                    estanteria[i][j] = bebida
                    println("Bebida con ID ${bebida.id} agregada en posición [$i][$j].")
                    return true
                }
            }
        }
        println("No hay espacio disponible en el almacén.")
        return false
    }


    fun eliminarBebida(id: Int): Boolean {
        for (i in estanteria.indices) {
            for (j in estanteria[i].indices) {
                if (estanteria[i][j]?.id == id) {
                    estanteria[i][j] = null
                    println("Bebida con ID $id eliminada.")
                    return true
                }
            }
        }
        println("No se encontró una bebida con ID $id.")
        return false
    }


    fun mostrarBebidas() {
        for (i in estanteria.indices) {
            for (j in estanteria[i].indices) {
                estanteria[i][j]?.mostrarInformacion()
            }
        }
    }


    fun calcularPrecio(): Double {
        var total = 0.0
        for (fila in estanteria) {
            for (bebida in fila) {
                if (bebida != null) {
                    total += bebida.precio
                }
            }
        }
        return total
    }


    fun calcularPrecio(marca: String): Double {
        var total = 0.0
        for (fila in estanteria) {
            for (bebida in fila) {
                if (bebida?.marca == marca) {
                    total += bebida.precio
                }
            }
        }
        return total
    }


    fun calcularPrecio(columna: Int): Double {
        if (columna !in 0..4) {
            println("Columna inválida.")
            return 0.0
        }
        var total = 0.0
        for (i in estanteria.indices) {
            if (estanteria[i][columna] != null) {
                total += estanteria[i][columna]!!.precio
            }
        }
        return total
    }
}


fun main() {
    val almacen = Almacen()


    almacen.agregarBebida(AguaMineral(1, 1.5, 1.0, "AguaPura", "Montaña"))
    almacen.agregarBebida(BebidaAzucarada(2, 2.0, 2.0, "CocaCola", 10.0, false))

    do {
    println("1.Mostrar Bebidas")
    println("2.Agregar bebidas")
    println("3.Borrar Bebidas")
    println("4.Calcular Precio Total")
    println("5.Calcular precio total")
    println("6.Calcular precio total por columna")
    println("7.Salir")

     var x : Int= readln().toInt()

    when (x) {



        1 ->{
            println("Bebidas en el almacén:")
            almacen.mostrarBebidas()
        }
        2 -> {
            println("Precio total de todas las bebidas: ${almacen.calcularPrecio()}")
        }
        3 -> {
            println("Bebidas en el almacén:")
            almacen.mostrarBebidas()

            println("Que marca desa Calcular" )
            val marca:String = readln()
            println("Precio total de las bebidas de la marca $marca: ${almacen.calcularPrecio(marca)}")
        }
        4 -> {
            println("Bebidas en el almacén:")
            almacen.mostrarBebidas()

            val columna : Int = readln().toInt()
            println("Precio total de la columna $columna: ${almacen.calcularPrecio(columna)}")
        }
        5 -> {
            println("Bebidas en el almacén:")
            almacen.mostrarBebidas()

            almacen.eliminarBebida(2)

            println("Bebidas después de eliminar:")
            almacen.mostrarBebidas()
        }
        6 -> {
            println("1.Añadir agua mineral")
            println("2.Añadir bebida mzucarada")
           var y: Int = readln().toInt()
           if (y == 1){
                println("Id")
                val id:Int= readln().toInt()
                println("Cantidad en Litros")
                val litros:Double= readln().toDouble()
                println("Precio")
                val precio:Double= readln().toDouble()
                println("Marca")
                val marca:String= readln()
                println("Origen")
                val origen:String= readln()

                almacen.agregarBebida(AguaMineral(id, litros, precio, marca, origen))

           } else if (y == 2){

                println("Id")
                val id:Int= readln().toInt()
                println("Cantidad en Litros")
                val litros:Double= readln().toDouble()
                println("Precio")
                val precio:Double= readln().toDouble()
                println("Marca")
                val marca:String= readln()
                println("Origen")
                val pAzucar:Double= readln().toDouble()
                println("Tiene promocion (s/n)")
                val Promocion:String= readln() ?: ""
                val promo: Boolean = Promocion.equals("s", ignoreCase = true)

                almacen.agregarBebida(BebidaAzucarada(id, litros, precio, marca, pAzucar, promo))

           } else{
                println("opcion no valida")
           }
        }
        7 -> {
            println("Ha Salido")
        }
    }
    }while (x !=7)
}