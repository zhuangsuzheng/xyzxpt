# 校园资讯平台 (Campus Information Platform)

[![License](https://img.shields.io/badge/license-MIT-blue.svg)](LICENSE)
[![Java](https://img.shields.io/badge/Java-1.8-orange.svg)](https://www.oracle.com/java/)
[![Spring Boot](https://img.shields.io/badge/Spring%20Boot-2.2.4-green.svg)](https://spring.io/projects/spring-boot)
[![Vue](https://img.shields.io/badge/Vue-2.5-brightgreen.svg)](https://vuejs.org/)
[![MySQL](https://img.shields.io/badge/MySQL-8.0-blue.svg)](https://www.mysql.com/)

> 基于 renren-fast 快速开发平台构建的校园资讯管理系统，支持前后端分离、权限控制、定时任务、云存储等功能。
>
> **毕业设计项目** | 作者：贾霄霄 | 学校：相关信息见项目说明

## ✨ 功能特性

- 🔐 **权限管理**：基于 Apache Shiro，支持角色、菜单、按钮级别权限控制
- 📊 **校园资讯管理**：新闻发布、分类、审核、展示
- 📅 **定时任务**：基于 Quartz 的动态任务调度
- 📂 **文件管理**：支持七牛云、阿里云 OSS、腾讯云 COS
- 📝 **系统日志**：操作日志记录与查询
- 🔍 **接口文档**：集成 Swagger，自动生成 API 文档
- 🔄 **代码生成**：支持在线生成 Entity、Mapper、Service、Controller、Vue 代码

## 🛠️ 技术栈

### 后端
- **核心框架**: Spring Boot 2.2.4
- **安全框架**: Apache Shiro 1.7+
- **持久层**: MyBatis-Plus 3.3
- **数据库**: MySQL 8.0 / 支持 Oracle、PostgreSQL、SQL Server
- **缓存**: Redis
- **定时任务**: Quartz 2.3
- **工具库**: Hutool、Lombok

### 前端
- **框架**: Vue 2.5 + Element UI 2.8
- **状态管理**: Vuex
- **路由**: Vue Router
- **HTTP**: Axios
- **构建**: Webpack 3

## 🚀 快速开始

### 环境要求
- JDK 1.8+
- Maven 3.6+
- MySQL 5.7+ / 8.0
- Redis
- Node.js 8.11+ & npm

### 后端启动

```bash
# 1. 创建数据库
CREATE DATABASE renren_fast DEFAULT CHARACTER SET utf8mb4;

# 2. 导入 SQL
# 执行 yykjc/db/mysql.sql

# 3. 修改配置
# 编辑 yykjc/src/main/resources/application-dev.yml 中的数据库和 Redis 配置

# 4. 启动
cd yykjc
mvn clean package
java -jar target/renren-fast.jar

# 或直接运行 RenrenApplication.java
```

访问 Swagger 文档：`http://localhost:8080/renren-fast/swagger-ui.html`

### 前端启动

```bash
cd yykjc_vue
npm install
npm run dev
```

默认账号：`admin` / `admin`

## 📁 项目结构

```
xyzxpt/
├── yykjc/                  # 后端 Spring Boot 项目
│   ├── db/                 # 数据库脚本
│   ├── src/main/java/     # Java 源码
│   └── pom.xml
├── yykjc_vue/              # 前端 Vue 项目
├── yykjc_generator/        # 代码生成器
└── README.md
```

## 🖼️ 截图预览

> 项目截图可以放在此处（建议上传至 GitHub Issues 或使用图床）

## 🛡️ 安全

本项目已更新多个高危依赖至安全版本。建议定期执行：

```bash
mvn dependency:tree
# 或使用 GitHub Dependabot 自动扫描
```

## 📝 开发规范

- 代码风格遵循阿里巴巴 Java 开发手册
- 提交信息使用 Conventional Commits
- 主分支：`master`

## 📄 许可证

本项目采用 [MIT License](LICENSE)。

## 👥 贡献

欢迎提交 Issue 和 Pull Request！

1. Fork 本仓库
2. 创建功能分支 (`git checkout -b feature/AmazingFeature`)
3. 提交更改 (`git commit -m 'Add some AmazingFeature'`)
4. 推送到分支 (`git push origin feature/AmazingFeature`)
5. 开启 Pull Request

## 📞 联系方式

- 作者：贾霄霄
- 项目维护：庄宿正
- GitHub：[@zhuangsuzheng](https://github.com/zhuangsuzheng)

---

⭐ 如果这个项目对你有帮助，请给一个 Star！
