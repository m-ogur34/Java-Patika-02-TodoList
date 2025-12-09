package com.mogu34.repository;

import com.mogu34.entity.Todo;
import java.util.List;

// Interface: Yapılacak işlerin listesidir (Sözleşme).
// Gövdesi boştur. Uygulayan sınıf (Impl) bu kurallara uymak ZORUNDADIR.
public interface TodoRepository {

    // Veritabanına yeni bir görev kaydet
    void save(Todo todo);

    // Tüm görevleri getir
    List<Todo> findAll();

    // ID'ye göre tek bir görevi bul (Detay görüntüleme için)
    Todo findById(Long id);

    // Bir görevi sil
    void deleteById(Long id);
}