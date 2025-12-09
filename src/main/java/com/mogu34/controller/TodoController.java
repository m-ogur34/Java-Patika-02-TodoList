package com.mogu34.controller;

import com.mogu34.dto.TodoDto;
import com.mogu34.service.TodoService;

import java.util.List;
import java.util.Scanner;

public class TodoController {

    // Controller, işi yapması için Service'e muhtaçtır.
    private final TodoService todoService;
    private final Scanner scanner;

    // CONSTRUCTOR INJECTION
    // Controller oluşturulurken ona bir Service verilmek zorundadır.
    public TodoController(TodoService todoService) {
        this.todoService = todoService;
        this.scanner = new Scanner(System.in);
    }

    // Uygulamayı başlatan ve menüyü gösteren metot
    public void start() {
        boolean isRunning = true;

        while (isRunning) {
            menuGoster();
            int secim = secimAl();

            switch (secim) {
                case 1:
                    yeniGorevEkle();
                    break;
                case 2:
                    gorevleriListele();
                    break;
                case 3:
                    gorevTamamla();
                    break;
                case 0:
                    System.out.println("Çıkış yapılıyor...");
                    isRunning = false;
                    break;
                default:
                    System.out.println("Hatalı seçim!");
            }
        }
    }

    private void menuGoster() {
        System.out.println("\n=== YAPILACAKLAR LİSTESİ (TODO APP) ===");
        System.out.println("1. Yeni Görev Ekle");
        System.out.println("2. Görevleri Listele");
        System.out.println("3. Görev Tamamla");
        System.out.println("0. Çıkış");
        System.out.print("Seçiminiz: ");
    }

    private int secimAl() {
        try {
            return Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            return -1;
        }
    }

    // --- SERVICE İLE KONUŞAN METOTLAR ---

    private void yeniGorevEkle() {
        System.out.print("Görev İçeriği: ");
        String icerik = scanner.nextLine();

        // Veriyi DTO paketine koyuyoruz
        TodoDto yeniGorev = new TodoDto();
        yeniGorev.setContent(icerik);
        yeniGorev.setCompleted(false);

        // Paketi Service'e gönderiyoruz (Garson siparişi mutfağa veriyor)
        todoService.addTodo(yeniGorev);
    }

    private void gorevleriListele() {
        System.out.println("\n--- GÖREV LİSTESİ ---");
        List<TodoDto> gorevler = todoService.getAllTodos();

        if (gorevler.isEmpty()) {
            System.out.println("Listeniz boş!");
        } else {
            for (TodoDto gorev : gorevler) {
                String durum = gorev.isCompleted() ? "[X]" : "[ ]";

                // GÜNCELLEME: ID bilgisini başa ekledik
                // Örn Çıktı: 1533221 [ ] Java Çalış
                System.out.println(gorev.getId() + "\t" + durum + " " + gorev.getContent());
            }
        }
    }

    private void gorevTamamla() {
        System.out.print("Tamamlanacak Görev ID'si (Simülasyon olduğu için ID bilmen lazım): ");
        // Not: Gerçek uygulamada önce listeyi ID ile basarız, kullanıcı oradan seçer.
        // Şimdilik test amaçlı rastgele bir ID veya listedeki sırayı kullanabiliriz.
        // Basitlik adına kullanıcıdan ID isteyelim.
        try {
            Long id = Long.parseLong(scanner.nextLine());
            todoService.completeTodo(id);
        } catch (NumberFormatException e) {
            System.out.println("Geçersiz ID formatı.");
        }
    }
}