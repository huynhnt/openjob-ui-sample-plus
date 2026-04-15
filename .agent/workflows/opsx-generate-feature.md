---
description: Sinh code feature mới dựa trên Base Knowledge đã được học từ project, đảm bảo đúng structure, convention và architecture.
---

# 🎯 Mục đích

Workflow này dùng để:

- Sinh code cho **feature mới**
- Dựa trên:
  - Base Knowledge (`.agent/knowledge/`)
  - Coding standards của project
  - Architecture hiện tại

👉 Đảm bảo:
- Code đúng style project
- Không phá vỡ kiến trúc
- Reuse pattern sẵn có

---

# ⚙️ Khi nào dùng

Sử dụng khi:

- Cần build feature mới
- Viết API mới
- Thêm logic xử lý (service/job/worker)

---

# 🚀 Cách sử dụng

User nhập:
/opsx-generate-feature


Hoặc mô tả:

- "Tạo API X"
- "Thêm job xử lý Y"
- "Viết service cho nghiệp vụ Z"

---

# 🧠 Luồng xử lý

## 🔹 Bước 1: Thu thập yêu cầu

AI sẽ hỏi (nếu thiếu thông tin):

- Tên feature
- Mục tiêu business
- Input / Output
- Có cần API không?
- Có liên quan DB / Redis / MQ không?

---

## 🔹 Bước 2: Load Knowledge (BẮT BUỘC)

Đọc:
.agent/knowledge/


Bao gồm:

- `project_structure.md`
- `architecture.md`
- `domain_model.md`
- `infrastructure.md`
- `libraries.md`
- `coding_standards.md`
- `code_templates.md`
- `anti_patterns.md`
``` id="load-knowledge-block"

---

## 🔹 Bước 3: Xác định vị trí code

Dựa vào `project_structure.md`:

- Controller đặt ở đâu?
- Service ở đâu?
- Repository ở đâu?
- Nếu multi-module:
  - server / worker / common?

---

## 🔹 Bước 4: Áp dụng Coding Standards

BẮT BUỘC tuân thủ:

- API format
- Exception handling
- Logging format
- Naming convention

👉 Không được:
- Tự ý tạo pattern mới
- Viết khác style project

---

## 🔹 Bước 5: Áp dụng Architecture

Dựa vào `architecture.md`:

### Nếu là Distributed System:

- Phân biệt:
  - Master / Worker
- Nếu là job:
  - tạo handler đúng pattern
- Nếu async:
  - dùng Redis / MQ theo project

---

## 🔹 Bước 6: Thiết kế Domain Logic

Dựa vào `domain_model.md`:

- Xác định entity liên quan
- Quan hệ dữ liệu
- Flow xử lý

---

## 🔹 Bước 7: Generate Code (QUAN TRỌNG)

Sinh code theo template:

- Controller
- Service
- Repository
- DTO

👉 Bắt buộc:
- Dùng `code_templates.md`
- Không invent structure mới

---

## 🔹 Bước 8: Kiểm tra Anti-pattern

So sánh với:
anti_patterns.md


👉 Tránh:

- duplicate logic
- hardcode config
- sai logging
- thiếu transaction

---

## 🔹 Bước 9: Kiểm tra Dependency

Dựa vào:
libraries.md



👉 Không được:
- import thư viện ngoài nếu project chưa dùng

---

## 🔹 Bước 10: Output

Trả về:

### 📦 Code hoàn chỉnh:

- File Controller
- File Service
- File Repository
- DTO / Model

### 📄 Kèm theo:

- Giải thích ngắn:
  - Flow xử lý
  - Vì sao đặt ở module đó

---

# ⚡ Mode

- `simple` → chỉ generate code
- `full` → generate + giải thích + flow (default)

---

# 🔒 Guardrails

- Không phá vỡ structure project
- Không tạo layer mới nếu không cần
- Không dùng lib ngoài
- Không viết code trái coding standard

---

# 🧠 Smart Rules

Nếu phát hiện:

- Có job / worker pattern  
→ generate theo kiểu distributed  

Nếu có Redis / MQ:  
→ ưu tiên async  

---

# 🏁 Kết quả

Sau khi chạy:

- Code:
  - đúng style
  - đúng kiến trúc
  - đúng vị trí
- Có thể merge vào project ngay

---

# 🔥 Gợi ý nâng cao

Có thể kết hợp với:

- `/opsx-init-knowledge` → học project
- `/opsx-refactor-standardize` → chuẩn hóa code

---

# ✅ END
