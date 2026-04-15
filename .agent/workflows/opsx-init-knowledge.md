---
description: Khởi tạo Base Knowledge (Cấu trúc, Tiêu chuẩn code, Thư viện) từ dự án cũ
---

# 🎯 Mục đích

Workflow này dùng để:

- Phân tích một dự án mã nguồn (Java/Spring Boot, Distributed System, v.v.)
- Trích xuất:
  - Cấu trúc project
  - Kiến trúc hệ thống
  - Domain model
  - Coding standards
  - Infrastructure
- Sinh ra **Base Knowledge** cho AI sử dụng về sau

👉 Giúp AI:
- Code đúng style project
- Không dùng sai thư viện
- Follow đúng kiến trúc hệ thống

---

# ⚙️ Khi nào dùng

Sử dụng khi:

- Bắt đầu làm việc với **project mới từ Github**
- Onboard vào **project legacy**
- Muốn AI hiểu project trước khi generate code

---

# 🚀 Cách sử dụng

User chạy:
/opsx-init-knowledge


Hoặc:

- "Phân tích project này"
- "Khởi tạo base knowledge cho repo này"

---

# 🧠 Luồng xử lý

## 🔹 Bước 1: Gọi Skill

Gọi:

- `openspec-init-knowledge`

Skill sẽ tự động:

- Scan source code
- Phân tích toàn diện project

---

## 🔹 Bước 2: Deep Analysis (tự động)

Skill sẽ thực hiện:

### 1. Detect Project Type
- Monolith / Microservice / Distributed System
- Multi-module hay không

### 2. Dependency Analysis
- Framework chính (Spring Boot, v.v.)
- ORM, Messaging, Cache
- Version & scope

### 3. Architecture Analysis
- Pattern:
  - Master-Worker
  - Event-driven
  - Scheduler

### 4. Project Structure
- Controller / Service / Repository
- Config / Module

### 5. Domain Model
- Entity chính
- Quan hệ

### 6. Infrastructure
- Redis / DB / MQ usage

### 7. Coding Standards
- API format
- Exception handling
- Logging
- Naming convention

### 8. Anti-pattern Detection
- Code smell
- Duplicate logic
- Hardcode config

### 9. Code Template Generation
- Controller
- Service
- Repository
- DTO

---

## 🔹 Bước 3: Sinh Knowledge Base

Tự động tạo:

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

## 🔹 Bước 4: Báo cáo kết quả

AI sẽ trả về:

- Kiến trúc hệ thống
- Framework chính
- Pattern đặc biệt
- Anti-pattern
- Confidence level

---

## 🔹 Bước 5: Xác nhận từ User

AI hỏi lại:

- Có cần refine coding standard không?
- Có muốn áp dụng rule nội bộ không?

---

# ⚡ Mode hoạt động

Workflow hỗ trợ:

- `quick` → scan nhanh
- `deep` → scan toàn diện (default)

---

# 🧠 Smart Rules

Nếu phát hiện:

- job / worker / scheduler  
→ tự động classify là **distributed system**  
→ chuyển sang `deep mode`

---

# 🔒 Quy tắc an toàn

- Không chỉnh sửa source code (READ-ONLY)
- Không áp đặt best practice nếu project không dùng
- Luôn ưu tiên pattern từ code thực tế

---

# 🏁 Kết quả mong đợi

Sau khi chạy workflow:

- AI hiểu rõ:
  - Structure
  - Architecture
  - Coding style
- Có thể:
  - Generate code chuẩn project
  - Maintain consistency
  - Reuse pattern sẵn có

---

# 🔥 Gợi ý workflow tiếp theo

Sau khi hoàn thành:

👉 Nên chạy tiếp:

- `/opsx-generate-feature` → sinh code theo knowledge
- `/opsx-refactor-standardize` → chuẩn hóa code cũ

---

# ✅ END