package com.fatec.bluds.api.infra.exceptions.Usuario;

public class UsuarioNotFoundException extends RuntimeException {

    public UsuarioNotFoundException() { super("Não foi possível encontrar o usuário"); }

    public UsuarioNotFoundException(String message) { super(message); }
}
