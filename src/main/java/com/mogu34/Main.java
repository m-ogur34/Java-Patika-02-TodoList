package com.mogu34;

import com.mogu34.controller.TodoController;
import com.mogu34.repository.TodoRepository;
import com.mogu34.repository.TodoRepositoryImpl;
import com.mogu34.service.TodoService;
import com.mogu34.service.TodoServiceImpl;

public class Main {
    public static void main(String[] args) {

        // 1. ADIM: Bağımlılıkları Oluştur (Dependency Injection)

        // Önce veritabanı bağlantısı (Repository) oluşturulur
        TodoRepository repository = new TodoRepositoryImpl();

        // Service, çalışmak için Repository'ye ihtiyaç duyar. Onu içine enjekte ediyoruz.
        TodoService service = new TodoServiceImpl(repository);

        // Controller, çalışmak için Service'e ihtiyaç duyar. Onu içine enjekte ediyoruz.
        TodoController controller = new TodoController(service);

        // 2. ADIM: Uygulamayı Başlat
        controller.start();
    }
}