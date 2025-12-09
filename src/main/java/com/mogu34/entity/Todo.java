package com.mogu34.entity;

// Bu sınıf, veritabanındaki "Todo" tablosunun Java karşılığıdır.
public class Todo {

    // 1. FIELD'LAR (Alanlar): Verinin özellikleridir.
    // 'private' yaparak dış dünyadan koruyoruz (Encapsulation).
    // Sadece bu sınıfın içinden erişilebilirler.
    private Long id;              // Görevin benzersiz kimliği (Örn: 1, 2, 3)
    private String content;       // Görevin içeriği (Örn: "Java çalış")
    private boolean isCompleted;  // Tamamlandı mı? (True/False)

    // 2. CONSTRUCTORS (Yapıcı Metotlar):
    // Sınıftan yeni bir nesne (object) üretilirken çalışan ilk metottur.

    // Boş Constructor (Parametresiz)
    // Çoğu framework (Spring, Hibernate) bu boş yapıcıya ihtiyaç duyar.
    public Todo() {
    }

    // Dolu Constructor (Veri girişi kolay olsun diye)
    public Todo(Long id, String content, boolean isCompleted) {
        this.id = id;
        this.content = content;
        this.isCompleted = isCompleted;
    }

    // 3. GETTER & SETTER (Erişim Yöntemleri):
    // Private değişkenlere dışarıdan güvenli şekilde ulaşmak için kapılar açıyoruz.

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public boolean isCompleted() {
        return isCompleted;
    }

    public void setCompleted(boolean completed) {
        isCompleted = completed;
    }

    // 4. TOSTRING (Yazdırma Formatı):
    // Bu nesneyi ekrana yazdırdığında (System.out.println) saçma sapan adresler yerine
    // anlamlı veri görmek için bu metodu "Override" (ezmek) ederiz.
    @Override
    public String toString() {
        return "Todo{" +
                "id=" + id +
                ", content='" + content + '\'' +
                ", isCompleted=" + isCompleted +
                '}';
    }
}