package servicio;

import modelo.*;

import java.util.ArrayList;

public class EmpleadoServicio {

    private ArrayList<Empleado> lista = new ArrayList<>();

    public void agregarEmpleado(Empleado empleado) {

        for (Empleado e : lista) {
            if (e.getCedula().equals(empleado.getCedula())) {
                System.out.println("Error: cédula duplicada.");
                return;
            }
        }

        lista.add(empleado);
        System.out.println("Empleado registrado correctamente.");
    }

    public void mostrarEmpleados() {

        if (lista.isEmpty()) {
            System.out.println("No existen registros.");
            return;
        }

        for (Empleado e : lista) {
            e.mostrarInformacion();
        }
    }

    public Empleado buscarPorCedula(String cedula) {

        for (Empleado e : lista) {
            if (e.getCedula().equals(cedula)) {
                return e;
            }
        }

        return null;
    }

    public void eliminarEmpleado(String cedula) {

        Empleado encontrado = buscarPorCedula(cedula);

        if (encontrado != null) {
            lista.remove(encontrado);
            System.out.println("Registro eliminado.");
        } else {
            System.out.println("Empleado no encontrado.");
        }
    }

    public void reemplazarEmpleado(String cedula, Empleado nuevoEmpleado) {

        for (int i = 0; i < lista.size(); i++) {

            if (lista.get(i).getCedula().equals(cedula)) {

                lista.set(i, nuevoEmpleado);

                System.out.println("Información reemplazada.");
                return;
            }
        }

        System.out.println("Empleado no encontrado.");
    }

    public void calcularPagos() {

        for (Empleado e : lista) {
            System.out.println(e.getNombre() +
                    " -> $" + e.calcularPago());
        }
    }

    public void mostrarEstadisticas() {

        int totalMedicos = 0;
        int totalAdministrativos = 0;

        double pagoMedicos = 0;
        double pagoAdministrativos = 0;

        Empleado mayor = null;

        for (Empleado e : lista) {

            if (e instanceof Medico) {
                totalMedicos++;
                pagoMedicos += e.calcularPago();
            }

            if (e instanceof Administrativo) {
                totalAdministrativos++;
                pagoAdministrativos += e.calcularPago();
            }

            if (mayor == null ||
                    e.calcularPago() > mayor.calcularPago()) {
                mayor = e;
            }
        }

        System.out.println("Total médicos: " + totalMedicos);
        System.out.println("Total administrativos: " + totalAdministrativos);
        System.out.println("Total empleados: " + lista.size());

        System.out.println("Pago total médicos: " + pagoMedicos);
        System.out.println("Pago total administrativos: " + pagoAdministrativos);

        if (mayor != null) {
            System.out.println("Empleado con mayor ingreso: "
                    + mayor.getNombre()
                    + " -> $" + mayor.calcularPago());
        }
    }
}