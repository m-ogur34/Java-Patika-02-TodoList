package com.mogu34.dto;

public class TodoDto {

    // YENİ ALAN: ID bilgisini de taşıyacağız
    private Long id;
    private String content;
    private boolean isCompleted;

    public TodoDto() {
    }

    // Constructor'ı güncelleyelim (veya elle set edebiliriz, şart değil)
    public TodoDto(Long id, String content, boolean isCompleted) {
        this.id = id;
        this.content = content;
        this.isCompleted = isCompleted;
    }

    // --- Getter ve Setter ---

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    // Diğer getter/setterlar aynı kalabilir...
    public String getContent() { return content; }
    public void setContent(String content) { this.content = content; }
    public boolean isCompleted() { return isCompleted; }
    public void setCompleted(boolean completed) { isCompleted = completed; }
}