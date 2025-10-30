import java.util.List;
import java.util.Scanner;

import model.Bicicleta;
import repository.BicicletaRepository;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BicicletaRepository bicicletaRepository = new BicicletaRepository();

        boolean seguir = true;

        while (seguir) {

            System.out.println("-----Menú----");
            System.out.println("¿Que deseas hacer?\n1.Comprar bicicletas\n2.Administrar bicicletas")

            System.out.println("----------Inventario bicicletas---------");
            System.out.println(
                    "¿Que desea hacer?\n1. Agregar bicleta\n2. Ver bicicletas\n3. Buscar por Marca \n4. Buscar por ID\n5. Buscar por color\n6. Eliminar bicicleta\n7. Actualizar información \n8. salir");
            Integer opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1: {

                    System.out.println("--------Registrar nueva bicicleta------");
                    System.out.println("Ingrese marca: ");
                    String marca = scanner.nextLine();

                    System.out.println("Ingrese modelo: ");
                    String modelo = scanner.nextLine();

                    System.out.println("Ingrese color: ");
                    String color = scanner.nextLine();

                    System.out.println("Ingrese precio: ");
                    double precio = scanner.nextDouble();
                    scanner.nextLine();

                    System.out.println("Ingrese cantidad: ");
                    Integer cantidad = scanner.nextInt();
                    scanner.nextLine();

                    Bicicleta bicicleta = new Bicicleta(marca, modelo, color, precio, cantidad);

                    BicicletaRepository.insertarBicicleta(bicicleta);

                }
                    break;

                case 2: {

                    System.out.println("\n------Lista de bicicletas registradas y stock------");

                    // llamamos al metodo listarUsuarios()
                    List<Bicicleta> bicicleta = BicicletaRepository.listarBicicletas();

                    for (Bicicleta u : bicicleta) {

                        String stockB;

                        if(u.getCantidad() > 0){
                            stockB = "Si hay stock " + u.getCantidad() + " unidades";
                        } else {
                            stockB = "No hay stock disponible 0 unidades";
                        }

                        System.out.println("ID: " + u.getId() + "| Marca:" + u.getMarca() + "| Modelo: " + u.getModelo() + "| Color: " + u.getColor() + "| precio: " + String.format("%,.0f",u.getPrecio()) + " | Cantidad: " + stockB);
                    }

                }
                    break;
                case 3: {

                    System.out.println("-------Filtros por Marca-------");
                    System.out.println("Ingrese la marca que busca: ");
                    String buscarMarca = scanner.nextLine();

                    Bicicleta bicicletaEncontrada = BicicletaRepository.FiltrarPorMarca(buscarMarca);

                    if(bicicletaEncontrada != null){
                    System.out.println("Bicicleta encontrada:" +
                            "ID: " + bicicletaEncontrada.getId() +
                            "|Marca: " + bicicletaEncontrada.getMarca() +
                            "|Modelo: " + bicicletaEncontrada.getModelo() +
                            "|Color: " + bicicletaEncontrada.getColor() + 
                            "|Precio: " + bicicletaEncontrada.getPrecio() + 
                            "|Cantidad: " + bicicletaEncontrada.getCantidad()
                            );
                } else{
                    System.out.println("Bicicleta no encontrada.");
                }
            }
                    break;

                case 4: {

                    System.out.println("-------Filtros por ID--------");
                    System.out.println("Ingrese el ID que busca: ");
                    int buscarId = scanner.nextInt();
                    scanner.nextLine();

                     Bicicleta bicicletaEncontrada = BicicletaRepository.FiltrarPorId(buscarId);

                    if(bicicletaEncontrada != null){
                    System.out.println("Bicicleta encontrada:" +
                            "ID: " + bicicletaEncontrada.getId() +
                            "|Marca: " + bicicletaEncontrada.getMarca() +
                            "|Modelo: " + bicicletaEncontrada.getModelo() +
                            "|Color: " + bicicletaEncontrada.getColor() + 
                            "|Precio: " + bicicletaEncontrada.getPrecio() + 
                            "|Cantidad: " + bicicletaEncontrada.getCantidad()
                            );
                } else{
                    System.out.println("Bicicleta no encontrada.");
                }

                    
                }
                    break;

                case 5: {
                    System.out.println("-------Filtros por color--------");
                    System.out.println("Ingrese el color: ");
                    String buscarColor = scanner.nextLine();
                    

                    Bicicleta bicicletaEncontrada = BicicletaRepository.FiltrarPorColor(buscarColor);

                    if(bicicletaEncontrada != null){
                        System.out.println("Bicicleta encontrada:");
                        System.out.println(
                             "ID: " + bicicletaEncontrada.getId() +
                            "|Marca: " + bicicletaEncontrada.getMarca() +
                            "|Modelo: " + bicicletaEncontrada.getModelo() +
                            "|Color: " + bicicletaEncontrada.getColor() + 
                            "|Precio: " + bicicletaEncontrada.getPrecio() + 
                            "|Cantidad: " + bicicletaEncontrada.getCantidad()
                            );
                } else {
                    System.out.println("No se encontro ninguna bicicleta.");
                }
                        
                    }


                break;

                case 6: {

                    System.out.println("--------Eliminar bicicleta---------");
                    System.out.println("Ingrese el ID de la bicicleta que desea eliminar: ");
                    int EliminarBicicleta = scanner.nextInt();
                    scanner.nextLine();

                    BicicletaRepository.EliminarBicicleta(EliminarBicicleta);

                }
                    break;

                case 7: {
                    System.out.println("--------Actualizar información-------");

                    System.out.println("Ingrese el id de la bicicleta que quiere actualizar");
                    Integer idRespuesta = scanner.nextInt();
                    scanner.nextLine();

                    Bicicleta BicicletaActual = BicicletaRepository.FiltrarPorId(idRespuesta);

                    if(BicicletaActual != null){
                          System.out.println("Usuario encontrado: ");
                          System.out.println("Marca actual: " + BicicletaActual.getMarca());
                          System.out.println("Modelo actual: " + BicicletaActual.getModelo());
                          System.out.println("Modelo color: " + BicicletaActual.getColor());
                             System.out.println("Modelo color: " + BicicletaActual.getColor());

                        System.out.println("Ingrese la nueva marca: ");
                        String nuevaMarca = scanner.nextLine();

                        System.out.println("Ingrese el nuevo modelo: ");
                        String nuevoModelo = scanner.nextLine();

                        System.out.println("Ingrese el nuevo color: ");
                        String nuevoColor = scanner.nextLine();
                    
                        System.out.println("Ingrese el nuevo precio: ");
                        Double nuevoPrecio = scanner.nextDouble();
                        scanner.nextLine();

                        System.out.println("Ingrese la nueva cantidad: ");
                        Integer nuevaCantidad = scanner.nextInt();
                        scanner.nextLine();

                        BicicletaRepository.ActualizarInformacion(idRespuesta, nuevaMarca, nuevoModelo, nuevoColor, nuevoPrecio, nuevaCantidad);

                        System.out.println("Bicicleta actualizada: " +  "| id: " + idRespuesta +
                        "| marca: " + nuevaMarca +
                        "| modelo: "  + nuevoModelo + 
                        "| color: " + nuevoPrecio +
                        "| cantidad " +  nuevaCantidad);
                    }       
                    
                }

                    break;
                case 8: {
                    System.out.println("Gracias por visitar el inventario.");
                    seguir = false;
                    break;
                }
                default:
                    System.out.println("Opcion incorrecta, vuelve a intentarlo.");
                    break;
            }

            System.out.println("Desea realizar otra accion? (si/no)");
            String VF = scanner.nextLine();

            if (!VF.equalsIgnoreCase("si")) {
                seguir = false;

                System.out.println("Vuelve pronto.");
            }

        }

        scanner.close();
    }

}