package com.mx.development.cometa.tools;

import com.mx.development.cometa.entity.Empleado;

import java.util.Optional;

public class Util {

    static public Optional<Empleado> cloneEmpleado(Empleado empleado) {
        /*if (empleado.getNombre() == null || empleado.getNombre().isEmpty()
                || empleado.getApellidoPaterno() == null || empleado.getApellidoPaterno().isEmpty()
                || empleado.getApellidoMaterno() == null || empleado.getApellidoMaterno().isEmpty() ) {
            Optional<Empleado> empleadoOptional = Optional.of(empleado);
            return empleadoOptional;
        }
*/
        //si todo está en orden y no hay errores de validación.
        Empleado clonedEmpleado = new Empleado();
        clonedEmpleado.setNombre(empleado.getNombre());
        clonedEmpleado.setApellidoMaterno(empleado.getApellidoMaterno());
        clonedEmpleado.setApellidoPaterno(empleado.getApellidoPaterno());
        Optional<Empleado> empleadoOptional = Optional.of(clonedEmpleado);
        return empleadoOptional;
    }

}
