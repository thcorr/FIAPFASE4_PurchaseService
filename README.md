# FIAPFASE4_PurchaseService

1. Criar container do rabbitMq via DockerCompose:
	1.1 O arquivo docker-compose.yaml esta no class path. Via terminal (i.e cmd, power shell, vs code, intellij) acesse o diretorio e digite: docker-compose up -d
	PS: Docker precisa estar instalado.
  1.2 O dashboard do RabbitMQ pode ser acessado via http://localhost:15672/	e se autentique com admin admin
  
2. Apos buildar o projeto, o service roda no endereco/porta: http://localhost:9088
3. Para acessar Swagger: http://localhost:9088/swagger-ui/#/

Crie compras via swagger. Isto ira disparar notificacoes via RabbitMQ para https://github.com/thcorr/FIAPFASE4_NotificationService (este precisa estar up)
