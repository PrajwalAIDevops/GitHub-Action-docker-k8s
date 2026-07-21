# 🚀 End-to-End DevSecOps CI/CD Pipeline using GitHub Actions, Docker, Kubernetes, GitLeaks & Trivy

![GitHub Actions](https://img.shields.io/badge/GitHub_Actions-CI%2FCD-blue?logo=githubactions)
![Docker](https://img.shields.io/badge/Docker-Containerization-2496ED?logo=docker)
![Kubernetes](https://img.shields.io/badge/Kubernetes-Orchestration-326CE5?logo=kubernetes)
![GitLeaks](https://img.shields.io/badge/GitLeaks-Secrets_Scanning-green)
![Trivy](https://img.shields.io/badge/Trivy-Vulnerability_Scanning-blue)
![License](https://img.shields.io/badge/License-MIT-yellow)

---

## 📖 Overview

This project demonstrates an **end-to-end DevSecOps CI/CD pipeline** that automates the software delivery lifecycle from source code to Kubernetes deployment.

The pipeline follows DevSecOps best practices by integrating automated security scanning before deployment, ensuring that only secure container images are deployed into the Kubernetes cluster.

The entire workflow is orchestrated using **GitHub Actions**.

---

# 🏗️ Architecture

```
                Developer
                    │
                    ▼
             Push Code to GitHub
                    │
                    ▼
          GitHub Actions Triggered
                    │
        ┌───────────┴────────────┐
        ▼                        ▼
 Build Docker Image       GitLeaks Scan
        │                        │
        └──────────────┬─────────┘
                       ▼
               Trivy Image Scan
                       │
             Scan Passed Successfully
                       │
                       ▼
          Push Image to Docker Hub
                       │
                       ▼
            Deploy to Kubernetes
                       │
                       ▼
           Application Available
```

---

# 🎯 Project Objectives

- Automate Docker image creation
- Integrate CI/CD using GitHub Actions
- Detect hardcoded secrets using GitLeaks
- Scan Docker images for vulnerabilities using Trivy
- Push validated Docker images to Docker Hub
- Automatically deploy latest image to Kubernetes
- Eliminate manual deployment process

---

# ⚙️ Technology Stack

| Technology | Purpose |
|------------|----------|
| GitHub Actions | CI/CD Automation |
| Docker | Containerization |
| Docker Hub | Image Registry |
| Kubernetes | Container Orchestration |
| GitLeaks | Secret Detection |
| Trivy | Vulnerability Scanning |
| YAML | Workflow & Kubernetes Manifests |

---

# 📂 Project Structure

```
.
├── .github
│   └── workflows
│       └── ci-cd.yml
│
├── app/
│   ├── app.py
│   ├── requirements.txt
│   └── Dockerfile
│
├── kubernetes/
│   ├── deployment.yaml
│   └── service.yaml
│
├── screenshots/
│
├── README.md
│
└── LICENSE
```

---

# 🔄 CI/CD Pipeline Workflow

## 1️⃣ Source Code Push

Developer pushes changes to the **main** branch.

↓

## 2️⃣ GitHub Actions Trigger

The workflow starts automatically.

↓

## 3️⃣ Build Docker Image

GitHub Actions builds the Docker image using the Dockerfile.

```bash
docker build -t app-image .
```

↓

## 4️⃣ GitLeaks Scan

The repository is scanned for

- API Keys
- Tokens
- Passwords
- Secrets
- Credentials

Example:

```bash
gitleaks detect --redact --exit-code=1
```

If secrets are detected

❌ Pipeline Fails

↓

## 5️⃣ Trivy Scan

Docker image is scanned for

- Critical Vulnerabilities
- High Vulnerabilities
- CVEs
- Misconfigurations

Example

```bash
trivy image --exit-code 1 image-name
```

If vulnerabilities exceed policy

❌ Pipeline Stops

↓

## 6️⃣ Push Image

After passing security checks

Docker image is pushed to Docker Hub.

↓

## 7️⃣ Kubernetes Deployment

The deployment manifest pulls the latest Docker image and updates the Kubernetes deployment.

```bash
kubectl apply -f deployment.yaml
kubectl apply -f service.yaml
```

Application becomes available through Kubernetes Service.

---

# 🔐 DevSecOps Security

## GitLeaks

GitLeaks protects repositories from accidentally committed secrets.

Scans include:

- AWS Keys
- GitHub Tokens
- Database Passwords
- API Keys
- SSH Keys

Pipeline fails immediately if secrets are detected.

---

## Trivy

Trivy scans Docker images for

- OS Vulnerabilities
- Application Vulnerabilities
- Library CVEs
- Misconfigurations

Only clean images continue to deployment.

---

# 🚀 GitHub Actions Pipeline Stages

```
Checkout Repository

        ↓

Build Docker Image

        ↓

GitLeaks Scan

        ↓

Trivy Scan

        ↓

Docker Login

        ↓

Push Docker Image

        ↓

Deploy to Kubernetes
```

---

# 📸 Pipeline Execution

Example successful pipeline

```
✔ Checkout

✔ Build Docker Image

✔ GitLeaks Scan

✔ Trivy Scan

✔ Push Docker Image

✔ Kubernetes Deployment

🎉 Deployment Successful
```

---

# ☸ Kubernetes Resources

The project deploys:

- Deployment
- ReplicaSet
- Pods
- Service

Features:

- Rolling Updates
- Self Healing
- High Availability
- Auto Restart
- Image Pull from Docker Hub

---

# 📌 Key Features

- End-to-End CI/CD
- Docker Image Automation
- GitHub Actions Workflow
- Secret Detection using GitLeaks
- Vulnerability Scanning using Trivy
- Docker Hub Integration
- Kubernetes Deployment
- Rolling Updates
- Automated Delivery
- DevSecOps Best Practices

---

# 💡 Learning Outcomes

This project demonstrates practical implementation of:

- CI/CD Automation
- DevSecOps Pipeline
- Docker Containerization
- Kubernetes Deployments
- Container Security
- Secret Management
- Vulnerability Scanning
- GitHub Actions Workflow Design
- Infrastructure Automation

---

# ▶️ How to Run

## Clone Repository

```bash
git clone https://github.com/PrajwalAIDevops/GitHub-Action-docker-k8s.git

cd GitHub-Action-docker-k8s
```

---

## Build Docker Image

```bash
docker build -t app .
```

---

## Run Docker Container

```bash
docker run -d -p 5000:5000 app
```

---

## Deploy to Kubernetes

```bash
kubectl apply -f kubernetes/deployment.yaml

kubectl apply -f kubernetes/service.yaml
```

---

## Verify

```bash
kubectl get pods

kubectl get svc

kubectl get deployment
```

---

# 📈 Future Improvements

- SonarQube Integration
- OWASP Dependency Check
- ArgoCD GitOps Deployment
- Prometheus Monitoring
- Grafana Dashboards
- Slack Notifications
- Microsoft Teams Alerts
- Kubernetes Ingress
- Helm Charts
- Terraform Infrastructure

---

# 👨‍💻 Author

**Prajwal B**

DevOps | DevSecOps | Kubernetes | AWS | CI/CD | Docker | GitHub Actions

GitHub:

https://github.com/PrajwalAIDevops

---

## ⭐ Support

If you found this project useful,

⭐ Star the repository

🍴 Fork the project

🤝 Feel free to contribute

---

## 📜 License

This project is licensed under the MIT License.
