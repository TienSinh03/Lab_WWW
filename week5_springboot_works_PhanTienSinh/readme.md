# Week-5

## Mô tả dự án
Ứng dụng này là một cổng thông tin việc làm nơi các công ty có thể đăng tuyển dụng và ứng viên có thể nộp đơn xin việc. Nó bao gồm các tính năng như đăng tuyển, quản lý hồ sơ ứng viên, xin việc và giới thiệu công việc dựa trên kỹ năng của ứng viên.

## Công nghệ được sử dụng
- Java: Dự án được viết bằng Java, một ngôn ngữ lập trình hướng đối tượng, dựa trên lớp, cấp cao phổ biến.
- Spring Boot: Dự án này sử dụng Spring Boot, là một framework mã nguồn mở dựa trên Java được sử dụng để tạo các ứng dụng dựa trên Spring cấp độ sản xuất, độc lập.
- Gradle: Gradle được sử dụng làm công cụ xây dựng cho dự án này. Nó giúp tự động hóa việc xây dựng, thử nghiệm, xuất bản, triển khai và nhiều gói phần mềm hoặc các loại dự án khác.

## Cách sử dụng
Khi ứng dụng đang chạy, bạn có thể truy cập giao diện web bằng cách điều hướng đến `http://localhost:8080` trong trình duyệt web của bạn.  

## Diagram

![Screenshot 2024-11-26 204805](https://github.com/user-attachments/assets/75081f19-dfce-44d4-ba6f-8407ca29415d)

## Lưu ý
- Cài đặt dependency email
  ```
  implementation 'org.springframework.boot:spring-boot-starter-mail'
  ```
  
- Thiết lập `resources/application.properties`

   ```
    spring.application.name=week5_springboot_jobseeking
    spring.datasource.driver-class-name=org.mariadb.jdbc.Driver
    spring.datasource.url=jdbc:mariadb://localhost:3306/works_detai_www
    spring.datasource.username=root
    spring.datasource.password=<your_password>
   
    spring.jpa.show-sql=true
    spring.jpa.hibernate.ddl-auto=update
    spring.jpa.generate-ddl=true

    // config jackson
    spring.jackson.serialization.write-dates-as-timestamps=false
    spring.jackson.default-property-inclusion=NON_NULL

    // config email
    spring.mail.host=smtp.gmail.com
    spring.mail.port=587
    spring.mail.username=<your email>
    spring.mail.password=<your passowrd>
    spring.mail.properties.mail.smtp.auth=true
    spring.mail.properties.mail.smtp.starttls.enable=true   
   ```

## Minh chứng 
### 1. Truy cập trang chủ với đường link: `http://localhost:8080`
   
 ![Screenshot 2024-11-26 210544](https://github.com/user-attachments/assets/5fd020e3-5589-4eb4-829a-6b3f7ce1315a)
  
### 2. Login được phân quyền bởi role candidate và company
    
![login](https://github.com/user-attachments/assets/6048f562-bc09-4adb-a270-d914e3eec0b8)

### 3. Cho phép công ty đăng tin tuyển người với các skill mong muốn

![addJob](https://github.com/user-attachments/assets/7a0cf199-28b4-4f84-8b7e-1dc3f06b9ac2)

### 4. Các ứng viên khi log vào sẽ được gợi ý các công việc có skill phù hợp với mình

![Screenshot 2024-11-26 211403](https://github.com/user-attachments/assets/61adb323-d79d-44cb-9d1a-8f031d4363df)

### 5. Giúp các công ty tìm các ứng viên có skill phù hợp rồi gửi mail mời.

![sendemail](https://github.com/user-attachments/assets/dc7680a8-b0bf-4dc1-87fd-5004ded6f2ed)

### 6. Đề xuất một số skill mà ứng viên chưa có để học. 

![Screenshot 2024-11-26 212155](https://github.com/user-attachments/assets/c39d3d2c-f23b-477b-87b2-4563567ba83f)




