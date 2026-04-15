---
name: openspec-init-knowledge
description: Phân tích sâu dự án mã nguồn và sinh Base Knowledge (structure, architecture, coding standards, templates) giúp AI code đúng chuẩn project.
license: MIT
metadata:
  author: AI Workflows
  version: "2.0-production"
---

# 🎯 Mục tiêu
Skill này dùng để phân tích một dự án mã nguồn (đặc biệt Java/Spring Boot, Distributed System) và sinh ra **Base Knowledge chuẩn production** để AI hiểu và code đúng theo style + kiến trúc thực tế của dự án.

---

# ⚙️ Trigger

User sử dụng:
/opsx-init-knowledge


Hoặc yêu cầu: *"phân tích project và tạo base knowledge"*

---

# 🧠 Tổng quan pipeline

1. Detect project root & type  
2. Scan dependency & framework  
3. Phân tích kiến trúc (architecture)  
4. Phân tích cấu trúc project  
5. Phân tích domain model  
6. Phân tích infrastructure  
7. Extract coding standards (pattern-based)  
8. Detect anti-pattern  
9. Generate code templates  
10. Build knowledge base  
11. Report + xác nhận user  

---

# 🔍 STEP 0: Detect Project Entry (BẮT BUỘC)

- Tìm file:
  - `pom.xml`, `build.gradle`, `settings.gradle`
- Nếu multi-module:
  - Xác định module chính (server/backend)
  - Phân loại module:
    - server
    - worker/client
    - common/shared
    - ui/frontend

### 🚫 Bỏ qua:
- `.git`
- `node_modules`
- `dist`, `build`, `target`

---

# 🔍 STEP 1: Dependency & Framework Analysis

Phân tích từ:
- `pom.xml`
- `build.gradle`
- `package.json`

### 📌 Phân loại:

- Core Framework (Spring Boot, Spring Cloud)
- ORM (JPA, Hibernate, MyBatis)
- Messaging (Kafka, RabbitMQ)
- Cache (Redis)
- Utility (Lombok, MapStruct)
- Internal modules

### 📌 Ghi nhận:
- version
- scope
- mục đích sử dụng

---

# 🏗 STEP 2: Architecture Detection (QUAN TRỌNG)

Phân tích để xác định:

- Monolith / Microservices / Distributed System
- Pattern:
  - Master-Worker
  - Event-driven
  - Scheduler

### 📌 Output:
`.agent/knowledge/architecture.md`

---

# 🗂 STEP 3: Project Structure

- Scan toàn bộ thư mục
- Xác định:
  - controller
  - service
  - repository
  - config

### 📌 Output:
`.agent/knowledge/project_structure.md`

---

# 🧩 STEP 4: Domain Model Extraction

- Xác định entity chính:
  - Job / Task / User / Transaction ...
- Phân tích quan hệ giữa các entity

### 📌 Output:
`.agent/knowledge/domain_model.md`

---

# ⚙️ STEP 5: Infrastructure Analysis

Phân tích:

- Redis dùng làm gì
- Database dùng để lưu gì
- Messaging (Kafka/RabbitMQ) nếu có

### 📌 Output:
`.agent/knowledge/infrastructure.md`

---

# 📏 STEP 6: Coding Standards (Pattern-based)

### 📌 Sampling rule:

- 5 Controller
- 5 Service
- 3 Repository

Nếu project nhỏ → lấy toàn bộ

### 📌 Phân tích:

- API response format
- Exception handling
- Logging
- Naming convention

### 📌 Multi-module:

Tách riêng:

- `coding_standard_server.md`
- `coding_standard_worker.md`

---

# ⚠️ STEP 7: Anti-pattern Detection

Phát hiện:

- duplicate logic
- hardcode config
- thiếu transaction
- logging không thống nhất

### 📌 Output:
`.agent/knowledge/anti_patterns.md`

---

# 🧱 STEP 8: Code Templates (QUAN TRỌNG NHẤT)

Sinh template chuẩn:

- Controller
- Service
- Repository
- DTO

### 📌 Output:
`.agent/knowledge/code_templates.md`

---

# 📚 STEP 9: Build Knowledge Base

Tạo cấu trúc:

.agent/knowledge/
│
├── project_structure.md
├── architecture.md
├── domain_model.md
├── infrastructure.md
├── libraries.md
├── coding_standards.md
├── coding_standard_server.md
├── coding_standard_worker.md
├── code_templates.md
├── anti_patterns.md


---

# 📊 STEP 10: Confidence Level

Đánh giá:

- High → pattern rõ ràng
- Medium → có khác biệt
- Low → code không nhất quán

---

# 📢 STEP 11: Report cho User

Báo cáo:

- Kiến trúc chính
- Framework chính
- Pattern đặc biệt
- Anti-pattern
- Confidence level

Hỏi user:

- Có muốn refine standard không?
- Có muốn override theo guideline nội bộ không?

---

# 🔒 Guardrails

- READ-ONLY (không sửa code)
- Không áp đặt best practice nếu project không dùng
- Luôn ưu tiên pattern từ source code thực tế

---

# ⚡ Mode

- `quick` → scan nhanh
- `deep` → scan toàn diện (default cho distributed system)

---

# 🧠 Smart Detection Rules

Nếu phát hiện:

- job / worker / scheduler  
→ classify: distributed system  
→ bật deep scan  

---

# 🏁 Kết quả

Sau khi chạy skill, AI có thể:

- Code đúng style project
- Không import thư viện lạ
- Follow đúng architecture
- Reuse pattern chuẩn

---

# 🔥 Notes

Skill này tối ưu cho:

- Java + Spring Boot
- Distributed system
- Enterprise backend

---