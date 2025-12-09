package com.mogu34.service;

import com.mogu34.dto.TodoDto;
import com.mogu34.entity.Todo;
import com.mogu34.repository.TodoRepository;

import java.util.ArrayList;
import java.util.List;

public class TodoServiceImpl implements TodoService {

    // Service, Repository'ye muhtaçtır. Ona iş yaptırır.
    private final TodoRepository todoRepository;

    // CONSTRUCTOR INJECTION (Bağımlılık Enjeksiyonu)
    // Spring Boot'ta buraya @Autowired yazacaktık.
    // Şimdi manuel olarak "Bana bir repository ver, çalışayım" diyoruz.
    public TodoServiceImpl(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    @Override
    public void addTodo(TodoDto todoDto) {
        // 1. VALIDATION (Doğrulama)
        // Kullanıcı boş bir görev gönderirse kaydetme, hata ver.
        if (todoDto.getContent() == null || todoDto.getContent().trim().isEmpty()) {
            System.out.println("HATA: Görev içeriği boş olamaz!");
            return; // Metodu burada kes.
        }

        // 2. MAPPING (DTO -> Entity Çevrimi)
        // Veritabanı sadece 'Todo' anlar, 'TodoDto' anlamaz. Çevirmemiz lazım.
        Todo todo = new Todo();
        // ID ataması yapmıyoruz, gerçek DB'lerde otomatik artar.
        // Simülasyon için rastgele bir ID uyduracağız (veya basitçe şimdilik System.currentTimeMillis() kullanalım)
        todo.setId(System.currentTimeMillis());
        todo.setContent(todoDto.getContent());
        todo.setCompleted(todoDto.isCompleted());

        // 3. PERSISTENCE (Kaydetme)
        todoRepository.save(todo);
        System.out.println("Service: Görev başarıyla eklendi.");
    }

    @Override
    public List<TodoDto> getAllTodos() {
        List<Todo> entities = todoRepository.findAll();
        List<TodoDto> dtos = new ArrayList<>();

        for (Todo entity : entities) {
            TodoDto dto = new TodoDto();

            // --- YENİ EKLENEN SATIR ---
            dto.setId(entity.getId()); // Entity'deki ID'yi al, DTO'ya koy.
            // ---------------------------

            dto.setContent(entity.getContent());
            dto.setCompleted(entity.isCompleted());
            dtos.add(dto);
        }
        return dtos;
    }

    @Override
    public void completeTodo(Long id) {
        // 1. Görevi bul
        Todo todo = todoRepository.findById(id);

        if (todo != null) {
            // 2. İş Mantığı: Durumu true yap
            todo.setCompleted(true);
            System.out.println("Service: Görev tamamlandı -> ID: " + id);
            // Not: Gerçek DB olsaydı burada todoRepository.save(todo) diyip güncellemeliydik.
            // Bizim listemiz referans tuttuğu için otomatik güncellenmiş gibi olur.
        } else {
            System.out.println("Service: Hata! ID bulunamadı: " + id);
        }
    }
}