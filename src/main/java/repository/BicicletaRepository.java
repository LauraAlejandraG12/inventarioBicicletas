package repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import db.Conexion; 
import model.Bicicleta;

public class BicicletaRepository {
    public static void insertarBicicleta(Bicicleta bicicleta) {

        /* Consulta SQL con espacios (?) para luego poner los valores reales */
        String sql = "INSERT INTO bicicleta (marca,modelo,color,precio,cantidad) VALUES (?,?,?,?,?)";

        try (Connection conn = Conexion.getConnection()) { /* Abrimos la conexión con la base de datos */

            /* Preparamos la consulta para poder llenarla con datos */
            PreparedStatement preparedStatement = conn.prepareStatement(sql);

            preparedStatement.setString(1, bicicleta.getMarca());
            preparedStatement.setString(2,bicicleta.getModelo());
            preparedStatement.setString(3, bicicleta.getColor());
            preparedStatement.setDouble(4,bicicleta.getPrecio());
            preparedStatement.setInt(5, bicicleta.getCantidad());

            preparedStatement.execute();

            System.out.println("Bicicleta agregada con exito al inventario");

            /* Atrapamos posible error si es que lo hay */
        } catch (Exception e) {
            /* imprime en consola el error que se produjo */
            e.printStackTrace();
        }
    }

    // Listar usuarios
    public static List<Bicicleta> listarBicicletas() {
        List<Bicicleta> lista = new ArrayList<>(); // creamos el array vacio

        /*
         * Consulta SQL que selecciona todas las columnas que queremos de la tabla
         * "usuario"
         */
        String sql = "SELECT * FROM bicicleta";

        /* abrimos la conexion y ejecutamos la consulta */
        try (Connection conn = Conexion.getConnection(); // conexion con la BD
                PreparedStatement ps = conn.prepareStatement(sql); // preparamos la consulta
                ResultSet rs = ps.executeQuery()) { // ejecutamos la consulta y obtenemos los resultados

            // recorremos cada fila de la tabla
            while (rs.next()) {
                Bicicleta u = new Bicicleta(
                        rs.getInt("id"), 
                        rs.getString("marca"), 
                        rs.getString("modelo"),
                        rs.getString("color"),
                        rs.getDouble("precio"),
                        rs.getInt("cantidad")
                );

                lista.add(u); 
            }

        } catch (Exception e) { 
            e.printStackTrace();
        }

     
        return lista;
    }

    public static Bicicleta FiltrarPorMarca(String marca) {
        Bicicleta bicicleta = null;
        String sql = "SELECT * FROM bicicleta WHERE marca = ?";

        try (Connection connection = Conexion.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, marca);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                bicicleta = new Bicicleta(
                        resultSet.getInt("id"), 
                        resultSet.getString("marca"), 
                        resultSet.getString("modelo"),
                        resultSet.getString("color"),
                        resultSet.getDouble("precio"),
                        resultSet.getInt("cantidad")
                );
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return bicicleta;
    }

    public static Bicicleta FiltrarPorId(Integer id) {
        Bicicleta bicicleta = null;
        String sql = "SELECT * FROM bicicleta WHERE id = ?";

        try (Connection conn = Conexion.getConnection(); // conexion con la BD
                PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                Integer Id = rs.getInt("id");
                String marca = rs.getString("marca");
                String modelo = rs.getString("modelo");
                String color = rs.getString("color");
                double precio = rs.getDouble("precio");
                Integer cantidad = rs.getInt("cantidad");

                bicicleta  = new Bicicleta(Id, marca, modelo, color, precio, cantidad);

        }      
    }catch (Exception e) {
            e.printStackTrace();
        }

        return bicicleta;
    }


    public static Bicicleta FiltrarPorColor(String color){

        Bicicleta bicicleta = null;
        String sql = "SELECT * FROM bicicleta WHERE color = ?";

        try (Connection conn = Conexion.getConnection(); // conexion con la BD
                PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, color);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                Integer Id = rs.getInt("id");
                String marca = rs.getString("marca");
                String modelo = rs.getString("modelo");
                String Color = rs.getString("color");
                double precio = rs.getDouble("precio");
                Integer cantidad = rs.getInt("cantidad");

                bicicleta = new Bicicleta(Id, marca, modelo, Color, precio, cantidad);

        }      
    }catch (Exception e) {
            e.printStackTrace();
        }

        return bicicleta;

    }

    public static void EliminarBicicleta(Integer id) {
        String sql = "DELETE FROM bicicleta WHERE id = ?";

        try (Connection connection = Conexion.getConnection(); // conexion con la BD
                PreparedStatement prepareStatement = connection.prepareStatement(sql)) {

            prepareStatement.setInt(1, id);

            Integer filas = prepareStatement.executeUpdate();

            if (filas > 0) {
                System.out.println("Bicicleta eliminadoa con exito");
            } else {
                System.out.println("No se encontro ninguna bicicleta con id: " + id);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static void ActualizarInformacion(int id, String nuevaMarca, String nuevoModelo, String nuevoColor, Double nuevoPrecio, Integer nuevaCantidad) {
        String sql = "UPDATE bicicleta SET marca = ?, modelo = ?, color = ?, precio= ? , cantidad = ? WHERE id = ? ";

        try (Connection connection = Conexion.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setString(1, nuevaMarca);
            preparedStatement.setString(2, nuevoModelo);
            preparedStatement.setString(3, nuevoColor);
            preparedStatement.setDouble(4, nuevoPrecio);
            preparedStatement.setInt(5, nuevaCantidad);
            preparedStatement.setInt(6, id);

            preparedStatement.executeUpdate();
            System.out.println("Bicicleta Editada correctamente.");

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
