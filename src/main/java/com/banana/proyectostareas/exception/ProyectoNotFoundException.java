package com.banana.proyectostareas.exception;

public class ProyectoNotFoundException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public ProyectoNotFoundException(String message) {
        super(message);
    }

    public ProyectoNotFoundException(Long proyectoId) {
        super("Proyecto with id: " + proyectoId + " not found");
    }

}
