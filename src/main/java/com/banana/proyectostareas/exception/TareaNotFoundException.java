package com.banana.proyectostareas.exception;

public class TareaNotFoundException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public TareaNotFoundException(String message) {
        super(message);
    }

    public TareaNotFoundException(Long tareaId) {
        super("Tarea with id: " + tareaId + " not found");
    }
}
