package com.mogu34.repository;

import com.mogu34.entity.Todo;
import java.util.ArrayList;
import java.util.List;

// 'implements TodoRepository' diyerek sözleşmeyi imzalıyoruz.
// Java bize kızacak: "Sözleşmedeki metotları yazmadın!" diye.
// Ampul simgesine tıklayıp "Implement methods" diyebilirsin veya elle yazabilirsin.
public class TodoRepositoryImpl implements TodoRepository {

    // VERİTABANI SİMÜLASYONU
    // Gerçek bir DB olmadığı için verileri bu listede tutacağız.
    // 'static' yaptık ki her yerden aynı listeye erişilsin (Ortak Havuz).
    private static List<Todo> todoList = new ArrayList<>();

    @Override
    public void save(Todo todo) {
        todoList.add(todo); // Listeye ekle (INSERT işlemi)
        System.out.println("Repository: Görev veritabanına kaydedildi -> " + todo.getContent());
    }

    @Override
    public List<Todo> findAll() {
        return todoList; // Listenin tamamını döndür (SELECT * işlemi)
    }

    @Override
    public Todo findById(Long id) {
        // Listeyi tek tek gez (For-Each Döngüsü)
        for (Todo todo : todoList) {
            // Eğer aranan ID ile sıradaki görevin ID'si eşleşirse
            if (todo.getId().equals(id)) {
                return todo; // Buldum, gönder.
            }
        }
        return null; // Bulamazsam null (boş) dön.
    }

    @Override
    public void deleteById(Long id) {
        // Silinecek görevi önce bulmamız lazım
        Todo silinecekTodo = findById(id);

        if (silinecekTodo != null) {
            todoList.remove(silinecekTodo); // Listeden sil (DELETE işlemi)
            System.out.println("Repository: Görev silindi -> " + id);
        } else {
            System.out.println("Repository: Silinecek görev bulunamadı!");
        }
    }
}