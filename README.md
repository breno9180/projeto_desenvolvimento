# Manual de Instalação e Configuração do Sistema de Gerenciamento de Fretes

# 1. Introdução
Este documento fornece as instruções necessárias para a instalação e configuração do sistema de gerenciamento de fretes, permitindo que empresas e entregadores criem, gerenciem e acompanhem o status de fretes.

# 2. Requisitos
Antes de iniciar a instalação, certifique-se de que os seguintes requisitos estejam atendidos:

# 2.1. Software Necessário
- Java Development Kit (JDK) 11 (https://www.oracle.com/java/technologies/downloads/#java11)
- Apache Maven 3.8.8 (https://maven.apache.org/download.cgi)
- PostgreSQL (https://www.postgresql.org/download/)
- IDE de sua preferência (IntelliJ IDEA: https://www.jetbrains.com , Eclipse: https://eclipseide.org)
- Git (para controle de versão, se necessário - https://git-scm.com/downloads)

# 2.2. Configurações de Ambiente
Variáveis de Ambiente:
- 'JAVA_HOME': Diretório de instalação do JDK
- 'MAVEN_HOME': Diretório de instalação do Maven
- 'PATH': Inclua os binários do Java e Maven

# 3. Instalação das Ferramentas

# 3.1. Instalação do JDK 11
- Baixe o JDK 11 a partir do site oficial da Oracle ou da OpenJDK.
- Siga as instruções de instalação fornecidas pelo instalador.
- Configure a variável de ambiente JAVA_HOME apontando para o diretório de instalação do JDK.

# 3.2. Instalação do Apache Maven
- Baixe o Apache Maven 3.8.8 do site oficial do Maven.
- Extraia os arquivos em um diretório de sua preferência.
- Configure a variável de ambiente MAVEN_HOME apontando para o diretório de instalação do Maven.
- Adicione o diretório bin do Maven ao PATH.

# 3.3. Instalação do PostgreSQL
- Baixe o instalador do PostgreSQL a partir do site oficial.
- Siga as instruções de instalação, incluindo a criação de uma senha para o usuário postgres.
- Opcionalmente, instale o pgAdmin para uma interface gráfica de administração.

# 3.4. Instalação do DBeaver (Opcional)
- Baixe e instale o DBeaver para facilitar a administração do PostgreSQL.
- Conecte-se ao banco de dados PostgreSQL utilizando o DBeaver.

# 3.5. Instalação do Git
- Baixe e instale o Git a partir do site oficial.
- Configure o Git com seu nome de usuário e e-mail:

'git config --global user.name "Seu Nome" '

'git config --global user.email "seu_email@example.com" '

# 4. Clonando o Repositório
Caso esteja utilizando um repositório Git, clone o projeto para sua máquina local utilizando o comando:

'git clone <URL_DO_REPOSITORIO>'

Navegue até o diretório do projeto, por exemplo:

'cd projeto_desenvolvimento'

# 5. Configuração do Banco de Dados

# 5.1. Configuração do Banco de Dados PostgreSQL
- Acesse o PostgreSQL e crie o banco de dados para o projeto:

'CREATE DATABASE gerenciador_fretes;'

- Crie um usuário para o banco de dados e conceda as permissões necessárias:

'CREATE USER frete_user WITH PASSWORD 'senha_segura';

GRANT ALL PRIVILEGES ON DATABASE gerenciador_fretes TO frete_user;'

- No projeto, configure o arquivo ´src/main/resources/application.properties´ com as credenciais do banco de dados.

# 6. Construção e Execução do Projeto

# 6.1. Compilar o Projeto
- No terminal, navegue até o diretório do projeto e compile usando o Maven:

´mvn clean install´

# 5.2. Executar o Projeto
- Após a compilação, execute a aplicação:

´mvn spring-boot:run´

Se preferir, pode executar diretamente a classe principal do projeto em sua IDE.


