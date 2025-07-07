package com.akira.tarefas_api.service;

import com.akira.tarefas_api.exception.TarefaNaoEncontrada;
import com.akira.tarefas_api.model.Tarefa;
import com.akira.tarefas_api.repository.TarefaRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class TarefaService {

    private final TarefaRepository tarefaRepository;

    public TarefaService(TarefaRepository tarefaRepository) {
        this.tarefaRepository = tarefaRepository;
    }

    public List<Tarefa> listarTarefas() {
        return tarefaRepository.findAll();
    }

    public Tarefa buscarPorId(Long id) {
        return tarefaRepository.findById(id)
                .orElseThrow(() -> new TarefaNaoEncontrada("Tarefa com Id" + id + "não encontrado!"));
    }

    public Tarefa salvarTarefa(Tarefa tarefa) {
        return tarefaRepository.save(tarefa);
    }

    public void deletarTarefa(Long id) {
        if(!tarefaRepository.existsById(id)) {
            throw new TarefaNaoEncontrada("Tarefa com o ID "+id+" não encontrado!");
        }
        tarefaRepository.deleteById(id);
    }
}
