package com.akira.tarefas_api.exception;

public class TarefaNaoEncontrada extends RuntimeException{

    public TarefaNaoEncontrada(String message) {
        super(message);
    }
}
