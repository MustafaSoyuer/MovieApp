# User entitysi için bütün katmanları ekleyelim
# Crud metotlarının ortak üretildiği bir yapı kuralım. (ICrudService)

# userservice register metodu yazalım. (register -> name,surname,email,password, repassword)
# şimdilik metodun gövdesini builder ile dolduralım
# password ile rePasswordun kontrolünü yapalım.

# Bir login metodu yazalım. Repository de e mail ve şifreye göre kullanıcı dönen bir metot yazılması gerekmektedir. 
# Veritabanında bu kullanıcı var ise sisteme giriş yapabiliyor olmalıyım.

# login metodunu Dto ile tekrar yazalım ->loginDto()

# ödev Commit-1
## 1- Kullanıcıları ismine göre sıralayan bir metot yazınız.
## 2- Kullanıcının girdiği bir isimle veritabanındaki bir ismin var olup olmadığını karşılaştırınız.
## 3- Kullanıcının isim sorgulaması için girdiği harf veya kelimeye göre veritabanında sorgu yapan bir metot yazınız.
## 4- Kullanıcının girdiği email'e göre veritabanında sorgu yapan bir metot yazınız.