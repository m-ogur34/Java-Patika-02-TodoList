package com.mogu34.service;

import com.mogu34.dto.TodoDto;
import java.util.List;

public interface TodoService {

    // Yeni görev ekle (Giriş DTO, Çıkış Void)
    void addTodo(TodoDto todoDto);

    // Tüm görevleri getir (Çıkış DTO Listesi)
    // Dikkat: Entity listesi değil, DTO listesi döndürüyoruz!
    List<TodoDto> getAllTodos();

    // Görevi tamamla (ID alır)
    void completeTodo(Long id);
}