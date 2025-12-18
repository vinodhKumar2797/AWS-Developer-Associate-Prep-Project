# aws-dev-associate-microservices

This repository is my hands-on prep for the **AWS Certified Developer – Associate** exam.  
It contains a set of **Java / Spring Boot microservices**, each one focused on a specific AWS topic I’ve studied (based on Stephane Maarek’s course).

The goal of this repo is to:
- Practice core AWS services with real code.
- Keep everything **topic-wise and easy to review**.
- Show a clear mapping between **exam domains** and **working microservices**.

## Microservices / Modules

- `iam-service` – examples of IAM users, roles, policies, and AWS SDK calls using instance/role credentials.
- `ec2-service` – APIs to describe, start, stop, or tag EC2 instances.
- `storage-service` – integration with EBS/EFS concepts (plus S3 later for object storage).
- `elb-asg-service` – demos around load balancing, health checks, and auto scaling flows.
- `rds-aurora-elasticache-service` – Spring Boot talking to RDS/Aurora with caching patterns using ElastiCache.
- `route53-service` – simple APIs/scripts to manage DNS records and demonstrate routing policies.

Each service is designed to be small, focused, and mapped to one part of the AWS syllabus, so I can track my progress and quickly review any topic before the exam.
