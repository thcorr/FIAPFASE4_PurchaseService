# FIAPFASE4_PurchaseService

## Para executar localmente via Docker:
0. No diretorio do projeto, via terminal, digite: docker compose up
1. Apos buildar o projeto, o service roda no endereco/porta: http://localhost:9088
2. Para acessar Swagger: http://localhost:9088/swagger-ui/#/
3. Crie compras via swagger. Isto ira disparar notificacoes via RabbitMQ para https://github.com/thcorr/FIAPFASE4_NotificationService (este precisa estar up)
