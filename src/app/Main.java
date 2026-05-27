package app;

import modelo.*;
import servicio.EmpleadoServicio;
import util.Validador;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        EmpleadoServicio servicio = new EmpleadoServicio();

        int opcion = 0;

        do {

            try {

                System.out.println("\n===== CLÍNICA SALUD TOTAL =====");
                System.out.println("1. Registrar médico");
                System.out.println("2. Registrar administrativo");
                System.out.println("3. Mostrar empleados");
                System.out.println("4. Buscar por cédula");
                System.out.println("5. Reemplazar información");
                System.out.println("6. Eliminar registro");
                System.out.println("7. Calcular pagos");
                System.out.println("8. Mostrar estadísticas");
                System.out.println("9. Salir");

                System.out.print("Opción: ");

                opcion = Integer.parseInt(sc.nextLine());

                switch (opcion) {

                    case 1:

                        System.out.print("Cédula: ");
                        String cedula = sc.nextLine();

                        System.out.print("Nombre: ");
                        String nombre = sc.nextLine();

                        System.out.print("Edad: ");
                        int edad = Integer.parseInt(sc.nextLine());

                        if (!Validador.validarEdad(edad)) {
                            System.out.println("Edad inválida.");
                            break;
                        }

                        System.out.print("Teléfono: ");
                        String telefono = sc.nextLine();

                        if (!Validador.validarTelefono(telefono)) {
                            System.out.println("Teléfono inválido.");
                            break;
                        }

                        System.out.print("Correo: ");
                        String correo = sc.nextLine();

                        if (!Validador.validarCorreo(correo)) {
                            System.out.println("Correo inválido.");
                            break;
                        }

                        System.out.print("Especialidad: ");
                        String especialidad = sc.nextLine();

                        System.out.print("Pacientes atendidos: ");
                        int pacientes =
                                Integer.parseInt(sc.nextLine());

                        System.out.print("Valor consulta: ");
                        double valorConsulta =
                                Double.parseDouble(sc.nextLine());

                        Medico medico = new Medico(
                                cedula,
                                nombre,
                                edad,
                                telefono,
                                correo,
                                especialidad,
                                pacientes,
                                valorConsulta
                        );

                        servicio.agregarEmpleado(medico);

                        break;

                    case 2:

                        System.out.print("Cédula: ");
                        String cedulaA = sc.nextLine();

                        System.out.print("Nombre: ");
                        String nombreA = sc.nextLine();

                        System.out.print("Edad: ");
                        int edadA =
                                Integer.parseInt(sc.nextLine());

                        System.out.print("Teléfono: ");
                        String telefonoA = sc.nextLine();

                        System.out.print("Correo: ");
                        String correoA = sc.nextLine();

                        System.out.print("Departamento: ");
                        String departamento = sc.nextLine();

                        System.out.print("Horas trabajadas: ");
                        int horas =
                                Integer.parseInt(sc.nextLine());

                        System.out.print("Valor hora: ");
                        double valorHora =
                                Double.parseDouble(sc.nextLine());

                        Administrativo admin =
                                new Administrativo(
                                        cedulaA,
                                        nombreA,
                                        edadA,
                                        telefonoA,
                                        correoA,
                                        departamento,
                                        horas,
                                        valorHora
                                );

                        servicio.agregarEmpleado(admin);

                        break;

                    case 3:

                        servicio.mostrarEmpleados();

                        break;

                    case 4:

                        System.out.print("Ingrese cédula: ");

                        String buscar = sc.nextLine();

                        Empleado encontrado =
                                servicio.buscarPorCedula(buscar);

                        if (encontrado != null) {
                            encontrado.mostrarInformacion();
                        } else {
                            System.out.println("Registro no encontrado.");
                        }

                        break;

                    case 5:

                        System.out.println("Función reemplazar pendiente.");

                        break;

                    case 6:

                        System.out.print("Ingrese cédula: ");

                        String eliminar = sc.nextLine();

                        servicio.eliminarEmpleado(eliminar);

                        break;

                    case 7:

                        servicio.calcularPagos();

                        break;

                    case 8:

                        servicio.mostrarEstadisticas();

                        break;

                    case 9:

                        System.out.println("Saliendo...");

                        break;

                    default:

                        System.out.println("Error: opción inválida.");
                }

            } catch (NumberFormatException e) {

                System.out.println("Error: ingrese valores numéricos válidos.");

            } catch (Exception e) {

                System.out.println("Ocurrió un error.");
            }

        } while (opcion != 9);
    }
}